package component.composeView.customButton

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier


@OptIn(ExperimentalMaterial3Api::class)
@Composable
actual fun BorderPickerButton(
    value: String?,
    modifier: Modifier,
    label: String?,
    onClick: (() -> Unit)?,
    enabled: Boolean,
    isRequired: Boolean
) {
    val expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        modifier = modifier,
        expanded = expanded,
        onExpandedChange = {
            onClick?.invoke()
        },
    ) {}
}