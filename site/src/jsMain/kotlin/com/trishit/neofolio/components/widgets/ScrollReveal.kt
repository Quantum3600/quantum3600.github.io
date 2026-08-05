package com.trishit.neofolio.components.widgets

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.Element

@Composable
fun ScrollReveal(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    var isVisible by remember { mutableStateOf(false) }
    var elementRef by remember { mutableStateOf<Element?>(null) }

    DisposableEffect(elementRef) {
        val el = elementRef
        if (el == null) return@DisposableEffect onDispose {}

        val callback: (Array<dynamic>) -> Unit = { entries ->
            if (entries.isNotEmpty() && entries[0].isIntersecting == true) {
                isVisible = true
            }
        }

        val options = js("{}")
        options.threshold = 0.12

        val observer = js("new IntersectionObserver(callback, options)")

        observer.observe(el)
        onDispose { observer.disconnect() }
    }

    Div(
        attrs = modifier
            .opacity(if (isVisible) 1 else 0)
            .styleModifier {
                property("transform", if (isVisible) "translateY(0px)" else "translateY(40px)")
                property("transition", "opacity 0.7s cubic-bezier(0.16, 1, 0.3, 1), transform 0.7s cubic-bezier(0.16, 1, 0.3, 1)")
            }
            .toAttrs {
                ref { el ->
                    elementRef = el
                    onDispose {}
                }
            }
    ) {
        content()
    }
}
