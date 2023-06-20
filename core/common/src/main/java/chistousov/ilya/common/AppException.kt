package chistousov.ilya.common

/**
 * Any exception that occurs in the application
 */
open class AppException(message: String = "") : Exception(message)

class MissingInternetException : AppException()