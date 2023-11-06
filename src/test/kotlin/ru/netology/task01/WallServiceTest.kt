package ru.netology.task01

import org.junit.Test

import org.junit.Assert.*

import ru.netology.task01.WallService.add

class WallServiceTest {

    @Test
    fun addTest() {
        val post = Post(
            10,
            1,
            12,
            111220,
            "testADS",
            markedAsAds = true,
            likes = Post.Likes(1, canLike = true),
            views = Post.Views()
        )
        val (iD) = add(post)
        assertEquals(1, iD)
    }
}