package jbarros.permissionanalysis.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavController


@Composable
fun BottomNavigationBar(
    navController: NavController?
) {
    val currentRoute = navController?.currentBackStackEntry?.destination?.route
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("appList", "sendApps")
    if (currentRoute != null) {
        selectedItem = items.indexOf(currentRoute)
    }

    NavigationBar {
        items.forEachIndexed { index, item ->

            NavigationBarItem(
                icon = { Icon(Icons.Filled.Favorite, contentDescription = item) },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = { selectedItem = index ;navController?.navigate(item)}
            )

        }
    }
}
