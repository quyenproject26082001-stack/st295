package com.create.lalala.dialog;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010 \u001a\u00020\u0011H\u0016J\b\u0010!\u001a\u00020\u0011H\u0016J\b\u0010\"\u001a\u00020\u0011H\u0016R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\rR\u0014\u0010\u000e\u001a\u00020\fX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR&\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00110\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u000e\u0010\u001f\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/create/lalala/dialog/ChooseColorDialog;", "Lcom/create/lalala/core/base/BaseDialog;", "Lcom/create/lalala/databinding/DialogColorPickerBinding;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "layoutId", "", "getLayoutId", "()I", "isCancelOnTouchOutside", "", "()Z", "isCancelableByBack", "onDoneEvent", "Lkotlin/Function1;", "", "getOnDoneEvent", "()Lkotlin/jvm/functions/Function1;", "setOnDoneEvent", "(Lkotlin/jvm/functions/Function1;)V", "onCloseEvent", "Lkotlin/Function0;", "getOnCloseEvent", "()Lkotlin/jvm/functions/Function0;", "setOnCloseEvent", "(Lkotlin/jvm/functions/Function0;)V", "onDismissEvent", "getOnDismissEvent", "setOnDismissEvent", "color", "initView", "initAction", "onDismissListener", "ST295_Horror_Emoji_Maker_v1.0.0_07.20.2026_debug"})
public final class ChooseColorDialog extends com.create.lalala.core.base.BaseDialog<com.create.lalala.databinding.DialogColorPickerBinding> {
    private final int layoutId = com.create.lalala.R.layout.dialog_color_picker;
    private final boolean isCancelOnTouchOutside = false;
    private final boolean isCancelableByBack = false;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onDoneEvent;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function0<kotlin.Unit> onCloseEvent;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function0<kotlin.Unit> onDismissEvent;
    private int color = android.graphics.Color.WHITE;
    
    public ChooseColorDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
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
    public final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> getOnDoneEvent() {
        return null;
    }
    
    public final void setOnDoneEvent(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function0<kotlin.Unit> getOnCloseEvent() {
        return null;
    }
    
    public final void setOnCloseEvent(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function0<kotlin.Unit> getOnDismissEvent() {
        return null;
    }
    
    public final void setOnDismissEvent(@org.jetbrains.annotations.NotNull()
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