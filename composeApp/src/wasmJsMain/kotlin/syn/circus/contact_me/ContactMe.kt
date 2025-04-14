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
import syn.circus.contact_me.widget.ContactInfoRow
import syn.circus.utils.function.calculateTextSize

@Composable
fun ContactMe(
    modifier: Modifier = Modifier,
) {

    val screenWidth by rememberSaveable {
        derivedStateOf {
            mutableStateOf(0)
        }
    }

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
        modifier = modifier.onGloballyPositioned {
            screenWidth.value = it.size.width
        }.wrapContentHeight(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {


        Text(
            "Contact Information",
            modifier = Modifier.padding(5.dp).padding(bottom = 10.dp),
            style = TextStyle(
                color = Color.Black,
                fontSize = (20).calculateTextSize(screenWidth.value).sp,
                fontWeight = FontWeight.Bold
            )
        )

        Text(
            "Have a project in mind or want to collaborate? Feel free to reach out using the form or my contact details below.",
            modifier = Modifier.padding(5.dp).padding(bottom = 10.dp),
            style = TextStyle(
                color = Color.Black.copy(alpha =.5f),
                fontSize = (16).calculateTextSize(screenWidth.value).sp,
            )
        )

        contactMeRow.forEach { (key, value) ->
            ContactInfoRow(
                modifier = Modifier.fillMaxWidth().padding(10.dp),
                icon = getIcon(key),
                contactTitle = key,
                contactInfo = value,
                screenSize = screenWidth.value,
                onClick = {
                }
            )
        }
    }
}