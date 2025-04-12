package syn.circus.portfolio.presentaion.widget

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import syn.circus.portfolio.domain.function.check

@Composable
fun LazyItemScope.Intro(
    modifier: Modifier = Modifier,
    smallScreen: Boolean = false,
    contactMe: () -> Unit
) {
    var screenWidth by remember {
        mutableStateOf(0)
    }

    var screenHeight by remember {
        mutableStateOf(0)
    }

    Row(
        modifier = modifier.onGloballyPositioned {
            screenWidth = it.size.width
            screenHeight = it.size.height
        }.fillMaxWidth().padding(5.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
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
                    "Hello, I\'m ", style = TextStyle(
                        color = Color.Blue,
                        fontSize = (screenWidth / 22).sp,
                    )
                )
                Text(
                    "Mobile developer", style = TextStyle(
                        color = Color.Black,
                        fontSize = (screenWidth / 30).sp,
                        fontWeight = FontWeight.Bold,
                    ), maxLines = 2
                )

                Text(
                    "I build cross-platform app", style = TextStyle(
                        color = Color.LightGray,
                        fontSize = (screenWidth / 28).sp,
                        fontWeight = FontWeight.Bold,
                    ), maxLines = 2
                )

                Text(
                    "I'm a application developer specializing in building exceptional digital experiences",
                    style = TextStyle(
                        color = Color.LightGray,
                        fontSize = (screenWidth / 28).sp,
                        fontWeight = FontWeight.Bold,
                    ),
                    maxLines = 2
                )
            }
        }
        AnimatedVisibility(
            modifier = Modifier,
            visible = smallScreen.not(),
        ) {
            Box(
                modifier = Modifier.clip(RoundedCornerShape(10.dp))
                    .shadow(5.dp, shape = RoundedCornerShape(10.dp))
                    .drawBehind {
                        drawRect(
                            color = Color.Gray,
                        )
                    }.padding(horizontal = 15.dp, vertical = 10.dp).fillParentMaxHeight()
            ) {
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
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}