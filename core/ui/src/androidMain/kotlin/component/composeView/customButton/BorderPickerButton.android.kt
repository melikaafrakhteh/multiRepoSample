package component.composeView.customButton

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
actual fun BorderPickerButton(
    value: String?,
    modifier: Modifier,
    label: String?,
    onClick: (() -> Unit)?,
    enabled: Boolean,
    isRequired: Boolean
) {
    CommonBorderPickerButton(
        value = value,
        modifier = modifier,
        label = label,
        onClick = onClick,
        isRequired = isRequired,
        enabled = enabled
    )
}