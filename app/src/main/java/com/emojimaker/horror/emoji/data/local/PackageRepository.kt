package com.emojimaker.horor.emoji.data.local

import android.content.Context
import com.emojimaker.horor.emoji.core.helper.MediaHelper
import com.emojimaker.horor.emoji.core.utils.key.ValueKey
import com.emojimaker.horor.emoji.data.model.PackageModel
import java.io.File
import java.util.UUID

object PackageRepository {
    suspend fun getPackagesAsync(context: Context): ArrayList<PackageModel> =
        kotlinx.coroutines.withContext(kotlinx.coroutines.Dispatchers.IO) {
            MediaHelper.readListFromFileAsync<PackageModel>(context, ValueKey.PACKAGE_FILE_INTERNAL)
                .map { pkg ->
                    pkg.copy(
                        items = pkg.items.filter { File(it).exists() }.toCollection(ArrayList()),
                        isSelected = false,
                        isShowSelection = false
                    )
                }
                .toCollection(ArrayList())
        }

    fun getPackages(context: Context): ArrayList<PackageModel> {
        return MediaHelper.readListFromFile<PackageModel>(context, ValueKey.PACKAGE_FILE_INTERNAL)
            .map { pkg ->
                pkg.copy(
                    items = pkg.items.filter { File(it).exists() }.toCollection(ArrayList()),
                    isSelected = false,
                    isShowSelection = false
                )
            }
            .toCollection(ArrayList())
    }

    fun createPackage(context: Context, name: String, previewPath: String): PackageModel {
        val list = getPackages(context)
        val packageModel = PackageModel(
            id = UUID.randomUUID().toString(),
            name = name,
            previewPath = previewPath
        )
        list.add(0, packageModel)
        savePackages(context, list)
        return packageModel
    }

    fun createPackageWithImage(context: Context, name: String, sourcePath: String): Boolean {
        val sourceFile = File(sourcePath)
        if (!sourceFile.exists()) return false

        val copiedPath = copyImageToPackageFolder(context, sourceFile) ?: return false
        val list = getPackages(context)
        if (list.any { it.name.trim().equals(name.trim(), ignoreCase = true) }) return false
        val packageModel = PackageModel(
            id = UUID.randomUUID().toString(),
            name = name,
            previewPath = copiedPath,
            items = arrayListOf(copiedPath)
        )
        list.add(0, packageModel)
        savePackages(context, list)
        return true
    }

    fun hasPackageName(context: Context, name: String): Boolean {
        val normalizedName = name.trim()
        return getPackages(context).any {
            it.name.trim().equals(normalizedName, ignoreCase = true)
        }
    }

    fun addImageToPackage(context: Context, packageId: String, sourcePath: String): Boolean {
        val sourceFile = File(sourcePath)
        if (!sourceFile.exists()) return false

        val copiedPath = copyImageToPackageFolder(context, sourceFile) ?: return false
        val list = getPackages(context)
        val index = list.indexOfFirst { it.id == packageId }
        if (index == -1) return false

        val packageModel = list[index]
        if (!packageModel.items.contains(copiedPath)) {
            packageModel.items.add(0, copiedPath)
        }
        list[index] = packageModel.copy(previewPath = packageModel.previewPath.ifEmpty { copiedPath })
        savePackages(context, list)
        return true
    }

    fun deleteItems(context: Context, packageId: String, paths: List<String>) {
        if (paths.isEmpty()) return
        val list = getPackages(context)
        val index = list.indexOfFirst { it.id == packageId }
        if (index == -1) return

        val packageModel = list[index]
        packageModel.items.removeAll(paths.toSet())
        paths.forEach { File(it).takeIf { file -> file.exists() }?.delete() }
        list[index] = packageModel.copy(previewPath = packageModel.items.firstOrNull().orEmpty())
        savePackages(context, list)
    }

    fun deletePackages(context: Context, packageIds: List<String>) {
        if (packageIds.isEmpty()) return
        val list = getPackages(context)
        val deleteList = list.filter { it.id in packageIds }
        deleteList.flatMap { it.items }.forEach { File(it).takeIf { file -> file.exists() }?.delete() }
        list.removeAll(deleteList.toSet())
        savePackages(context, list)
    }

    private fun savePackages(context: Context, list: List<PackageModel>) {
        MediaHelper.writeListToFile(context, ValueKey.PACKAGE_FILE_INTERNAL, list)
    }

    private fun copyImageToPackageFolder(context: Context, sourceFile: File): String? {
        return runCatching {
            val directory = File(context.filesDir, ValueKey.PACKAGE_ALBUM)
            if (!directory.exists()) directory.mkdirs()
            val target = File(directory, "${System.currentTimeMillis()}_${UUID.randomUUID()}.png")
            sourceFile.copyTo(target, overwrite = true)
            target.absolutePath
        }.getOrNull()
    }
}
