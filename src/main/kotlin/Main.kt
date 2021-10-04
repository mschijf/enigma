import machine.Enigma
import machine.Rotor
import machine.RotorSet

fun main(args: Array<String>) {
//    val rotor = Rotor("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 'A')
//    val rotor = Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ", 'A')
//    rotor.show()
//    println("---------------------------------------")
//    rotor.setRingStellung('B')
//    rotor.seStartPositon('A')
//    rotor.setRingStellung('F')
//    rotor.seStartPositon('Y')
//    val output = rotor.code('A')
//    println("Output = $output")

    val enigma = Enigma(RotorSet())
    val output = enigma.codeString("FUVEPUMWARVQKEFGHGDIJFMFXI")
    println("Output = $output")

//    val output = enigma.code('A')
//    println("Output = $output")
//    val output2 = enigma.code('A')
//    println("Output = $output2")
//    val output3 = enigma.code('A')
//    println("Output = $output3")

}