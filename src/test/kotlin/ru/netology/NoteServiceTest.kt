package ru.netology

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class NoteServiceTest {

    @Before
    fun clear() {
        NoteService.clearNotes()
        CommentService.clearComments()
        CommentService.clearDelComments()
    }


    @Test
    fun add_shouldAddCorrect() {
        val expectedNote = Note()
        val testNote = NoteService.add(Note())

        assertEquals(expectedNote, testNote)
    }

    @Test
    fun createComment_shouldReturnCommentCorrect() {
        NoteService.add(Note())
        val expectedComment = Comment()
        val testComment = NoteService.createComment(1, Comment())

        assertEquals(expectedComment, testComment)
    }

    @Test(expected = Exception::class)
    fun createComment_shouldThrowException() {
        NoteService.add(Note())
        val testComment = NoteService.createComment(2, Comment())
    }

    @Test
    fun update_shouldUpdateNoteById() {
        NoteService.add(Note())
        val expectedResTrue = NoteService.update(Note(id = 1))

        assertTrue(expectedResTrue)
    }

    @Test
    fun update_shouldNotUpdateNote() {
        NoteService.add(Note())
        val expectedResFalse = NoteService.update(Note(id = 99))

        assertFalse(expectedResFalse)
    }

    @Test
    fun updateComment_shouldReturnCommentCorrectly() {
        NoteService.add(Note(id = 1))
        NoteService.createComment(1, Comment())
        val expectedTrue = NoteService.updateComment(Comment(id = 1))

        assertTrue(expectedTrue)
    }

    @Test
    fun updateComment_shouldNotReturnComment() {
        NoteService.add(Note(id = 1))
        NoteService.createComment(1, Comment())
        val expectedFalse = NoteService.updateComment(Comment(id = 99))

        assertFalse(expectedFalse)
    }

    @Test
    fun delete_shouldReturnTrueOfDelete() {
        NoteService.add(Note(id = 1))
        NoteService.add(Note(id = 2))

        val expectedTrue = NoteService.delete(Note(id = 2))

        assertTrue(expectedTrue)
    }

    @Test
    fun delete_shouldReturnFalseBecauseNothingToDelete() {
        NoteService.add(Note(id = 1))
        NoteService.add(Note(id = 2))

        val expectedFalse = NoteService.delete(Note(id = 3))

        assertFalse(expectedFalse)
    }

    @Test
    fun deleteComment_shouldReturnTrueOfDelete() {
        NoteService.add(Note())
        NoteService.createComment(noteId = 1, Comment())

        val expectedTrue = NoteService.deleteComment(Comment(id = 1))

        assertTrue(expectedTrue)
    }

    @Test
    fun deleteComment_shouldReturnTFalseBecauseNothingToDelete() {
        NoteService.add(Note())
        NoteService.createComment(noteId = 1, Comment())

        val expectedFalse = NoteService.deleteComment(Comment(id = 2))

        assertFalse(expectedFalse)
    }

    @Test
    fun get_shouldReturnListCorrect() {
        val expectedList = listOf<Note>(Note(id = 1), Note(id = 2), Note(id = 3))

        NoteService.add(Note())
        NoteService.add(Note())
        NoteService.add(Note())

        val testList = NoteService.get(1)

        assertEquals(expectedList, testList)
    }

    @Test
    fun getById_shouldReturnNoteCorrect() {
        NoteService.add(Note(id = 1))
        val expectedNote = NoteService.add(Note(id = 2))

        val testNote = NoteService.getById(2)

        assertEquals(expectedNote, testNote)
    }

    @Test(expected = Exception::class)
    fun getById_shouldThrowException() {
        NoteService.add(Note(id = 1))
        NoteService.getById(2)
    }

    @Test
    fun getComments_shouldReturnCommentListCorrect() {
        NoteService.add(Note())
        NoteService.createComment(1, Comment())
        NoteService.createComment(1, Comment())

        val expectedList = listOf<Comment>(Comment(id = 1), Comment(id = 2))
        val testList = NoteService.getComments(1)

        assertEquals(expectedList, testList)
    }

    @Test(expected = Exception::class)
    fun getComments_shouldThrowException() {
        NoteService.add(Note())
        NoteService.createComment(1, Comment())
        NoteService.getComments(2)
    }

    @Test
    fun restoreComment_shouldReturnTrueOfRestore() {
        NoteService.add(Note())
        NoteService.createComment(1, Comment(id = 1))
        NoteService.deleteComment(Comment(id = 1))

        val expectedTrue = NoteService.restoreComment(1)
        assertTrue(expectedTrue)
    }

    @Test
    fun restoreComment_shouldReturnFalse() {
        NoteService.add(Note())
        NoteService.createComment(1, Comment(id = 1))
        NoteService.deleteComment(Comment(id = 1))

        val expectedFalse = NoteService.restoreComment(2)
        assertFalse(expectedFalse)
    }
}