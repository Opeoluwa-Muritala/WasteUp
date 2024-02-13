package com.example.wasteup.ui.theme.Views.SignUp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.wasteup.ui.theme.Components.Logo
import com.example.wasteup.ui.theme.Components.SwitchingButton
import com.example.wasteup.ui.theme.ViewModels.signUp_and_signIn_ViewModel

@Composable
fun SignUp_and_SignIn_Screen(
    navController: NavController
) {
var switch by remember {
    mutableStateOf(true)
}
    var screen by rememberSaveable {
        mutableIntStateOf(0)
    }
    val viewModel = viewModel<signUp_and_signIn_ViewModel>()
    val state by viewModel.state.collectAsState(initial = true)
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.spacedBy(
          20.dp,
            Alignment.Top
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Spacer(modifier = Modifier.height(10.dp))
        Logo(
            color = Color.Green,
            fontWeight = FontWeight.Normal
        )

        SwitchingButton(
            state,
            {
                viewModel.onClickButton(true)
            }
        ) {
            viewModel.onClickButton(false)
        }

        when (state) {
             true -> {
                Login(navController)
            }

            else -> SignUp(navController)
        }
    }
}


