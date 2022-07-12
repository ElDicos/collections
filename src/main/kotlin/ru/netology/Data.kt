package ru.netology

data class Note(
    val id: Int = 1,
    val ownerId: Int = 1,
    val title: String = "default title",
    val text: String = "default text",
    val date: Int = 1,
    val comments: Int = 1,
    val readComments: Int = 1,
    val viewUrl: String = "default url",
    val privacyView: String = "default privacy",
    val canComment: Int = 1,
    val textWiki: String = "default wiki",
) {
}

data class Comment(
    val id: Int = 1,
    val fromId: Int = 1,
    val noteId: Int = 1,
    val date: Int = 1,
    val text: String = "default text",
) {
}