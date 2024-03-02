package com.app.muuvi.feature.onboarding.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.muuvi.core.ui.component.ButtonPrimaryColor
import com.app.muuvi.core.ui.component.OutlinedButtonWithHeadingIcon
import com.app.muuvi.feature.onboarding.R
import com.app.muuvi.ui.theme.Grey500
import com.app.muuvi.ui.theme.Grey700
import com.app.muuvi.ui.theme.Grey900
import com.app.muuvi.ui.theme.PrimaryColor
import com.app.muuvi.ui.theme.fontFamily

@Composable
fun GetStartedScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onFacebookClick: () -> Unit,
    onGoogleClick: () -> Unit,
    onPasswordSignInClick: () -> Unit,
    onSignUpClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Icon(
                modifier = Modifier.clickable(onClick = onBackClick),
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = null,
            )
        }
        Image(
            modifier = Modifier.padding(vertical = 30.dp),
            painter = painterResource(id = R.drawable.image_get_started),
            contentDescription = null,
        )
        Text(
            text = stringResource(id = R.string.let_get_started),
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            color = Grey900,
            fontSize = 28.sp
        )
        OutlinedButtonWithHeadingIcon(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, bottom = 16.dp),
            onClick = onFacebookClick,
            resourceId = com.app.muuvi.core.ui.R.drawable.icon_facebook,
            title = stringResource(id = R.string.facebook_login),
        )

        OutlinedButtonWithHeadingIcon(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            onClick = onGoogleClick,
            resourceId = com.app.muuvi.core.ui.R.drawable.icon_google,
            title = stringResource(id = R.string.google_login),
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Divider(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp),
                thickness = 0.5.dp,
            )
            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = stringResource(id = R.string.or),
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                color = Grey700,
            )
            Divider(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 10.dp),
                thickness = 0.5.dp,
            )
        }
        ButtonPrimaryColor(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            onClick = onPasswordSignInClick,
            title = stringResource(id = R.string.sign_in_with_password)
        )
        Row(
            modifier = Modifier.padding(top = 30.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = stringResource(id = R.string.dont_have_an_account),
                fontFamily = fontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = Grey500,
            )

            Button(
                onClick = onSignUpClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                ),
                contentPadding = PaddingValues(vertical = 0.dp, horizontal = 8.dp),
                ) {
                Text(
                    text = stringResource(id = R.string.sign_up),
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = PrimaryColor,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GetStartedScreenPreview() {
    GetStartedScreen(
        onBackClick = {},
        onFacebookClick = {},
        onGoogleClick = {},
        onPasswordSignInClick = {},
        onSignUpClick = {},
    )
}
