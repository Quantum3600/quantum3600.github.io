package com.trishit.neofolio.components.sections

import androidx.compose.runtime.Composable
import com.trishit.neofolio.data.PORTFOLIO_DATA
import com.trishit.neofolio.models.Theme
import com.trishit.neofolio.style.NeoButtonStyle
import com.trishit.neofolio.style.Fonts
import com.trishit.neofolio.components.widgets.LucideIcon
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Composable
fun TopNavSection(
    currentTheme: Theme,
    onThemeToggle: () -> Unit
) {
    Nav(
        attrs = Modifier
            .position(Position.Fixed)
            .top(0.px)
            .width(100.percent)
            .padding(1.5.cssRem)
            .zIndex(50)
            .display(DisplayStyle.Flex)
            .justifyContent(com.varabyte.kobweb.compose.css.JustifyContent.SpaceBetween)
            .alignItems(com.varabyte.kobweb.compose.css.AlignItems.Center)
            .toAttrs()
    ) {
        Div(
            attrs = NeoButtonStyle.toModifier()
                .backgroundColor(Colors.White)
                .color(Colors.Black)
                .border(4.px, LineStyle.Solid, Colors.Black)
                .padding(0.75.cssRem, 1.5.cssRem)
                .fontWeight(FontWeight.Black)
                .fontSize(1.5.cssRem)
                .fontFamily(Fonts.Display, "sans-serif")
                .textTransform(TextTransform.Uppercase)
                .toAttrs()
        ) {
            Text(PORTFOLIO_DATA.name)
        }

        Button(
            attrs = NeoButtonStyle.toModifier()
                .backgroundColor(Colors.White)
                .color(Colors.Black)
                .padding(0.75.cssRem, 1.25.cssRem)
                .border(4.px, LineStyle.Solid, Colors.Black)
                .fontSize(2.cssRem)
                .display(DisplayStyle.Flex)
                .alignItems(com.varabyte.kobweb.compose.css.AlignItems.Center)
                .justifyContent(com.varabyte.kobweb.compose.css.JustifyContent.Center)
                .onClick { onThemeToggle() }
                .toAttrs()
        ) {
            when (currentTheme) {
                Theme.LIGHT -> LucideIcon("moon", modifier = Modifier.fontSize(2.cssRem))
                Theme.DARK -> LucideIcon("monitor", modifier = Modifier.fontSize(2.cssRem))
                Theme.RETRO -> LucideIcon("sun", modifier = Modifier.fontSize(2.cssRem))
            }
        }
    }
}
