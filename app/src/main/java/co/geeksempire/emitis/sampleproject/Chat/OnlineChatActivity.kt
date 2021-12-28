package co.geeksempire.emitis.sampleproject.Chat

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import co.geeksempire.emitis.sampleproject.databinding.OnlineChatLayoutBinding

class OnlineChatActivity : AppCompatActivity() {

    lateinit var onlineChatLayoutBinding: OnlineChatLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onlineChatLayoutBinding = OnlineChatLayoutBinding.inflate(layoutInflater)
        setContentView(onlineChatLayoutBinding.root)

        if (intent.hasExtra("USERNAME")) {

            val userNameText = intent.getStringExtra("USERNAME" /* Key */)

            Toast.makeText(applicationContext, userNameText, Toast.LENGTH_LONG).show()

            onlineChatLayoutBinding.userNameTextView.text = userNameText

        }

    }

}