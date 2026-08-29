package com.trishit.neofolio.components.sections

import androidx.compose.runtime.Composable
import com.trishit.neofolio.data.PORTFOLIO_DATA
import com.trishit.neofolio.style.NeoBoxStyle
import com.trishit.neofolio.style.NeoButtonStyle
import com.trishit.neofolio.style.Fonts
import com.trishit.neofolio.components.widgets.LucideIcon
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
fun HeroSection() {
    Section(
        attrs = Modifier
            .id("home")
            .styleModifier { property("min-height", "calc(100vh - 20rem)") }
            .display(DisplayStyle.Flex)
            .alignItems(com.varabyte.kobweb.compose.css.AlignItems.Center)
            .justifyContent(com.varabyte.kobweb.compose.css.JustifyContent.Center)
            .padding(top = 3.cssRem, bottom = 4.cssRem)
            .margin(bottom = 20.cssRem)
            .toAttrs()
    ) {
        Div(
            attrs = Modifier
                .display(DisplayStyle.Grid)
                .styleModifier { property("grid-template-columns", "1fr 1.2fr") }
                .gap(4.cssRem)
                .alignItems(com.varabyte.kobweb.compose.css.AlignItems.Center)
                .width(100.percent)
                .toAttrs()
        ) {
            // Profile Image Container
            Div(attrs = Modifier.display(DisplayStyle.Flex).justifyContent(com.varabyte.kobweb.compose.css.JustifyContent.Center).toAttrs()) {
                Div(attrs = Modifier.position(Position.Relative).width(30.cssRem).height(30.cssRem).toAttrs()) {
                    Img(
                        src = "/photo.webp",
                        alt = PORTFOLIO_DATA.name,
                        attrs = NeoBoxStyle.toModifier()
                            .width(100.percent)
                            .height(100.percent)
                            .border(4.px, LineStyle.Solid, Colors.Black)
                            .objectFit(ObjectFit.Cover)
                            .backgroundColor(Colors.White)
                            .toAttrs()
                    )
                }
            }

            // Hero Text
            Div(attrs = Modifier.display(DisplayStyle.Flex).flexDirection(FlexDirection.Column).alignItems(com.varabyte.kobweb.compose.css.AlignItems.FlexStart).toAttrs()) {
                Span(
                    attrs = Modifier
                        .backgroundColor(Color("#ffe66d"))
                        .color(Colors.Black)
                        .border(4.px, LineStyle.Solid, Colors.Black)
                        .padding(0.5.cssRem, 1.cssRem)
                        .fontWeight(FontWeight.Bold)
                        .fontFamily(Fonts.Mono, "monospace")
                        .margin(bottom = 1.5.cssRem)
                        .toAttrs()
                ) {
                    Text("v1.0.0 // HELLO_WORLD")
                }

                H1(
                    attrs = Modifier
                        .fontSize(4.5.cssRem)
                        .fontWeight(FontWeight.Black)
                        .fontFamily(Fonts.Display, "sans-serif")
                        .textTransform(TextTransform.Uppercase)
                        .lineHeight(1.em)
                        .margin(bottom = 0.75.cssRem)
                        .toAttrs()
                ) {
                    Text("Hello, Trishit Here!")
                }

                H2(
                    attrs = Modifier
                        .fontSize(1.75.cssRem)
                        .fontWeight(FontWeight.Bold)
                        .color(Color("#ff5252"))
                        .margin(bottom = 1.25.cssRem)
                        .toAttrs()
                ) {
                    Text(PORTFOLIO_DATA.role)
                }

                P(
                    attrs = Modifier
                        .fontSize(1.25.cssRem)
                        .borderLeft(8.px, LineStyle.Solid, Color("#ff5252"))
                        .padding(left = 1.5.cssRem)
                        .margin(bottom = 2.5.cssRem)
                        .toAttrs()
                ) {
                    Text(PORTFOLIO_DATA.about)
                }

                Div(attrs = Modifier.display(DisplayStyle.Flex).gap(1.5.cssRem).toAttrs()) {
                    A(
                        href = "#projects",
                        attrs = NeoButtonStyle.toModifier()
                            .backgroundColor(Color("#ffe66d"))
                            .color(Colors.Black)
                            .border(4.px, LineStyle.Solid, Colors.Black)
                            .padding(1.cssRem, 2.cssRem)
                            .fontSize(1.25.cssRem)
                            .fontWeight(FontWeight.Bold)
                            .fontFamily(Fonts.Display, "sans-serif")
                            .textTransform(TextTransform.Uppercase)
                            .textDecorationLine(TextDecorationLine.None)
                            .toAttrs()
                    ) {
                        Text("Explore Apps ")
                        LucideIcon("arrow-right", modifier = Modifier.margin(left = 0.35.cssRem))
                    }

                    A(
                        href = "#contact",
                        attrs = NeoButtonStyle.toModifier()
                            .backgroundColor(Colors.White)
                            .color(Colors.Black)
                            .border(4.px, LineStyle.Solid, Colors.Black)
                            .padding(1.cssRem, 2.cssRem)
                            .fontSize(1.25.cssRem)
                            .fontWeight(FontWeight.Bold)
                            .fontFamily(Fonts.Display, "sans-serif")
                            .textTransform(TextTransform.Uppercase)
                            .textDecorationLine(TextDecorationLine.None)
                            .toAttrs()
                    ) {
                        LucideIcon("mail", modifier = Modifier.margin(right = 0.5.cssRem))
                        Text("Contact Me")
                    }
                }
            }
        }
    }
}
