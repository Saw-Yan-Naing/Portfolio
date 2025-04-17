package syn.circus.utils.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import syn.circus.utils.function.check

@Composable
fun HoverAbleIconButton(
    modifier: Modifier = Modifier,
    hoverColor: Color = Color.White,
    iconColor: Color = Color.LightGray,
    icon: Painter,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.Crop,
    onClick: () -> Unit,
) {

    val interActionSource = rememberSaveable {
        MutableInteractionSource()
    }

    val isHovered = interActionSource.collectIsHoveredAsState()

    Image(
        modifier = modifier.clickable(
            interactionSource = interActionSource,
            indication = null,
            onClick = onClick
        ),
        painter = icon,
        colorFilter = ColorFilter.tint(
            color = ((isHovered.value) check { hoverColor })
                ?: iconColor
        ),
        contentScale = contentScale,
        contentDescription = contentDescription
    )
}