package com.emojimaker.horor.emoji.data.local;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0006\u0010\b\u001a\u00020\tJ\u001e\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fJ\u0016\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fJ$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u0017J\u001c\u0010\u0018\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u0017J\u001e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\t2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0017H\u0002J\u001a\u0010\u001c\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002\u00a8\u0006\u001f"}, d2 = {"Lcom/emojimaker/horor/emoji/data/local/PackageRepository;", "", "<init>", "()V", "getPackages", "Ljava/util/ArrayList;", "Lcom/emojimaker/horor/emoji/data/model/PackageModel;", "Lkotlin/collections/ArrayList;", "context", "Landroid/content/Context;", "createPackage", "name", "", "previewPath", "createPackageWithImage", "", "sourcePath", "hasPackageName", "addImageToPackage", "packageId", "deleteItems", "", "paths", "", "deletePackages", "packageIds", "savePackages", "list", "copyImageToPackageFolder", "sourceFile", "Ljava/io/File;", "ST295_Horror_Emoji_Maker_V1.0.3_09.18.2026_debug"})
public final class PackageRepository {
    @org.jetbrains.annotations.NotNull()
    public static final com.emojimaker.horor.emoji.data.local.PackageRepository INSTANCE = null;
    
    private PackageRepository() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.emojimaker.horor.emoji.data.model.PackageModel> getPackages(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.emojimaker.horor.emoji.data.model.PackageModel createPackage(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String previewPath) {
        return null;
    }
    
    public final boolean createPackageWithImage(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String sourcePath) {
        return false;
    }
    
    public final boolean hasPackageName(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        return false;
    }
    
    public final boolean addImageToPackage(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String packageId, @org.jetbrains.annotations.NotNull()
    java.lang.String sourcePath) {
        return false;
    }
    
    public final void deleteItems(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String packageId, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> paths) {
    }
    
    public final void deletePackages(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> packageIds) {
    }
    
    private final void savePackages(android.content.Context context, java.util.List<com.emojimaker.horor.emoji.data.model.PackageModel> list) {
    }
    
    private final java.lang.String copyImageToPackageFolder(android.content.Context context, java.io.File sourceFile) {
        return null;
    }
}