package com.trishit.neofolio.data

import com.trishit.neofolio.models.*

val PORTFOLIO_DATA = PortfolioData(
    name = "Trishit Majumdar",
    role = "Android Developer & Web Explorer",
    about = "I am Trishit Majumdar, an Android Developer passionate about Kotlin Multiplatform and Modern Web Development. Focused on building intuitive mobile applications, robust native toolkits, and modern web architectures.",
    socials = Socials(
        email = "trishitquantum360@gmail.com",
        github = "github.com/Quantum3600",
        linkedin = "linkedin.com/in/trishit-majumdar-008344281",
        twitter = "twitter.com/Trishit18",
        instagram = "instagram.com/com.trishit.quantum360",
        facebook = "facebook.com/com.trishit.quantum360"
    ),
    projects = listOf(
        Project(
            id = "1",
            title = "KobGames Store",
            description = "A modern web game store interface built with Kobweb, showcasing the power of Kotlin on the web.",
            year = "2025",
            tech = listOf("Kobweb", "Kotlin", "Compose HTML"),
            link = "https://github.com/Quantum3600/KobGames-Store"
        ),
        Project(
            id = "2",
            title = "WakeApp",
            description = "A smart alarm Android application designed to ensure you wake up on time with intuitive UI patterns.",
            year = "2025",
            tech = listOf("Android", "Kotlin", "Jetpack Compose"),
            link = "https://github.com/Quantum3600/WakeApp"
        ),
        Project(
            id = "3",
            title = "Quotd",
            description = "A minimalistic quotes application delivering daily inspiration with a focus on Material Design.",
            year = "2025",
            tech = listOf("Android", "Kotlin", "MVVM"),
            link = "https://github.com/Quantum3600/Quotd"
        )
    ),
    skills = listOf(
        SkillGroup("Android/KMP", listOf("Kotlin", "Jetpack Compose", "Kobweb", "Ktor Mobile")),
        SkillGroup("Frontend", listOf("React", "TypeScript", "Tailwind", "HTML/CSS")),
        SkillGroup("Backend", listOf("Node.js", "Spring Boot", "Java", "Ktor Server", "MongoDB")),
        SkillGroup("Tools/AI", listOf("Git", "Docker", "Figma", "Gemini", "TensorFlow"))
    ),
    education = listOf(
        Education(
            id = "e1",
            period = "Present",
            role = "B.Tech in Computer Science",
            company = "Hooghly Engineering & Technology College",
            description = "Pursuing Bachelor of Technology in Computer Science & Engineering."
        ),
        Education(
            id = "e2",
            period = "Completed",
            role = "Higher Secondary",
            company = "Hooghly Collegiate School",
            description = "Completed Higher Secondary education with focus on Science."
        ),
        Education(
            id = "e3",
            period = "Completed",
            role = "Secondary Education",
            company = "St. John's School",
            description = "Foundation laid at primary and middle school level."
        )
    )
)

val INITIAL_TERMINAL_LOGS = listOf(
    "Welcome to TrishitOS v1.0.0",
    "Initializing Android Runtime...",
    "Loading Kotlin Multiplatform modules...",
    "System ready. Type 'help' for commands."
)
