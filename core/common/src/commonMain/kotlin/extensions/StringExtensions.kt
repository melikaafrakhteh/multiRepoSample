package extensions

fun String.withHttps(): String {
    return "https://".plus(this.replace("http://", "").replace("https://", ""))
}