package ru.netology

interface Basic_Functionality<T> {

    fun add(item: T) : T

    fun update(item: T) : Boolean

    fun delete(item: T) : Boolean
}