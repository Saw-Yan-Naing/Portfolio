package syn.circus.portfolio.presentaion

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import syn.circus.portfolio.domain.Destination
import syn.circus.portfolio.presentaion.widget.ActionBarTextButton
import syn.circus.portfolio.presentaion.widget.Intro

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class, ExperimentalMaterial3Api::class)
@Composable
fun App() {
    MaterialTheme {
        val screenSize = calculateWindowSizeClass()
        val smallDevice = screenSize.widthSizeClass == WindowWidthSizeClass.Compact
        val appbarList = Destination.Body.getAppBarList()
        val lazyListState = rememberLazyListState()
        val firstItem = lazyListState.firstVisibleItemIndex
        val scope = rememberCoroutineScope()

        LaunchedEffect(firstItem) {
            println(appbarList[firstItem].name)
        }

        Scaffold(
            topBar = {
                TopAppBar(
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
                                        color = Color.Blue, fontSize = 16.sp,
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
                            ActionBarTextButton(
                                modifier = Modifier.padding(horizontal = 5.dp, vertical = 3.dp),
                                title = dest.name,
                                onClick = {
                                    scope.launch(Dispatchers.Default) {
                                        lazyListState.animateScrollToItem(
                                            appbarList.indexOf(dest)
                                        )
                                    }
                                },
                                showUnderLine = dest.name == appbarList[firstItem].name,
                            )
                        }
                    }
                )
            }
        ) {
            Box(
                modifier = Modifier.padding(top = it.calculateTopPadding()).drawBehind {
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
                        Text(
                            appbarList[firstItem].name,
                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 16.sp
                            )
                        )
                    }

                    item(
                        key = Destination.Projects.name
                    ) {
                        Text(
                            appbarList[firstItem].name,
                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 16.sp
                            )
                        )
                    }

                    item(
                        key = Destination.Skills.name
                    ) {
                        Text(
                            appbarList[firstItem].name,
                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 16.sp
                            )
                        )
                    }

                    item(
                        key = Destination.Contact.name
                    ) {
                        Text(
                            appbarList[firstItem].name,
                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 16.sp
                            )
                        )
                    }
                }
            }
        }


    }
}