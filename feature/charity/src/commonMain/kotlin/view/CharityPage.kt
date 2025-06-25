package view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import multireposample.feature.charity.generated.resources.Res
import multireposample.feature.charity.generated.resources.feature_charity_charity
import multireposample.feature.charity.generated.resources.feature_charity_charity_description
import multireposample.feature.charity.generated.resources.feature_charity_seeMahakCharity
import org.jetbrains.compose.resources.stringResource
import theme.Dimens


@Composable
fun CharityPage(
    onClickOpenWebView: () -> Unit
) {
    CharityScreen(
        onClickOpenWebView = onClickOpenWebView
    )
}


@Composable
private fun CharityScreen(onClickOpenWebView: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFE0F7FA),
                        Color(0xFFB2EBF2),
                        Color(0xFF80DEEA)
                    )
                )
            )
            .padding(Dimens.spaceExtraLarge)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(Res.string.feature_charity_charity),
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = Dimens.spaceLarge)
            )

            Text(
                text = stringResource(Res.string.feature_charity_charity_description),
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = Dimens.spaceLarge)
            )

            Button(
                onClick = {
                    onClickOpenWebView()
                },
                shape = RoundedCornerShape(Dimens.spaceLarge),
                modifier = Modifier
                    .padding(top = Dimens.spaceExtraLarge)
                    .height(Dimens.buttonsHeight)
                    .fillMaxWidth(0.8f)
            ) {
                Text(
                    text = stringResource(Res.string.feature_charity_seeMahakCharity),
                    color = MaterialTheme.colorScheme.onSecondary
                )
            }
        }
    }
}