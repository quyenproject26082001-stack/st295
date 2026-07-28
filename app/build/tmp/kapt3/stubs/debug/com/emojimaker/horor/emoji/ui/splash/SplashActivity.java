package com.emojimaker.horor.emoji.ui.splash;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u001d\u001a\u00020\u0002H\u0014J\b\u0010\u001e\u001a\u00020\u001fH\u0014J\b\u0010 \u001a\u00020\u001fH\u0016J\b\u0010!\u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u001fH\u0014J\b\u0010#\u001a\u00020\u001fH\u0016J\b\u0010$\u001a\u00020\u001fH\u0014J\b\u0010%\u001a\u00020\u001fH\u0017J\b\u0010&\u001a\u00020\u001fH\u0014J\b\u0010\'\u001a\u00020\u001aH\u0014R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/emojimaker/horor/emoji/ui/splash/SplashActivity;", "Lcom/emojimaker/horor/emoji/core/base/BaseActivity;", "Lcom/emojimaker/horor/emoji/databinding/ActivitySplashBinding;", "<init>", "()V", "intentActivity", "Landroid/content/Intent;", "getIntentActivity", "()Landroid/content/Intent;", "setIntentActivity", "(Landroid/content/Intent;)V", "dataViewModel", "Lcom/emojimaker/horor/emoji/ui/home/DataViewModel;", "getDataViewModel", "()Lcom/emojimaker/horor/emoji/ui/home/DataViewModel;", "dataViewModel$delegate", "Lkotlin/Lazy;", "interCallBack", "Lcom/lvt/ads/callback/InterCallback;", "getInterCallBack", "()Lcom/lvt/ads/callback/InterCallback;", "setInterCallBack", "(Lcom/lvt/ads/callback/InterCallback;)V", "MIN_SPLASH_MS", "", "minTimePassed", "", "dataReady", "triggered", "setViewBinding", "initView", "", "dataObservable", "tryProceed", "viewListener", "initText", "initActionBar", "onBackPressed", "onResume", "shouldPlayBackgroundMusic", "ST295_Horror_Emoji_Maker_V1.0.1_07.28.2026_debug"})
public final class SplashActivity extends com.emojimaker.horor.emoji.core.base.BaseActivity<com.emojimaker.horor.emoji.databinding.ActivitySplashBinding> {
    @org.jetbrains.annotations.Nullable()
    private android.content.Intent intentActivity;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy dataViewModel$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private com.lvt.ads.callback.InterCallback interCallBack;
    private final long MIN_SPLASH_MS = 3000L;
    private boolean minTimePassed = false;
    private boolean dataReady = false;
    private boolean triggered = false;
    
    public SplashActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.content.Intent getIntentActivity() {
        return null;
    }
    
    public final void setIntentActivity(@org.jetbrains.annotations.Nullable()
    android.content.Intent p0) {
    }
    
    private final com.emojimaker.horor.emoji.ui.home.DataViewModel getDataViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.lvt.ads.callback.InterCallback getInterCallBack() {
        return null;
    }
    
    public final void setInterCallBack(@org.jetbrains.annotations.Nullable()
    com.lvt.ads.callback.InterCallback p0) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    protected com.emojimaker.horor.emoji.databinding.ActivitySplashBinding setViewBinding() {
        return null;
    }
    
    @java.lang.Override()
    protected void initView() {
    }
    
    @java.lang.Override()
    public void dataObservable() {
    }
    
    private final void tryProceed() {
    }
    
    @java.lang.Override()
    protected void viewListener() {
    }
    
    @java.lang.Override()
    public void initText() {
    }
    
    @java.lang.Override()
    protected void initActionBar() {
    }
    
    @java.lang.Override()
    @android.annotation.SuppressLint(value = {"GestureBackNavigation", "MissingSuperCall"})
    public void onBackPressed() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    protected boolean shouldPlayBackgroundMusic() {
        return false;
    }
}