package chistousov.ilya.common

interface Permissions {

    fun checkPermission(permission: String): Boolean

    fun requestPermission(permission: String)
}