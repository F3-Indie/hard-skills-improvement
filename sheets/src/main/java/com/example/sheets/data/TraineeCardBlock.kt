package com.example.sheets.data

enum class TraineeCardBlock : CardBlock {
    Tools, Language, SoftSkills;
    
    override val title: String
        get() = this.name
}