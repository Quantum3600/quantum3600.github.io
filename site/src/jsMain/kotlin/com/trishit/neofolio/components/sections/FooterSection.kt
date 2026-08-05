package com.trishit.neofolio.components.sections

import androidx.compose.runtime.Composable
import com.trishit.neofolio.data.PORTFOLIO_DATA
import com.trishit.neofolio.style.Fonts
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.compose.ui.graphics.Colors
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Composable
fun FooterSection() {
    Footer(
        attrs = Modifier
            .backgroundColor(Colors.Black)
            .color(Colors.White)
            .padding(4.cssRem)
            .textAlign(TextAlign.Center)
            .borderTop(8.px, LineStyle.Solid, Color("#ff5252"))
            .toAttrs()
    ) {
        P(attrs = Modifier.fontWeight(FontWeight.Bold).fontSize(1.25.cssRem).fontFamily(Fonts.Display, "sans-serif").margin(bottom = 1.cssRem).toAttrs()) {
            Text("DESIGNED & BUILT BY ${PORTFOLIO_DATA.name.uppercase()}")
        }
        P(attrs = Modifier.fontSize(1.cssRem).color(Colors.Gray).fontFamily(Fonts.Mono, "monospace").toAttrs()) {
            Text("© 2026 // NEO_FOLIO_KOBWEB")
        }
    }
}
