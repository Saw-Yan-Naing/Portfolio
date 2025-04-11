package syn.circus.portfolio.presentaion

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource

import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.compose_multiplatform
import syn.circus.portfolio.domain.Destination
import syn.circus.portfolio.presentaion.widget.Intro

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun App() {
    MaterialTheme {
        val screenSize = calculateWindowSizeClass()

        val smallDevice = screenSize.widthSizeClass == WindowWidthSizeClass.Compact

        val appbarList = Destination.Body.getAppBarList()
        val lazyListState = rememberLazyListState()

        Scaffold(
            topBar = {
                TopAppBar(
                    backgroundColor = Color.Blue.copy(alpha = .3f),
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
                            Text(
                                dest.name,
                                modifier = Modifier.padding(horizontal = 3.dp, vertical = 5.dp),
                            )
                        }
                    }
                )
            }
        ) {
            LazyColumn(
                state = lazyListState,
                modifier = Modifier.padding(top = it.calculateTopPadding())
            ) {
                item(
                    key = Destination.Intro.name
                ) {
                    Intro(
                        smallScreen = smallDevice,
                        contactMe = {}
                    )
                }
            }
        }


    }
}