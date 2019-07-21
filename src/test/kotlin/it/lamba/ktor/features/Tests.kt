package it.lamba.ktor.features

import io.ktor.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import org.junit.Test

class Tests {

    private val serverAddress = "127.0.0.1"
    private val serverPort = 8000
    private val spaRoute = "/"
    private val folderPath = "test"
    private val defaultPage = "lol.html"
    private val useFiles = true

    private val testServer by lazy {
        embeddedServer(Netty, port = serverPort, host = serverAddress){
            install(SinglePageApplication){
                defaultPage = this@Tests.defaultPage
                folderPath = this@Tests.folderPath
                spaRoute = this@Tests.spaRoute
                useFiles = this@Tests.useFiles
            }
        }
    }

    @Test
    fun testFile() {
        testServer.start(wait = true)
    }

}