package com.app.mova.core.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.app.mova.core.ui.theme.MovaTheme
import com.app.mova.ui.theme.PrimaryColor
import com.app.mova.ui.theme.fontFamily

@Composable
fun MovaCheckBox(
    modifier: Modifier = Modifier,
    checked: Boolean,
    description: String,
    onCheckedChange: (Boolean) -> Unit,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(
                checkedColor = PrimaryColor,
                uncheckedColor = PrimaryColor,
                checkmarkColor = Color.White,
            )
        )
        Text(
            text = description,
            fontFamily = fontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MovaCheckBoxCheckedPreview() {
    MovaTheme {
        MovaCheckBox(
            checked = true,
            description = "Remember me",
            onCheckedChange = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MovaCheckBoxUnCheckedPreview() {
    MovaTheme {
        MovaCheckBox(
            checked = false,
            description = "Remember me",
            onCheckedChange = {},
        )
    }
}
