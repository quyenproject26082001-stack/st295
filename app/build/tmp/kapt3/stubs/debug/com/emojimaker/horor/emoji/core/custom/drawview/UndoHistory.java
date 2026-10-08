package com.emojimaker.horor.emoji.core.custom.drawview;

/**
 * Stores snapshots owned by the caller; snapshots must not be mutated after recording.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\u0013\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0018J\r\u0010\u0019\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010\u001aJ\r\u0010\u001b\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010\u001aJ\u0013\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0018R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00028\u0000X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\fR$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001d"}, d2 = {"Lcom/emojimaker/horor/emoji/core/custom/drawview/UndoHistory;", "T", "", "initialState", "limit", "", "<init>", "(Ljava/lang/Object;I)V", "past", "Lkotlin/collections/ArrayDeque;", "future", "current", "Ljava/lang/Object;", "value", "getLimit", "()I", "setLimit", "(I)V", "canUndo", "", "canRedo", "record", "", "state", "(Ljava/lang/Object;)V", "undo", "()Ljava/lang/Object;", "redo", "clear", "ST295_Horror_Emoji_Maker_V1.0.6_10.08.2026_debug"})
public final class UndoHistory<T extends java.lang.Object> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.collections.ArrayDeque<T> past = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.collections.ArrayDeque<T> future = null;
    private T current;
    private int limit;
    
    public UndoHistory(T initialState, int limit) {
        super();
    }
    
    public final int getLimit() {
        return 0;
    }
    
    public final void setLimit(int value) {
    }
    
    public final boolean canUndo() {
        return false;
    }
    
    public final boolean canRedo() {
        return false;
    }
    
    public final void record(T state) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final T undo() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final T redo() {
        return null;
    }
    
    public final void clear(T state) {
    }
}