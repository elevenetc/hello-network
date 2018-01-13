package threads

import java.io.DataOutputStream
import java.io.OutputStream
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue

class WritingThread(outputStream: OutputStream) : Thread() {

    private val stream = DataOutputStream(outputStream)
    private val queue: BlockingQueue<String> = LinkedBlockingQueue()
    private var connected: Boolean = true

    override fun run() {
        while (connected) {
            try {
                val data = queue.take()
                stream.writeBytes(data)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {

            }
        }

    }
}