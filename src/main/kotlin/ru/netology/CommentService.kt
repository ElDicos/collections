package ru.netology

object CommentService : Basic_Functionality<Comment> {

    private val comments = mutableListOf<Comment>()
    private val deletedComments = mutableListOf<Comment>()
    private var newId = 1

    override fun add(item: Comment): Comment {
        val newComment = item.copy(id = newId)
        newId++
        comments += newComment
        return newComment
    }

    override fun update(item: Comment): Boolean {
        for ((index, commentId) in comments.withIndex())
            if (commentId.id == item.id) {
                comments[index] = item
                return true
            }
        return false
    }

    override fun delete(item: Comment): Boolean {
        for ((index, commentId) in comments.withIndex())
            if (commentId.id == item.id) {
                deletedComments += commentId
                comments.removeAt(index)
                return true
            }
        return false
    }

    fun get(noteId: Int): List<Comment> {
        var commentList = emptyList<Comment>()
        for (searchedId in comments)
            if (searchedId.noteId == noteId) {
                commentList += searchedId
            }
        return commentList
    }

    fun restore(id: Int): Boolean {
        for (existId in comments)
            if (existId.id == id)
                return false
        for (searchedId in deletedComments)
            if (searchedId.id == id) {
                comments += searchedId
                return true
            }
        return false
    }

    fun clearComments() {
        newId = 1
        comments.clear()
    }

    fun clearDelComments() {
        deletedComments.clear()
    }
}
