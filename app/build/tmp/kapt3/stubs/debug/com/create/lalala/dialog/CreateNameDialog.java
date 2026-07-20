package com.create.lalala.dialog;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\"\u001a\u00020\u0013H\u0016J\b\u0010#\u001a\u00020\u0013H\u0016J\b\u0010$\u001a\u00020\u0013H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u000eX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R&\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00130\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017\u00a8\u0006%"}, d2 = {"Lcom/create/lalala/dialog/CreateNameDialog;", "Lcom/create/lalala/core/base/BaseDialog;", "Lcom/create/lalala/databinding/DialogCreateNameBinding;", "context", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "getContext", "()Landroid/app/Activity;", "layoutId", "", "getLayoutId", "()I", "isCancelOnTouchOutside", "", "()Z", "isCancelableByBack", "onNoClick", "Lkotlin/Function0;", "", "getOnNoClick", "()Lkotlin/jvm/functions/Function0;", "setOnNoClick", "(Lkotlin/jvm/functions/Function0;)V", "onYesClick", "Lkotlin/Function1;", "", "getOnYesClick", "()Lkotlin/jvm/functions/Function1;", "setOnYesClick", "(Lkotlin/jvm/functions/Function1;)V", "onDismissClick", "getOnDismissClick", "setOnDismissClick", "initView", "initAction", "onDismissListener", "ST295_Horror_Emoji_Maker_v1.0.0_07.20.2026_debug"})
public final class CreateNameDialog extends com.create.lalala.core.base.BaseDialog<com.create.lalala.databinding.DialogCreateNameBinding> {
    @org.jetbrains.annotations.NotNull()
    private final android.app.Activity context = null;
    private final int layoutId = com.create.lalala.R.layout.dialog_create_name;
    private final boolean isCancelOnTouchOutside = false;
    private final boolean isCancelableByBack = false;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function0<kotlin.Unit> onNoClick;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onYesClick;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function0<kotlin.Unit> onDismissClick;
    
    public CreateNameDialog(@org.jetbrains.annotations.NotNull()
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
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function0<kotlin.Unit> getOnNoClick() {
        return null;
    }
    
    public final void setOnNoClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> getOnYesClick() {
        return null;
    }
    
    public final void setOnYesClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function0<kotlin.Unit> getOnDismissClick() {
        return null;
    }
    
    public final void setOnDismissClick(@org.jetbrains.annotations.NotNull()
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
}