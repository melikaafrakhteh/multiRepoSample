package view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import multireposample.feature.charity.generated.resources.Res
import multireposample.feature.charity.generated.resources.feature_charity_seeMahakCharity
import org.jetbrains.compose.resources.stringResource


@Composable
fun CharityPage(
    onClickOpenWebView: () -> Unit
) {
    CharityScreen(
        onClickOpenWebView = onClickOpenWebView
    )
}


@Composable
fun CharityScreen(onClickOpenWebView: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { onClickOpenWebView() }
        ) {
            Text(text = stringResource(Res.string.feature_charity_seeMahakCharity))
        }
    }
}