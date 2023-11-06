package ru.netology.task01

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

import ru.netology.task01.WallService.add

class WallServiceTest {

    @Test
    fun testAdd() {
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

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun testUpdateTrue() {
        clearBeforeTest()
        val post = Post(
            1,
            1,
            12,
            111220,
            "testADS",
            markedAsAds = true,
            likes = Post.Likes(1, canLike = true),
            views = Post.Views()
        )
        add(post)
        val result = WallService.update(post)
        assertEquals(true, result)
    }

    @Test
    fun testUpdateFalse() {
        clearBeforeTest()
        val post = Post(
            1,
            1,
            12,
            111220,
            "testADS",
            markedAsAds = true,
            likes = Post.Likes(1, canLike = true),
            views = Post.Views()
        )
        val result = WallService.update(post)
        assertEquals(false, result)
    }
}