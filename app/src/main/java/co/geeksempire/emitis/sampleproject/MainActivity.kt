package co.geeksempire.emitis.sampleproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import co.geeksempire.emitis.sampleproject.databinding.ActivityMainUiBinding

class MainActivity : AppCompatActivity() {

    // + - / *
    var mathOperation: String = ""

    var result: Long = 0

    lateinit var activityMainUiBinding: ActivityMainUiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainUiBinding = ActivityMainUiBinding.inflate(layoutInflater)
        setContentView(activityMainUiBinding.root)

        activityMainUiBinding.equalTextView.setOnClickListener {

            //Get First Number
            var firstNumber: Long = if (activityMainUiBinding.firstNumber.text.isNullOrBlank()) {
                Toast.makeText(applicationContext, "Hey Idiot Add A Number", Toast.LENGTH_LONG).show()

                0
            } else {
                activityMainUiBinding.firstNumber.text.toString().toLong()
            }
            //Get Second Number
            var secondNumber: Long =  if (activityMainUiBinding.secondNumber.text.isNullOrBlank()) {
                Toast.makeText(applicationContext, "Hey Idiot Add A Number", Toast.LENGTH_LONG).show()

                0
            } else {
                activityMainUiBinding.secondNumber.text.toString().toLong()
            }

            if (result == 0.toLong()) {

                result = if (mathOperation == "+") {

                    (firstNumber + secondNumber)

                } else if (mathOperation == "-") {

                    (firstNumber - secondNumber)


                } else if (mathOperation == "*") {

                    (firstNumber * secondNumber)


                } else if (mathOperation == "/") {

                    (firstNumber / secondNumber)

                } else {

                    Toast.makeText(applicationContext, "Hey Idiot Select A Operation", Toast.LENGTH_LONG).show()

                    0
                }

            } else {

                firstNumber = result
                activityMainUiBinding.firstNumber.setText(result.toString())

                result = if (mathOperation == "+") {

                    (firstNumber + secondNumber)

                } else if (mathOperation == "-") {

                    (firstNumber - secondNumber)


                } else if (mathOperation == "*") {

                    (firstNumber * secondNumber)


                } else if (mathOperation == "/") {

                    (firstNumber / secondNumber)

                } else {

                    Toast.makeText(applicationContext, "Hey Idiot Select A Operation", Toast.LENGTH_LONG).show()

                    0
                }

            }

            activityMainUiBinding.resultTextView.setText(result.toString())

            //1 - Change Text Color
            activityMainUiBinding.equalTextView.setTextColor(getColor(R.color.pink))

            //2 - Change Background Color
            activityMainUiBinding.equalTextView.setBackgroundColor(getColor(android.R.color.holo_blue_light))

            //3 - Show A Toast Message
            Toast.makeText(applicationContext, getString(R.string.testId), Toast.LENGTH_LONG).show()

        }

        activityMainUiBinding.sumOperationButton.setOnClickListener {

            mathOperation = "+"

            activityMainUiBinding.operationTextView.setText(mathOperation)

        }

        activityMainUiBinding.minusOperationButton.setOnClickListener {

            mathOperation = "-"

            activityMainUiBinding.operationTextView.setText(mathOperation)

        }

        activityMainUiBinding.multiplyOperationButton.setOnClickListener {

            mathOperation = "*"

            activityMainUiBinding.operationTextView.setText(mathOperation)

        }

        activityMainUiBinding.divideOperationButton.setOnClickListener {

            mathOperation = "/"

            activityMainUiBinding.operationTextView.setText(mathOperation)

        }

    }

}