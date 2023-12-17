package com.demircandemir.borutoapp.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demircandemir.borutoapp.R
import com.demircandemir.borutoapp.ui.theme.INFO_ICON_SIZE
import com.demircandemir.borutoapp.ui.theme.titleColor

@Composable
fun InfoBox(
    icon: Painter,
    iconColor: Color,
    bigText: String,
    smallText: String,
    textColor: Color
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            modifier = Modifier
                .padding(end = 5.dp)
                .size(INFO_ICON_SIZE),
            painter = icon,
            contentDescription = stringResource(R.string.icon_info),
            tint = iconColor
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = bigText,
                color = textColor,
                fontSize = MaterialTheme.typography.h6.fontSize,
                fontWeight = FontWeight.Black,
                textAlign = TextAlign.Center,

            )
            Text(
                modifier = Modifier
                    .alpha(ContentAlpha.medium),
                text = smallText,
                color = textColor,
                fontSize = MaterialTheme.typography.overline.fontSize
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun InfoBoxPreview() {
    InfoBox(
        icon = painterResource(id = R.drawable.ic_bolt),
        iconColor = MaterialTheme.colors.primary,
        bigText = "92",
        smallText = "Power",
        textColor = MaterialTheme.colors.titleColor
    )
}