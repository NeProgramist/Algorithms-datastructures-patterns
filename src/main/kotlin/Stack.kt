

class Stack(initialSize: Int): Iterator<Any> {
    private var stackSize = initialSize
    private var stack = Array<Any>(stackSize) {}
    private var currentSize = 0
    private var currentIndex = 0

    fun push(item: Any) {
        stack[currentSize] = item
        currentSize++
        if(currentSize == stackSize) {
            stackSize *= 2
            stack = Array(stackSize) { stack }
        }
        currentIndex = currentSize-1
    }

    fun pop() : Any {
        return if (currentSize == 0)
            error("the stack is empty")
        else {
            currentSize--
            stack[currentSize]
        }
    }

    fun peek() : Any = stack[currentSize-1]

    fun empty() = currentSize == 0

    override fun hasNext() = currentIndex >= 0
    override fun next() = stack[currentIndex--]
}