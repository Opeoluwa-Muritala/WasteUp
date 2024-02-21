package com.example.wasteup.ui.theme.OnboardingViews.Location

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.example.wasteup.Navigation.NavRoute
import com.example.wasteup.ui.theme.Components.AppButton
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationScreen(navController: NavController) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(10.dp)
            .background(Color.White)
    ) {
        val sheetState = rememberModalBottomSheetState()
        val scope = rememberCoroutineScope()
        var showBottomSheet by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Row {

                Box(
                    modifier = Modifier
                        .size(50.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.ArrowBack,
                        contentDescription = "Back",
                        Modifier
                            .align(
                                Alignment.Center
                            )
                            .size(30.dp),
                        tint = Color.Black
                    )
                }

                Column {
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "Let's get started",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                Text(
                    text = "Select Location",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp
                )
                Text(
                    text = "Find other Upcyclers close to your location",
                    fontWeight = FontWeight.Normal,
                    fontSize = 9.sp
                )
            }
            Column(
                Modifier.fillMaxSize(0.9f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

            CircularProgressIndicator(
                color = Color.Green,
                strokeWidth = 10.dp,
                strokeCap = StrokeCap.Round,
                modifier = Modifier.size(150.dp)
            )
            }

            AppButton(onClick = {
                                showBottomSheet = true
            }, text = "Continue")
        }
        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    showBottomSheet = false
                },
                sheetState = sheetState,
                shape = RoundedCornerShape(20.dp),
                containerColor = Color.White,
                dragHandle = {
                    Spacer(modifier = Modifier.height(10.dp))
                    Box(modifier = Modifier
                        .width(150.dp)
                        .height(10.dp)
                        .clip(RoundedCornerShape(40))
                        .background(Color.Gray)
                        .padding(20.dp))
                }
            ) {
                // Sheet content
                Spacer(modifier = Modifier.height(80.dp))
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Box(modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .background(Color.Green.copy(0.5f))){
                        Icon(imageVector = Icons.Filled.Check, contentDescription = "", modifier = Modifier.align(
                            Alignment.Center).size(60.dp), tint = Color.White)
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(30.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Location Set",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Text(
                        text = "You can now locate upcycle stations around your location",
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
                AppButton(onClick = {
                    scope.launch { sheetState.hide() }.invokeOnCompletion {
                        if (!sheetState.isVisible) {
                            showBottomSheet = false
                        }
                        navController.navigate(NavRoute.MainScreen.route)
                    }
                }, text = "Done")
                Spacer(modifier = Modifier.height(30.dp))
            }
        }
    }
}

