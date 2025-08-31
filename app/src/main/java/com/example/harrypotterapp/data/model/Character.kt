package com.example.harrypotterapp.data.model

import com.google.gson.annotations.SerializedName

data class Character(
    val id: String?,
    val name: String?,
    @SerializedName("alternate_names")
    val alternateNames: List<String>?,
    val species: String?,
    val gender: String?,
    val house: String?,
    val dateOfBirth: String?,
    val yearOfBirth: Int?,
    val wizard: Boolean?,
    val ancestry: String?,
    val eyeColour: String?,
    val hairColour: String?,
    val wand: Wand?,
    val patronus: String?,
    val hogwartsStudent: Boolean?,
    val hogwartsStaff: Boolean?,
    val actor: String?,
    @SerializedName("alternate_actors")
    val alternateActors: List<String>?,
    val alive: Boolean?,
    val image: String?
)