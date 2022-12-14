package jbarros.permissionanalysis.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.ui.platform.LocalContext
import jbarros.permissionanalysis.core.localDataSource.PackageManagerSource


@Composable
fun OnboardingScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    var isClicked by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier.fillMaxSize().padding(horizontal = 10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Bienvenido al auditor de privacidad", fontSize = 30.sp)
        Text("Escanearemos tu dispositivo en búsqueda de las aplicaciones instaladas y sus permisos")
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = {isClicked = true},
        ) {
            Text("Analizar dispositivo")
        }
        if (isClicked) {
            Text("Cargando...")
            navController.navigate("appList")
            isClicked = false
        }
    }
}