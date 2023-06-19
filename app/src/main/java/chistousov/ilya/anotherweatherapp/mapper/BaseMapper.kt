package chistousov.ilya.anotherweatherapp.mapper

interface BaseMapper<T, R> {

    fun map(input: T): R
}