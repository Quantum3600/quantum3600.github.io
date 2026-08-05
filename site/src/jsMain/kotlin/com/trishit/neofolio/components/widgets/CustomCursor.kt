package com.trishit.neofolio.components.widgets

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.compose.ui.graphics.Colors
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import kotlinx.browser.window

@Composable
fun CustomCursor() {
    var posX by remember { mutableStateOf(0.0) }
    var posY by remember { mutableStateOf(0.0) }
    var isHovered by remember { mutableStateOf(false) }
    var isMouseDown by remember { mutableStateOf(false) }

    DisposableEffect(Unit) {
        val handleMouseMove: (org.w3c.dom.events.Event) -> Unit = { e ->
            val mouseEvent = e.asDynamic()
            posX = mouseEvent.clientX as Double
            posY = mouseEvent.clientY as Double

            val target = mouseEvent.target
            val tagName = target?.tagName?.toString()?.lowercase() ?: ""
            val isClickable = tagName == "a" || tagName == "button" || tagName == "input" || tagName == "textarea" ||
                    target?.getAttribute?.call(target, "role") == "button"
            isHovered = isClickable
        }

        val handleMouseDown: (org.w3c.dom.events.Event) -> Unit = { isMouseDown = true }
        val handleMouseUp: (org.w3c.dom.events.Event) -> Unit = { isMouseDown = false }

        window.addEventListener("mousemove", handleMouseMove)
        window.addEventListener("mousedown", handleMouseDown)
        window.addEventListener("mouseup", handleMouseUp)

        onDispose {
            window.removeEventListener("mousemove", handleMouseMove)
            window.removeEventListener("mousedown", handleMouseDown)
            window.removeEventListener("mouseup", handleMouseUp)
        }
    }

    val size = if (isMouseDown) 18.px else if (isHovered) 52.px else 28.px

    Div(
        attrs = Modifier
            .position(Position.Fixed)
            .left(posX.px)
            .top(posY.px)
            .width(size)
            .height(size)
            .backgroundColor(Colors.White)
            .borderRadius(50.percent)
            .pointerEvents(PointerEvents.None)
            .zIndex(99999)
            .styleModifier {
                property("mix-blend-mode", "difference")
                property("transform", "translate(-50%, -50%)")
                property("transition", "width 0.2s cubic-bezier(0.16, 1, 0.3, 1), height 0.2s cubic-bezier(0.16, 1, 0.3, 1)")
            }
            .toAttrs()
    )
}
