package com.example.wasteup.ui.theme.Components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextFieldAndText(
    content: @Composable ColumnScope.() -> Unit,
    text: AnnotatedString = buildAnnotatedString {
        append("E-mail *")
        addStyle(
            SpanStyle(
                color = Color.Red,
            ),
            7,
            8
        )
    }
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(text = text,
            fontSize = 10.sp,
            color = Color.Black
        )
        content()
    }
}