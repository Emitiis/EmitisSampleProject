package co.geeksempire.emitis.sampleproject

//"FrIEndS" // -> F.R.I.E.N.D.S.
fun String.addDotAfterCharacter() : String {

    val inputString = this@addDotAfterCharacter

    val stringBuilder = StringBuilder()

    inputString.forEach { character ->

        stringBuilder.append(character.uppercaseChar() + ".")

    }

    return stringBuilder.toString()
}