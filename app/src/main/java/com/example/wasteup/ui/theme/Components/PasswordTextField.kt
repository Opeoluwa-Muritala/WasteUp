package com.example.wasteup.ui.theme.Components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.wasteup.R

@Composable
fun Password() {
    var showIcon by rememberSaveable {
        mutableStateOf(false)
    }
    var password by rememberSaveable {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = password,
        onValueChange = {
            password = it
        },
        colors = TextFieldDefaults.colors(
            focusedPlaceholderColor = Color.Green,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedIndicatorColor = Color.Green,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black
        ),
        modifier = Modifier.fillMaxWidth(),
        visualTransformation = if (!showIcon) PasswordVisualTransformation('*') else VisualTransformation.None,
        shape = RoundedCornerShape(10.dp),
        trailingIcon = {
            Icon(
                painter = painterResource(id = if (!showIcon) R.drawable.eyeopened else R.drawable.eyeclosed),
                "show",
                modifier = Modifier
                    .clickable {
                        showIcon = !showIcon
                    }
                    .size(20.dp),
                tint = Color.LightGray
            )
        }
    )
}