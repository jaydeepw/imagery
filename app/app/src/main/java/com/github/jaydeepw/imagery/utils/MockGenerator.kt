package com.github.jaydeepw.imagery.utils

import com.github.jaydeepw.imagery.models.Photo
import kotlin.random.Random

val RANDOM = Random(5)

val DOG_PICS = listOf<String>(
    "https://images.unsplash.com/photo-1489924034176-2e678c29d4c6?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1651&q=80",
    "https://d1941uuft27pfg.cloudfront.net/breed-uploads/2018/08/siberian-husky-detail.jpg?bust=1535566590&width=630"
)

fun getRandomDogPhotos(count: Int): List<Photo> {
    val list = arrayListOf<Photo>()
    for (i in 0..count) {
        list.add(Photo(DOG_PICS[RANDOM.nextInt(DOG_PICS.size)]))
    }

    return list
}