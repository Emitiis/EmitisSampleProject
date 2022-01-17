package co.geeksempire.emitis.sampleproject.FirestoreDatabase

import com.google.firebase.Timestamp

class MessageDataStructure {

    var messageContent: String? = null
    var messageTime: Timestamp? = null
    var userId: String? = null

    constructor()

    constructor (messageContent: String, messageTime: Timestamp, userId: String) {
        this@MessageDataStructure.messageContent = messageContent
        this@MessageDataStructure.messageTime = messageTime
        this@MessageDataStructure.userId = userId
    }

}