package machine

class PlugBoard(vararg letterPairs: Pair<Char, Char>) {
    private val letterMap = mutableMapOf<Char, Char>()
    init {
        for (pair in letterPairs) {
            letterMap[pair.first] = pair.second
            letterMap[pair.second] = pair.first
        }
    }

    fun redirect(letter: Char) : Char {
        return letterMap[letter] ?: letter
    }
}