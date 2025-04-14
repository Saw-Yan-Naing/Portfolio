package syn.circus.about_me

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
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
import syn.circus.about_me.widget.PortFolioImage
import syn.circus.utils.function.calculateTextSize

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AboutMe(
    modifier: Modifier = Modifier,
    smallScreen: Boolean = false,
) {
    val screenWidth by rememberSaveable {
        derivedStateOf {
            mutableStateOf(0)
        }
    }
    FlowRow(
        modifier = modifier.onGloballyPositioned {
            screenWidth.value = it.size.width
        },
    ) {
        Column(
            modifier = Modifier.weight(1f).align(Alignment.Top),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {

            Text(
                "About Me",
                modifier = Modifier.padding(vertical = 10.dp),
                style = TextStyle(
                    color = Color.Black,
                    fontSize = (23).calculateTextSize(screenWidth.value).sp,
                    fontWeight = FontWeight.Bold,
                )
            )

            Text(
                """I'm a mobile developer with 1 year of experience building modern, user-friendly applications using Kotlin, Dart, Jetpack Compose, and Flutter. I've worked on and maintained several projects, particularly in the e-commerce space, using both Flutter and Jetpack Compose to create smooth and responsive user experiences.

I studied Mathematics at Yangon University, but due to the crisis, I had to step away from my academic path. Despite that, my passion for technology and development has continued to grow. I'm now focused on expanding my skills and working toward becoming a well-rounded software developer.

Outside of coding, I enjoy staying active by playing sports like basketball, volleyball, and badminton. When I'm indoors, I like to relax by reading manga and watching anime — it helps me unwind and stay inspired.
            """.trimIndent(),
                style = TextStyle(
                    color = Color.Black.copy(alpha = .5f),
                    fontSize = (16).calculateTextSize(screenWidth = screenWidth.value).sp,
                    fontWeight = FontWeight.Thin
                ),
                modifier = Modifier.padding(vertical = 10.dp)
            )
        }
        PortFolioImage(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(50.dp)
        )
    }
}