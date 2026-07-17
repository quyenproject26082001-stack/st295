package com.create.lalala.dialog;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0014J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u000eX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/create/lalala/dialog/WaitingDialog;", "Lcom/create/lalala/core/base/BaseDialog;", "Lcom/create/lalala/databinding/DialogLoadingBinding;", "context", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "getContext", "()Landroid/app/Activity;", "layoutId", "", "getLayoutId", "()I", "isCancelOnTouchOutside", "", "()Z", "isCancelableByBack", "spinnerAnim", "Landroid/animation/ObjectAnimator;", "initView", "", "onStart", "initAction", "onDismissListener", "ST295_Horror_Emoji_Maker_v1.0.0_07.17.2026_debug"})
public final class WaitingDialog extends com.create.lalala.core.base.BaseDialog<com.create.lalala.databinding.DialogLoadingBinding> {
    @org.jetbrains.annotations.NotNull()
    private final android.app.Activity context = null;
    private final int layoutId = com.create.lalala.R.layout.dialog_loading;
    private final boolean isCancelOnTouchOutside = false;
    private final boolean isCancelableByBack = false;
    @org.jetbrains.annotations.Nullable()
    private android.animation.ObjectAnimator spinnerAnim;
    
    public WaitingDialog(@org.jetbrains.annotations.NotNull()
    android.app.Activity context) {
        super(null, 0, false, false);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Activity getContext() {
        return null;
    }
    
    @java.lang.Override()
    public int getLayoutId() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean isCancelOnTouchOutside() {
        return false;
    }
    
    @java.lang.Override()
    public boolean isCancelableByBack() {
        return false;
    }
    
    @java.lang.Override()
    public void initView() {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    @java.lang.Override()
    public void initAction() {
    }
    
    @java.lang.Override()
    public void onDismissListener() {
    }
}