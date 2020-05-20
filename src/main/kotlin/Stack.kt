class Stack<T>: Iterable<T> {
    private var stack = ArrayList<T>()
    private var index = -1

    fun push(item: T) {
        stack.add(item)
        index++
    }

    fun pop() =
        if (empty()) {
            error("the stack is empty")
        } else {
            val res = stack[index]
            stack.removeAt(index)
            index--
            res
        }

    fun peek() = stack[index]

    fun empty() = index == -1

    override fun iterator() = StackIterator()

    inner class StackIterator: Iterator<T> {
        var curr = index
        override fun hasNext() = curr >= 0
        override fun next() = stack[curr--]
    }
}