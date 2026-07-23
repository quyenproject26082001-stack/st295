package com.emojimaker.horor.emoji.dialog;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0017\u001a\u00020\u0012H\u0016J\b\u0010\u0018\u001a\u00020\u0012H\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0016R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\rR\u0014\u0010\u000e\u001a\u00020\fX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR&\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/emojimaker/horor/emoji/dialog/AddNewPackageDialog;", "Lcom/emojimaker/horor/emoji/core/base/BaseDialog;", "Lcom/emojimaker/horor/emoji/databinding/DialogAddNewPackageBinding;", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "layoutId", "", "getLayoutId", "()I", "isCancelOnTouchOutside", "", "()Z", "isCancelableByBack", "onAddPackageClick", "Lkotlin/Function1;", "", "", "getOnAddPackageClick", "()Lkotlin/jvm/functions/Function1;", "setOnAddPackageClick", "(Lkotlin/jvm/functions/Function1;)V", "initView", "initAction", "onDismissListener", "ST295_Horror_Emoji_Maker_V1.0.1_07.23.2026_debug"})
public final class AddNewPackageDialog extends com.emojimaker.horor.emoji.core.base.BaseDialog<com.emojimaker.horor.emoji.databinding.DialogAddNewPackageBinding> {
    private final int layoutId = com.emojimaker.horor.emoji.R.layout.dialog_add_new_package;
    private final boolean isCancelOnTouchOutside = true;
    private final boolean isCancelableByBack = true;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onAddPackageClick;
    
    public AddNewPackageDialog(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
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
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> getOnAddPackageClick() {
        return null;
    }
    
    public final void setOnAddPackageClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> p0) {
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