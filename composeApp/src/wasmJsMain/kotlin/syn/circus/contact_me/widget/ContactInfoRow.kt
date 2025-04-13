package syn.circus.contact_me.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.layoutId
import syn.circus.utils.function.calculateTextSize


@Composable
fun ContactInfoRow(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    onClick: () -> Unit,
    contactTitle: String,
    contactInfo: String,
    screenSize : Int,
) {

    ConstraintLayout(
        modifier = modifier.clip(RoundedCornerShape(10.dp)).clickable {
            onClick.invoke()
        }.padding(20.dp).layoutId(contactTitle.toLowerCase(Locale.current))
    ) {
        val (iconRef, textColumnRef) = createRefs()

        // Icon Circle
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(color = Color(0xFFE0DFFF), shape = CircleShape)
                .constrainAs(iconRef) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "Email Icon",
                tint = Color(0xFF7C3AED) // Purple color for the icon
            )
        }

        // Text Column
        Column(
            modifier = Modifier
                .padding(start = 12.dp)
                .constrainAs(textColumnRef) {
                    start.linkTo(iconRef.end)
                    top.linkTo(iconRef.top)
                    bottom.linkTo(iconRef.bottom)
                }
        ) {
            Text(
                text = contactTitle,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = (16).calculateTextSize(screenSize).sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = contactInfo,
                style = TextStyle(
                    color = Color.Gray,
                    fontSize = (16).calculateTextSize(screenSize).sp,
                )
            )
        }
    }
}