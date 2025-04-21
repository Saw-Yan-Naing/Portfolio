package syn.circus.footer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.FlowRowOverflow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.browser.window
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.github_icon
import portfolio.composeapp.generated.resources.linkedin_icon
import syn.circus.portfolio.BuildKonfig
import syn.circus.ui_config.navyBlue
import syn.circus.ui_config.purple
import syn.circus.utils.domain.Destination
import syn.circus.utils.function.calculateTextSize
import syn.circus.utils.function.check
import syn.circus.utils.ui.HoverAbleIconButton

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun LazyItemScope.PortFolioFooter(
    modifier: Modifier = Modifier,
    lazyListState: LazyListState,
    smallDevice: Boolean = false,
) {

    val appbarList = Destination.Body.getAppBarList()
    val scope = rememberCoroutineScope()
    val screenWidth by remember {
        derivedStateOf { mutableStateOf(0) }
    }

    Column(
        modifier = modifier.fillParentMaxWidth()
            .onGloballyPositioned {
                screenWidth.value = it.size.width
            }
            .drawBehind {
                drawRect(color = navyBlue)
            }.padding(horizontal = 15.dp, vertical = 10.dp)
    ) {
        FlowRow(
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            overflow = FlowRowOverflow.Visible,
            horizontalArrangement = Arrangement.Center
        ) {
            appbarList.map { dest ->
                val interactionSource = remember {
                    MutableInteractionSource()
                }
                val isHovered by interactionSource.collectIsHoveredAsState()
                Text(
                    dest.name,
                    modifier = Modifier.padding(
                        horizontal = 5.dp, vertical = 3.dp
                    ).clickable(
                        interactionSource = interactionSource,
                        indication = null
                    ) {
                        scope.launch {
                            val index = Destination.entries.indexOf(dest)
                            if (index != -1) {
                                lazyListState.animateScrollToItem(index)
                            }
                            println("scroll to $index")
                        }
                    },
                    style = TextStyle(
                        color = (isHovered check { purple }) ?: Color.White,
                        fontSize = (12).calculateTextSize(screenWidth.value).sp,
                        fontWeight = (isHovered check { FontWeight.Bold })
                            ?: FontWeight.SemiBold
                    ), textAlign = TextAlign.Center
                )
            }
            if (smallDevice.not()) Spacer(modifier = Modifier.weight(1f))
            HoverAbleIconButton(
                icon = painterResource(Res.drawable.github_icon),
                contentDescription = "github-icon",
                modifier = Modifier.size(
                    width = (25).calculateTextSize(screenWidth.value).dp, height = (25).calculateTextSize(screenWidth.value).dp
                ).padding(5.dp)
            ) {
                window.open(BuildKonfig.githubUrl)
            }

            HoverAbleIconButton(
                icon = painterResource(Res.drawable.linkedin_icon),
                contentDescription = "linkedIn-icon",
                modifier = Modifier.size(
                    width = (25).calculateTextSize(screenWidth.value).dp, height = (25).calculateTextSize(screenWidth.value).dp
                ).padding(5.dp)
            ) {
                window.open(BuildKonfig.linkedInUrl)
            }
        }

        HorizontalDivider(
            modifier = Modifier.fillParentMaxWidth().padding(10.dp)
        )

        Text(
            modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp),
            text = "© Saw Yan Naing. All rights reversed",
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            color = Color.LightGray
        )
    }
}