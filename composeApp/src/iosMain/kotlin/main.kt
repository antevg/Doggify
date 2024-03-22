import androidx.compose.ui.window.ComposeUIViewController
import com.eacipher.doggify.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
