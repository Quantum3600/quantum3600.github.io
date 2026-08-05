package com.trishit.neofolio.components.sections

import androidx.compose.runtime.Composable
import com.trishit.neofolio.data.PORTFOLIO_DATA
import com.trishit.neofolio.style.NeoBoxStyle
import com.trishit.neofolio.style.Fonts
import com.trishit.neofolio.components.widgets.FaIcon
import com.trishit.neofolio.components.widgets.getDeviconClass
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
fun SkillsSection() {
    Section(attrs = Modifier.id("skills").margin(bottom = 10.cssRem).toAttrs()) {
        H2(
            attrs = Modifier
                .fontSize(3.cssRem)
                .fontWeight(FontWeight.Black)
                .fontFamily(Fonts.Display, "sans-serif")
                .textTransform(TextTransform.Uppercase)
                .margin(bottom = 4.cssRem)
                .toAttrs()
        ) {
            Text("Technical Arsenal")
        }

        Div(
            attrs = Modifier
                .display(DisplayStyle.Grid)
                .styleModifier { property("grid-template-columns", "repeat(auto-fit, minmax(240px, 1fr))") }
                .gap(2.5.cssRem)
                .toAttrs()
        ) {
            PORTFOLIO_DATA.skills.forEach { skillGroup ->
                Div(
                    attrs = NeoBoxStyle.toModifier()
                        .backgroundColor(Colors.White)
                        .color(Colors.Black)
                        .border(4.px, LineStyle.Solid, Colors.Black)
                        .padding(2.cssRem)
                        .toAttrs()
                ) {
                    H3(
                        attrs = Modifier
                            .fontSize(1.75.cssRem)
                            .fontWeight(FontWeight.Black)
                            .fontFamily(Fonts.Display, "sans-serif")
                            .textTransform(TextTransform.Uppercase)
                            .margin(bottom = 1.5.cssRem)
                            .toAttrs()
                    ) {
                        Text(skillGroup.category)
                    }
                    Ul(attrs = Modifier.padding(left = 0.px).styleModifier { property("list-style-type", "none") }.toAttrs()) {
                        skillGroup.items.forEach { skill ->
                            Li(
                                attrs = Modifier
                                    .display(DisplayStyle.Flex)
                                    .alignItems(com.varabyte.kobweb.compose.css.AlignItems.Center)
                                    .fontSize(1.125.cssRem)
                                    .fontWeight(FontWeight.Bold)
                                    .fontFamily(Fonts.Mono, "monospace")
                                    .margin(bottom = 0.75.cssRem)
                                    .toAttrs()
                            ) {
                                val iconClass = getDeviconClass(skill)
                                if (iconClass != null) {
                                    FaIcon(iconClass, modifier = Modifier.margin(right = 0.6.cssRem).fontSize(1.25.cssRem))
                                } else {
                                    FaIcon("fa-solid fa-code", modifier = Modifier.margin(right = 0.6.cssRem).fontSize(1.25.cssRem))
                                }
                                Text(skill)
                            }
                        }
                    }
                }
            }
        }
    }
}
