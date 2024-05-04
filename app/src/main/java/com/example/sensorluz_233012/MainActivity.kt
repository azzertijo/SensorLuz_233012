package com.example.sensorluz_233012

import android.content.res.Resources.Theme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sensorluz_233012.ui.theme.SensorLuz_233012Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SensorLuz_233012Theme {
                val viewModel = viewModel<MainViewModel>()
                val isDark = viewModel.isDark
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            if (isDark) Color.DarkGray else Color.White
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = if(isDark) {
                            "No sol"
                        } else {
                            "Sol"
                        },
                        color = if(isDark) Color.White else Color.Magenta
                    )
                }
            }
        }
    }
}