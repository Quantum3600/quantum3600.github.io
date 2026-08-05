package com.trishit.neofolio.pages

import androidx.compose.runtime.Composable
import com.trishit.neofolio.components.layouts.PortfolioLayout
import com.trishit.neofolio.components.sections.*
import com.trishit.neofolio.components.widgets.ScrollReveal
import com.varabyte.kobweb.core.Page

@Page
@Composable
fun HomePage() {
    PortfolioLayout {
        ScrollReveal { HeroSection() }
        ScrollReveal { SkillsSection() }
        ScrollReveal { ProjectsSection() }
        ScrollReveal { EducationSection() }
        ScrollReveal { ContactSection() }
        ScrollReveal { ResumeSection() }
    }
}
