//package ru.netology
//
//fun main() {
//
//    val note = Note()
//    NoteService.add(note)
//    NoteService.add(Note())
//    NoteService.add(Note())
//    println(NoteService.get(0))
//
//    val noteU = Note()
//    NoteService.add(noteU)
//    println(NoteService.get(1))
//
//
//    println(NoteService.get(1))
//    println(NoteService.getById(3))
//
//    println(NoteService.createComment(1, Comment()))
//    println(NoteService.createComment(2, Comment(text = "asd")))
//    println(NoteService.createComment(2, Comment()))
//    println(NoteService.updateComment(Comment(id = 2, text = "Chanasdd")))
//    println(NoteService.createComment(2, Comment()))
//    println()
//    println(NoteService.getComments(2))
//    println(NoteService.deleteComment(Comment(id = 3, noteId = 2 )))
//    println(NoteService.updateComment(Comment(id = 3, noteId = 2 , text = "234234")))
//    println(NoteService.delete(Note(id = 2)))
//    println(NoteService.getComments(2))
//
//}
