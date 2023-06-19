package chistousov.ilya.common

interface BaseMapper<T, R> {

    fun map(input: T): R
}