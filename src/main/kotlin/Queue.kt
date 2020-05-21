class Queue<T>: Iterable<T> {
    private val queue = ArrayList<T>()

    fun enqueue(item: T) {
        queue.add(item)
    }

    fun dequeue() =
        if(empty()) {
            error("the queue is empty")
        } else {
            val res = queue[0]
            queue.removeAt(0)
            res
        }

    fun peek() = queue[0]

    fun empty() = queue.size == 0

    override fun iterator() = QueueIterator()

    inner class QueueIterator: Iterator<T> {
        var curr = 0
        override fun hasNext() = curr < queue.size
        override fun next() = queue[curr++]
    }
}