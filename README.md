# 24Stream Kotlin

An android library for generating 24Stream HTML widgets to be used in WebView or any other nested browser.


## Installation

To install the library you need to add JitPack repository first(if you haven't already). In your project `root gradle.build` file add `maven { url 'https://jitpack.io' }` inside allprojects->repositories like following:

```gradle
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

```

In newer projects you may need to add it to `settings.gradle` too. It should be in `dependencyResolutionManagement->repositories` like following:

```
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```


## Usage

#### GetHTML

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `brand` | `string` | **Required**. Brand name for the page |
| `productId` | `string` | **Required**. Prouct ID for the page |
| `retailerDomain` | `string` | **Required**. Domain of the retailer of the page |
| `templateType` | `string` | **Required**. Template type of the page |
| `resultType` | `Stream24ResultType` | Result type of the page. One of `.json`, `.html` or `.iframe`. Defaults to `.html`|
| `contentType` | `Stream24ContentType` | Content type of the page. One of `.shopInShops` or `.minisite`. Defaults to `.minisite`|

Returns HTML code of the page.

## Example

```kotlin
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
```