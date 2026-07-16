package com.create.lalala.core.base;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B-\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u001aH\u0002J\b\u0010\u001e\u001a\u00020\u001aH\u0016J\b\u0010\u001f\u001a\u00020\u001aH&J\b\u0010 \u001a\u00020\u001aH&J\b\u0010!\u001a\u00020\u001aH&R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u00028\u0000X\u0084.\u00a2\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0013\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\tX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\tX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0017\u00a8\u0006\""}, d2 = {"Lcom/create/lalala/core/base/BaseDialog;", "VB", "Landroidx/viewbinding/ViewBinding;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "gravity", "", "maxWidth", "", "maxHeight", "<init>", "(Landroid/content/Context;IZZ)V", "binding", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "setBinding", "(Landroidx/viewbinding/ViewBinding;)V", "Landroidx/viewbinding/ViewBinding;", "layoutId", "getLayoutId", "()I", "isCancelOnTouchOutside", "()Z", "isCancelableByBack", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setupWindow", "dismiss", "initView", "initAction", "onDismissListener", "ST295_Horror_Emoji_Maker_v1.0.0_07.15.2026_debug"})
public abstract class BaseDialog<VB extends androidx.viewbinding.ViewBinding> extends android.app.Dialog {
    private final int gravity = 0;
    private final boolean maxWidth = false;
    private final boolean maxHeight = false;
    protected VB binding;
    
    public BaseDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context, int gravity, boolean maxWidth, boolean maxHeight) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final VB getBinding() {
        return null;
    }
    
    protected final void setBinding(@org.jetbrains.annotations.NotNull()
    VB p0) {
    }
    
    public abstract int getLayoutId();
    
    public abstract boolean isCancelOnTouchOutside();
    
    public abstract boolean isCancelableByBack();
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupWindow() {
    }
    
    @java.lang.Override()
    public void dismiss() {
    }
    
    public abstract void initView();
    
    public abstract void initAction();
    
    public abstract void onDismissListener();
}