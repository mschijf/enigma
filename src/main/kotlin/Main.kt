import machine.Enigma
import machine.Rotor
import machine.RotorSet

fun main(args: Array<String>) {
//    val rotor = Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ", 'A')
//    rotor.setRingStellung('B')
//    rotor.seStartPositon('A')
//    rotor.setRingStellung('F')
//    rotor.seStartPositon('Y')
//    val output = rotor.followWire('A' - 'A')
//    val outputLetter = rotor.indexToLetter(output)
//    println("Output = $output met letter $outputLetter")

    val enigma = Enigma(RotorSet(), false)
//    enigma.rotor1.setRingStellung('Z')
    val outputStr = enigma.codeString("ABCDEFGHIJKLMNOPQRSTUVWXYZ")
    val printStr = addSpace(outputStr, 5)
    println("Output = ${printStr.lowercase()}")

//    val output = enigma.code('A')
//    println("Output = $output")
//    val output2 = enigma.code('A')
//    println("Output = $output2")
//    val output3 = enigma.code('A')
//    println("Output = $output3")

}

fun addSpace(s: String, after: Int): String {
    var count: Int = 0
    var sb = StringBuilder()
    for (ch in s) {
        count++
        sb.append(ch)
        if (count % after == 0) {
            sb.append(' ')
        }
    }
    return sb.toString()
}