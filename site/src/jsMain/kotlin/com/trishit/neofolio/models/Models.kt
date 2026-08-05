package com.neofolio.models

enum class Theme {
    LIGHT, DARK, RETRO
}

data class Project(
    val id: String,
    val title: String,
    val description: String,
    val year: String,
    val tech: List<String>,
    val link: String
)

data class SkillGroup(
    val category: String,
    val items: List<String>
)

data class Education(
    val id: String,
    val period: String,
    val role: String,
    val company: String,
    val description: String
)

data class Socials(
    val email: String,
    val github: String,
    val linkedin: String,
    val twitter: String,
    val instagram: String,
    val facebook: String
)

data class PortfolioData(
    val name: String,
    val about: String,
    val skills: List<SkillGroup>,
    val projects: List<Project>,
    val education: List<Education>,
    val socials: Socials
)

