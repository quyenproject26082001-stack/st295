package com.emojimaker.horor.emoji.core.custom.drawview

import org.junit.Assert.*
import org.junit.Test

class UndoHistoryTest {
    @Test fun evictionStopsAtOldestRetainedState() {
        val history = UndoHistory(0, 30)
        (1..100).forEach(history::record)
        (99 downTo 70).forEach { assertEquals(it, history.undo()) }
        assertFalse(history.canUndo())
        assertNull(history.undo())
        (71..100).forEach { assertEquals(it, history.redo()) }
        assertFalse(history.canRedo())
    }

    @Test fun editingAfterUndoDropsRedoBranch() {
        val history = UndoHistory("empty", 30)
        history.record("a")
        history.record("b")
        assertEquals("a", history.undo())
        history.record("c")
        assertFalse(history.canRedo())
        assertEquals("a", history.undo())
        assertEquals("empty", history.undo())
    }

    @Test fun resetDropsBothHistories() {
        val history = UndoHistory(emptyList<String>(), 30)
        history.record(listOf("old bitmap"))
        history.undo()
        history.clear(emptyList())
        assertFalse(history.canUndo())
        assertFalse(history.canRedo())
        history.record(listOf("new bitmap"))
        assertEquals(emptyList<String>(), history.undo())
    }

    @Test fun reducingLimitStillBoundsHistoryAfterRedo() {
        val history = UndoHistory(0, 30)
        (1..10).forEach(history::record)
        repeat(5) { history.undo() }
        history.limit = 2
        assertEquals(6, history.redo())
        assertEquals(7, history.redo())
        assertEquals(6, history.undo())
        assertEquals(5, history.undo())
        assertNull(history.undo())
    }
}
