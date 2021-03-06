package dev.zotov.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Layout()
        }

//        setupActionBarWithNavController(findNavController(R.id.nav_host_fragment));
    }

    override fun onSupportNavigateUp(): Boolean {
        val controller = findNavController(R.id.nav_host_fragment);
        return controller.navigateUp() || super.onSupportNavigateUp()
    }

    @Composable
    fun Layout() {
        Text("Hello mates")
    }
}