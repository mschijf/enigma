package machine

class Rotor (output: String, notchPositionChar: Char) {
    private val notchPosition = notchPositionChar - 'A'
    private val rotorLength = output.length
    private val wiring = Array(rotorLength) { index -> output[index] - 'A' }
    private val dewiring = Array(rotorLength) { index -> output.indexOf('A' + index) }
    private var startPosition = 0
    private var ringStellungPosition = 0

    fun setRingStellung(value : Char) {
        ringStellungPosition = value - 'A'
    }

    fun seStartPositon(value : Char) {
        startPosition = value - 'A'
    }

    fun rotate() {
        startPosition = clockPosition(startPosition - 1)
    }

    fun notchJustPassed() : Boolean {
        return notchPosition == clockPosition((rotorLength-1)-startPosition)
    }

    fun followWire(index: Int) : Int {
        var step = clockPosition(index - startPosition - ringStellungPosition)
        step = wiring[step]
        return clockPosition(step + ringStellungPosition + startPosition)
    }

    fun followWireBack(index: Int) : Int {
        var step = clockPosition(index - startPosition - ringStellungPosition)
        step = dewiring[step]
        return clockPosition(step + ringStellungPosition + startPosition)
    }

    private fun clockPosition(number: Int): Int {
        return (number + 10 * rotorLength) % rotorLength
    }
}