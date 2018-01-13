fun main(args: Array<String>) {
    tcpClient()
}

class Main{

}

fun tcpClient() {
    val port = 5555
    TCPServer().start(port)
    TCPClient().connect("localhost", port)
    Thread.sleep(Long.MAX_VALUE)
}

fun broadcastClientAndServer() {

    val server = UDPBroadcastServer()
    val client = UDPBroadcastClient()

    Thread({
        server.start()
    }).start()

    Thread({

        var i = 0
        while (true) {
            client.send("hello:$i")
            i++
            Thread.sleep(1000)
        }


    }).start()
}
