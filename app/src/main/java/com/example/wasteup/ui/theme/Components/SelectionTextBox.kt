package com.example.wasteup

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountrySelectionBox(
    modifier: Modifier = Modifier,
    label: String,
    countries: List<String>
) {
    var expanded by remember { mutableStateOf(false) }
    var searchText by remember { mutableStateOf("") }

    Box(modifier
        .clickable{
             expanded = !expanded }
    ) {
        OutlinedTextField(
            value = searchText,
            onValueChange = {
                searchText = it
            },
            label = {
                Text(text = label)
            },
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Black,
                focusedLabelColor = Color.Black,
                unfocusedLabelColor = Color.Black,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                containerColor = Color.Transparent,
                cursorColor = Color.Black
            ),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "Toggle Dropdown",
                    modifier = Modifier.clickable { expanded = !expanded }
                )
            },
            readOnly = false,
            modifier = modifier
                .clickable(
                    enabled = true, onClick = { expanded = !expanded }
                )
                .align(Alignment.TopStart)
                .fillMaxWidth()
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.width(IntrinsicSize.Min).align(Alignment.BottomStart),

        ) {
            countries
                .filter { it.lowercase().contains(searchText.lowercase()) }
                .forEach { country ->
                    DropdownMenuItem(
                        text = { Text(text = country) },
                        onClick = {
                            searchText = country
                            expanded = false
                        }
                    )
                }
        }
    }
}