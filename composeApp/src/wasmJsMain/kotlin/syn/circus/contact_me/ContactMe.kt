package syn.circus.contact_me

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import syn.circus.contact_me.widget.ContactInfoRow
import syn.circus.portfolio.presentaion.LocalScreenWidth
import syn.circus.utils.function.calculateTextSize

@Composable
fun ContactMe(
    modifier: Modifier = Modifier,
) {
    val screenSize = LocalScreenWidth.current

    val contactMeRow = mapOf(
        "Email" to "syannaing76@gmail.com",
        "Location" to "Thingangyun Township,Yangon,Myanmar",
        "Phone" to "+959897145711"
    )

    fun getIcon(key: String) = when (key) {
        "Email" -> Icons.Rounded.Email
        "Location" -> Icons.Rounded.LocationOn
        else -> Icons.Rounded.Phone
    }
    
    Column(
        modifier = modifier.wrapContentHeight(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            "Get In Touch",
            modifier = Modifier.padding(horizontal = 5.dp, vertical = 10.dp)
                .padding(bottom = 10.dp),
            style = TextStyle(
                color = Color.Black,
                fontSize = (30).calculateTextSize(screenSize).sp,
                fontWeight = FontWeight.Bold
            )
        )

        Text(
            "Contact Information",
            modifier = Modifier.padding(5.dp).padding(bottom = 10.dp),
            style = TextStyle(
                color = Color.LightGray,
                fontSize = (25).calculateTextSize(screenSize).sp,
            )
        )

        Text(
            "Have a project in mind or want to collaborate? Feel free to reach out using the form or my contact details below.",
            modifier = Modifier.padding(5.dp).padding(bottom = 10.dp),
            style = TextStyle(
                color = Color.LightGray,
                fontSize = (25).calculateTextSize(screenSize).sp,
            )
        )

        contactMeRow.forEach { (key, value) ->
            ContactInfoRow(
                modifier = Modifier.fillMaxWidth().padding(10.dp),
                icon = getIcon(key),
                contactTitle = key,
                contactInfo = value,
                screenSize = screenSize,
                onClick = {
                }
            )
        }
    }
}