package ru.netology

object NoteService : Basic_Functionality<Note> {

    private val notes = mutableListOf<Note>()

    override fun add(item: Note): Note {
        var newId = 1
        for (noteId in notes)
            if (noteId.id >= newId) {
                newId = noteId.id + 1
            }
        val newNote = item.copy(id = newId)
        notes.add(newNote)
        return newNote
    }

    fun createComment(noteId: Int, comment: Comment): Comment {
        for (searchedId in notes)
            if (searchedId.id == noteId) {
                val newComment = comment.copy(noteId = noteId)
                return CommentService.add(newComment)
            }
        return throw Exception("Заметки с данным id не существует")
    }

    override fun update(item: Note): Boolean {
        for ((index, noteId) in notes.withIndex())
            if (noteId.id == item.id) {
                notes[index] = item
                return true
            }
        return false
    }

    fun updateComment(comment: Comment): Boolean {
        return CommentService.update(comment)
    }

    override fun delete(item: Note): Boolean {
        for ((index, noteId) in notes.withIndex())
            if (noteId.id == item.id) {
                notes.removeAt(index)
                return true
            }
        return false
    }

    fun deleteComment(comment: Comment): Boolean {
        return CommentService.delete(comment)
    }

    fun get(ownerId: Int): List<Note> {
        var noteList = emptyList<Note>()
        for (searchedId in notes)
            if (searchedId.ownerId == ownerId) {
                noteList += searchedId
            }
        return noteList
    }

    fun getById(id: Int): Note {
        for (searchedId in notes)
            if (searchedId.id == id)
                return searchedId
        return throw Exception("Заметка не найдена")
    }

    fun getComments(id: Int): List<Comment> {
        for (searchedId in notes)
            if (searchedId.id == id) {
                return CommentService.get(id)
            }
        return throw Exception("Заметки не существует")
    }

    fun restoreComment(id: Int): Boolean {
        return CommentService.restore(id)
    }

    fun clearNotes() {
        notes.clear()
    }
}


