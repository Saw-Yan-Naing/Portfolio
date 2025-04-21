package syn.circus.intro

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.withStyle

@Composable
fun AnnotatedString.Builder.ListTextSpan(
    firstText: String,
    firstTextStyle: SpanStyle,
    list: List<String>,
    listTextStyle: SpanStyle,
) {

    withStyle(
        firstTextStyle
    ) {
        append(firstText)

        withStyle(
            firstTextStyle
        ) {
            append(" [ ")
        }

        list.forEachIndexed { index, text ->
            withStyle(
                listTextStyle
            ) {
                append(text)
                if (index != list.lastIndex) {
                    append(" , ")
                }
            }
        }

        withStyle(
            firstTextStyle
        ) {
            append(" ] , \n")
        }
    }

}