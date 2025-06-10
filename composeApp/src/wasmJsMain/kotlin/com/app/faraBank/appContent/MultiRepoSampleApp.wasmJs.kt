package com.app.faraBank.appContent

import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.browser.window

@Composable
actual fun KeyboardAware(content: @Composable () -> Unit) {
    var isKeyboardOpen by remember { mutableStateOf(false) }
    var keyboardHeight by remember { mutableStateOf(0) }
    val windowHeight by remember { mutableStateOf(window.innerHeight) }

    val scrollState = rememberScrollState()

    Box(modifier = Modifier.padding(bottom = if (isKeyboardOpen) keyboardHeight.dp else 0.dp)) {
        content()
        VerticalScrollbar(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .fillMaxHeight(),
            adapter = rememberScrollbarAdapter(scrollState)
        )
    }
}