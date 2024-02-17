package com.example.wasteup.ui.theme.OnboardingViews.SignUp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wasteup.Navigation.NavRoute
import com.example.wasteup.R
import com.example.wasteup.ui.theme.Components.AppButton
import com.example.wasteup.ui.theme.Components.SignWithGoogle


@Composable
fun Login(
    navController: NavController
){

    var email by rememberSaveable {
        mutableStateOf("")
    }
    var password by rememberSaveable {
        mutableStateOf("")
    }
    var check by rememberSaveable {
        mutableStateOf(false)
    }
    var showIcon by rememberSaveable {
        mutableStateOf(false)
    }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(
            10.dp,
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(text = buildAnnotatedString {
                append("E-mail *")
                addStyle(
                    SpanStyle(
                        color = Color.Red,
                    ),
                    7,
                    8
                )
            },
                fontSize = 10.sp,
                color = Color.Black
            )
            OutlinedTextField(value = email, onValueChange = {
                email = it
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
                textStyle = TextStyle(
                    fontSize = 15.sp
                ),
                shape = RoundedCornerShape(10.dp)
            )
        }
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(text = buildAnnotatedString {
                append("Password *")
                addStyle(
                    SpanStyle(
                        color = Color.Red,
                    ),
                    9,
                    10
                )
            },
                fontSize = 10.sp,
                color = Color.Black
            )
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
        AppButton(
            onClick = {
                navController.navigate(NavRoute.AccountType.route)
            }
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = check,
                    onCheckedChange = { check = !check },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Green,
                        checkmarkColor = Color.White
                    )
                )
                Spacer(modifier = Modifier.width(1.dp))
                Text(
                    "Remember Me",
                    color = Color.Black,
                    fontSize = 10.sp
                )
            }
            Text(
                "Forgotten Password?",
                textDecoration = TextDecoration.Underline,
                color = Color.Black,
                fontSize = 10.sp
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        SignWithGoogle {
            navController.navigate(NavRoute.AccountType.route)
        }
        Text(
            "Don't have an account?",
            color = Color.LightGray,
            fontSize = 10.sp
        )
    }
}