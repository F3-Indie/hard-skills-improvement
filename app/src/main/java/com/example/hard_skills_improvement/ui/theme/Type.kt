package com.example.hard_skills_improvement.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.hard_skills_improvement.R

val fontFamily = FontFamily(
    Font(R.font.bitum, FontWeight.Normal),
    Font(R.font.bitum_bold, FontWeight.Bold),
    Font(R.font.bitum_italic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.bitum_light, FontWeight.Light)
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodySmall = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 18.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.25.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 28.sp,
        letterSpacing = 1.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)