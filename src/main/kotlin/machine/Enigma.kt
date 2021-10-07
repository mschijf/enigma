package machine

import org.slf4j.LoggerFactory


class Enigma () {
    private val EMPTY_ROTOR = Rotor("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 'A')
    private val EMPTY_REFLECTOR = Reflector("ABCDEFGHIJKLMNOPQRSTUVWXYZ")
    private val log = LoggerFactory.getLogger(javaClass)

    val plugBoard = PlugBoard()
    private val entryRotor = EntryRotor()
    var rotor1 = EMPTY_ROTOR
    var rotor2 = EMPTY_ROTOR
    var rotor3 = EMPTY_ROTOR
    var reflector = EMPTY_REFLECTOR

    fun codeString(input: String): String {
        return input.uppercase()
            .filter { ch -> ch.isLetter() }
            .map{ ch -> codeLetter(ch)}
            .joinToString("")
    }

    private fun codeLetter(inputLetter: Char): Char {
        rotateRotors()
        var letter = plugBoard.redirect(inputLetter)
        var stream = entryRotor.letterToIndex(letter)
        stream = rotor1.followWire(stream)
        stream = rotor2.followWire(stream)
        stream = rotor3.followWire(stream)
        stream = reflector.followWire(stream)
        stream = rotor3.followWireBack(stream)
        stream = rotor2.followWireBack(stream)
        stream = rotor1.followWireBack(stream)
        letter = entryRotor.indexToLetter(stream)
        letter = plugBoard.redirect(letter)
        return letter
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
        log.info(logLine)
    }
}