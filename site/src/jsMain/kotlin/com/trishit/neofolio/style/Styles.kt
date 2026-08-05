package com.trishit.neofolio.style

import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.TransitionTimingFunction
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.*

object Fonts {
    val Display = "Space Grotesk"
    val Mono = "JetBrains Mono"
}

val FontDisplayModifier = Modifier.fontFamily(Fonts.Display, "sans-serif")
val FontMonoModifier = Modifier.fontFamily(Fonts.Mono, "monospace")

// Neo-Brutalist standard shadow and animation style rules
val NeoBoxStyle = CssStyle {
    base {
        Modifier
            .transition(Transition.of("all", 0.2.s, TransitionTimingFunction.EaseOut))
            .boxShadow(8.px, 8.px, 0.px, 0.px, Colors.Black)
            .fontFamily(Fonts.Display, "sans-serif")
    }
    hover {
        Modifier
            .transform { translate((-4).px, (-4).px) }
            .boxShadow(12.px, 12.px, 0.px, 0.px, Colors.Black)
    }
}

val NeoButtonStyle = CssStyle {
    base {
        Modifier
            .transition(Transition.of("all", 0.15.s, TransitionTimingFunction.EaseInOut))
            .boxShadow(4.px, 4.px, 0.px, 0.px, Colors.Black)
            .cursor(Cursor.Pointer)
            .fontFamily(Fonts.Display, "sans-serif")
            .fontWeight(FontWeight.Bold)
    }
    hover {
        Modifier
            .transform { translate((-2).px, (-2).px) }
            .boxShadow(6.px, 6.px, 0.px, 0.px, Colors.Black)
    }
}
