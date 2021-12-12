package co.geeksempire.emitis.sampleproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import co.geeksempire.emitis.sampleproject.databinding.ActivityMainUiBinding

class MainActivity : AppCompatActivity() {

    lateinit var activityMainUiBinding: ActivityMainUiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainUiBinding = ActivityMainUiBinding.inflate(layoutInflater)
        setContentView(activityMainUiBinding.root)

        activityMainUiBinding.equalTextView.setOnClickListener {

            var firstNumber = activityMainUiBinding.firstNumber.text.toString().toInt()
            var secondNumber = activityMainUiBinding.secondNumber.text.toString().toInt()

            activityMainUiBinding.resultTextView.setText((firstNumber + secondNumber).toString())

            //1 - Change Text Color
            activityMainUiBinding.equalTextView.setTextColor(getColor(R.color.pink))

            //2 - Change Background Color
            activityMainUiBinding.equalTextView.setBackgroundColor(getColor(android.R.color.holo_blue_light))

            //3 - Show A Toast Message
            Toast.makeText(applicationContext, getString(R.string.testId), Toast.LENGTH_LONG).show()

        }

    }

}