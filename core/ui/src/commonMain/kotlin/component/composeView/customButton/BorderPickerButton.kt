package component.composeView.customButton

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation.Companion.keyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation

@Composable
expect fun BorderPickerButton(
    value: String?,
    modifier: Modifier,
    label: String?,
    onClick: (() -> Unit)?,
    enabled: Boolean,
    isRequired: Boolean
)

@Composable
internal fun CommonBorderPickerButton(
    value: String?,
    enabled: Boolean,
    modifier: Modifier = Modifier,
    label: String? = null,
    onClick: (() -> Unit)? = null,
    isRequired: Boolean = false,
) {
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val interactionSource = remember { MutableInteractionSource() }

    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collect {
            if (it is PressInteraction.Release) {
                keyboardController?.hide()
                if (enabled) {
                    focusManager.clearFocus()
                }
                onClick?.invoke()
            }
        }
    }

    OutlinedTextField(
        value = value.orEmpty(),
        onValueChange = {}, // readOnly field
        modifier = modifier
            .clip(MaterialTheme.shapes.medium),
        enabled = enabled,
        readOnly = true,
        textStyle = LocalTextStyle.current,
        interactionSource = interactionSource,
        label = {
            if (label != null) Text(label)
        },
        singleLine = true,
        shape = OutlinedTextFieldDefaults.shape,
        colors = OutlinedTextFieldDefaults.colors()
    )
}
