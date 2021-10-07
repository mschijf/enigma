package machine

class EntryRotor  {
    fun letterToIndex(letter: Char): Int = letter - 'A'
    fun indexToLetter(index: Int): Char = 'A' + index
}