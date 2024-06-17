package com.naufalm.haditsar.data.models

data class Hadits(
    val id: Int,
    val no_hadith: Int,
    val matan: Matan,
    val rawi: String
)

data class Matan(
    val arabic: String,
    val translation: String
)
