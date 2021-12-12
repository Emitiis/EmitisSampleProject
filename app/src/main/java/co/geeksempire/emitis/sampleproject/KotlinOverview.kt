package co.geeksempire.emitis.sampleproject

class KotlinOverview {

    var firstNumber: Int = 30
    var secondNumber: Int = 10

    // + - / *
    var mathOperation: String = ""

    fun sumUpNumbers() : Int /* Return Result As A Number */ {

        return (firstNumber + secondNumber)
    }

    fun multiplyNumbers() : Int {

        return (firstNumber * secondNumber)
    }

}