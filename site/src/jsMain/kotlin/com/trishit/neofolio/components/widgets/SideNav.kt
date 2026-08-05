package com.trishit.neofolio.components.widgets

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.silk.components.navigation.Link
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun SideNav(activeSection: String) {
    val sections = listOf("home", "skills", "projects", "experience", "contact")
    var hoveredSection by remember { mutableStateOf<String?>(null) }

    Div(
        attrs = Modifier
            .position(Position.Fixed)
            .right(1.5.cssRem)
            .top(50.percent)
            .transform { translate(0.px, (-50).percent) }
            .zIndex(40)
            .display(DisplayStyle.Flex)
            .flexDirection(FlexDirection.Column)
            .gap(1.cssRem)
            .toAttrs()
    ) {
        sections.forEach { section ->
            val isVisible = hoveredSection == section
            Link(
                path = "#$section",
                modifier = Modifier
                    .display(DisplayStyle.Flex)
                    .alignItems(com.varabyte.kobweb.compose.css.AlignItems.Center)
                    .gap(1.cssRem)
                    .justifyContent(com.varabyte.kobweb.compose.css.JustifyContent.End)
                    .textDecorationLine(TextDecorationLine.None)
                    .cursor(Cursor.Pointer)
                    .onMouseEnter { hoveredSection = section }
                    .onMouseLeave { hoveredSection = null }
            ) {
                Span(
                    attrs = Modifier
                        .backgroundColor(Colors.Black)
                        .color(Colors.White)
                        .padding(0.5.cssRem, 1.cssRem)
                        .fontSize(1.125.cssRem)
                        .fontWeight(FontWeight.Black)
                        .textTransform(TextTransform.Uppercase)
                        .border(4.px, LineStyle.Solid, Color("#ff5252"))
                        .opacity(if (isVisible) 1 else 0)
                        .visibility(if (isVisible) Visibility.Visible else Visibility.Hidden)
                        .transform { translate(if (isVisible) 0.px else 10.px, 0.px) }
                        .transition(
                            Transition.of("opacity", 0.2.s, TransitionTimingFunction.EaseInOut),
                            Transition.of("transform", 0.2.s, TransitionTimingFunction.EaseInOut),
                            Transition.of("visibility", 0.2.s, TransitionTimingFunction.EaseInOut)
                        )
                        .pointerEvents(PointerEvents.None)
                        .toAttrs()
                ) {
                    Text(section)
                }
                
                Div(
                    attrs = Modifier
                        .width(1.2.cssRem)
                        .height(1.2.cssRem)
                        .border(2.px, LineStyle.Solid, Colors.Black)
                        .backgroundColor(if (activeSection == section || isVisible) Color("#ff5252") else Colors.White)
                        .transition(Transition.of("all", 0.3.s, TransitionTimingFunction.EaseInOut))
                        .transform { 
                            if (activeSection == section || isVisible) rotate(45.deg) else rotate(0.deg) 
                        }
                        .toAttrs()
                )
            }
        }
    }
}
