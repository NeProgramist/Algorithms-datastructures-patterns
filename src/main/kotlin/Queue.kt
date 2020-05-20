class Queue<T>: Iterable<T> {
    val queue = ArrayList<T>()
    fun enqueue(item: T) {

    }

    fun dequeue():T {

    }

    fun peek():T {

    }

    fun empty() : Boolean {

    }
    override fun iterator() = QueueIterator<T>()
    inner class QueueIterator<T> : Iterator<T> {
        override fun hasNext(): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun next(): T {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }
}