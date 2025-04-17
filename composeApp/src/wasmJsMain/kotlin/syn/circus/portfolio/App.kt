package syn.circus.portfolio

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import syn.circus.about_me.AboutMe
import syn.circus.contact_me.ContactMe
import syn.circus.footer.PortFolioFooter
import syn.circus.intro.Intro
import syn.circus.skills.Skills
import syn.circus.ui_config.navyBlue
import syn.circus.utils.domain.Destination
import syn.circus.utils.function.check

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class, ExperimentalMaterial3Api::class)
@Composable
fun App() {

    MaterialTheme {

        val screenSize = calculateWindowSizeClass()
        val smallDevice = screenSize.widthSizeClass == WindowWidthSizeClass.Compact
        val appbarList = Destination.Body.getAppBarList()
        val lazyListState = rememberLazyListState()
        val scope = rememberCoroutineScope()

        LaunchedEffect(lazyListState) {
            println("Lazy list state -> ${lazyListState.firstVisibleItemIndex}")
        }
        Scaffold(
            topBar = {
                TopAppBar(
                    modifier = Modifier.shadow(
                        5.dp,
                    ),
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.White
                    ),
                    title = {
                        Text(
                            text = buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.Black, fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold,
                                    )
                                ) {
                                    append("Port")
                                }
                                withStyle(
                                    style = SpanStyle(
                                        color = navyBlue, fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold,
                                    )
                                ) {
                                    append("Folio")
                                }
                            },
                            textAlign = TextAlign.Start,
                        )
                    },
                    actions = {
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
                                    color = (isHovered check { Color.Blue }) ?: Color.Black,
                                    fontSize = 14.sp,
                                    fontWeight = (isHovered check { FontWeight.Bold })
                                        ?: FontWeight.SemiBold
                                ), textAlign = TextAlign.Center
                            )
                        }
                    }
                )
            }
        ) {
            Box(
                modifier = Modifier
                    .padding(top = it.calculateTopPadding()).drawBehind {
                        drawRect(
                            color = Color.White
                        )
                    }
            ) {
                LazyColumn(
                    state = lazyListState,
                ) {
                    item(
                        key = Destination.Intro.name
                    ) {
                        Intro(
                            smallScreen = smallDevice,
                        )
                    }

                    item(
                        key = Destination.About.name
                    ) {
                        AboutMe(
                            modifier = Modifier
                                .wrapContentHeight(
                                    align = Alignment.CenterVertically
                                )
                        )
                    }

                    item(
                        key = Destination.Skills.name
                    ) {
                        Skills(
                            modifier = Modifier.fillParentMaxWidth()
                        )
                    }

                    item(
                        key = Destination.Contact.name
                    ) {
                        ContactMe(
                            modifier = Modifier
                        )
                    }

                    item(
                        key = Destination.Footer.name
                    ) {
                        PortFolioFooter(
                            lazyListState = lazyListState
                        )
                    }
                }
            }
        }
    }
}