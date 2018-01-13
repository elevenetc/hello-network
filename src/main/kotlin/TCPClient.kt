import org.slf4j.Logger
import org.slf4j.LoggerFactory
import threads.ReadingThread
import threads.WritingThread
import java.net.InetSocketAddress
import java.net.Socket

class TCPClient {

    val logger: Logger = LoggerFactory.getLogger(javaClass)

    fun connect(address: String, port: Int) {
        try {
            val socket = Socket()
            socket.connect(InetSocketAddress(address, port))
            ReadingThread(socket.getInputStream()).start()
            WritingThread(socket.getOutputStream()).start()
            logger.info("connected with {}", socket.inetAddress)
        } catch (e: Exception) {
            logger.error("disconnected", e)
        } finally {

        }
    }
}