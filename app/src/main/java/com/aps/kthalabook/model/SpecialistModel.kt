package com.aps.kthalabook.model

data class SpecialistModel(
    var image: String,
    var selected: Boolean,
)

fun getSpecialistItem(): List<SpecialistModel> {
    return mutableListOf(
        SpecialistModel(
            image = "https://picsum.photos/200/300",
            selected = false
        ),
        SpecialistModel(
            image = "https://picsum.photos/200/300?grayscale",
            selected = false,
        ),
        SpecialistModel(
            image = "https://picsum.photos/200/300/?blur",
            selected = false
        ),
        SpecialistModel(
            image = "https://picsum.photos/200/300",
            selected = true
        ),
        SpecialistModel(
            image = "https://picsum.photos/200/300?grayscale",
            selected = false
        ),
        SpecialistModel(
            image = "https://picsum.photos/200/300/?blur",
            selected = false
        ),
        SpecialistModel(
            image = "https://picsum.photos/200/300",
            selected = false
        ),
        SpecialistModel(
            image = "\"https://picsum.photos/200/300/?blur",
            selected = false
        ),
        SpecialistModel(
            image = "https://picsum.photos/200/300/?blur",
            selected = false
        ),
        SpecialistModel(
            image = "https://picsum.photos/200/300",
            selected = false
        ),
        SpecialistModel(
            image = "https://picsum.photos/200/300",
            selected = false
        ),
        SpecialistModel(
            image = "https://picsum.photos/200/300",
            selected = false
        ),
        SpecialistModel(
            image = "https://picsum.photos/200/300?grayscale",
            selected = false
        )
    )
}