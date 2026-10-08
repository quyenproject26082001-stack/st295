package com.emojimaker.horor.emoji.core.custom.drawview

/** Stores snapshots owned by the caller; snapshots must not be mutated after recording. */
internal class UndoHistory<T>(initialState: T, limit: Int = Int.MAX_VALUE) {
    private val past = ArrayDeque<T>()
    private val future = ArrayDeque<T>()
    private var current = initialState

    var limit: Int = limit
        set(value) {
            require(value > 0)
            field = value
            while (past.size > value) past.removeFirst()
            while (future.size > value) future.removeFirst()
        }

    init { require(limit > 0) }

    fun canUndo() = past.isNotEmpty()
    fun canRedo() = future.isNotEmpty()

    fun record(state: T) {
        past.addLast(current)
        while (past.size > limit) past.removeFirst()
        current = state
        future.clear()
    }

    fun undo(): T? {
        if (!canUndo()) return null
        future.addLast(current)
        current = past.removeLast()
        return current
    }

    fun redo(): T? {
        if (!canRedo()) return null
        past.addLast(current)
        while (past.size > limit) past.removeFirst()
        current = future.removeLast()
        return current
    }

    fun clear(state: T) {
        past.clear()
        future.clear()
        current = state
    }
}
