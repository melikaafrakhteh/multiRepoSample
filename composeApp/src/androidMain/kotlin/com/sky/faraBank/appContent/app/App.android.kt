package com.sky.faraBank.appContent.app

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
actual fun KeyboardAware(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .imePadding()
            .systemBarsPadding()
    ) {
        content()
    }
}