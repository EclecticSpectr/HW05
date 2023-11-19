package ru.netology.task01

data class Audio(
    val id: Int,
    val ownerId: Int,
    val artist: String,
    val title: String,
    val duration: Int,
    val url: String,
    val lyricsId: Int,
    val albumId: Int,
    val genreId: Int,
    val date: Int,
    val noSearch: Boolean = false,
    val isHq: Boolean = false
)

data class Photo(
    val id: Int,
    val albumId: Int,
    val ownerId: Int,
    val userId: Int,
    val text: String,
    val date: Int,
    val sizes: Array<Sizes> = emptyArray(),
    val width: Int,
    val height: Int
) {
    data class Sizes(
        val type: String,
        val url: String,
        val width: Int,
        val height: Int
    )
}

data class Graffity(
    val id: Int,
    val ownerId: Int,
    val url: String,
    val width: Int,
    val height: Int
)

data class Gift(
    val id: Int,
    val thumb256: String,
    val thumb96: String,
    val thumb48: String
)

data class Video(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val description: String,
    val duration: Int,
    val image: Array<Image>? = emptyArray<Image>(),
    val firstFrame: Array<Image>? = emptyArray<Image>(),
    val date: Int,
    val addingDate: Int,
    val views: Int,
    val localViews: Int,
    val comments: Int,
    val player: String,
    val platform: String,
    val canAdd: Boolean,
    val isPrivate: Boolean = true,
    val accessKey: String,
    val processing: Boolean = true,
    val isFavorite: Boolean,
    val canComment: Boolean,
    val canEdit: Boolean,
    val canLike: Boolean,
    val canRepost: Boolean,
    val canSubscribe: Boolean,
    val canAddToFaves: Boolean,
    val canAttachLink: Boolean,
    val width: Int,
    val height: Int,
    val userId: Int,
    val converting: Boolean,
    val added: Boolean,
    val isSubscribed: Boolean,
    val repeat: Boolean = true,
    val type: String,
    val balance: Int,
    val liveStatus: String,
    val live: Boolean,
    val upcoming: Boolean,
    val spectators: Int,
    val likes: VideoLikes,
    val reposts: VideoReposts
) {
    data class Image(
        val height: Int,
        val url: String,
        val width: Int,
        val withPadding: Int? = 1
    )

    data class VideoLikes(
        val count: Int,
        val userLikes: Boolean
    )

    data class VideoReposts(
        val count: Int,
        val wallCount: Int,
        val mailCount: Int,
        val userReposted: Boolean
    )
}