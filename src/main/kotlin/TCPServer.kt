import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.net.ServerSocket

class TCPServer {

    val logger: Logger = LoggerFactory.getLogger(javaClass)
    var running = true

    fun start(port: Int) {
        ServerThread(port).start()
    }

    inner class ServerThread(private val port: Int) : Thread() {


        override fun run() {

            try {
                val server = ServerSocket(port)

                while (running) {
                    logger.info("waiting for client")
                    val client = server.accept()
                    logger.info("client accepted: {}", client)
                }
            } catch (e: Exception) {
                logger.error("disconnected with", e)
            }
        }
    }
}