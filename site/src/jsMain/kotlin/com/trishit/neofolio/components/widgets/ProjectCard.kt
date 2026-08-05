package com.trishit.neofolio.components.widgets

import androidx.compose.runtime.Composable
import com.trishit.neofolio.models.Project
import com.trishit.neofolio.style.NeoBoxStyle
import com.trishit.neofolio.style.NeoButtonStyle
import com.trishit.neofolio.style.Fonts
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Composable
fun ProjectCard(project: Project) {
    Div(
        attrs = NeoBoxStyle.toModifier()
            .backgroundColor(Colors.White)
            .color(Colors.Black)
            .border(4.px, LineStyle.Solid, Colors.Black)
            .padding(2.cssRem)
            .display(DisplayStyle.Flex)
            .flexDirection(FlexDirection.Column)
            .fillMaxHeight()
            .toAttrs()
    ) {
        Div(
            attrs = Modifier
                .display(DisplayStyle.Flex)
                .justifyContent(com.varabyte.kobweb.compose.css.JustifyContent.SpaceBetween)
                .alignItems(com.varabyte.kobweb.compose.css.AlignItems.Start)
                .margin(bottom = 1.5.cssRem)
                .toAttrs()
        ) {
            H3(attrs = Modifier.fontSize(2.cssRem).fontWeight(FontWeight.Bold).margin(0.px).fontFamily(Fonts.Display, "sans-serif").toAttrs()) {
                Text(project.title)
            }
            Span(
                attrs = Modifier
                    .backgroundColor(Colors.Black)
                    .color(Colors.White)
                    .padding(0.25.cssRem, 0.75.cssRem)
                    .fontWeight(FontWeight.Bold)
                    .fontFamily(Fonts.Mono, "monospace")
                    .toAttrs()
            ) {
                Text(project.year)
            }
        }

        P(attrs = Modifier.margin(bottom = 2.cssRem).fontSize(1.125.cssRem).flexGrow(1).toAttrs()) {
            Text(project.description)
        }

        Div(
            attrs = Modifier
                .display(DisplayStyle.Flex)
                .flexWrap(FlexWrap.Wrap)
                .gap(0.75.cssRem)
                .margin(bottom = 2.cssRem)
                .toAttrs()
        ) {
            project.tech.forEach { t ->
                val iconClass = getDeviconClass(t)
                Span(
                    attrs = Modifier
                        .display(DisplayStyle.Flex)
                        .alignItems(com.varabyte.kobweb.compose.css.AlignItems.Center)
                        .backgroundColor(Color("rgba(78, 205, 196, 0.3)"))
                        .border(2.px, LineStyle.Solid, Colors.Black)
                        .padding(0.375.cssRem, 0.75.cssRem)
                        .fontSize(0.875.cssRem)
                        .fontWeight(FontWeight.Bold)
                        .fontFamily(Fonts.Mono, "monospace")
                        .textTransform(TextTransform.Uppercase)
                        .toAttrs()
                ) {
                    if (iconClass != null) {
                        FaIcon(iconClass, modifier = Modifier.margin(right = 0.35.cssRem))
                    }
                    Text(t)
                }
            }
        }

        A(
            href = project.link,
            attrs = NeoButtonStyle.toModifier()
                .styleModifier { property("margin-top", "auto") }
                .backgroundColor(Color("#ff5252"))
                .color(Colors.White)
                .border(4.px, LineStyle.Solid, Colors.Black)
                .padding(0.75.cssRem, 1.5.cssRem)
                .fontSize(1.125.cssRem)
                .fontWeight(FontWeight.Black)
                .fontFamily(Fonts.Display, "sans-serif")
                .textTransform(TextTransform.Uppercase)
                .textDecorationLine(TextDecorationLine.None)
                .textAlign(TextAlign.Center)
                .transition(Transition.of("background-color", 0.2.s, TransitionTimingFunction.EaseOut))
                .toAttrs()
        ) {
            Text("View Project ")
            LucideIcon("external-link", modifier = Modifier.margin(left = 0.35.cssRem))
        }
    }
}
