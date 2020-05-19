fun main() {
    val stack = Stack(10)
    stack.push(1)
    stack.push(2)
    for(el in stack) println("element = $el")
}