package co.geeksempire.emitis.sampleproject.FirestoreDatabase

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.geeksempire.emitis.sampleproject.FirestoreDatabase.Adapter.FirestoreAdapter
import co.geeksempire.emitis.sampleproject.databinding.FirestoreLayoutBinding
import com.google.firebase.Timestamp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

data class MessageDataStructure (
    var messageContent: String,
    var messageTime: Timestamp
)

class FirestoreActivity : AppCompatActivity() {

    lateinit var firestoreLayoutBinding: FirestoreLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firestoreLayoutBinding = FirestoreLayoutBinding.inflate(layoutInflater)
        setContentView(firestoreLayoutBinding.root)

        val linearLayoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
        firestoreLayoutBinding.messagesRecyclerView.layoutManager = linearLayoutManager

        val firestoreAdapter = FirestoreAdapter(this@FirestoreActivity)
        firestoreLayoutBinding.messagesRecyclerView.adapter = firestoreAdapter

        firestoreLayoutBinding.sendMessageView.setOnClickListener {

            val enteredTextMessage = firestoreLayoutBinding.firestoreText.text.toString()


            // Send Data to Server
            Firebase.firestore
                .collection("/StickerMessenger/Conversations/SauronWithElias")
                .add(MessageDataStructure(
                    messageContent = enteredTextMessage,
                    messageTime = Timestamp.now()
                )).addOnSuccessListener { documentReference /* Reference To Sent Message */ ->

                    firestoreLayoutBinding.firestoreText.setText("")

                    // Get Information Of Sent Message
                    documentReference.get().addOnSuccessListener { documentSnapshot /* Snapshot (= All Data) Of Sent Message */  ->

                        firestoreAdapter.inputSimpleListData.add(documentSnapshot)

                        firestoreAdapter.notifyItemInserted(firestoreAdapter.inputSimpleListData.size /* Last Position */)

                        val scrollPosition = firestoreAdapter.inputSimpleListData.size - 1

                        firestoreLayoutBinding.messagesRecyclerView.smoothScrollToPosition(scrollPosition)

                    }

                }.addOnFailureListener {

                }

        }

        // Download New Data (Get List Of Messages) & Show It In A RecyclerView
        Firebase.firestore
            .collection("/StickerMessenger/Conversations/SauronWithElias")
            .orderBy("messageTime")
            .get().addOnSuccessListener { querySnapshot ->

                // After Data Sent Successfully -> Download New Data (Get List Of Messages) & Show It In A RecyclerView


                if (firestoreAdapter.inputSimpleListData.isNotEmpty()) {
                    firestoreAdapter.inputSimpleListData.clear() // Clear All Existed Data To Avoid Duplication
                }

                firestoreAdapter.inputSimpleListData.addAll(querySnapshot.documents)

                firestoreAdapter.notifyDataSetChanged()

                val scrollPosition = firestoreAdapter.inputSimpleListData.size - 1
                linearLayoutManager.scrollToPosition(scrollPosition)

            }.addOnFailureListener {

            }

    }

}