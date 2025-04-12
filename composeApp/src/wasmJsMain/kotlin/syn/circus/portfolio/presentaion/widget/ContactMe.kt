package syn.circus.portfolio.presentaion.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LazyItemScope.ContactMe(
    modifier: Modifier = Modifier,
) {

    val screenWidth = remember {
        mutableStateOf(0)
    }
    Column(
        modifier = modifier.onGloballyPositioned {
            screenWidth.value = it.size.width
        }.fillParentMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            "Get In Touch",
            modifier = Modifier.padding(horizontal = 5.dp, vertical = 10.dp)
                .padding(bottom = 10.dp),
            style = TextStyle(
                color = Color.Black,
                fontSize = (screenWidth.value / 35).sp,
                fontWeight = FontWeight.Bold
            )
        )

        Text(
            "Contact Information",
            modifier = Modifier.padding(5.dp).padding(bottom = 10.dp),
            style = TextStyle(
                color = Color.LightGray,
                fontSize = (screenWidth.value / 40).sp
            )
        )

        Text(
            "Have a project in mind or want to collaborate? Feel free to reach out using the form or my contact details below.",
            modifier = Modifier.padding(5.dp).padding(bottom = 10.dp),
            style = TextStyle(
                color = Color.LightGray,
                fontSize = (screenWidth.value / 70).sp
            )
        )


        ContactInfoRow(
            modifier = Modifier.fillParentMaxWidth().padding(10.dp),
            icon = Icons.Rounded.Email,
            contactTitle = "Email",
            contactInfo = "syannaing76@gmail.com",
            onClick = {

            }
        )
        ContactInfoRow(
            modifier = Modifier.fillParentMaxWidth().padding(10.dp),
            icon = Icons.Rounded.LocationOn,
            contactTitle = "Location",
            contactInfo = "Thingangyun Township, Yangon ,Myanmar",
            onClick = {

            }
        )
        ContactInfoRow(
            modifier = Modifier.fillParentMaxWidth().padding(10.dp),
            icon = Icons.Rounded.Phone,
            contactTitle = "Phone",
            contactInfo = "+959897145711",
            onClick = {

            }
        )
    }
}