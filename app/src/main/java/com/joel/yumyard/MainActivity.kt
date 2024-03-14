package com.joel.yumyard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.joel.authentication.onboarding.OnboardingScreen
import com.joel.design.icons.UzitoIcons
import com.joel.yumyard.ui.navigation.AppNavHost
import com.joel.yumyard.ui.navigation.BottomNavigationBar
import com.joel.yumyard.ui.navigation.Screens
import com.joel.yumyard.ui.theme.UzitoTheme
import dagger.hilt.android.AndroidEntryPoint

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UzitoTheme {
                YumyardApp(startDestination = Screens.Discover.route)
            }
        }
    }
}

@Composable
fun YumyardApp(startDestination : String){
    val navController = rememberNavController()
    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }
    val fabState = rememberSaveable { (mutableStateOf(true)) }


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { if (bottomBarState.value) BottomNavigationBar(navController) },
        floatingActionButton = { if (fabState.value) MealPlanFAB {
            navController.navigate(Screens.MealPlan.route)
        } },
        floatingActionButtonPosition = FabPosition.Center
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
        ) {
            AppNavHost(
                navController = navController,
                updateBottomBarState = { bottomBarState.value = it },
                startDestination = startDestination,
                updateFABState =  { fabState.value = it }
            )
        }
    }
}

@Composable
fun MealPlanFAB(
    onClick : () -> Unit
){

    FloatingActionButton(
        onClick = {
            onClick()
        },
        shape = RoundedCornerShape(50),
        containerColor = Color(0xFF00B969),
        modifier = Modifier
            .size(70.dp)
    ) {
        Icon(
            painter = painterResource(id = UzitoIcons.add),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .size(30.dp)
        )
    }

}
