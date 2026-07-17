package com.create.lalala.ui.permission;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006J\u0016\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0006J\u0016\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0006J\u0016\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0006J\u0011\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u00a2\u0006\u0002\u0010\u001bJ\u0011\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u00a2\u0006\u0002\u0010\u001bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n\u00a8\u0006\u001d"}, d2 = {"Lcom/create/lalala/ui/permission/PermissionViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_storageGranted", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "storageGranted", "Lkotlinx/coroutines/flow/StateFlow;", "getStorageGranted", "()Lkotlinx/coroutines/flow/StateFlow;", "_notificationGranted", "notificationGranted", "getNotificationGranted", "checkAndUpdatePermissionState", "", "granted", "isStorage", "updateStorageGranted", "sharePrefer", "Lcom/create/lalala/core/helper/SharePreferenceHelper;", "updateNotificationGranted", "needGoToSettings", "storage", "getStoragePermissions", "", "", "()[Ljava/lang/String;", "getNotificationPermissions", "ST295_Horror_Emoji_Maker_v1.0.0_07.17.2026_debug"})
public final class PermissionViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _storageGranted = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> storageGranted = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _notificationGranted = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> notificationGranted = null;
    
    public PermissionViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getStorageGranted() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getNotificationGranted() {
        return null;
    }
    
    public final void checkAndUpdatePermissionState(boolean granted, boolean isStorage) {
    }
    
    public final void updateStorageGranted(@org.jetbrains.annotations.NotNull()
    com.create.lalala.core.helper.SharePreferenceHelper sharePrefer, boolean granted) {
    }
    
    public final void updateNotificationGranted(@org.jetbrains.annotations.NotNull()
    com.create.lalala.core.helper.SharePreferenceHelper sharePrefer, boolean granted) {
    }
    
    public final boolean needGoToSettings(@org.jetbrains.annotations.NotNull()
    com.create.lalala.core.helper.SharePreferenceHelper sharePrefer, boolean storage) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String[] getStoragePermissions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String[] getNotificationPermissions() {
        return null;
    }
}