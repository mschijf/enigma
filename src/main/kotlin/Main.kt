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

    val enigma = Enigma(RotorSet())
    enigma.rotor1.setRingStellung('Z')
    val outputStr = enigma.codeString("ABCDEFGHIJKLMNOPQRSTUVWXYZ")
    println("Output = $outputStr")

//    val output = enigma.code('A')
//    println("Output = $output")
//    val output2 = enigma.code('A')
//    println("Output = $output2")
//    val output3 = enigma.code('A')
//    println("Output = $output3")

}