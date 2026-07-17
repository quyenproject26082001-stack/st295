package com.create.lalala.dialog;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010 \u001a\u00020\u0015H\u0016J\b\u0010!\u001a\u00020\u0015H\u0016J\b\u0010\"\u001a\u00020\u0015H\u0016J\u001e\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\bR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\rR\u0014\u0010\u000e\u001a\u00020\fX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001a\u0010\u000f\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\"\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019\u00a8\u0006\'"}, d2 = {"Lcom/create/lalala/dialog/RateDialog;", "Lcom/create/lalala/core/base/BaseDialog;", "Lcom/create/lalala/databinding/DialogRateBinding;", "context", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "layoutId", "", "getLayoutId", "()I", "isCancelOnTouchOutside", "", "()Z", "isCancelableByBack", "i", "getI", "setI", "(I)V", "onRateGreater3", "Lkotlin/Function0;", "", "getOnRateGreater3", "()Lkotlin/jvm/functions/Function0;", "setOnRateGreater3", "(Lkotlin/jvm/functions/Function0;)V", "onRateLess3", "getOnRateLess3", "setOnRateLess3", "onCancel", "getOnCancel", "setOnCancel", "initView", "initAction", "onDismissListener", "setView", "tv1", "tv2", "img", "ST295_Horror_Emoji_Maker_v1.0.0_07.17.2026_debug"})
public final class RateDialog extends com.create.lalala.core.base.BaseDialog<com.create.lalala.databinding.DialogRateBinding> {
    private final int layoutId = com.create.lalala.R.layout.dialog_rate;
    private final boolean isCancelOnTouchOutside = false;
    private final boolean isCancelableByBack = false;
    private int i = 0;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function0<kotlin.Unit> onRateGreater3;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function0<kotlin.Unit> onRateLess3;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function0<kotlin.Unit> onCancel;
    
    public RateDialog(@org.jetbrains.annotations.NotNull()
    android.app.Activity context) {
        super(null, 0, false, false);
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
    
    public final int getI() {
        return 0;
    }
    
    public final void setI(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlin.jvm.functions.Function0<kotlin.Unit> getOnRateGreater3() {
        return null;
    }
    
    public final void setOnRateGreater3(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlin.jvm.functions.Function0<kotlin.Unit> getOnRateLess3() {
        return null;
    }
    
    public final void setOnRateLess3(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlin.jvm.functions.Function0<kotlin.Unit> getOnCancel() {
        return null;
    }
    
    public final void setOnCancel(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> p0) {
    }
    
    @java.lang.Override()
    public void initView() {
    }
    
    @java.lang.Override()
    public void initAction() {
    }
    
    @java.lang.Override()
    public void onDismissListener() {
    }
    
    public final void setView(int tv1, int tv2, int img) {
    }
}