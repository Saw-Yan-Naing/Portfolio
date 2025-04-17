package syn.circus.intro

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import syn.circus.ui_config.purple
import syn.circus.utils.function.calculateTextSize
import syn.circus.utils.function.check

@Composable
fun LazyItemScope.Intro(
    modifier: Modifier = Modifier,
    smallScreen: Boolean = false,
) {
    val screenWidth by rememberSaveable {
        derivedStateOf { mutableStateOf(0) }
    }

    Row(
        modifier = modifier.onGloballyPositioned {
            screenWidth.value = it.size.width
        }.fillMaxWidth().padding(horizontal = 5.dp, vertical = 20.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Surface(
            modifier = Modifier.fillMaxWidth((smallScreen.not() check { .5f }) ?: 1f)
                .padding(horizontal = 10.dp, vertical = 5.dp)
        ) {
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.Start,
            ) {
                Text(
                    "Hello, my name is ", style = TextStyle(
                        color = purple,
                        fontSize = (14).calculateTextSize(screenWidth.value).sp,
                        fontWeight = FontWeight.Thin
                    ),
                    modifier = Modifier.padding(vertical = 5.dp)
                )
                Text(
                    "Saw Yan Naing", style = TextStyle(
                        color = Color.Black,
                        fontSize = (25).calculateTextSize(screenWidth.value).sp,
                        fontWeight = FontWeight.Bold,
                    ), maxLines = 2,
                    modifier = Modifier.padding(vertical = 5.dp)
                )

                Text(
                    "I build cross-platform app", style = TextStyle(
                        color = purple,
                        fontSize = (20).calculateTextSize(screenWidth.value).sp,
                        fontWeight = FontWeight.Bold,
                    ), maxLines = 2,
                    modifier = Modifier.padding(vertical = 5.dp)
                )

                Text(
                    "I'm a application developer specializing in building exceptional digital experiences",
                    style = TextStyle(
                        color = purple.copy(.65f),
                        fontSize = (20).calculateTextSize(screenWidth.value).sp,
                        fontWeight = FontWeight.Bold,
                    ),
                    maxLines = 2,
                    modifier = Modifier.padding(vertical = 5.dp)
                )
            }
        }
        AnimatedVisibility(
            modifier = Modifier.padding(
                vertical = 50.dp
            ),
            visible = smallScreen.not(),
        ) {
            Card(
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Gray,
                ),
                elevation = CardDefaults.cardElevation(10.dp),
                modifier = Modifier
                    .fillParentMaxHeight(
                        .8f
                    )
                    .padding(horizontal = 15.dp, vertical = 10.dp)
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    Surface(
                        modifier = Modifier.align(Alignment.Center)
                            .padding(20.dp),
                        shape = RoundedCornerShape(10.dp),
                        color = Color.White.copy(alpha = .5f),
                    ) {
                        Text(
                            """
                      final developer = {
                      name : "Saw Yan Naing",
                      skills : [Jetpack compose, KMP, Flutter, Dart , Kotlin],
                      loves : "Developing Application" 
                      };
                    """.trimIndent(),
                            modifier = Modifier.wrapContentSize(align = Alignment.Center).padding(
                                horizontal = 20.dp, vertical = 10.dp
                            ),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                color = Color.Black,
                                fontSize = (12).calculateTextSize(screenWidth.value).sp
                            )
                        )
                    }
                }
            }
        }
    }
}