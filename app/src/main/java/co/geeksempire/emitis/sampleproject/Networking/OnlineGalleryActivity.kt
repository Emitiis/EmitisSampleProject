package co.geeksempire.emitis.sampleproject.Networking

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import co.geeksempire.emitis.sampleproject.databinding.OnlineGalleryLayoutBinding
import kotlinx.coroutines.*
import org.json.JSONArray
import org.json.JSONObject
import java.net.URL

class OnlineGalleryActivity : AppCompatActivity() {

    lateinit var onlineGalleryLayoutBinding: OnlineGalleryLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onlineGalleryLayoutBinding = OnlineGalleryLayoutBinding.inflate(layoutInflater)
        setContentView(onlineGalleryLayoutBinding.root)

        CoroutineScope(Dispatchers.Main).launch {// Main Layer -> Can Access Views in Layout

            val downloadedImage = downloadImage("https://i1.wp.com/abanabsalan.com/wp-content/uploads/2021/06/beautiful-Nail-Design.jpg").await()

            onlineGalleryLayoutBinding.onlineImageView.setImageBitmap(downloadedImage)

            val downloadedTitle = downloadJson("https://abanabsalan.com/wp-json/wp/v2/posts?include[]=5877").await()

            onlineGalleryLayoutBinding.onlineTitleText.text = downloadedTitle

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

}