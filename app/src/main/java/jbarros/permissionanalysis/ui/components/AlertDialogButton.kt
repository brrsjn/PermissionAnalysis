package jbarros.permissionanalysis.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AlertDialogButton(name: String, appName: String) {
    MaterialTheme {
        Column {
            val openDialog = remember { mutableStateOf(false)  }

            ElevatedButton(
                modifier = Modifier.padding(16.dp)
                ,onClick = {
                    openDialog.value = true
                }) {
                Text(name)
            }
            if (openDialog.value) {
                AlertDialog(
                    onDismissRequest = {
                        // Dismiss the dialog when the user clicks outside the dialog or on the back
                        // button. If you want to disable that functionality, simply use an empty
                        // onDismissRequest.
                        openDialog.value = false
                    },
                    title = {
                        Text(text = "Eliminar aplicación")
                    },
                    text = {
                        Text(text = "Vas a eliminar la aplicacion $appName ¿Estas seguro?")
                    },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                openDialog.value = false
                            }
                        ) {
                            Text("Confirmar")
                        }
                    },
                    dismissButton = {
                        TextButton(
                            onClick = {
                                openDialog.value = false
                            }
                        ) {
                            Text("Cancelar")
                        }
                    }
                )


            }
        }
    }

}
