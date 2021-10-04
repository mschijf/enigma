package machine

import org.slf4j.LoggerFactory


class Enigma (rotorSet: RotorSet, val showLog: Boolean = false){
    private val log = LoggerFactory.getLogger(javaClass)

    var rotor1 = rotorSet.rotorI
    var rotor2 = rotorSet.rotorII
    var rotor3 = rotorSet.rotorIII
    var reflector = rotorSet.reflectorB

    fun codeString(input: String): String {
        return input.map{ ch -> codeLetter(ch)}.joinToString("")
    }

    private fun codeLetter(inputLetter: Char): Char {
        rotateRotors()
        log("Before: $inputLetter")
        val out1 = rotor1.followWire(inputLetter - 'A')
        log("After rotor1  (code): $out1")
        val out2 = rotor2.followWire(out1)
        log("After rotor2  (code): $out2")
        val out3 = rotor3.followWire(out2)
        log("After rotor3  (code): $out3")
        val reflect= reflector.followWire(out3)
        log("After reflect (refl): $reflect")
        val out4 = rotor3.followWireBack(reflect)
        log("After rotor3  (deco): $out4")
        val out5 = rotor2.followWireBack(out4)
        log("After rotor2  (deco): $out5")
        val out6 = rotor1.followWireBack(out5)
        log("After rotor1  (deco): $out6")
        return 'A' + out6
    }

    private fun rotateRotors() {
        rotor1.rotate()
        if (rotor1.notchJustPassed()) {
            rotor2.rotate()
            if (rotor2.notchJustPassed()) {
                rotor3.rotate()
                rotor2.rotate()
            }
        }
    }
    
    private fun log(logLine: String) {
        if (showLog)
            log(logLine)
    }
}