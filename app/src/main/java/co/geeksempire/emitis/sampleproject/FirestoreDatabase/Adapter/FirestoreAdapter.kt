package co.geeksempire.emitis.sampleproject.FirestoreDatabase.Adapter

import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import co.geeksempire.emitis.sampleproject.R
import co.geeksempire.emitis.sampleproject.databinding.ItemFirestoreMessageBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.ktx.Firebase

class FirestoreAdapter (private val context: AppCompatActivity) : RecyclerView.Adapter<FirestoreViewHolder>() {

    val inputSimpleListData: ArrayList<DocumentSnapshot> = ArrayList<DocumentSnapshot>()

    override fun getItemCount(): Int {

        return inputSimpleListData.size
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): FirestoreViewHolder {

        return FirestoreViewHolder(ItemFirestoreMessageBinding.inflate(context.layoutInflater, viewGroup, false))
    }

    override fun onBindViewHolder(firestoreViewHolder: FirestoreViewHolder, position: Int) {

        firestoreViewHolder.userMessageTextView.text = inputSimpleListData[position].get("messageContent").toString()

        val firebaseUserId = inputSimpleListData[position].get("userId")

        if (firebaseUserId == Firebase.auth.currentUser!!.uid) {

            //Background Green
            firestoreViewHolder.rootItemView.setBackgroundColor(context.getColor(R.color.green))

        } else {

            //Background Gray
            firestoreViewHolder.rootItemView.setBackgroundColor(context.getColor(R.color.gray))

        }

    }

}