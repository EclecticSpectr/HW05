package ru.netology.task01

sealed interface Attachment {
    val type: String
}

object WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var reportComments = emptyArray<reportComment>()

    fun add(post: Post): Post {
        posts += if (posts.isNotEmpty()) {
            val (previousId) = posts.last()
            post.copy(iD = previousId?.plus(1))
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

    fun createComment(postId: Int, comment: Comment): Comment {
        posts.let {
            for (item in it) {
                if (item.iD == postId) {
                    comments += comment
                    println("Комментарий добавлен")
                    return comment
                }
                throw PostNotFoundException("Пост ID:$postId не найден")
            }
        }
        throw EmptyArrayException("Не создано ни одного поста")
    }

    fun createReportComment(commentId: Int, reportComment: reportComment): Int {
        comments.let {
            for (item in it) {
                if (item.id == commentId) {
                    if (reportComment.reason !in 0..8) throw WrongReasonException("Неверная причина жалобы")
                    reportComments += reportComment
                    println("Жалоба добавлена")
                    return 1
                }
                throw PostNotFoundException("Комментарий ID:$commentId не найден")
            }
        }
        throw EmptyArrayException("Не создано ни одного комментария")
    }

    fun clear() {
        posts = emptyArray()
        comments = emptyArray()
        reportComments = emptyArray()
    }
}

fun main() {
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

    for (i in 1..9) println(WallService.add(post))

    WallService.update(post.copy(iD = 9, ownerId = 2))

    try {
        WallService.createComment(1, comment)
    } catch (e: PostNotFoundException) {
        println(e)
    } catch (e: EmptyArrayException) {
        println(e)
    }

    try {
        WallService.createReportComment(1, reportComment)
    } catch (e: PostNotFoundException) {
        println(e)
    } catch (e: WrongReasonException) {
        println(e)
    } catch (e: EmptyArrayException) {
        println(e)
    }
}