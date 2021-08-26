import react.dom.render
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinext.js.require
import react.RBuilder
import react.ReactNode
import react.dom.div

fun main() {
    require("./styles.css")

    window.onload = {
        render(document.getElementById("root")) {
            div(classes = "container flex text-white text-6xl font-sans bg-gradient-to-r from-secondary to-primary min-w-full h-screen p-4") {
                div(classes = "m-auto") {
                    text("Kotlin is the future of programing")
                }
            }
        }
    }
}

fun RBuilder.text(text: String) = childList.add(ReactNode(text))

