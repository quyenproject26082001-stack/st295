package com.emojimaker.horor.emoji.ui.package_view;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0018\u001a\u00020\u0002H\u0014J\b\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0014J\u0018\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` H\u0002J \u0010!\u001a\u00020\u001a2\u0016\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` H\u0002J \u0010#\u001a\u00020\u001a2\u0016\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` H\u0002J\b\u0010$\u001a\u00020\u001aH\u0014J\b\u0010%\u001a\u00020\u001aH\u0016J\b\u0010&\u001a\u00020\u001aH\u0014J\b\u0010\'\u001a\u00020\u001aH\u0002J\b\u0010(\u001a\u00020\u001aH\u0002J\b\u0010)\u001a\u00020\u001aH\u0002J\u0010\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u0016H\u0002J\b\u0010,\u001a\u00020\u001aH\u0002J\b\u0010-\u001a\u00020\u001aH\u0014R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/emojimaker/horor/emoji/ui/package_view/ViewAllPackageActivity;", "Lcom/emojimaker/horor/emoji/core/utils/share/whatsapp/WhatsappSharingActivity;", "Lcom/emojimaker/horor/emoji/databinding/ActivityViewAllPackageBinding;", "<init>", "()V", "viewModel", "Lcom/emojimaker/horor/emoji/ui/my_creation/view_model/ViewAllPackageViewModel;", "getViewModel", "()Lcom/emojimaker/horor/emoji/ui/my_creation/view_model/ViewAllPackageViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "shareViewModel", "Lcom/emojimaker/horor/emoji/ui/my_creation/view_model/MyCreationViewModel;", "getShareViewModel", "()Lcom/emojimaker/horor/emoji/ui/my_creation/view_model/MyCreationViewModel;", "shareViewModel$delegate", "packageItemAdapter", "Lcom/emojimaker/horor/emoji/ui/my_creation/adapter/PackageItemAdapter;", "getPackageItemAdapter", "()Lcom/emojimaker/horor/emoji/ui/my_creation/adapter/PackageItemAdapter;", "packageItemAdapter$delegate", "isInSelectionMode", "", "isAllSelected", "setViewBinding", "initView", "", "dataObservable", "viewListener", "getTargetPackagePaths", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "handleAddToTelegram", "paths", "handleAddToWhatsApp", "initActionBar", "initAds", "onRestart", "enterSelectionMode", "resetSelectionMode", "handleSelectAll", "updateSelectAllIcon", "allSelected", "handleDeleteSelected", "onResume", "ST295_Horror_Emoji_Maker_V1.0.3_09.18.2026_debug"})
public final class ViewAllPackageActivity extends com.emojimaker.horor.emoji.core.utils.share.whatsapp.WhatsappSharingActivity<com.emojimaker.horor.emoji.databinding.ActivityViewAllPackageBinding> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy shareViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy packageItemAdapter$delegate = null;
    private boolean isInSelectionMode = false;
    private boolean isAllSelected = false;
    
    public ViewAllPackageActivity() {
        super();
    }
    
    private final com.emojimaker.horor.emoji.ui.my_creation.view_model.ViewAllPackageViewModel getViewModel() {
        return null;
    }
    
    private final com.emojimaker.horor.emoji.ui.my_creation.view_model.MyCreationViewModel getShareViewModel() {
        return null;
    }
    
    private final com.emojimaker.horor.emoji.ui.my_creation.adapter.PackageItemAdapter getPackageItemAdapter() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    protected com.emojimaker.horor.emoji.databinding.ActivityViewAllPackageBinding setViewBinding() {
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
    
    private final java.util.ArrayList<java.lang.String> getTargetPackagePaths() {
        return null;
    }
    
    private final void handleAddToTelegram(java.util.ArrayList<java.lang.String> paths) {
    }
    
    private final void handleAddToWhatsApp(java.util.ArrayList<java.lang.String> paths) {
    }
    
    @java.lang.Override()
    protected void initActionBar() {
    }
    
    @java.lang.Override()
    public void initAds() {
    }
    
    @java.lang.Override()
    protected void onRestart() {
    }
    
    private final void enterSelectionMode() {
    }
    
    private final void resetSelectionMode() {
    }
    
    private final void handleSelectAll() {
    }
    
    private final void updateSelectAllIcon(boolean allSelected) {
    }
    
    private final void handleDeleteSelected() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
}