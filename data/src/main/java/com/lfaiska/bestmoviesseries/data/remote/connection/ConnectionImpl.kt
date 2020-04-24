package com.lfaiska.bestmoviesseries.data.remote.connection

import java.io.IOException
import java.net.InetSocketAddress
import java.net.Socket

class ConnectionImpl(val socket: Socket) : Connection {

    override suspend fun isAvailable(): Boolean {
        return try {
            performRequest()
            true
        } catch (e: IOException) {
            false
        }
    }

    private fun performRequest() {
        socket.connect(InetSocketAddress(HOSTNAME, PORT), TIMEOUT)
        socket.close()
    }

    companion object {
        const val TIMEOUT = 1500
        const val HOSTNAME = "8.8.8.8"
        const val PORT = 53
    }
}