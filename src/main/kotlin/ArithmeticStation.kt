class ArithmeticStation {
    private val operations = mapOf<String, (Double, Double) -> Double>(
        "+" to {f, s -> s + f},
        "-" to {f, s -> s - f},
        "*" to {f, s -> s * f},
        "/" to {f, s -> s / f}
    )

    private val operators = Stack<String>()
    private val operands = Stack<Double>()

    operator fun invoke(operation: String): Double {
        operation.split(" ").forEach {
            when (it) {
                ")" -> {
                    val op = operators.pop()
                    val v = (operations[op] ?: error("")).invoke(operands.pop(), operands.pop())
                    operands.push(v)
                }
                "(" -> {}
                in operations -> operators.push(it)
                else -> operands.push(it.toDouble())
            }
        }
        return operands.pop()
    }
}

private fun main() {
    val arithmeticStation = ArithmeticStation()

    val first = arithmeticStation("( ( ( 1 + 2 ) + 3 ) * 3 )")
    println(first) // 18.0

    val second = arithmeticStation("( ( ( 123 + 2 ) * 0 ) - 3 )")
    println(second) // -3.0
}
