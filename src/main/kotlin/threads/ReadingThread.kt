package threads

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class ReadingThread(inputStream: InputStream) : Thread() {

    private val reader = BufferedReader(InputStreamReader(inputStream))
    private var connected: Boolean = true

    override fun run() {
        while (connected) {
            try {
                val line = reader.readLine()
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {

            }
        }

    }
}