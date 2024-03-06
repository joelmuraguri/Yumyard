package com.joel.yumyard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.joel.authentication.onboarding.OnboardingScreen
import com.joel.yumyard.ui.theme.UzitoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UzitoTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    OnboardingScreen()
                }
            }
        }
    }
}

