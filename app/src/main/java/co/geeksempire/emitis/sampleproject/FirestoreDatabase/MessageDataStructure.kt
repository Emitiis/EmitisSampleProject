package co.geeksempire.emitis.sampleproject.FirestoreDatabase

import com.google.firebase.Timestamp

//data class MessageDataStructure(var messageContent: String, var messageTime: Timestamp, var userId: String)
class MessageDataStructure {

    var messageContent: String? = null
    var messageTime: Timestamp? = null
    var userId: String? = null

    constructor() // Empty Constructor Always Needed For Firestore Adapter

    constructor (messageContent: String, messageTime: Timestamp, userId: String) {
        this@MessageDataStructure.messageContent = messageContent
        this@MessageDataStructure.messageTime = messageTime
        this@MessageDataStructure.userId = userId
    }

}