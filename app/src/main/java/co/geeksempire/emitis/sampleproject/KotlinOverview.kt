package co.geeksempire.emitis.sampleproject

class KotlinOverview /*(var firstInputNumber: Int, var  secondInputNumber: Int)*/{

    companion object {
        var firstBigNumber: Long = 123456789
    }

    // True / False
    var correctAnswer: Boolean = true

    //Numbers
//    var firstNumber: Int = 30
//    var secondNumber: Int = 10


    var aFloatNumber: Float = 1.1f
    var aDoubleNumber: Double = 123456789.666

    val aValueNumber = "777"

    fun mixTexts() {

        var aaa: String = "AAA"
        var bbb: String = "BBB"

        var result = aaa + 123.987

        println(result)

    }

    // + - / *
    var mathOperation: String = ""

    // A Function To Sum Up Two Numbers
    fun sumUpNumbers(firstInputNumber: Int, secondInputNumber: Int) : Int /* Return Result As A Number */ {

        var result = (firstInputNumber + secondInputNumber)

        return result
    }

    // A Function To Multiply Two Numbers
    fun multiplyNumbers(firstInputNumber: Int, secondInputNumber: Int) : Int {

        var result = (firstInputNumber * secondInputNumber)

        return result
    }

    //
    fun loopInData() {

        repeat(10) {

//            println(it)

        }

        (31..73).forEach {

//            println(it)

        }

        //
        // Example Of User's Inputs
        //
        var resultNumber = 0

        var operationDetected: Boolean = false

        var whichOperationTypeDetected = "+"

        var allInputNumbers = "13 + 197 - 3 * 73" // = 15,111

        allInputNumbers.split(" ").forEach { character ->

            if (character.toIntOrNull() != null) {//Number Detected

                val aNumber = character.toInt()

                if (operationDetected == false) {//Off

                    resultNumber = aNumber

                } else if (operationDetected == true){//On

                    when (whichOperationTypeDetected) {
                        "+" -> {

                            //resultNumber = resultNumber + aNumber
                            resultNumber += aNumber

                        }
                        "-" -> {

                            resultNumber -= aNumber

                        }
                        "*" -> {

                            resultNumber *= aNumber

                        }
                        "/" -> {

                            resultNumber /= aNumber

                        }
                    }

                    operationDetected = false

                }

            } else if (character == "+" || /*OR*/ character == "-" || character == "*" || character == "/") {

                operationDetected = true

                whichOperationTypeDetected = character // -> + - * /

            }

            println("Final Result = " + resultNumber)

        }

    }

}