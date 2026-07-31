package com.emojimaker.horor.emoji.core.base;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u000b\u001a\u00028\u0000H$\u00a2\u0006\u0002\u0010\nJ\b\u0010\f\u001a\u00020\rH$J\b\u0010\u000e\u001a\u00020\rH$J\b\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\rH$J\b\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\u0012\u0010&\u001a\u00020\r2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0014J\b\u0010)\u001a\u00020\rH\u0002J\b\u0010*\u001a\u00020\rH\u0014J\b\u0010+\u001a\u00020\rH\u0014J\b\u0010,\u001a\u00020\rH\u0017J\u000e\u0010-\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010.J\u000e\u0010/\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010.J\u000e\u00100\u001a\u00020\r2\u0006\u00101\u001a\u000202J\b\u00103\u001a\u00020\rH\u0014R\u0012\u0010\u0006\u001a\u0004\u0018\u00018\u0000X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0007R\u0011\u0010\b\u001a\u00028\u00008F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001b\u0010\u0015\u001a\u00020\u00168DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001b\u001a\u00020\u001c8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\u00020!X\u0084.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u00064"}, d2 = {"Lcom/emojimaker/horor/emoji/core/base/BaseActivity;", "T", "Landroidx/viewbinding/ViewBinding;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "_binding", "Landroidx/viewbinding/ViewBinding;", "binding", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "setViewBinding", "initView", "", "viewListener", "dataObservable", "initText", "initActionBar", "initAds", "shouldPlayBackgroundMusic", "", "loadingDialog", "Lcom/emojimaker/horor/emoji/dialog/WaitingDialog;", "getLoadingDialog", "()Lcom/emojimaker/horor/emoji/dialog/WaitingDialog;", "loadingDialog$delegate", "Lkotlin/Lazy;", "sharePreference", "Lcom/emojimaker/horor/emoji/core/helper/SharePreferenceHelper;", "getSharePreference", "()Lcom/emojimaker/horor/emoji/core/helper/SharePreferenceHelper;", "sharePreference$delegate", "toast", "Landroid/widget/Toast;", "getToast", "()Landroid/widget/Toast;", "setToast", "(Landroid/widget/Toast;)V", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setUpUI", "onResume", "onPause", "onBackPressed", "showLoading", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dismissLoading", "showToast", "content", "", "onDestroy", "ST295_Horror_Emoji_Maker_V1.0.2_07.31.2026_debug"})
public abstract class BaseActivity<T extends androidx.viewbinding.ViewBinding> extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.Nullable()
    private T _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy loadingDialog$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy sharePreference$delegate = null;
    protected android.widget.Toast toast;
    
    public BaseActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final T getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    protected abstract T setViewBinding();
    
    protected abstract void initView();
    
    protected abstract void viewListener();
    
    public void dataObservable() {
    }
    
    public void initText() {
    }
    
    protected abstract void initActionBar();
    
    public void initAds() {
    }
    
    protected boolean shouldPlayBackgroundMusic() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final com.emojimaker.horor.emoji.dialog.WaitingDialog getLoadingDialog() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final com.emojimaker.horor.emoji.core.helper.SharePreferenceHelper getSharePreference() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final android.widget.Toast getToast() {
        return null;
    }
    
    protected final void setToast(@org.jetbrains.annotations.NotNull()
    android.widget.Toast p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setUpUI() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
    
    @java.lang.Override()
    @android.annotation.SuppressLint(value = {"MissingSuperCall", "GestureBackNavigation"})
    public void onBackPressed() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object showLoading(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object dismissLoading(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    public final void showToast(@org.jetbrains.annotations.NotNull()
    java.lang.Object content) {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
}