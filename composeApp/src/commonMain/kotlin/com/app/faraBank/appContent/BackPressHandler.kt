package com.app.faraBank.appContent

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class BackPressHandler {

    private val _onBackPressed = MutableSharedFlow<Unit>()
    val onBackPressed: SharedFlow<Unit> = _onBackPressed

    fun triggerBackPress() {
        CoroutineScope(Dispatchers.Default).launch {
            _onBackPressed.emit(Unit)
        }
    }
}
