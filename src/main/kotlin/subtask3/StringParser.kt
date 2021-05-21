package subtask3

class StringParser {

    fun getResult(inputString: String): Array<String> {
        //throw NotImplementedError("Not implemented")

        val subStrings: MutableList<String> = mutableListOf()
        var endIndex = -1
        for (index in 0 until (inputString.length - 2)) {
            endIndex = when (inputString[index]) {
                '(' -> findCloseBracket('(', ')', index, inputString)
                '[' -> findCloseBracket('[', ']', index, inputString)
                '<' -> findCloseBracket('<', '>', index, inputString)
                else -> -1
            }
            if (endIndex - index > 1) {
                subStrings.add(inputString.substring(index + 1, endIndex))
            }
        }
        //return subStrings.toTypedArray()
        return Array(subStrings.size){subStrings[it]}
    }

    private fun findCloseBracket(open: Char, close: Char, startIndex: Int, inputString: String): Int {
        var newOpenBracket = 0
        var endIndex = startIndex
        var isFounded = false

        loop@ while (endIndex < inputString.length - 1) {
            endIndex++
            when (inputString[endIndex]) {
                open -> newOpenBracket++
                close -> {
                    if (newOpenBracket > 0) {
                        newOpenBracket--
                    } else {
                        isFounded = true
                        break@loop
                    }
                }
            }
        }
        return if (isFounded) endIndex else -1
    }
}
