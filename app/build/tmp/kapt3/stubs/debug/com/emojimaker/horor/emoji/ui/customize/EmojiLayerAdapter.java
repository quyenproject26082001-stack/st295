package com.emojimaker.horor.emoji.ui.customize;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001,B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0006\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u001a\u001a\u00020\t2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u001cJ\u001c\u0010\u001d\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\bH\u0016J\u001c\u0010!\u001a\u00020\t2\n\u0010\"\u001a\u00060\u0002R\u00020\u00002\u0006\u0010#\u001a\u00020\bH\u0016J\b\u0010$\u001a\u00020\bH\u0016J\u0016\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\bJ\u000e\u0010)\u001a\u00020\t2\u0006\u0010#\u001a\u00020\bJ\u000e\u0010*\u001a\u00020\t2\u0006\u0010#\u001a\u00020\bJ\b\u0010+\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t0\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R&\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001e\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0017j\b\u0012\u0004\u0012\u00020\u0007`\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/emojimaker/horor/emoji/ui/customize/EmojiLayerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/emojimaker/horor/emoji/ui/customize/EmojiLayerAdapter$LayerViewHolder;", "drawView", "Lcom/emojimaker/horor/emoji/core/custom/drawview/DrawView;", "onItemClick", "Lkotlin/Function2;", "Lcom/emojimaker/horor/emoji/data/model/draw/DrawableDraw;", "", "", "<init>", "(Lcom/emojimaker/horor/emoji/core/custom/drawview/DrawView;Lkotlin/jvm/functions/Function2;)V", "onStartDrag", "Lkotlin/Function1;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getOnStartDrag", "()Lkotlin/jvm/functions/Function1;", "setOnStartDrag", "(Lkotlin/jvm/functions/Function1;)V", "onItemCountChanged", "getOnItemCountChanged", "setOnItemCountChanged", "items", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "deleteVisiblePosition", "submitDraws", "draws", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "onItemMove", "", "fromPosition", "toPosition", "onItemDismiss", "revealDelete", "hideDelete", "LayerViewHolder", "ST295_Horror_Emoji_Maker_V1.0.3_09.18.2026_debug"})
public final class EmojiLayerAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.emojimaker.horor.emoji.ui.customize.EmojiLayerAdapter.LayerViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final com.emojimaker.horor.emoji.core.custom.drawview.DrawView drawView = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function2<com.emojimaker.horor.emoji.data.model.draw.DrawableDraw, java.lang.Integer, kotlin.Unit> onItemClick = null;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super androidx.recyclerview.widget.RecyclerView.ViewHolder, kotlin.Unit> onStartDrag;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onItemCountChanged;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.emojimaker.horor.emoji.data.model.draw.DrawableDraw> items = null;
    private int deleteVisiblePosition = androidx.recyclerview.widget.RecyclerView.NO_POSITION;
    
    public EmojiLayerAdapter(@org.jetbrains.annotations.NotNull()
    com.emojimaker.horor.emoji.core.custom.drawview.DrawView drawView, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super com.emojimaker.horor.emoji.data.model.draw.DrawableDraw, ? super java.lang.Integer, kotlin.Unit> onItemClick) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<androidx.recyclerview.widget.RecyclerView.ViewHolder, kotlin.Unit> getOnStartDrag() {
        return null;
    }
    
    public final void setOnStartDrag(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super androidx.recyclerview.widget.RecyclerView.ViewHolder, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> getOnItemCountChanged() {
        return null;
    }
    
    public final void setOnItemCountChanged(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> p0) {
    }
    
    public final void submitDraws(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.emojimaker.horor.emoji.data.model.draw.DrawableDraw> draws) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.emojimaker.horor.emoji.ui.customize.EmojiLayerAdapter.LayerViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.emojimaker.horor.emoji.ui.customize.EmojiLayerAdapter.LayerViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final boolean onItemMove(int fromPosition, int toPosition) {
        return false;
    }
    
    public final void onItemDismiss(int position) {
    }
    
    public final void revealDelete(int position) {
    }
    
    private final void hideDelete() {
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/emojimaker/horor/emoji/ui/customize/EmojiLayerAdapter$LayerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/emojimaker/horor/emoji/databinding/ItemLayerDrawBinding;", "<init>", "(Lcom/emojimaker/horor/emoji/ui/customize/EmojiLayerAdapter;Lcom/emojimaker/horor/emoji/databinding/ItemLayerDrawBinding;)V", "bind", "", "draw", "Lcom/emojimaker/horor/emoji/data/model/draw/DrawableDraw;", "position", "", "ST295_Horror_Emoji_Maker_V1.0.3_09.18.2026_debug"})
    public final class LayerViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.emojimaker.horor.emoji.databinding.ItemLayerDrawBinding binding = null;
        
        public LayerViewHolder(@org.jetbrains.annotations.NotNull()
        com.emojimaker.horor.emoji.databinding.ItemLayerDrawBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.emojimaker.horor.emoji.data.model.draw.DrawableDraw draw, int position) {
        }
    }
}