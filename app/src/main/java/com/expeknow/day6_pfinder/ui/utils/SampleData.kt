package com.expeknow.day6_pfinder.ui.utils

import com.expeknow.day6_pfinder.R

class SampleData (
    val imageID : Int,
    val fullName: String,
    val gender: String,
    val ageInYears: Int,
    val location: String
    )

val petDataList = listOf(

    SampleData(
        imageID = R.drawable.dog1,
        fullName = "Germen Shepherd ",
        gender = "Male",
        ageInYears = 3,
        location = "California, New Carolina"
    ),

    SampleData(
        imageID = R.drawable.dog2,
        fullName = "Golden Retriever from Colorado",
        gender = "Female",
        ageInYears = 2,
        location = "Denver, Colorado"
    ),

    SampleData(
        imageID = R.drawable.dog3,
        fullName = "Labrador Retriever from Texas",
        gender = "Male",
        ageInYears = 4,
        location = "Houston, Texas"
    ),

    SampleData(
        imageID = R.drawable.dog4,
        fullName = "Siberian Husky from Alaska",
        gender = "Female",
        ageInYears = 1,
        location = "Anchorage, Alaska"
    ),

    SampleData(
        imageID = R.drawable.dog5,
        fullName = "Bulldog from England",
        gender = "Male",
        ageInYears = 6,
        location = "London, UK"
    ),


    SampleData(
        imageID = R.drawable.cat1,
        fullName = "Cute domestic cat with mixed breed",
        gender = "Female",
        ageInYears = 5,
        location = "California, South"
    ),

    SampleData(
        imageID = R.drawable.cat2,
        fullName = "Fluffy Persian Cat",
        gender = "Male",
        ageInYears = 2,
        location = "New York, USA"
    ),

    SampleData(
        imageID = R.drawable.bird1,
        fullName = "Serbian from Africa",
        gender = "Male",
        ageInYears = 4,
        location = "California, New Jersey"
    ),

    SampleData(
        imageID = R.drawable.bird2,
        fullName = "Blue Macaw Serbian from Africa In the Coast of Carolina",
        gender = "Female",
        ageInYears = 2,
        location = "Florida, USA"
    ),

    SampleData(
        imageID = R.drawable.bird3,
        fullName = "Yellow Canary from Europe",
        gender = "Male",
        ageInYears = 1,
        location = "London, UK"
    ),

    SampleData(
        imageID = R.drawable.bird4,
        fullName = "Green Budgerigar from Australia",
        gender = "Female",
        ageInYears = 3,
        location = "Sydney, Australia"
    ),

    SampleData(
        imageID = R.drawable.bird5,
        fullName = "African Grey Parrot",
        gender = "Male",
        ageInYears = 5,
        location = "Nairobi, Kenya"
    ),
)