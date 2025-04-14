package syn.circus.utils.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import syn.circus.utils.function.check

@Composable
fun ActionBarTextButton(
    modifier: Modifier = Modifier,
    title: String,
    onClick: () -> Unit,
    showUnderLine: Boolean = false,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered = interactionSource.collectIsHoveredAsState()

    val availableWidth = remember {
        mutableStateOf(0)
    }

    Surface(
        modifier = modifier.onGloballyPositioned {
            availableWidth.value = it.size.width
        }
            .clip(RoundedCornerShape(10.dp))
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            ).hoverable(
                interactionSource,
            ).wrapContentSize(
                align = Alignment.Center
            ),
        shape = RoundedCornerShape(10.dp),
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                title,
                style = TextStyle(
                    color = (showUnderLine check { Color.Blue }) ?: Color.Black,
                    fontSize = 14.sp,
                    fontWeight = (showUnderLine check { FontWeight.Bold })
                        ?: FontWeight.SemiBold
                ), textAlign = TextAlign.Center
            )
            AnimatedVisibility(
                visible = showUnderLine || isHovered.value
            ) {
                HorizontalDivider(
                    modifier = Modifier.width(
                        100.dp
                    ),
                    color = Color.Blue
                )
            }
        }
    }
}