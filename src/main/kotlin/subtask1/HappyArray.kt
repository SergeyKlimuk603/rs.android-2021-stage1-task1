package subtask1

class HappyArray {

    fun convertToHappy(sadArray: IntArray): IntArray {
        //throw NotImplementedError("Not implemented")
        if (sadArray.size < 3) {
            return sadArray
        }

        // первый индекс массива, он всегда счастливый
        val firstIndex: Int = 1
        // последний (вычисляемый) индекс счастливого массива (сдвигается по мере удаления несчастливых элементов)
        var lastIndex: Int = (sadArray.size - 1)
        // текущий проверяемый элемент
        var currentIndex: Int = firstIndex

        /*
        Удаляем несчастливые элементы. Если происходит удаление элемента, то проверяем
        элемент стоящий левее, т.к. этот элемент в новой модификации массива может оказаться
        несчастливым
         */
        while (currentIndex < lastIndex) {
            if (isElementHappy(currentIndex, sadArray)) {   // если элемент - счастливый, переходим к проверке следующего элемента
                currentIndex++
            } else {                                        // если элемент - несчастливый, удаляем его и переходим к проверке предыдущего элемента
                delElement(currentIndex, lastIndex,  sadArray)
                lastIndex--
                if (currentIndex > firstIndex) {            // проверка окончания массива, чтобы не выйти за его пределы
                    currentIndex--
                }
            }
        }
        // вырезаем из текущего массива новый, счастливый
        return cutArray(sadArray, lastIndex)
    }

    // проверяем является ли элемент с индексом index счастливым
    private fun isElementHappy(index: Int, array: IntArray): Boolean {
        return array[index] <= (array[index - 1] + array[index + 1])
    }

    // удаляем несчастливый элемент массива сдвигом правой части массива влево
    private fun delElement(index: Int, lastIndex: Int, array: IntArray) {
        for (i in index until lastIndex) {
            array[i] = array[i + 1]
        }
    }

    // вырезаем счастливый массив из обработанного несчастливого
    private fun cutArray(array: IntArray, lastIndex: Int): IntArray {
        val newArray: IntArray = IntArray(lastIndex + 1)
        for (i in 0..lastIndex) {
            newArray[i] = array[i]
        }
        return newArray
    }
}
