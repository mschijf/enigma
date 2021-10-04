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
        return notchPosition == clockPosition(25-startPosition)
    }

    fun indexToLetter(index: Int): Char {
        return 'A' + clockPosition(index - startPosition)
    }

    fun followWire(index: Int) : Int {
        var step = index
        step = clockPosition(step - startPosition)
        step = clockPosition(step - ringStellungPosition)
        step = wiring[step]
        step = clockPosition(step + ringStellungPosition)
        step = clockPosition(step + startPosition)
        return step
    }

    fun followWireBack(index: Int) : Int {
        var step = index
        step = clockPosition(step - startPosition)
        step = clockPosition(step - ringStellungPosition)
        step = dewiring[step]
        step = clockPosition(step + ringStellungPosition)
        step = clockPosition(step + startPosition)
        return step
    }

    private fun clockPosition(number: Int): Int {
        return (number + rotorLength) % rotorLength
    }
}