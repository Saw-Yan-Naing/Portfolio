package syn.circus.portfolio.presentaion.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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

@Composable
fun Intro(
    modifier: Modifier = Modifier,
    smallScreen: Boolean = false,
    contactMe: () -> Unit
) {
    val screenHeight by remember {
        derivedStateOf {
            mutableStateOf(0)
        }
    }
    if (smallScreen) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {

        }
    } else {
        Row(
            modifier = modifier
                .onGloballyPositioned {
                    screenHeight.value = it.size.height
                }
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Surface(
                modifier = Modifier.fillMaxWidth(.5f)
                    .padding(5.dp)
            ) {
                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.Start,
                ) {
                    Text(
                        "Hello, my name is",
                        style = TextStyle(
                            color = Color.Blue,
                            fontSize = 12.sp,

                            )
                    )
                    Text(
                        "Mobile developer",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                        ),
                        maxLines = 2
                    )

                    Text(
                        "I build cross-platform app",
                        style = TextStyle(
                            color = Color.LightGray,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                        ),
                        maxLines = 2
                    )

                    Text(
                        "I'm a application developer specializing in building exceptional digital experiences",
                        style = TextStyle(
                            color = Color.LightGray,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                        ),
                        maxLines = 2
                    )

                }
            }
            Box(
                modifier = Modifier.fillMaxWidth(.5f)
                    .clip(RoundedCornerShape(10.dp))
                    .drawBehind {
                        drawRect(
                            color = Color.Gray,
                        )
                    }

            ) {
                Text(
                    """
                      final developer = {
                      name : "Saw Yan Naing",
                      skills : [Jetpack compose, KMP, Flutter, Dart , Kotlin],
                      loves : "Developing Application" 
                      };
                    """.trimIndent(),
                    modifier = Modifier.wrapContentSize(align = Alignment.Center)
                        .padding(horizontal = 30.dp, vertical = 40.dp),
                    textAlign = TextAlign.Center
                )
            }

        }
    }
}