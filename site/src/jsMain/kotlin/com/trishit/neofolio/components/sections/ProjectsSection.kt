package com.trishit.neofolio.components.sections

import androidx.compose.runtime.Composable
import com.trishit.neofolio.data.PORTFOLIO_DATA
import com.trishit.neofolio.style.Fonts
import com.trishit.neofolio.components.widgets.ProjectCard
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Composable
fun ProjectsSection() {
    Section(attrs = Modifier.id("projects").margin(bottom = 10.cssRem).toAttrs()) {
        H2(
            attrs = Modifier
                .fontSize(3.cssRem)
                .fontWeight(FontWeight.Black)
                .fontFamily(Fonts.Display, "sans-serif")
                .textTransform(TextTransform.Uppercase)
                .margin(bottom = 4.cssRem)
                .toAttrs()
        ) {
            Text("Selected Works")
        }

        Div(
            attrs = Modifier
                .display(DisplayStyle.Grid)
                .styleModifier { property("grid-template-columns", "repeat(auto-fit, minmax(300px, 1fr))") }
                .gap(2.5.cssRem)
                .margin(bottom = 3.cssRem)
                .toAttrs()
        ) {
            PORTFOLIO_DATA.projects.forEach { project ->
                ProjectCard(project = project)
            }
        }
    }
}
