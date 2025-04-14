package syn.circus.utils.function

fun Int.calculateTextSize(screenWidth: Int): Int {

    val textSize =
        when {
            screenWidth in 0..599 -> this
            screenWidth in 600..1200 -> (this * 1.3).toInt()
            screenWidth > 1200 -> (this * 1.5).toInt()
            else -> this
        }
    return textSize
}