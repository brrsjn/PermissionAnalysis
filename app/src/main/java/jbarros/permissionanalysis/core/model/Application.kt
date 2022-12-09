package jbarros.permissionanalysis.core.model

data class Application (
    val packageName: String,
    val appName: String,
    val appPermissionCount: Int,
    val permissions: List<String>
)