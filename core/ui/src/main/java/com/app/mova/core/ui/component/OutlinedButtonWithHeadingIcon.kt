package com.app.mova.core.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.mova.core.ui.R
import com.app.mova.ui.theme.Grey200
import com.app.mova.ui.theme.Grey900
import com.app.mova.ui.theme.fontFamily

@Composable
fun OutlinedButtonWithHeadingIcon(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    @DrawableRes resourceId: Int,
    title: String,
) {
    OutlinedButton(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, color = Grey200),
        contentPadding = PaddingValues(vertical = 18.dp),
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = resourceId),
            contentDescription = null,
            tint = Color.Unspecified,
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = title,
            color = Grey900,
            fontFamily = fontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OutlinedButtonWithHeadingIconPreview() {
    OutlinedButtonWithHeadingIcon(
        onClick = {},
        resourceId = R.drawable.icon_facebook,
        title = "Continue with Facebook"
    )
}
