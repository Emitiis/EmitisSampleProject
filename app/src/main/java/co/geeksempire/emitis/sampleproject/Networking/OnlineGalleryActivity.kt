package co.geeksempire.emitis.sampleproject.Networking

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import co.geeksempire.emitis.sampleproject.databinding.OnlineGalleryLayoutBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.*
import org.json.JSONArray
import org.json.JSONObject
import java.net.URL

class OnlineGalleryActivity : AppCompatActivity() {

    val auth = Firebase.auth

    lateinit var onlineGalleryLayoutBinding: OnlineGalleryLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onlineGalleryLayoutBinding = OnlineGalleryLayoutBinding.inflate(layoutInflater)
        setContentView(onlineGalleryLayoutBinding.root)

        CoroutineScope(Dispatchers.Main).launch {// Main Layer -> Can Access Views in Layout

            val downloadedTitle = downloadJson("https://abanabsalan.com/wp-json/wp/v2/posts?include[]=5877").await()

            onlineGalleryLayoutBinding.onlineTitleText.text = downloadedTitle



            val downloadedImage = downloadImage("https://i1.wp.com/abanabsalan.com/wp-content/uploads/2021/06/beautiful-Nail-Design.jpg").await()

            onlineGalleryLayoutBinding.onlineImageView.setImageBitmap(downloadedImage)

        }

        onlineGalleryLayoutBinding.googleSignUp.setOnClickListener {
            invokeGoogleAccounts()
        }

    }



    //Completely In IO Layer
    fun downloadImage(imageLink: String) : Deferred<Bitmap> = CoroutineScope(Dispatchers.IO).async {

        val rawBytes: ByteArray = URL(imageLink).readBytes()

        // Convert Bytes To Image
        val imageBitmap = BitmapFactory.decodeByteArray(rawBytes, 0, rawBytes.size)

        return@async imageBitmap
    }

    fun downloadJson(jsonLink: String) : Deferred<String> = CoroutineScope(Dispatchers.IO).async {

        val rawBytes: ByteArray = URL(jsonLink).readBytes()

        // Convert Bytes To String
        val jsonString = String(rawBytes)

        // Convert String To JSON
        val allJsonData = JSONArray(jsonString)

        // Convert To JSON Object
        val aJsonData = allJsonData[0] as JSONObject

        // Extract Data from JSON Object
        val postTile = aJsonData.getJSONObject("excerpt").getString("rendered")

        return@async postTile
    }

    fun invokeGoogleAccounts() {

        val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("164207542361-i8u41pppnrqospuk1n5ebgachh5h34e5.apps.googleusercontent.com")
            .requestEmail()
            .build()

        val googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions)

        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, 671)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 671) {

            GoogleSignIn.getSignedInAccountFromIntent(data).addOnCompleteListener { task ->

                try {

                    // Google Sign In was successful
                    val googleAccount = task.getResult(ApiException::class.java)!!


                    println(">>> Email Address: " + googleAccount.email)
                    println(">>> Name: " + googleAccount.displayName)
                    println(">>> Photo Link: " + googleAccount.photoUrl)

                    firebaseAuthWithGoogle(googleAccount.idToken!!)

                } catch (e: ApiException) {
                    e.printStackTrace()


                }

            }

        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = auth.currentUser


                } else {

                // If sign in fails, display a message to the user.

                }
            }
    }

}