package com.create.lalala.listener.listenerdraw;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\r\u001a\u00020\u0003H&J\u0018\u0010\u000e\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000fH&J\u0018\u0010\u0010\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000fH&J\b\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\u0003H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0017\u00c0\u0006\u0003"}, d2 = {"Lcom/create/lalala/listener/listenerdraw/OnDrawListener;", "", "onAddedDraw", "", "draw", "Lcom/create/lalala/data/model/draw/Draw;", "onClickedDraw", "onDeletedDraw", "onDragFinishedDraw", "onTouchedDownDraw", "onZoomFinishedDraw", "onFlippedDraw", "onDoubleTappedDraw", "onHideOptionIconDraw", "onUndoDeleteDraw", "", "onUndoUpdateDraw", "onUndoDeleteAll", "onRedoAll", "onReplaceDraw", "onEditText", "Lcom/create/lalala/data/model/draw/DrawableDraw;", "onReplace", "ST295_Horror_Emoji_Maker_v1.0.0_07.17.2026_debug"})
public abstract interface OnDrawListener {
    
    public abstract void onAddedDraw(@org.jetbrains.annotations.NotNull()
    com.create.lalala.data.model.draw.Draw draw);
    
    public abstract void onClickedDraw(@org.jetbrains.annotations.NotNull()
    com.create.lalala.data.model.draw.Draw draw);
    
    public abstract void onDeletedDraw(@org.jetbrains.annotations.NotNull()
    com.create.lalala.data.model.draw.Draw draw);
    
    public abstract void onDragFinishedDraw(@org.jetbrains.annotations.NotNull()
    com.create.lalala.data.model.draw.Draw draw);
    
    public abstract void onTouchedDownDraw(@org.jetbrains.annotations.NotNull()
    com.create.lalala.data.model.draw.Draw draw);
    
    public abstract void onZoomFinishedDraw(@org.jetbrains.annotations.NotNull()
    com.create.lalala.data.model.draw.Draw draw);
    
    public abstract void onFlippedDraw(@org.jetbrains.annotations.NotNull()
    com.create.lalala.data.model.draw.Draw draw);
    
    public abstract void onDoubleTappedDraw(@org.jetbrains.annotations.NotNull()
    com.create.lalala.data.model.draw.Draw draw);
    
    public abstract void onHideOptionIconDraw();
    
    public abstract void onUndoDeleteDraw(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.create.lalala.data.model.draw.Draw> draw);
    
    public abstract void onUndoUpdateDraw(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.create.lalala.data.model.draw.Draw> draw);
    
    public abstract void onUndoDeleteAll();
    
    public abstract void onRedoAll();
    
    public abstract void onReplaceDraw(@org.jetbrains.annotations.NotNull()
    com.create.lalala.data.model.draw.Draw draw);
    
    public abstract void onEditText(@org.jetbrains.annotations.NotNull()
    com.create.lalala.data.model.draw.DrawableDraw draw);
    
    public abstract void onReplace(@org.jetbrains.annotations.NotNull()
    com.create.lalala.data.model.draw.Draw draw);
}