import java.net.DatagramPacket
import java.net.DatagramSocket


class UDPBroadcastServer(port: Int = 6666) {

    private val socket = DatagramSocket(port)

    fun start() {

        println("server started")

        while (true) {

            println("server waiting for data")

            val buf = ByteArray(256)
            val packet = DatagramPacket(buf, buf.size)
            socket.receive(packet)
            val strData = String(packet.data)
            println("received: $strData")
        }

    }
}