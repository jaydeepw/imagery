package com.github.jaydeepw.imagery.utils

import com.github.jaydeepw.imagery.models.Photo
import kotlin.random.Random

val RANDOM = Random(5)

val DOG_PICS = listOf<String>(
    "https://images.unsplash.com/photo-1489924034176-2e678c29d4c6?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1651&q=80",
    "https://d1941uuft27pfg.cloudfront.net/breed-uploads/2018/08/siberian-husky-detail.jpg?bust=1535566590&width=630",
    "https://i.pinimg.com/474x/c2/52/30/c25230009a6562e5c0b18686dc81f8c7--siberian-husky-puppies-huskies-puppies.jpg",
    "https://i.pinimg.com/474x/4d/f5/fb/4df5fb93e2292bdea07f4341377c868a.jpg",
    "https://i.pinimg.com/474x/8e/16/c8/8e16c811602f175f547da8e8abe7b5e9.jpg",
    "https://i.pinimg.com/474x/6d/f4/49/6df449b8b9e4be767aba47f79c524f08--husky-cute-cute-puppies-husky.jpg",
    "https://i.pinimg.com/474x/d2/56/94/d2569404e1953e5e837f779759cd68a3--siberian-husky-puppies-huskies-puppies.jpg",
    "https://i.pinimg.com/474x/83/fd/9d/83fd9db5d510bfc66aaeb31de8812457.jpg"
)

fun getRandomDogPhotos(count: Int): List<Photo> {
    val list = arrayListOf<Photo>()
    for (i in 0..count) {
        val photo = Photo(DOG_PICS[RANDOM.nextInt(DOG_PICS.size)])
        photo.title = "Random title $i"
        list.add(photo)
    }

    return list
}