package com.joel.yumyard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.joel.authentication.onboarding.OnboardingScreen
import com.joel.yumyard.ui.navigation.AppNavHost
import com.joel.yumyard.ui.navigation.BottomNavigationBar
import com.joel.yumyard.ui.navigation.Screens
import com.joel.yumyard.ui.theme.UzitoTheme

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

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { if (bottomBarState.value) BottomNavigationBar(navController) }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
        ) {
            AppNavHost(
                navController = navController,
                updateBottomBarState = { bottomBarState.value = it },
                startDestination = startDestination
            )
        }
    }
}

