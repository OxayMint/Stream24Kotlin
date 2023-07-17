package dev.fgoja.demo.stream24_kotlin

import android.os.Bundle
import android.util.Log
import android.webkit.WebSettings
import android.webkit.WebSettings.ZoomDensity
import android.webkit.WebView
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.fgoja.demo.stream24_kotlin.ui.theme.Stream24_KotlinTheme
import dev.fgoja.stream24.Stream24


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val webview = WebView(this)
        val html = Stream24.GetHTML("Samsung", "16651081549", "irshad.az", "master_template", Stream24.Stream24ResultType.html, Stream24.Stream24ContentType.shopInShops)
        webview.getSettings().javaScriptEnabled = true
        webview.loadData(html,
            "text/html", "UTF-8")
        setContentView(webview)
    }
}
