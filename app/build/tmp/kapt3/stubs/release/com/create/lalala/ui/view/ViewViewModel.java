package com.create.lalala.ui.view;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0006J\u000e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u001aJ\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u001aJ\u000e\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001e"}, d2 = {"Lcom/create/lalala/ui/view/ViewViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_pathInternal", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "pathInternal", "Lkotlinx/coroutines/flow/StateFlow;", "getPathInternal", "()Lkotlinx/coroutines/flow/StateFlow;", "statusFrom", "", "getStatusFrom", "()I", "setStatusFrom", "(I)V", "setPath", "", "path", "deleteFile", "Lkotlinx/coroutines/flow/Flow;", "Lcom/create/lalala/core/utils/state/HandleState;", "context", "Landroid/content/Context;", "shareFiles", "Landroid/app/Activity;", "downloadFiles", "updateStatusFrom", "status", "ST295_Horror_Emoji_Maker_v1.0.0_07.20.2026_release"})
public final class ViewViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _pathInternal = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> pathInternal = null;
    private int statusFrom = 0;
    
    public ViewViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getPathInternal() {
        return null;
    }
    
    public final int getStatusFrom() {
        return 0;
    }
    
    public final void setStatusFrom(int p0) {
    }
    
    public final void setPath(@org.jetbrains.annotations.NotNull()
    java.lang.String path) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.create.lalala.core.utils.state.HandleState> deleteFile(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String path) {
        return null;
    }
    
    public final void shareFiles(@org.jetbrains.annotations.NotNull()
    android.app.Activity context) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.create.lalala.core.utils.state.HandleState> downloadFiles(@org.jetbrains.annotations.NotNull()
    android.app.Activity context) {
        return null;
    }
    
    public final void updateStatusFrom(int status) {
    }
}