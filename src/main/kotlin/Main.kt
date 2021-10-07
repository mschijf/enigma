import machine.Enigma
import machine.Rotor
import machine.RotorSet

fun main(args: Array<String>) {

    val rotorSet = RotorSet()
    val enigma = Enigma()

    enigma.rotor1 = rotorSet.rotorI
    enigma.rotor1.seStartPositon('A')
    enigma.rotor1.setRingStellung('A')

    enigma.rotor2 = rotorSet.rotorII
    enigma.rotor2.seStartPositon('A')
    enigma.rotor2.setRingStellung('A')

    enigma.rotor3 = rotorSet.rotorIII
    enigma.rotor3.seStartPositon('A')
    enigma.rotor3.setRingStellung('A')

    enigma.reflector = rotorSet.reflectorB

    enigma.plugBoard.addPlug('A' to 'B')


    val inputStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val outputStr = enigma.codeString(inputStr)

    val printInStr = addSpace(inputStr, 5)
    val printOutStr = addSpace(outputStr, 5)
    println("Input  = $printInStr")
    println("Output = ${printOutStr.lowercase()}")
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