package jbarros.permissionanalysis.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import jbarros.permissionanalysis.core.localDataSource.PackageManagerSource
import jbarros.permissionanalysis.core.model.Application
import jbarros.permissionanalysis.ui.components.AplicationCard

@Composable
fun AppListScreen(
    modifier: Modifier = Modifier,
    applications: List<Application> = PackageManagerSource.getApps(LocalContext.current)
) {
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(items = applications) { app ->
            AplicationCard(appName = app.appName, packageName = app.packageName, app.appPermissionCount, app.permissions)
        }
    }
}