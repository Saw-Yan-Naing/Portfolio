package syn.circus.intro

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.withStyle

@Composable
fun AnnotatedString.Builder.DoubleTextSpan(
    firstText: String,
    secondText: String,
    firstTextStyle: SpanStyle,
    secondTextStyle: SpanStyle,
) {
    withStyle(
        style = firstTextStyle
    ){
        append(firstText)
    }
    withStyle(
        style = secondTextStyle
    ){
        append(secondText)
    }
}