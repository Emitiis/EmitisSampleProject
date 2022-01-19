package co.geeksempire.emitis.sampleproject.FirestoreDatabase

import com.google.firebase.Timestamp

//data class MessageDataStructure(var messageContent: String, var messageTime: Timestamp, var userId: String)
class MessageDataStructure {

    var messageContentInitial: String? = null
    var messageTimeInitial: Timestamp? = null
    var userIdInitial: String? = null

    constructor() // Empty Constructor Always Needed For Firestore Adapter

    constructor (messageContent: String, messageTime: Timestamp, userId: String) {
        this@MessageDataStructure.messageContentInitial = messageContent
        this@MessageDataStructure.messageTimeInitial = messageTime
        this@MessageDataStructure.userIdInitial = userId
    }

}