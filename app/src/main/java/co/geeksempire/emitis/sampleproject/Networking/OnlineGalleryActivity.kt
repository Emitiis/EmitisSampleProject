package co.geeksempire.emitis.sampleproject.Networking

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import co.geeksempire.emitis.sampleproject.databinding.OnlineGalleryLayoutBinding
import kotlinx.coroutines.*
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

        }

    }

    //Completely In IO Layer
    fun downloadImage(imageLink: String) : Deferred<Bitmap> = CoroutineScope(Dispatchers.IO).async {

        val rawBytes: ByteArray = URL(imageLink).readBytes()

        val imageBitmap = BitmapFactory.decodeByteArray(rawBytes, 0, rawBytes.size)

        return@async imageBitmap
    }

}