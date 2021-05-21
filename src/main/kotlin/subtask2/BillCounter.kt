package subtask2

class BillCounter {

    // The output could be "Bon Appetit" or the string with number(e.g "10")
    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        //throw NotImplementedError("Not implemented")
        val annaHasToPay: Int = (bill.sum() - bill[k]) / 2
        return if (b == annaHasToPay) {
            "Bon Appetit"
        } else {
            (b - annaHasToPay).toString()
        }
    }
}
