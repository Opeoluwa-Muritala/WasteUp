package com.example.wasteup.ui.theme.OnboardingViews.SignUp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.wasteup.Navigation.NavRoute
import com.example.wasteup.ui.theme.Components.Password
import com.example.wasteup.ui.theme.Components.AppButton
import com.example.wasteup.ui.theme.Components.SignWithGoogle
import com.example.wasteup.ui.theme.Components.TextFieldAndText
import com.example.wasteup.ui.theme.ViewModels.signUp_and_signIn_ViewModel

@Composable
fun SignUp (
    navController: NavController
) {
    var name by remember {
        mutableStateOf("")
    }
    var check by remember {
        mutableStateOf(true)
    }
    val viewModel = viewModel<signUp_and_signIn_ViewModel>()

    Column(
        Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        TextFieldAndText(content = {
            OutlinedTextField(
                value = name, onValueChange = {
                    name = it
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
        }, text = buildAnnotatedString { append("Name") })
        TextFieldAndText(content = {
            OutlinedTextField(
                value = name, onValueChange = {
                    name = it
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
        )
        TextFieldAndText(content = {
            Password()
        },
            text = buildAnnotatedString {
                append("Password *")
                addStyle(
                    SpanStyle(
                        color = Color.Red,
                    ),
                    9,
                    10
                )
            }
        )
        TextFieldAndText(content = {
            Password()
        },
            text = buildAnnotatedString {
                append("Confirm Password *")
                addStyle(
                    SpanStyle(
                        color = Color.Red,
                    ),
                    16,
                    17
                )
            }
        )
        AppButton(text = "Sign Up", onClick = {
            viewModel.onClickButton(true)
        })
        Row {
            Checkbox(
                checked = check,
                onCheckedChange = { check = !check },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.White,
                    checkmarkColor = Color.Green
                )
            )
            Spacer(modifier = Modifier.width(1.dp))
            Text(
                buildAnnotatedString {
                    append("By Signing up, you agree to the Terms of Service and Privacy Policy")
                    addStyle(
                        SpanStyle(
                            textDecoration = TextDecoration.Underline
                        ),
                        32,
                        48,
                    )
                    addStyle(
                        SpanStyle(
                            textDecoration = TextDecoration.Underline
                        ),
                        50,
                        67
                    )
                },
                color = Color.Black,
                fontSize = 10.sp
            )
        }
        SignWithGoogle {
            navController.navigate(NavRoute.AccountType.route)
        }
        Text(
            "Already have an account?",
            color = Color.LightGray,
            fontSize = 10.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
    }
}