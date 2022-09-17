package com.example.composefirstapp.ui.composable

import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composefirstapp.ui.data.DialogContent

@Composable
fun SimpleDialog(
    data : DialogContent,
    onCancel: () -> Unit,
    onAccept: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onCancel,
        title = {
            Text(data.title)
        },
        text = {
            Text(data.content)
        },
        buttons = {
            Row(
                modifier = Modifier.padding(all = 8.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
            //confirmButton = {
                Button(
                    onClick = onAccept
                ) {
                    Text("Accept")
                }
            //},
            //dismissButton = {
                Button(
                    onClick = onCancel
                ) {
                    Text("Cancel")
                }
            }
        //}
        }



    )
}