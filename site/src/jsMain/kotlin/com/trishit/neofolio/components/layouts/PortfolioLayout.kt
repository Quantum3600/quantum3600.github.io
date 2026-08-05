package com.trishit.neofolio.components.layouts

import androidx.compose.runtime.*
import com.trishit.neofolio.models.Theme
import com.trishit.neofolio.style.Fonts
import com.trishit.neofolio.components.widgets.SideNav
import com.trishit.neofolio.components.widgets.CustomCursor
import com.trishit.neofolio.components.sections.TopNavSection
import com.trishit.neofolio.components.sections.FooterSection
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.TransitionTimingFunction
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.compose.ui.graphics.Colors
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import kotlinx.browser.window

@Composable
fun PortfolioLayout(content: @Composable () -> Unit) {
    var theme by remember { mutableStateOf(Theme.LIGHT) }
    var activeSection by remember { mutableStateOf("home") }

    // Scroll listener to activate the side navbar section dynamic feedback
    DisposableEffect(Unit) {
        if (window.location.hash.isEmpty()) {
            window.scrollTo(0.0, 0.0)
        }
        val handleScroll: (org.w3c.dom.events.Event) -> Unit = {
            val sections = listOf("home", "skills", "projects", "experience", "contact")
            for (section in sections) {
                val element = window.document.getElementById(section)
                if (element != null) {
                    val rect = element.getBoundingClientRect()
                    if (rect.top >= -300 && rect.top <= 400) {
                        activeSection = section
                        break
                    }
                }
            }
        }
        window.addEventListener("scroll", handleScroll)
        onDispose { window.removeEventListener("scroll", handleScroll) }
    }

    val bgColor = when (theme) {
        Theme.DARK -> Color("#18181b")
        Theme.RETRO -> Color("#fdf6e3")
        Theme.LIGHT -> Color("#f0f0f0")
    }

    val textColor = when (theme) {
        Theme.DARK -> Colors.White
        Theme.RETRO -> Color("#657b83")
        Theme.LIGHT -> Colors.Black
    }

    CustomCursor()

    Div(
        attrs = Modifier
            .minHeight(100.vh)
            .backgroundColor(bgColor)
            .color(textColor)
            .fontFamily(Fonts.Display, "sans-serif")
            .transition(Transition.of("background-color", 0.3.s, TransitionTimingFunction.Ease))
            .toAttrs()
    ) {
        SideNav(activeSection = activeSection)

        TopNavSection(
            currentTheme = theme,
            onThemeToggle = {
                theme = when (theme) {
                    Theme.LIGHT -> Theme.DARK
                    Theme.DARK -> Theme.RETRO
                    Theme.RETRO -> Theme.LIGHT
                }
            }
        )

        Main(
            attrs = Modifier
                .maxWidth(1200.px)
                .styleModifier {
                    property("margin-left", "auto")
                    property("margin-right", "auto")
                }
                .padding(top = 6.5.cssRem, left = 1.5.cssRem, right = 1.5.cssRem, bottom = 5.cssRem)
                .toAttrs()
        ) {
            content()
        }

        FooterSection()
    }
}
