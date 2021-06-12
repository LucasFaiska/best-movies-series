package com.lfaiska.bestmoviesseries.data.repository.serie

import com.lfaiska.bestmoviesseries.data.local.datasource.serie.SerieLocalDataSource
import com.lfaiska.bestmoviesseries.data.local.entity.SerieLocalEntity
import com.lfaiska.bestmoviesseries.data.remote.connection.Connection
import com.lfaiska.bestmoviesseries.data.remote.datasource.serie.SerieRemoteDataSource
import com.lfaiska.bestmoviesseries.data.remote.dao.PagedListRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.dao.SerieRemoteEntity
import com.lfaiska.bestmoviesseries.data.repository.base.PagedListModel
import com.lfaiska.bestmoviesseries.data.repository.model.SerieModel
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyInt

class SerieRepositoryTest {

    private lateinit var repository: SerieRepository

    @MockK
    lateinit var remote: SerieRemoteDataSource

    @MockK
    lateinit var local: SerieLocalDataSource

    @MockK
    lateinit var connection: Connection

    private lateinit var serieListModel: PagedListModel<SerieModel>
    private lateinit var serieListLocal: List<SerieLocalEntity>
    private lateinit var serieListRemote: PagedListRemoteEntity<SerieRemoteEntity>
    private val languageMock = "pt-BR"

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        repository = SerieRepositoryImpl(remote, local, connection)

        serieListModel = PagedListModel(
            page = 0,
            items = listOf(
                SerieModel(
                    31917,
                    "/vC324sdfcS313vh9QXwijLIHPJp.jpg",
                    5.04,
                    47.432451,
                    "Based on the Pretty Little Liars series of young adult novels by Sara Shepard, the series follows the lives of four girls — Spencer, Hanna, Aria, and Emily — whose clique falls apart after the disappearance of their queen bee, Alison. One year later, they begin receiving messages from someone using the name A who threatens to expose their secrets — including long-hidden ones they thought only Alison knew.",
                    "Pretty Little Liars",
                    "2015-05-27"
                ),
                SerieModel(
                    62560,
                    "/esN3gWb1P091xExLddD2nh4zmi3.jpg",
                    7.5,
                    37.882356,
                    "A contemporary and culturally resonant drama about a young programmer, Elliot, who suffers from a debilitating anti-social disorder and decides that he can only connect to people by hacking them. He wields his skills as a weapon to protect the people that he cares about. Elliot will find himself in the intersection between a cybersecurity firm he works for and the underworld organizations that are recruiting him to bring down corporate America.",
                    "Mr. Robot",
                    "2015-05-27"
                )
            )
        )

        serieListRemote = PagedListRemoteEntity(
            page = 0,
            results = listOf(
                SerieRemoteEntity(
                    31917,
                    "/vC324sdfcS313vh9QXwijLIHPJp.jpg",
                    5.04,
                    47.432451,
                    "Based on the Pretty Little Liars series of young adult novels by Sara Shepard, the series follows the lives of four girls — Spencer, Hanna, Aria, and Emily — whose clique falls apart after the disappearance of their queen bee, Alison. One year later, they begin receiving messages from someone using the name A who threatens to expose their secrets — including long-hidden ones they thought only Alison knew.",
                    "Pretty Little Liars",
                    "2015-05-27"
                ),
                SerieRemoteEntity(
                    62560,
                    "/esN3gWb1P091xExLddD2nh4zmi3.jpg",
                    7.5,
                    37.882356,
                    "A contemporary and culturally resonant drama about a young programmer, Elliot, who suffers from a debilitating anti-social disorder and decides that he can only connect to people by hacking them. He wields his skills as a weapon to protect the people that he cares about. Elliot will find himself in the intersection between a cybersecurity firm he works for and the underworld organizations that are recruiting him to bring down corporate America.",
                    "Mr. Robot",
                    "2015-05-27"
                )
            )
        )

        serieListLocal = listOf(
            SerieLocalEntity(
                id = 31917,
                language = "pt-BR",
                posterPath = "/vC324sdfcS313vh9QXwijLIHPJp.jpg",
                voteAverage = 5.04,
                popularity = 47.432451,
                overview = "Based on the Pretty Little Liars series of young adult novels by Sara Shepard, the series follows the lives of four girls — Spencer, Hanna, Aria, and Emily — whose clique falls apart after the disappearance of their queen bee, Alison. One year later, they begin receiving messages from someone using the name A who threatens to expose their secrets — including long-hidden ones they thought only Alison knew.",
                name = "Pretty Little Liars",
                firstAirDate = "2015-05-27"
            ),
            SerieLocalEntity(
                id = 62560,
                language = "pt-BR",
                posterPath = "/esN3gWb1P091xExLddD2nh4zmi3.jpg",
                voteAverage = 7.5,
                popularity = 37.882356,
                overview = "A contemporary and culturally resonant drama about a young programmer, Elliot, who suffers from a debilitating anti-social disorder and decides that he can only connect to people by hacking them. He wields his skills as a weapon to protect the people that he cares about. Elliot will find himself in the intersection between a cybersecurity firm he works for and the underworld organizations that are recruiting him to bring down corporate America.",
                name = "Mr. Robot",
                firstAirDate = "2015-05-27"
            )
        )
    }

    @Test
    fun `when invoke getSeries and there is connection available should retrieve a PagedListModel of SerieModel from remote and save a List of SerieLocalEntity on local`() {
        runBlocking {
            coEvery { connection.isAvailable() } returns true
            coEvery { remote.getSeries(anyInt(), languageMock) } returns serieListRemote
            coEvery { local.saveSeries(any()) } returns Unit

            val result = repository.getSeries(anyInt(), languageMock)

            assert(result == serieListModel)

            coVerify(Ordering.SEQUENCE) {
                connection.isAvailable()
                remote.getSeries(anyInt(), languageMock)
                local.saveSeries(serieListLocal)
            }
        }
    }

    @Test
    fun `when invoke getSeries and there is no connection available should returns a PagedListModel of SerieModel from local`() {
        runBlocking {
            coEvery { connection.isAvailable() } returns false
            coEvery { local.getSeries(languageMock) } returns serieListLocal

            val result = repository.getSeries(anyInt(), languageMock)

            assert(result == serieListModel)

            coVerify(Ordering.SEQUENCE) {
                connection.isAvailable()
                local.getSeries(languageMock)
            }
        }
    }

    @Test
    fun `when invoke getSeries and remote getSeries throws a exception should throws a SerieRepositoryException with method value getSeries`() {
        runBlocking {
            coEvery { connection.isAvailable() } returns true
            coEvery { remote.getSeries(anyInt(), languageMock) } throws Exception()
            coEvery { local.saveSeries(serieListLocal) } returns Unit

            try {
                repository.getSeries(anyInt(), languageMock)
            } catch (exception: SerieRepositoryException) {
                assert(exception.method == "getSeries")
            }

            coVerify(Ordering.SEQUENCE) {
                connection.isAvailable()
                remote.getSeries(anyInt(), languageMock)
            }
        }
    }
}