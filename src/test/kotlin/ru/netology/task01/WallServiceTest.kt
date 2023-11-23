package ru.netology.task01

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

import ru.netology.task01.WallService.add
import ru.netology.task01.WallService.createComment
import ru.netology.task01.WallService.createReportComment

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun testAdd() {
        val post = Post(
            10,
            1,
            12,
            date = 111220,
            text = "testADS",
            markedAsAds = true,
            likes = Post.Likes(1, canLike = true),
            views = Post.Views()
        )
        val (iD) = add(post)
        assertEquals(1, iD)
    }

    @Test
    fun testUpdateTrue() {
        val post = Post(
            1,
            1,
            12,
            date = 111220,
            text = "testADS",
            markedAsAds = true,
            likes = Post.Likes(1, canLike = true),
            views = Post.Views()
        )
        add(post)
        val result = WallService.update(post)
        assertTrue(result)
    }

    @Test
    fun testUpdateFalse() {
        val post = Post(
            1,
            1,
            12,
            date = 111220,
            text = "testADS",
            markedAsAds = true,
            likes = Post.Likes(1, canLike = true),
            views = Post.Views()
        )
        val result = WallService.update(post)
        assertFalse(result)
    }

    @Test
    fun testCreateCommentAdded() {
        val post = Post(
            1,
            1,
            12,
            date = 111220,
            text = "testADS",
            markedAsAds = true,
            likes = Post.Likes(1, canLike = true),
            views = Post.Views()
        )

        val comment = Comment(
            1,
            1,
            11112012,
            "New comment",
            donut = Comment.Donut(true, "text"),
            0,
            null,
            null,
            null
        )
        add(post)
        val (iD) = createComment(1, comment)
        assertEquals(1, iD)
    }

    @Test(expected = PostNotFoundException::class)
    fun testShouldThrow() {
        val post = Post(
            1,
            1,
            12,
            date = 111220,
            text = "testADS",
            markedAsAds = true,
            likes = Post.Likes(1, canLike = true),
            views = Post.Views()
        )

        val comment = Comment(
            1,
            1,
            11112012,
            "New comment",
            donut = Comment.Donut(true, "text"),
            0,
            null,
            null,
            null
        )
        add(post)
        createComment(2, comment)
    }

    @Test
    fun testCreateReportComment() {
        val post = Post(
            1,
            1,
            12,
            date = 111220,
            text = "testADS",
            markedAsAds = true,
            likes = Post.Likes(1, canLike = true),
            views = Post.Views()
        )
        val comment = Comment(
            1,
            1,
            11112012,
            "New comment",
            donut = Comment.Donut(true, "text"),
            0,
            null,
            null,
            null
        )
        val reportComment = reportComment(1, 1, 0)

        add(post)
        createComment(1, comment)
        val result = createReportComment(1, reportComment)
        assertEquals(1, result)
    }

    @Test(expected = WrongReasonException::class)
    fun testShouldThrowReason() {
        val post = Post(
            1,
            1,
            12,
            date = 111220,
            text = "testADS",
            markedAsAds = true,
            likes = Post.Likes(1, canLike = true),
            views = Post.Views()
        )

        val comment = Comment(
            1,
            1,
            11112012,
            "New comment",
            donut = Comment.Donut(true, "text"),
            0,
            null,
            null,
            null
        )
        val reportComment = reportComment(1, 1, 9)

        add(post)
        createComment(1, comment)
        createReportComment(1, reportComment)
    }
}