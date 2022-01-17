package co.geeksempire.emitis.sampleproject.FirestoreDatabase

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.geeksempire.emitis.sampleproject.FirestoreDatabase.Adapter.FirestoreAdapter
import co.geeksempire.emitis.sampleproject.databinding.FirestoreLayoutBinding
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.Timestamp
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


data class MessageDataStructure (
    var messageContent: String,
    var messageTime: Timestamp,
    var userId: String
)

class FirestoreActivity : AppCompatActivity() {

    val firebaseUser = Firebase.auth.currentUser!! // !! Two Exclamations Mark Means I Asserted

    val query: Query = Firebase.firestore
        .collection("/StickerMessenger/Conversations/SauronWithElias")
        .orderBy("messageTime")

    val firestoreRecyclerOptions: FirestoreRecyclerOptions<MessageDataStructure> = FirestoreRecyclerOptions.Builder<MessageDataStructure>()
        .setQuery(query, MessageDataStructure::class.java)
        .build()

    val firestoreAdapter = FirestoreAdapter(this@FirestoreActivity, firestoreRecyclerOptions)

    lateinit var firestoreLayoutBinding: FirestoreLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firestoreLayoutBinding = FirestoreLayoutBinding.inflate(layoutInflater)
        setContentView(firestoreLayoutBinding.root)

        val linearLayoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
        firestoreLayoutBinding.messagesRecyclerView.layoutManager = linearLayoutManager

        firestoreLayoutBinding.messagesRecyclerView.adapter = firestoreAdapter

        firestoreLayoutBinding.sendMessageView.setOnClickListener {

            val enteredTextMessage = firestoreLayoutBinding.firestoreText.text.toString()

            // Send Data to Server

            var conversationId = "SauronWithElias" // After Sort

            Firebase.firestore
                .collection("/StickerMessenger/Conversations/${conversationId}")
                .add(MessageDataStructure(
                    messageContent = enteredTextMessage,
                    messageTime = Timestamp.now(),
                    userId = firebaseUser.uid
                )).addOnSuccessListener { documentReference /* Reference To Sent Message */ ->

                    firestoreLayoutBinding.firestoreText.setText("")

                }.addOnFailureListener {

                }

        }

    }

    override fun onStart() {
        super.onStart()

        firestoreAdapter.startListening()

    }

    override fun onPause() {
        super.onPause()

        firestoreAdapter.stopListening()

    }

}