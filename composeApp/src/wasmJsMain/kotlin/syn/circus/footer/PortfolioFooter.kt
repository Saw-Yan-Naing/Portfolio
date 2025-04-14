package syn.circus.footer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LazyItemScope.PortFolioFooter(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillParentMaxWidth()
            .drawBehind {
                drawRect(color = Color(0xFFFFFFFF))
            }.padding(horizontal = 15.dp, vertical = 10.dp)
    ) {

    }
}