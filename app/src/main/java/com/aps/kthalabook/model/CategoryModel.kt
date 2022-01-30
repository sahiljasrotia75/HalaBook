package com.aps.kthalabook.model

import com.aps.kthalabook.R

data class CategoryModel(
    var text:String,
    var selected:Boolean,
    var image:Int
)

fun getCategoryItem():List<CategoryModel>{
    return mutableListOf(
        CategoryModel(
            text = "Aesthetic",
            image = R.drawable.ic_aesthetic,
            selected = false
        ),
        CategoryModel(
            text = "Beauty Salon",
            image = R.drawable.ic_beaury_salon,
            selected = false,
        ),
        CategoryModel(
            text = "Eye",
            image = R.drawable.ic_eye,
            selected = false
        ),
        CategoryModel(
            text = "Hair Removal",
            image = R.drawable.ic_hair_removal,

            selected = true
        ),
        CategoryModel(
            text = "Hair Salon",
            image = R.drawable.ic_hair_salon,
            selected = false
        ),
        CategoryModel(
            text = "Massage",
            image = R.drawable.ic_massage,

            selected = false
        ),
        CategoryModel(
            text = "Nail Salon",
            image = R.drawable.ic_nail_salon,

            selected = false
        ),
        CategoryModel(
            text = "Spa",
            image = R.drawable.ic_spa,
            selected = false
        )
    )
}