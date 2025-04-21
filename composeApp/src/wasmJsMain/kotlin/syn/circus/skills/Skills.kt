package syn.circus.skills

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import syn.circus.skills.widget.SkillPercentageRow
import syn.circus.ui_config.purple
import syn.circus.utils.function.calculateTextSize

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Skills(
    modifier: Modifier = Modifier
) {

    val screenWidth by rememberSaveable {
        derivedStateOf {
            mutableStateOf(0)
        }
    }

    Column(
        modifier = modifier
            .onGloballyPositioned {
            screenWidth.value = it.size.width
        }.padding(
            horizontal = (10).calculateTextSize(screenWidth.value).dp,
            vertical = (20).calculateTextSize(screenWidth.value).dp
        ),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            "Skills & Technology",
            modifier = Modifier.padding(5.dp).padding(bottom = 10.dp),
            style = TextStyle(
                color = Color.Black,
                fontSize = (20).calculateTextSize(screenWidth.value).sp,
                fontWeight = FontWeight.Bold
            )
        )

        FlowRow(
            modifier = Modifier.fillMaxWidth().padding(5.dp).padding(bottom = 10.dp)
                .wrapContentHeight(
                    align = Alignment.CenterVertically
                ),
            horizontalArrangement = Arrangement.Start
        ) {
            Column(
                modifier = Modifier.weight(1f).padding(5.dp),
                horizontalAlignment = Alignment.Start
            ) {

                Text(
                    "Language",
                    modifier = Modifier.padding(5.dp).padding(bottom = 10.dp),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = (16).calculateTextSize(screenWidth.value).sp,
                        fontWeight = FontWeight.Bold
                    )
                )

                Text(
                    "• Kotlin",
                    modifier = Modifier.padding(5.dp),
                    style = TextStyle(
                        color = purple,
                        fontSize = (16).calculateTextSize(screenWidth.value).sp,
                        fontWeight = FontWeight.Bold
                    )
                )

                Text(
                    "• Dart",
                    modifier = Modifier.padding(5.dp),
                    style = TextStyle(
                        color = purple,
                        fontSize = (16).calculateTextSize(screenWidth.value).sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            Column(
                modifier = Modifier.weight(1f).padding(5.dp),
                horizontalAlignment = Alignment.Start
            ) {

                Text(
                    "Frameworks",
                    modifier = Modifier.padding(5.dp).padding(bottom = 10.dp),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = (16).calculateTextSize(screenWidth.value).sp,
                        fontWeight = FontWeight.Bold
                    )
                )

                Text(
                    "• Android (Jetpack Compose)",
                    modifier = Modifier.padding(5.dp),
                    style = TextStyle(
                        color = purple,
                        fontSize = (16).calculateTextSize(screenWidth.value).sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )

                Text(
                    "• Flutter",
                    modifier = Modifier.padding(5.dp),
                    style = TextStyle(
                        color = purple,
                        fontSize = (16).calculateTextSize(screenWidth.value).sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }

            Column(
                modifier = Modifier.weight(1f).padding(5.dp),
                horizontalAlignment = Alignment.Start
            ) {

                Text(
                    "Tools",
                    modifier = Modifier.padding(5.dp).padding(bottom = 10.dp),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = (16).calculateTextSize(screenWidth.value).sp,
                        fontWeight = FontWeight.Bold
                    )
                )

                Text(
                    "• Git",
                    modifier = Modifier.padding(5.dp),
                    style = TextStyle(
                        color = purple,
                        fontSize = (16).calculateTextSize(screenWidth.value).sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )

                Text(
                    "• Android Studio",
                    modifier = Modifier.padding(5.dp),
                    style = TextStyle(
                        color = purple,
                        fontSize = (16).calculateTextSize(screenWidth.value).sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )

                Text(
                    "• IntelliJ",
                    modifier = Modifier.padding(5.dp),
                    style = TextStyle(
                        color = purple,
                        fontSize = (16).calculateTextSize(screenWidth.value).sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }
        }


        Text(
            "Proficiency",
            modifier = Modifier.fillMaxWidth().padding(5.dp).padding(bottom = 10.dp),
            style = TextStyle(
                color = Color.Black,
                fontSize = (16).calculateTextSize(screenWidth.value).sp,
                fontWeight = FontWeight.Bold
            )
        )


        SkillPercentageRow(
            screenWidth = screenWidth.value,
            skillName = "Android & KMP",
            skillPercent = 65.0,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 5.dp)
        )

        SkillPercentageRow(
            screenWidth = screenWidth.value,
            skillName = "Mobile Application Development",
            skillPercent = 65.0,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 5.dp )
        )
    }
}