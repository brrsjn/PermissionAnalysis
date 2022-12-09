package jbarros.permissionanalysis.ui.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight

@Composable
fun AplicationCard(appName: String, packageName: String, permissionQuantity: Int, permisos: List<String>) {

    var expanded by remember { mutableStateOf(false) }

    val extraPadding by animateDpAsState(
        if (expanded) 48.dp else 0.dp
    )
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier
                .weight(1f)
                .padding(bottom = extraPadding)
            ) {
                Row {
                    Text(text = appName)
                    ElevatedButton(
                        onClick = { expanded = !expanded },
                        modifier = Modifier.padding(start = 15.dp)
                    ) {
                        Text(if (expanded) "Ocultar" else "Ver más")
                    }
                }
                if (expanded) {
                    Row {
                        Text(text = "Nombre del paquete:", fontWeight = FontWeight.Bold)
                        Text(text = packageName)
                    }
                    Text(text = "Cantidad de permisos: $permissionQuantity", fontWeight = FontWeight.Bold)
                    if (permissionQuantity == 0) {
                        Text(text = "No hay permisos para mostrar")
                    } else {
                        for (permiso in permisos) {
                            Text(text = permiso)
                        }
                    }

                    AlertDialogButton("Eliminar", appName = appName)
                    
                }
            }
        }
    }
}