package com.create.lalala.core.base;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u000b\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u0018\u0012\u0014\u0012\u00120\u0005R\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00000\u0004:\u0001\'B\'\u0012\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00010\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ(\u0010\u0012\u001a\u00120\u0005R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J(\u0010\u0016\u001a\u00020\u00172\u0016\u0010\u0018\u001a\u00120\u0005R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\b\u0010\u001a\u001a\u00020\u0015H\u0016J\u0016\u0010\u001b\u001a\u00020\u00172\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0016J\u001d\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00028\u00002\u0006\u0010 \u001a\u00028\u0000H\u0014\u00a2\u0006\u0002\u0010!J\u001d\u0010\"\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00028\u00002\u0006\u0010 \u001a\u00028\u0000H\u0014\u00a2\u0006\u0002\u0010!J%\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00028\u00012\u0006\u0010%\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u0015H$\u00a2\u0006\u0002\u0010&R&\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00010\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R!\u0010\r\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000ej\b\u0012\u0004\u0012\u00028\u0000`\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006("}, d2 = {"Lcom/create/lalala/core/base/BaseAdapter;", "T", "VB", "Landroidx/viewbinding/ViewBinding;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/create/lalala/core/base/BaseAdapter$BaseViewHolder;", "bindingInflater", "Lkotlin/Function3;", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "", "<init>", "(Lkotlin/jvm/functions/Function3;)V", "items", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItems", "()Ljava/util/ArrayList;", "onCreateViewHolder", "parent", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "submitList", "list", "", "areItemsTheSame", "oldItem", "newItem", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "areContentsTheSame", "onBind", "binding", "item", "(Landroidx/viewbinding/ViewBinding;Ljava/lang/Object;I)V", "BaseViewHolder", "ST295_Horror_Emoji_Maker_v1.0.0_07.17.2026_debug"})
public abstract class BaseAdapter<T extends java.lang.Object, VB extends androidx.viewbinding.ViewBinding> extends androidx.recyclerview.widget.RecyclerView.Adapter<com.create.lalala.core.base.BaseAdapter<T, VB>.BaseViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function3<android.view.LayoutInflater, android.view.ViewGroup, java.lang.Boolean, VB> bindingInflater = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<T> items = null;
    
    public BaseAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function3<? super android.view.LayoutInflater, ? super android.view.ViewGroup, ? super java.lang.Boolean, ? extends VB> bindingInflater) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<T> getItems() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.create.lalala.core.base.BaseAdapter<T, VB>.BaseViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.create.lalala.core.base.BaseAdapter<T, VB>.BaseViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public void submitList(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends T> list) {
    }
    
    protected boolean areItemsTheSame(T oldItem, T newItem) {
        return false;
    }
    
    protected boolean areContentsTheSame(T oldItem, T newItem) {
        return false;
    }
    
    protected abstract void onBind(@org.jetbrains.annotations.NotNull()
    VB binding, T item, int position);
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00028\u0001\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rR\u0013\u0010\u0002\u001a\u00028\u0001\u00a2\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000e"}, d2 = {"Lcom/create/lalala/core/base/BaseAdapter$BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "<init>", "(Lcom/create/lalala/core/base/BaseAdapter;Landroidx/viewbinding/ViewBinding;)V", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "Landroidx/viewbinding/ViewBinding;", "bindItem", "", "item", "position", "", "(Ljava/lang/Object;I)V", "ST295_Horror_Emoji_Maker_v1.0.0_07.17.2026_debug"})
    public final class BaseViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final VB binding = null;
        
        public BaseViewHolder(@org.jetbrains.annotations.NotNull()
        VB binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final VB getBinding() {
            return null;
        }
        
        public final void bindItem(T item, int position) {
        }
    }
}