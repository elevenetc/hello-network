import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress


class UDPBroadcastClient(private val port: Int = 6666) {

    private val socket = DatagramSocket()
    private val ipAddress = InetAddress.getByName("localhost")

    init {
        socket.broadcast = true
    }

    fun send(value: String) {

        println("send client data")

        val ba = value.toByteArray()
        val packet = DatagramPacket(ba, ba.size, ipAddress, port)

        socket.send(packet)
    }
}