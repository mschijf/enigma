package machine

class PlugBoard {
    private val letterMap = mutableMapOf<Char, Char>()

    fun removeAll() {
        letterMap.clear()
    }

    fun addPlug(letterPair: Pair<Char, Char>): PlugBoard {
        if (letterMap.containsKey(letterPair.first) || letterMap.containsKey(letterPair.second)) {
            throw Exception("Letter ${letterPair.first} or ${letterPair.second} already plugged")
        }
        letterMap[letterPair.first] = letterPair.second
        letterMap[letterPair.second] = letterPair.first
        return this
    }

    fun removePlugForLetter(letter: Char) {
        val otherSide = letterMap.remove(letter)
        if (otherSide != null)
            letterMap.remove(otherSide)
    }

    fun redirect(letter: Char) : Char {
        return letterMap[letter] ?: letter
    }
}