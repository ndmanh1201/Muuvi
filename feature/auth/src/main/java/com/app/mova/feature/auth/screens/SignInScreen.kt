package com.app.muuvi.feature.auth.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.muuvi.core.ui.R
import com.app.muuvi.core.ui.component.InputTextField
import com.app.muuvi.core.ui.component.muuviButton
import com.app.muuvi.core.ui.component.muuviCheckBox
import com.app.muuvi.core.ui.component.OutlinedButtonWithHeadingIcon
import com.app.muuvi.feature.auth.model.SignInUiState
import com.app.muuvi.ui.theme.DisabledButtonColor
import com.app.muuvi.ui.theme.Grey500
import com.app.muuvi.ui.theme.Grey700
import com.app.muuvi.ui.theme.Grey900
import com.app.muuvi.ui.theme.PrimaryColor
import com.app.muuvi.ui.theme.fontFamily

@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    uiState: SignInUiState,
    onBackClick: () -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onFacebookClick: () -> Unit,
    onGoogleClick: () -> Unit,
    onSignUpClick: () -> Unit,
    onCheckedChange: (Boolean) -> Unit,
) {
    Column(
        modifier = modifier.padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Icon(
                modifier = Modifier.clickable(onClick = onBackClick),
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = null,
            )
        }
        Icon(
            modifier = Modifier
                .size(120.dp)
                .padding(vertical = 24.dp),
            imageVector = ImageVector.vectorResource(id = R.drawable.logo),
            contentDescription = null,
            tint = Color.Unspecified,
        )
        Text(
            text = stringResource(id = R.string.login_to_your_account),
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            color = Grey900,
            fontSize = 28.sp,
        )
        Spacer(modifier = Modifier.height(24.dp))
        InputTextField(
            value = uiState.email,
            leadingIconResId = R.drawable.icon_email,
            hint = stringResource(id = R.string.hint_email),
            onValueChange = onEmailChange,
        )
        Spacer(modifier = Modifier.height(24.dp))
        InputTextField(
            value = uiState.password,
            leadingIconResId = R.drawable.icon_lock,
            hint = stringResource(id = R.string.hint_password),
            onValueChange = onPasswordChange,
            trailingIconEnable = true,
        )
        Spacer(modifier = Modifier.height(20.dp))
        muuviCheckBox(
            checked = uiState.isRememberChecked,
            description = stringResource(id = R.string.remember_me),
            onCheckedChange = onCheckedChange,
        )
        Spacer(modifier = Modifier.height(20.dp))
        muuviButton(
            modifier = Modifier.fillMaxWidth(),
            title = stringResource(id = R.string.sign_up),
            color = DisabledButtonColor,
            onClick = onSignUpClick,
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Divider(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp),
                thickness = 0.5.dp,
            )
            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = stringResource(id = R.string.or_continue_with),
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
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            OutlinedButtonWithHeadingIcon(
                onClick = onFacebookClick,
                resourceId = R.drawable.icon_facebook,
                title = "",
            )
            Spacer(modifier = Modifier.width(20.dp))
            OutlinedButtonWithHeadingIcon(
                onClick = onGoogleClick,
                resourceId = R.drawable.icon_google,
                title = "",
            )
        }
        Row(
            modifier = Modifier.padding(top = 40.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = stringResource(id = R.string.already_have_an_account),
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
                    text = stringResource(id = R.string.sign_in),
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
fun SignInScreenPreview() {
    SignInScreen(
        uiState = SignInUiState(),
        onBackClick = {},
        onEmailChange = {},
        onPasswordChange = {},
        onSignUpClick = {},
        onFacebookClick = {},
        onGoogleClick = {},
        onCheckedChange = {},
    )
}
