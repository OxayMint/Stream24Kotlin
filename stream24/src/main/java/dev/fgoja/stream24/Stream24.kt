package dev.fgoja.stream24

class Stream24() {
    enum class Stream24ContentType {
        shopInShops, minisite
    }

    enum class Stream24ResultType {
        html, json, iframe
    }

    companion object {
        @JvmOverloads
        fun GetHTML(
            brand: String?,
            productId: String?,
            retailerDomain: String?,
            templateType: String?,
            resultType: Stream24ResultType? = Stream24ResultType.html,
            contentType: Stream24ContentType? = Stream24ContentType.minisite
        ): String {
            return String.format(
                "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\" />\n" +
                        "    <title>24 Stream</title>\n" +
                        "    <script async=\"\" src=\"https://content.24ttl.stream/widget.js\"></script>\n"+
                        "</head>\n" +
                        "\n" +
                        "<body>\n" +
                        "    <div class=\"wrapper\"></div>\n" +
                        "    <script>(function (w, d, s, o) { var f = d.getElementsByTagName(s)[0]; var j = d.createElement(s); w.TTLStreamReady = new Promise((resolve) => { j.async = true; j.src = 'https://content.24ttl.stream/widget.js'; f.parentNode.insertBefore(j, f); j.onload = function () { w.ttlStream = new TTLStream(o); resolve(w.ttlStream); }; }); })(window, document, 'script', {}); </script>\n" +
                        "    <script> TTLStreamReady.then(() => { ttlStream.findAndInsert({ \"brand\": \"%s\", \"productId\": \"%s\", \"retailerDomain\": \"%s\", \"templateType\": \"%s\", \"resultType\": \"%s\", \"contentType\": \"%s\", \"el\": \".wrapper\", \"windowMode\": \"self\" }); }); </script>\n" +
                        "</body>\n" +
                        "\n" +
                        "</html>",
                brand,
                productId,
                retailerDomain,
                templateType,
                _getResultType(resultType),
                _getContentType(contentType)
            )
        }

        fun _getContentType(contentType: Stream24ContentType?): String {
            when (contentType) {
                Stream24ContentType.shopInShops -> return "sis"
                else -> return "minisite"
            }
        }

        fun _getResultType(resultType: Stream24ResultType?): String {
            when (resultType) {
                Stream24ResultType.json -> return "json"
                Stream24ResultType.iframe -> return "iframe"
                else -> return "html"
            }
        }
    }
}