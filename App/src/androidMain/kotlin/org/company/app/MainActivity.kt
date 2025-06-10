package org.company.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.app.faraBank.appContent.BackPressHandler
import com.app.faraBank.appContent.MultiRepoSampleApp

class MainActivity : AppCompatActivity() {

    private val backPressHandler = BackPressHandler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            MultiRepoSampleApp(backPressHandler)
        }
    }
}
