package co.geeksempire.emitis.sampleproject

class KotlinOverview {

    companion object {
        var firstBigNumber: Long = 123456789
    }

    // True / False
    var correctAnswer: Boolean = true

    //Numbers
    var firstNumber: Int = 30
    var secondNumber: Int = 10


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
    fun sumUpNumbers() : Int /* Return Result As A Number */ {

        var result = (firstNumber + secondNumber)

        return result
    }

    // A Function To Multiply Two Numbers
    fun multiplyNumbers() : Int {

        return (firstNumber * secondNumber)
    }

    //
    fun loopInData() {

        repeat(10) {

//            println(it)

        }

        (31..73).forEach {

//            println(it)

        }

        //Example Of User Inputs
        var allNumbers = "3 + 9 + 1 * 2"

        allNumbers.forEachIndexed { index, character ->

//            println("$index. " + character)

        }

    }

}