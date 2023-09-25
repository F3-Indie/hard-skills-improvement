package com.example.sheets.domain.entities

enum class TraineeCardBlock : CardBlock {
    Tools, Language, SoftSkills;
    
    override val title: String
        get() = this.name
}