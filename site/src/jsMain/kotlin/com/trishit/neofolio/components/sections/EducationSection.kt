package com.trishit.neofolio.components.sections

import androidx.compose.runtime.Composable
import com.trishit.neofolio.data.PORTFOLIO_DATA
import com.trishit.neofolio.style.NeoBoxStyle
import com.trishit.neofolio.style.Fonts
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Composable
fun EducationSection() {
    Section(attrs = Modifier.id("experience").margin(bottom = 10.cssRem).toAttrs()) {
        H2(
            attrs = Modifier
                .fontSize(3.cssRem)
                .fontWeight(FontWeight.Black)
                .fontFamily(Fonts.Display, "sans-serif")
                .textTransform(TextTransform.Uppercase)
                .margin(bottom = 4.cssRem)
                .toAttrs()
        ) {
            Text("Education")
        }

        PORTFOLIO_DATA.education.forEach { edu ->
            Div(
                attrs = NeoBoxStyle.toModifier()
                    .backgroundColor(Colors.White)
                    .color(Colors.Black)
                    .border(4.px, LineStyle.Solid, Colors.Black)
                    .padding(2.5.cssRem)
                    .display(DisplayStyle.Flex)
                    .gap(2.cssRem)
                    .toAttrs()
            ) {
                Div(attrs = Modifier.width(25.percent).toAttrs()) {
                    Span(
                        attrs = Modifier
                            .backgroundColor(Color("#ffe66d"))
                            .padding(0.5.cssRem, 1.cssRem)
                            .fontWeight(FontWeight.Bold)
                            .fontFamily(Fonts.Mono, "monospace")
                            .border(4.px, LineStyle.Solid, Colors.Black)
                            .toAttrs()
                    ) {
                        Text(edu.period)
                    }
                }
                Div(attrs = Modifier.width(75.percent).toAttrs()) {
                    H3(
                        attrs = Modifier
                            .fontSize(2.cssRem)
                            .fontWeight(FontWeight.Black)
                            .fontFamily(Fonts.Display, "sans-serif")
                            .textTransform(TextTransform.Uppercase)
                            .margin(bottom = 0.5.cssRem)
                            .toAttrs()
                    ) {
                        Text(edu.role)
                    }
                    H4(attrs = Modifier.fontSize(1.25.cssRem).color(Colors.Gray).margin(bottom = 1.cssRem).toAttrs()) {
                        Text(edu.company)
                    }
                    P(attrs = Modifier.fontSize(1.125.cssRem).toAttrs()) {
                        Text(edu.description)
                    }
                }
            }
        }
    }
}
