package com.emojimaker.horor.emoji.dialog;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u001d\u001a\u00020\u0011H\u0016J\b\u0010\u001e\u001a\u00020\u0011H\u0016J\b\u0010\u001f\u001a\u00020\u0011H\u0016J\u0006\u0010 \u001a\u00020\u0011J\b\u0010!\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\rR\u0014\u0010\u000e\u001a\u00020\fX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR&\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R&\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/emojimaker/horor/emoji/dialog/AddPackageDialog;", "Lcom/emojimaker/horor/emoji/core/base/BaseDialog;", "Lcom/emojimaker/horor/emoji/databinding/DialogAddPackageBinding;", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "layoutId", "", "getLayoutId", "()I", "isCancelOnTouchOutside", "", "()Z", "isCancelableByBack", "onCreateNewPackageClick", "Lkotlin/Function1;", "", "getOnCreateNewPackageClick", "()Lkotlin/jvm/functions/Function1;", "setOnCreateNewPackageClick", "(Lkotlin/jvm/functions/Function1;)V", "onAddToPackageClick", "", "getOnAddToPackageClick", "setOnAddToPackageClick", "adapter", "Lcom/emojimaker/horor/emoji/ui/my_creation/adapter/AddPackageAdapter;", "selectedPackageId", "initView", "initAction", "onDismissListener", "reloadPackages", "updateAddButton", "ST295_Horror_Emoji_Maker_V1.0.0_07.22.2026_debug"})
public final class AddPackageDialog extends com.emojimaker.horor.emoji.core.base.BaseDialog<com.emojimaker.horor.emoji.databinding.DialogAddPackageBinding> {
    @org.jetbrains.annotations.NotNull()
    private final android.app.Activity activity = null;
    private final int layoutId = com.emojimaker.horor.emoji.R.layout.dialog_add_package;
    private final boolean isCancelOnTouchOutside = true;
    private final boolean isCancelableByBack = true;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super com.emojimaker.horor.emoji.dialog.AddPackageDialog, kotlin.Unit> onCreateNewPackageClick;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onAddToPackageClick;
    @org.jetbrains.annotations.NotNull()
    private final com.emojimaker.horor.emoji.ui.my_creation.adapter.AddPackageAdapter adapter = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String selectedPackageId = "";
    
    public AddPackageDialog(@org.jetbrains.annotations.NotNull()
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
    public final kotlin.jvm.functions.Function1<com.emojimaker.horor.emoji.dialog.AddPackageDialog, kotlin.Unit> getOnCreateNewPackageClick() {
        return null;
    }
    
    public final void setOnCreateNewPackageClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.emojimaker.horor.emoji.dialog.AddPackageDialog, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> getOnAddToPackageClick() {
        return null;
    }
    
    public final void setOnAddToPackageClick(@org.jetbrains.annotations.NotNull()
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
    
    public final void reloadPackages() {
    }
    
    private final void updateAddButton() {
    }
}