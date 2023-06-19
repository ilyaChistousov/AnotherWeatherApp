package chistousov.ilya.common

/**
 * Any exception that occurs in the application
 */
class AppException(message: String = "", cause: Throwable? = null) : Exception(message)