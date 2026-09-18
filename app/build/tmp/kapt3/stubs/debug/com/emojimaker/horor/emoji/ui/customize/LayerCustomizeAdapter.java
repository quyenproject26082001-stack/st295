package com.emojimaker.horor.emoji.ui.customize;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 )2\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002()B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u001fJ\u001c\u0010!\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\fH\u0016J\u001c\u0010%\u001a\u00020\r2\n\u0010&\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\'\u001a\u00020\fH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR,\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R&\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006*"}, d2 = {"Lcom/emojimaker/horor/emoji/ui/customize/LayerCustomizeAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/emojimaker/horor/emoji/data/model/custom/ItemNavCustomModel;", "Lcom/emojimaker/horor/emoji/ui/customize/LayerCustomizeAdapter$CustomizeViewHolder;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "onItemClick", "Lkotlin/Function2;", "", "", "getOnItemClick", "()Lkotlin/jvm/functions/Function2;", "setOnItemClick", "(Lkotlin/jvm/functions/Function2;)V", "onNoneClick", "Lkotlin/Function1;", "getOnNoneClick", "()Lkotlin/jvm/functions/Function1;", "setOnNoneClick", "(Lkotlin/jvm/functions/Function1;)V", "onRandomClick", "Lkotlin/Function0;", "getOnRandomClick", "()Lkotlin/jvm/functions/Function0;", "setOnRandomClick", "(Lkotlin/jvm/functions/Function0;)V", "getUnlockedGifPositions", "", "items", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "CustomizeViewHolder", "Companion", "ST295_Horror_Emoji_Maker_V1.0.3_09.18.2026_debug"})
public final class LayerCustomizeAdapter extends androidx.recyclerview.widget.ListAdapter<com.emojimaker.horor.emoji.data.model.custom.ItemNavCustomModel, com.emojimaker.horor.emoji.ui.customize.LayerCustomizeAdapter.CustomizeViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function2<? super com.emojimaker.horor.emoji.data.model.custom.ItemNavCustomModel, ? super java.lang.Integer, kotlin.Unit> onItemClick;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onNoneClick;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function0<kotlin.Unit> onRandomClick;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.emojimaker.horor.emoji.data.model.custom.ItemNavCustomModel> DiffCallback = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.emojimaker.horor.emoji.ui.customize.LayerCustomizeAdapter.Companion Companion = null;
    
    public LayerCustomizeAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function2<com.emojimaker.horor.emoji.data.model.custom.ItemNavCustomModel, java.lang.Integer, kotlin.Unit> getOnItemClick() {
        return null;
    }
    
    public final void setOnItemClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super com.emojimaker.horor.emoji.data.model.custom.ItemNavCustomModel, ? super java.lang.Integer, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> getOnNoneClick() {
        return null;
    }
    
    public final void setOnNoneClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function0<kotlin.Unit> getOnRandomClick() {
        return null;
    }
    
    public final void setOnRandomClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Integer> getUnlockedGifPositions(@org.jetbrains.annotations.NotNull()
    java.util.List<com.emojimaker.horor.emoji.data.model.custom.ItemNavCustomModel> items) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.emojimaker.horor.emoji.ui.customize.LayerCustomizeAdapter.CustomizeViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.emojimaker.horor.emoji.ui.customize.LayerCustomizeAdapter.CustomizeViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/emojimaker/horor/emoji/ui/customize/LayerCustomizeAdapter$Companion;", "", "<init>", "()V", "DiffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/emojimaker/horor/emoji/data/model/custom/ItemNavCustomModel;", "getDiffCallback", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "ST295_Horror_Emoji_Maker_V1.0.3_09.18.2026_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.emojimaker.horor.emoji.data.model.custom.ItemNavCustomModel> getDiffCallback() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/emojimaker/horor/emoji/ui/customize/LayerCustomizeAdapter$CustomizeViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/emojimaker/horor/emoji/databinding/ItemCustomizeBinding;", "<init>", "(Lcom/emojimaker/horor/emoji/ui/customize/LayerCustomizeAdapter;Lcom/emojimaker/horor/emoji/databinding/ItemCustomizeBinding;)V", "getBinding", "()Lcom/emojimaker/horor/emoji/databinding/ItemCustomizeBinding;", "bind", "", "item", "Lcom/emojimaker/horor/emoji/data/model/custom/ItemNavCustomModel;", "position", "", "ST295_Horror_Emoji_Maker_V1.0.3_09.18.2026_debug"})
    public final class CustomizeViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.emojimaker.horor.emoji.databinding.ItemCustomizeBinding binding = null;
        
        public CustomizeViewHolder(@org.jetbrains.annotations.NotNull()
        com.emojimaker.horor.emoji.databinding.ItemCustomizeBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.emojimaker.horor.emoji.databinding.ItemCustomizeBinding getBinding() {
            return null;
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.emojimaker.horor.emoji.data.model.custom.ItemNavCustomModel item, int position) {
        }
    }
}