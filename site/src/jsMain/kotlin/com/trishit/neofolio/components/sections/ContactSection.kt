package com.trishit.neofolio.components.sections

import androidx.compose.runtime.*
import com.trishit.neofolio.data.PORTFOLIO_DATA
import com.trishit.neofolio.style.NeoBoxStyle
import com.trishit.neofolio.style.NeoButtonStyle
import com.trishit.neofolio.style.Fonts
import com.trishit.neofolio.components.widgets.FaIcon
import com.trishit.neofolio.components.widgets.LucideIcon
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import kotlinx.browser.window

@Composable
fun ContactSection() {
    var nameInput by remember { mutableStateOf("") }
    var messageInput by remember { mutableStateOf("") }

    Section(attrs = Modifier.id("contact").margin(bottom = 8.cssRem).toAttrs()) {
        H2(
            attrs = Modifier
                .fontSize(3.cssRem)
                .fontWeight(FontWeight.Black)
                .fontFamily(Fonts.Display, "sans-serif")
                .textTransform(TextTransform.Uppercase)
                .margin(bottom = 4.cssRem)
                .toAttrs()
        ) {
            Text("Initiate Handshake")
        }

        Div(
            attrs = Modifier
                .display(DisplayStyle.Grid)
                .styleModifier { property("grid-template-columns", "1fr 1fr") }
                .gap(4.cssRem)
                .toAttrs()
        ) {
            Div(
                attrs = NeoBoxStyle.toModifier()
                    .backgroundColor(Colors.Black)
                    .color(Colors.White)
                    .padding(2.5.cssRem)
                    .border(4.px, LineStyle.Solid, Color("#ff5252"))
                    .toAttrs()
            ) {
                H3(
                    attrs = Modifier
                        .fontSize(2.5.cssRem)
                        .fontWeight(FontWeight.Black)
                        .fontFamily(Fonts.Display, "sans-serif")
                        .textTransform(TextTransform.Uppercase)
                        .margin(bottom = 2.5.cssRem)
                        .toAttrs()
                ) {
                    Text("Let's Build The Future")
                }
                P(attrs = Modifier.fontSize(1.25.cssRem).fontFamily(Fonts.Mono, "monospace").lineHeight(1.6).margin(bottom = 3.cssRem).toAttrs()) {
                    Text("Currently open for new opportunities. Whether you have a question or just want to say hi, I'll try my best to get back to you!")
                }

                Div(
                    attrs = Modifier
                        .display(DisplayStyle.Grid)
                        .styleModifier { property("grid-template-columns", "repeat(auto-fit, minmax(140px, 1fr))") }
                        .gap(1.5.cssRem)
                        .toAttrs()
                ) {
                    val linkModifier = Modifier
                        .display(DisplayStyle.Flex)
                        .alignItems(com.varabyte.kobweb.compose.css.AlignItems.Center)
                        .gap(1.cssRem)
                        .color(Colors.White)
                        .fontSize(1.25.cssRem)
                        .fontWeight(FontWeight.Bold)
                        .textDecorationLine(TextDecorationLine.None)
                        .transition(Transition.of("color", 0.2.s, TransitionTimingFunction.EaseInOut))

                    A(
                        href = "https://${PORTFOLIO_DATA.socials.github}",
                        attrs = linkModifier.toAttrs {
                            attr("target", "_blank")
                            attr("rel", "noreferrer")
                        }
                    ) {
                        FaIcon("fa-brands fa-github", modifier = Modifier.fontSize(2.cssRem))
                        Text("GitHub")
                    }

                    A(
                        href = "https://${PORTFOLIO_DATA.socials.linkedin}",
                        attrs = linkModifier.toAttrs {
                            attr("target", "_blank")
                            attr("rel", "noreferrer")
                        }
                    ) {
                        FaIcon("fa-brands fa-linkedin", modifier = Modifier.fontSize(2.cssRem))
                        Text("LinkedIn")
                    }

                    A(
                        href = "mailto:${PORTFOLIO_DATA.socials.email}",
                        attrs = linkModifier.toAttrs()
                    ) {
                        FaIcon("fa-solid fa-envelope", modifier = Modifier.fontSize(2.cssRem))
                        Text("Email")
                    }

                    A(
                        href = "https://${PORTFOLIO_DATA.socials.twitter}",
                        attrs = linkModifier.toAttrs {
                            attr("target", "_blank")
                            attr("rel", "noreferrer")
                        }
                    ) {
                        FaIcon("fa-brands fa-x-twitter", modifier = Modifier.fontSize(2.cssRem))
                        Text("X / Twitter")
                    }

                    A(
                        href = "https://${PORTFOLIO_DATA.socials.instagram}",
                        attrs = linkModifier.toAttrs {
                            attr("target", "_blank")
                            attr("rel", "noreferrer")
                        }
                    ) {
                        FaIcon("fa-brands fa-instagram", modifier = Modifier.fontSize(2.cssRem))
                        Text("Instagram")
                    }

                    A(
                        href = "https://${PORTFOLIO_DATA.socials.facebook}",
                        attrs = linkModifier.toAttrs {
                            attr("target", "_blank")
                            attr("rel", "noreferrer")
                        }
                    ) {
                        FaIcon("fa-brands fa-facebook", modifier = Modifier.fontSize(2.cssRem))
                        Text("Facebook")
                    }
                }
            }

            val formModifier = NeoBoxStyle.toModifier()
                .backgroundColor(Colors.White)
                .color(Colors.Black)
                .border(4.px, LineStyle.Solid, Colors.Black)
                .padding(2.5.cssRem)
                .display(DisplayStyle.Flex)
                .flexDirection(FlexDirection.Column)
                .gap(1.5.cssRem)

            Form(
                action = "#",
                attrs = formModifier.toAttrs()
            ) {
                Div {
                    Label(
                        attrs = Modifier
                            .display(DisplayStyle.Block)
                            .fontSize(1.25.cssRem)
                            .fontWeight(FontWeight.Black)
                            .fontFamily(Fonts.Display, "sans-serif")
                            .textTransform(TextTransform.Uppercase)
                            .margin(bottom = 0.5.cssRem)
                            .toAttrs()
                    ) {
                        Text("Identify Yourself")
                    }
                    val inputModifier = Modifier
                        .width(100.percent)
                        .padding(1.cssRem)
                        .border(4.px, LineStyle.Solid, Colors.Black)
                        .fontSize(1.125.cssRem)
                        .fontWeight(FontWeight.Bold)
                        .fontFamily(Fonts.Mono, "monospace")

                    Input(
                        type = InputType.Text,
                        attrs = inputModifier.toAttrs {
                            onInput { nameInput = it.value }
                        }
                    )
                }

                Div {
                    Label(
                        attrs = Modifier
                            .display(DisplayStyle.Block)
                            .fontSize(1.25.cssRem)
                            .fontWeight(FontWeight.Black)
                            .fontFamily(Fonts.Display, "sans-serif")
                            .textTransform(TextTransform.Uppercase)
                            .margin(bottom = 0.5.cssRem)
                            .toAttrs()
                    ) {
                        Text("Transmission")
                    }
                    val textAreaModifier = Modifier
                        .width(100.percent)
                        .height(8.cssRem)
                        .padding(1.cssRem)
                        .border(4.px, LineStyle.Solid, Colors.Black)
                        .fontSize(1.125.cssRem)
                        .fontWeight(FontWeight.Bold)
                        .fontFamily(Fonts.Mono, "monospace")

                    TextArea(
                        attrs = textAreaModifier.toAttrs {
                            onInput { messageInput = it.value }
                        }
                    )
                }

                Button(
                    attrs = NeoButtonStyle.toModifier()
                        .backgroundColor(Color("#ff5252"))
                        .color(Colors.White)
                        .border(4.px, LineStyle.Solid, Colors.Black)
                        .padding(1.25.cssRem)
                        .fontSize(1.25.cssRem)
                        .fontWeight(FontWeight.Black)
                        .fontFamily(Fonts.Display, "sans-serif")
                        .textTransform(TextTransform.Uppercase)
                        .onClick {
                            val mailtoUrl = "mailto:${PORTFOLIO_DATA.socials.email}?subject=Portfolio Contact from $nameInput&body=$messageInput"
                            window.location.href = mailtoUrl
                        }
                        .toAttrs()
                ) {
                    LucideIcon("mail", modifier = Modifier.margin(right = 0.5.cssRem))
                    Text("Send Message")
                }
            }
        }
    }
}
