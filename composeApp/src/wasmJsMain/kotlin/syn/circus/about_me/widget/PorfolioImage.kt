package syn.circus.about_me.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.profile

@Composable
fun PortFolioImage(
    modifier: Modifier = Modifier,
) {
    val interAction = rememberSaveable {
        MutableInteractionSource()
    }

    val isHovered = interAction.collectIsHoveredAsState()

    Box(
        modifier = modifier
            .size(
                width = 300.dp,
                height = 300.dp
            )
            .hoverable(interAction)
    ) {

        Box(
            modifier = Modifier
                .size(
                    width = 220.dp,
                    height = 270.dp
                )
                .align(Alignment.Center)
                .clip(RoundedCornerShape(10.dp))
                .border(
                    width = 1.dp,
                    color = Color.Blue,
                    shape = RoundedCornerShape(10.dp)
                )
        )
        Card(
            modifier = Modifier
                .size(
                    width = 200.dp,
                    height = 250.dp
                )
                .align(Alignment.Center).offset {
                    if (isHovered.value.not())
                        IntOffset.Zero
                    else
                        IntOffset(20, y = -20)
                },
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            )
        ) {
            Image(
                painter = painterResource(Res.drawable.profile),
                modifier = Modifier.align(Alignment.CenterHorizontally),
                contentDescription = "portfolio_image",
                contentScale = ContentScale.FillBounds,
            )
        }
    }
}