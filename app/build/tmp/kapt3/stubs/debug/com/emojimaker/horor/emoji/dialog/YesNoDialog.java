package com.emojimaker.horor.emoji.dialog;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010%\u001a\u00020\u001aH\u0016J\b\u0010&\u001a\u00020\u001aH\u0002J\b\u0010\'\u001a\u00020\u001aH\u0016J\b\u0010(\u001a\u00020\u001aH\u0016J\b\u0010)\u001a\u00020\u001aH\u0002J\b\u0010*\u001a\u00020\tH\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0012R\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0014\u0010\u0016\u001a\u00020\tX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\tX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR \u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001e\u00a8\u0006+"}, d2 = {"Lcom/emojimaker/horor/emoji/dialog/YesNoDialog;", "Lcom/emojimaker/horor/emoji/core/base/BaseDialog;", "Lcom/emojimaker/horor/emoji/databinding/DialogConfirmBinding;", "context", "Landroid/app/Activity;", "title", "", "description", "isError", "", "notifAds", "<init>", "(Landroid/app/Activity;IIZZ)V", "getContext", "()Landroid/app/Activity;", "getTitle", "()I", "getDescription", "()Z", "getNotifAds", "layoutId", "getLayoutId", "isCancelOnTouchOutside", "isCancelableByBack", "onNoClick", "Lkotlin/Function0;", "", "getOnNoClick", "()Lkotlin/jvm/functions/Function0;", "setOnNoClick", "(Lkotlin/jvm/functions/Function0;)V", "onYesClick", "getOnYesClick", "setOnYesClick", "onDismissClick", "getOnDismissClick", "setOnDismissClick", "initView", "initBackground", "initAction", "onDismissListener", "initText", "isInternetDialog", "ST295_Horror_Emoji_Maker_V1.0.2_07.31.2026_debug"})
public final class YesNoDialog extends com.emojimaker.horor.emoji.core.base.BaseDialog<com.emojimaker.horor.emoji.databinding.DialogConfirmBinding> {
    @org.jetbrains.annotations.NotNull()
    private final android.app.Activity context = null;
    private final int title = 0;
    private final int description = 0;
    private final boolean isError = false;
    private final boolean notifAds = false;
    private final int layoutId = com.emojimaker.horor.emoji.R.layout.dialog_confirm;
    private final boolean isCancelOnTouchOutside = false;
    private final boolean isCancelableByBack = false;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function0<kotlin.Unit> onNoClick;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function0<kotlin.Unit> onYesClick;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function0<kotlin.Unit> onDismissClick;
    
    public YesNoDialog(@org.jetbrains.annotations.NotNull()
    android.app.Activity context, int title, int description, boolean isError, boolean notifAds) {
        super(null, 0, false, false);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Activity getContext() {
        return null;
    }
    
    public final int getTitle() {
        return 0;
    }
    
    public final int getDescription() {
        return 0;
    }
    
    public final boolean isError() {
        return false;
    }
    
    public final boolean getNotifAds() {
        return false;
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
    public final kotlin.jvm.functions.Function0<kotlin.Unit> getOnYesClick() {
        return null;
    }
    
    public final void setOnYesClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> p0) {
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
    
    private final void initBackground() {
    }
    
    @java.lang.Override()
    public void initAction() {
    }
    
    @java.lang.Override()
    public void onDismissListener() {
    }
    
    private final void initText() {
    }
    
    private final boolean isInternetDialog() {
        return false;
    }
}