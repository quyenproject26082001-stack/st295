package com.create.lalala.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.create.lalala.data.local.entity.MediaItemEntity

@Dao
interface MediaItemDao {
    @Query("SELECT * FROM media_items WHERE album = :album ORDER BY createdAt DESC, updatedAt DESC")
    suspend fun getByAlbum(album: String): List<MediaItemEntity>

    @Query("SELECT COUNT(*) FROM media_items WHERE album = :album")
    suspend fun countAlbum(album: String): Int

    @Upsert
    suspend fun upsert(item: MediaItemEntity)

    @Upsert
    suspend fun upsertAll(items: List<MediaItemEntity>)

    @Query("DELETE FROM media_items WHERE path IN (:paths)")
    suspend fun deleteByPaths(paths: List<String>)

    @Query("DELETE FROM media_items WHERE album = :album AND path IN (:paths)")
    suspend fun deleteAlbumPaths(album: String, paths: List<String>)
}
