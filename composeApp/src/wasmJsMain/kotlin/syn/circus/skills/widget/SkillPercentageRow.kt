package syn.circus.skills.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import syn.circus.utils.function.calculateTextSize

@Composable
fun SkillPercentageRow(
    modifier: Modifier = Modifier,
    skillPercent: Double,
    screenWidth: Int,
    skillName: String,
) {

    val percentageText = "${((skillPercent) %100)} %"

    ConstraintLayout(
        modifier = modifier,
    ) {
        val (skill, percentage) = createRefs()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(skill) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                skillName,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = (14).calculateTextSize(screenWidth).sp,
                    fontWeight = FontWeight.SemiBold
                ),
                modifier = Modifier.padding(vertical = 5.dp)
            )

            Text(
                percentageText,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = (14).calculateTextSize(screenWidth).sp,
                )
            )
        }

        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(
                    percentage
                ) {
                    top.linkTo(skill.bottom)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }.padding(5.dp),
            trackColor = Color.LightGray,
            color = Color.Blue,
            progress = {
                (skillPercent.toFloat()) /100f
            }
        )
    }


}