package com.emojimaker.horor.emoji.ui.customize;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0017\u0018B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\u0010\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u001c\u0010\u0014\u001a\u00020\u000b2\n\u0010\u0015\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0019"}, d2 = {"Lcom/emojimaker/horor/emoji/ui/customize/BottomNavigationCustomizeAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/emojimaker/horor/emoji/data/model/custom/NavigationModel;", "Lcom/emojimaker/horor/emoji/ui/customize/BottomNavigationCustomizeAdapter$BottomNavViewHolder;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "onItemClick", "Lkotlin/Function1;", "", "", "getOnItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnItemClick", "(Lkotlin/jvm/functions/Function1;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "BottomNavViewHolder", "Companion", "ST295_Horror_Emoji_Maker_V1.0.2_07.31.2026_debug"})
public final class BottomNavigationCustomizeAdapter extends androidx.recyclerview.widget.ListAdapter<com.emojimaker.horor.emoji.data.model.custom.NavigationModel, com.emojimaker.horor.emoji.ui.customize.BottomNavigationCustomizeAdapter.BottomNavViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onItemClick;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.emojimaker.horor.emoji.data.model.custom.NavigationModel> DiffCallback = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.emojimaker.horor.emoji.ui.customize.BottomNavigationCustomizeAdapter.Companion Companion = null;
    
    public BottomNavigationCustomizeAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> getOnItemClick() {
        return null;
    }
    
    public final void setOnItemClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> p0) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.emojimaker.horor.emoji.ui.customize.BottomNavigationCustomizeAdapter.BottomNavViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.emojimaker.horor.emoji.ui.customize.BottomNavigationCustomizeAdapter.BottomNavViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/emojimaker/horor/emoji/ui/customize/BottomNavigationCustomizeAdapter$BottomNavViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/emojimaker/horor/emoji/databinding/ItemBottomNavigationBinding;", "<init>", "(Lcom/emojimaker/horor/emoji/ui/customize/BottomNavigationCustomizeAdapter;Lcom/emojimaker/horor/emoji/databinding/ItemBottomNavigationBinding;)V", "bind", "", "item", "Lcom/emojimaker/horor/emoji/data/model/custom/NavigationModel;", "position", "", "ST295_Horror_Emoji_Maker_V1.0.2_07.31.2026_debug"})
    public final class BottomNavViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.emojimaker.horor.emoji.databinding.ItemBottomNavigationBinding binding = null;
        
        public BottomNavViewHolder(@org.jetbrains.annotations.NotNull()
        com.emojimaker.horor.emoji.databinding.ItemBottomNavigationBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.emojimaker.horor.emoji.data.model.custom.NavigationModel item, int position) {
        }
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/emojimaker/horor/emoji/ui/customize/BottomNavigationCustomizeAdapter$Companion;", "", "<init>", "()V", "DiffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/emojimaker/horor/emoji/data/model/custom/NavigationModel;", "getDiffCallback", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "ST295_Horror_Emoji_Maker_V1.0.2_07.31.2026_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.emojimaker.horor.emoji.data.model.custom.NavigationModel> getDiffCallback() {
            return null;
        }
    }
}