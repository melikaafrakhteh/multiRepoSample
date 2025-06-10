package data

enum class TransactionTimePeriod {
    ONE_MONTH,
    THREE_MONTHS,
    SIX_MONTHS,
    ONE_YEAR,
}

fun getTransactionTimePeriod(value:String?): TransactionTimePeriod? {
    return TransactionTimePeriod.entries.firstOrNull { it.name == value?.uppercase() }
}