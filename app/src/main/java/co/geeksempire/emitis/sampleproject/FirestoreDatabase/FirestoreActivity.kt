package co.geeksempire.emitis.sampleproject.FirestoreDatabase

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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

        firestoreLayoutBinding.sendMessageView.setOnClickListener {

            val enteredTextMessage = firestoreLayoutBinding.firestoreText.text.toString()

            Firebase.firestore
                .collection("/StickerMessenger/Conversations/SauronWithElias")
                .add(MessageDataStructure(
                    messageContent = enteredTextMessage,
                    messageTime = Timestamp.now()
                )).addOnSuccessListener {

                }.addOnFailureListener {

                }

        }

    }

}