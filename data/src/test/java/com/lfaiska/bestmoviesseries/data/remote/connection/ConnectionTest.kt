package com.lfaiska.bestmoviesseries.data.remote.connection

import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import java.io.IOException
import java.net.InetSocketAddress
import java.net.Socket

class ConnectionTest {

    lateinit var connection: Connection

    @MockK(relaxUnitFun = true)
    lateinit var socket: Socket

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        connection = ConnectionImpl(socket)
    }

    @Test
    fun testConnectionIsAvailable() {
        every {
            socket.connect(
                InetSocketAddress(ConnectionImpl.HOSTNAME, ConnectionImpl.PORT),
                ConnectionImpl.TIMEOUT
            )
        } returns Unit

        runBlocking {
            val result = connection.isAvailable()
            assert(result)
        }
    }

    @Test
    fun testConnectionIsUnavailable() {
        every {
            socket.connect(
                InetSocketAddress(ConnectionImpl.HOSTNAME, ConnectionImpl.PORT),
                ConnectionImpl.TIMEOUT
            )
        } throws IOException()

        runBlocking {
            val result = connection.isAvailable()
            assert(!result)
        }
    }
}