package com.create.lalala.ui.trending;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0019\u001a\u00020\u0002H\u0014J\b\u0010\u001a\u001a\u00020\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0014J\b\u0010\u001e\u001a\u00020\u001bH\u0014J\b\u0010\u001f\u001a\u00020\u001bH\u0002J\u001a\u0010 \u001a\u00020\u001b2\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\"H\u0002J\b\u0010#\u001a\u00020\u001bH\u0002J\"\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u00162\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\"H\u0002J\u001e\u0010&\u001a\b\u0012\u0004\u0012\u00020(0\'2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\"H\u0002J\b\u0010)\u001a\u00020\u001bH\u0002J\u0010\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u0018H\u0016J\b\u0010.\u001a\u00020\u001bH\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/create/lalala/ui/trending/TrendingActivity;", "Lcom/create/lalala/core/base/BaseActivity;", "Lcom/create/lalala/databinding/ActivityTrendingBinding;", "<init>", "()V", "viewModel", "Lcom/create/lalala/ui/random_character/RandomCharacterViewModel;", "getViewModel", "()Lcom/create/lalala/ui/random_character/RandomCharacterViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "dataViewModel", "Lcom/create/lalala/ui/home/DataViewModel;", "getDataViewModel", "()Lcom/create/lalala/ui/home/DataViewModel;", "dataViewModel$delegate", "customizeCharacterViewModel", "Lcom/create/lalala/ui/customize/CustomizeCharacterViewModel;", "getCustomizeCharacterViewModel", "()Lcom/create/lalala/ui/customize/CustomizeCharacterViewModel;", "customizeCharacterViewModel$delegate", "currentSuggestion", "Lcom/create/lalala/data/model/custom/SuggestionModel;", "isAnimating", "", "setViewBinding", "initView", "", "dataObservable", "viewListener", "initActionBar", "initData", "showRandomSuggestion", "onComplete", "Lkotlin/Function0;", "handleGenerate", "renderSuggestion", "model", "glideListener", "Lcom/bumptech/glide/request/RequestListener;", "Landroid/graphics/drawable/Drawable;", "handleEdit", "onWindowFocusChanged", "hasFocus", "reHideRunnable", "Ljava/lang/Runnable;", "applyUiCustomize", "ST295_Horror_Emoji_Maker_v1.0.0_07.17.2026_debug"})
public final class TrendingActivity extends com.create.lalala.core.base.BaseActivity<com.create.lalala.databinding.ActivityTrendingBinding> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy dataViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy customizeCharacterViewModel$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private com.create.lalala.data.model.custom.SuggestionModel currentSuggestion;
    private boolean isAnimating = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Runnable reHideRunnable = null;
    
    public TrendingActivity() {
        super();
    }
    
    private final com.create.lalala.ui.random_character.RandomCharacterViewModel getViewModel() {
        return null;
    }
    
    private final com.create.lalala.ui.home.DataViewModel getDataViewModel() {
        return null;
    }
    
    private final com.create.lalala.ui.customize.CustomizeCharacterViewModel getCustomizeCharacterViewModel() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    protected com.create.lalala.databinding.ActivityTrendingBinding setViewBinding() {
        return null;
    }
    
    @java.lang.Override()
    protected void initView() {
    }
    
    @java.lang.Override()
    public void dataObservable() {
    }
    
    @java.lang.Override()
    protected void viewListener() {
    }
    
    @java.lang.Override()
    protected void initActionBar() {
    }
    
    private final void initData() {
    }
    
    private final void showRandomSuggestion(kotlin.jvm.functions.Function0<kotlin.Unit> onComplete) {
    }
    
    private final void handleGenerate() {
    }
    
    private final void renderSuggestion(com.create.lalala.data.model.custom.SuggestionModel model, kotlin.jvm.functions.Function0<kotlin.Unit> onComplete) {
    }
    
    private final com.bumptech.glide.request.RequestListener<android.graphics.drawable.Drawable> glideListener(kotlin.jvm.functions.Function0<kotlin.Unit> onComplete) {
        return null;
    }
    
    private final void handleEdit() {
    }
    
    @java.lang.Override()
    public void onWindowFocusChanged(boolean hasFocus) {
    }
    
    @kotlin.Suppress(names = {"DEPRECATION"})
    private final void applyUiCustomize() {
    }
}