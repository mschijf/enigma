package machine

class Reflector(output: String) {
    private val rotorLength = output.length
    private val wiring = Array(rotorLength) { index -> output[index] - 'A' }

    fun followWire(index: Int) : Int {
        var step = index
        step = wiring[step]
        return step
    }
}