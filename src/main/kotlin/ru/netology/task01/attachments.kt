package ru.netology.task01

class AudioAttachment(inObj: Audio) : Attachment {
    override val type: String = "audio"
}

class PhotoAttachment(inObj: Photo) : Attachment {
    override val type: String = "photo"
}

class GraffityAttachment(inObj: Graffity) : Attachment {
    override val type: String = "photo"
}

class GiftAttachment(inObj: Gift) : Attachment {
    override val type: String = "gift"
}

class VideoAttachment(inObj: Video) : Attachment {
    override val type: String = "video"
}