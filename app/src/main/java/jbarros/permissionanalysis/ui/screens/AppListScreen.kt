package jbarros.permissionanalysis.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import jbarros.permissionanalysis.core.localDataSource.PackageManagerSource
import jbarros.permissionanalysis.core.model.Application
import jbarros.permissionanalysis.ui.components.AplicationCard
import jbarros.permissionanalysis.ui.components.BottomNavigationBar
import jbarros.permissionanalysis.ui.components.TopNavigationBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppListScreen(
    modifier: Modifier = Modifier,
    applications: List<Application> = PackageManagerSource.getApps(LocalContext.current),
    navController: NavController?,
) {
    Scaffold(
        topBar = {TopNavigationBar(titulo = "Aplicaciones instaladas")},
        content = { paddingValues ->
            LazyColumn(modifier = modifier
                .padding(top = paddingValues.calculateTopPadding())
            ) {
                items(items = applications) { app ->
                    AplicationCard(appName = app.appName, packageName = app.packageName, app.appPermissionCount, app.permissions)
                }
            }
        },
        bottomBar = { BottomNavigationBar(navController = navController)}
    )

}

@Preview(
    showBackground = true
)
@Composable
fun AppListScreen(){
    AppListScreen(navController = null)
}