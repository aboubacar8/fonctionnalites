import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
 import com.jstarczewski.pc.mathview.src.MathView

@Composable
fun MathViewComposable(formula: String) {
    AndroidView(
        factory = { ctx ->
            MathView(ctx).apply {
                text = formula
            }
        }
    )
}