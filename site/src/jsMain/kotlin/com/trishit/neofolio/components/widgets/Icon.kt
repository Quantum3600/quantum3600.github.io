package com.trishit.neofolio.components.widgets

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.dom.I

@Composable
fun FaIcon(iconClass: String, modifier: Modifier = Modifier) {
    I(attrs = modifier.toAttrs {
        classes(*iconClass.split(" ").toTypedArray())
    })
}

@Composable
fun LucideIcon(name: String, modifier: Modifier = Modifier) {
    I(attrs = modifier.toAttrs {
        attr("data-lucide", name)
    })
    LaunchedEffect(name) {
        try {
            kotlinx.browser.window.asDynamic().lucide?.createIcons()
        } catch (_: Throwable) {}
    }
}

fun getDeviconClass(tech: String): String? {
    val t = tech.lowercase()
    return when {
        t.contains("react") -> "devicon-react-original"
        t.contains("kotlin") -> "devicon-kotlin-plain"
        t.contains("android") -> "devicon-android-plain"
        t.contains("javascript") -> "devicon-javascript-plain"
        t.contains("java") -> "devicon-java-plain"
        t.contains("python") -> "devicon-python-plain"
        t.contains("c++") || t == "c" -> "devicon-cplusplus-plain"
        t.contains("spring") -> "devicon-spring-plain"
        t.contains("node") -> "devicon-nodejs-plain"
        t.contains("mongo") -> "devicon-mongodb-plain"
        t.contains("docker") -> "devicon-docker-plain"
        t.contains("git") -> "devicon-git-plain"
        t.contains("figma") -> "devicon-figma-plain"
        t.contains("compose") -> "devicon-jetpackcompose-plain"
        t.contains("tailwind") -> "devicon-tailwindcss-plain"
        t.contains("typescript") -> "devicon-typescript-plain"
        t.contains("html") -> "devicon-html5-plain"
        t.contains("css") -> "devicon-css3-plain"
        t.contains("postgres") -> "devicon-postgresql-plain"
        t.contains("firebase") -> "devicon-firebase-plain"
        t.contains("tensorflow") -> "devicon-tensorflow-original"
        t.contains("linux") -> "devicon-linux-plain"
        else -> null
    }
}
