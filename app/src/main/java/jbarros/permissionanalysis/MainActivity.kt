package jbarros.permissionanalysis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

import jbarros.permissionanalysis.ui.screens.AppListScreen
import jbarros.permissionanalysis.ui.screens.OnboardingScreen
import jbarros.permissionanalysis.ui.theme.PermissionAnalysisTheme

import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import jbarros.permissionanalysis.ui.components.TopNavigationBar
import jbarros.permissionanalysis.ui.screens.SendAppsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PermissionAnalysisTheme {
                NavigationHost(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun NavigationHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    Surface(modifier) {
        NavHost(navController = navController, startDestination = "onBoarding") {
            composable(route = "onBoarding") {
                OnboardingScreen(navController)
            }
            composable(route = "appList") {
                Column {
                    AppListScreen(navController = navController)
                }
            }
            composable(route = "sendApps") {
                Column {
                    SendAppsScreen(navController= navController)
                }
            }
        }
    }
}