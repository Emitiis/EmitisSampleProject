package co.geeksempire.emitis.sampleproject

class KotlinOverview {

    var firstNumber: Int = 30
    var secondNumber: Int = 10

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

}