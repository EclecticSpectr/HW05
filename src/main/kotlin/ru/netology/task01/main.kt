package ru.netology.task01

data class Post(
    val iD: Int = 0,
    val ownerId: Int?,
    val fromId: Int?,
    val date: Int,
    val text: String = "",
    val friendsOnly: Boolean = false,
    val canPin: Boolean = false,
    val canDelete: Boolean = false,
    val canEdit: Boolean = false,
    val markedAsAds: Boolean = false,
    val likes: Likes,
    val views: Views,
    val attachments: Array<Attachment>? = emptyArray()
) {
    data class Likes(
        val count: Int,
        val userLikes: Boolean = false,
        val canLike: Boolean = false,
        val canPublish: Boolean = false
    )

    data class Views(val count: Int = 0)
}

sealed interface Attachment {
    val type: String
}

object WallService {
    private var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        posts += if (posts.isNotEmpty()) {
            val (previousId) = posts.last()
            post.copy(iD = previousId + 1)
        } else {
            post.copy(iD = 1)
        }
        return posts.last()
    }

    fun update(post: Post): Boolean {
        val (checkId) = post
        for ((index, item) in posts.withIndex()) {
            if (item.iD == checkId) {
                posts[index] = post.copy()
                println("ID enabled")
                println(posts[index])
                return true
            }
        }
        println("ID not exists")
        return false
    }

    fun clear() {
        posts = emptyArray()
    }
}

fun main() {
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
    for (i in 1..9) println(WallService.add(post))

    WallService.update(post.copy(iD = 9, ownerId = 2))
}