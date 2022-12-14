package jbarros.permissionanalysis.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import jbarros.permissionanalysis.ui.components.BottomNavigationBar
import jbarros.permissionanalysis.ui.components.TopNavigationBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SendAppsScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {TopNavigationBar("Enviar analysis a API")},
        content = {paddingValues ->
            Column(modifier = modifier
                .fillMaxSize()
                .padding(top = paddingValues.calculateTopPadding())
                .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Text(text = "En esta pantalla se enviaran las aplicaciones a mongodb para tener un dataset con las aplicaciones y sus permisos")
                Button(
                    modifier = Modifier.padding(vertical = 24.dp),
                    onClick = {},
                ) {
                    Text("Enviar datos")
                }
            }

        },
        bottomBar = {BottomNavigationBar(navController)}
    )

}