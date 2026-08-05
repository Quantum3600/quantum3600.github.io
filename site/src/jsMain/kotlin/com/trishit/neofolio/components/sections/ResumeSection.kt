package com.trishit.neofolio.components.sections

import androidx.compose.runtime.Composable
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
fun ResumeSection() {
    Div(attrs = Modifier.display(DisplayStyle.Flex).justifyContent(com.varabyte.kobweb.compose.css.JustifyContent.Center).margin(bottom = 4.cssRem).toAttrs()) {
        A(
            href = "/MyResume.pdf",
            attrs = NeoButtonStyle.toModifier()
                .backgroundColor(Color("#ffe66d"))
                .color(Colors.Black)
                .border(4.px, LineStyle.Solid, Colors.Black)
                .padding(1.25.cssRem, 2.5.cssRem)
                .fontSize(1.5.cssRem)
                .fontWeight(FontWeight.Black)
                .fontFamily(Fonts.Display, "sans-serif")
                .textTransform(TextTransform.Uppercase)
                .textDecorationLine(TextDecorationLine.None)
                .toAttrs {
                    attr("download", "Trishit_Majumdar_Resume.pdf")
                    attr("target", "_blank")
                }
        ) {
            LucideIcon("download", modifier = Modifier.margin(right = 0.75.cssRem))
            Text("Download Resume")
        }
    }
}
