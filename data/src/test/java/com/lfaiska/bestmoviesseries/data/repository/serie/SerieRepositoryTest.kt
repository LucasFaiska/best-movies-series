package com.lfaiska.bestmoviesseries.data.repository.serie

import com.lfaiska.bestmoviesseries.data.local.datasource.serie.SerieLocalDataSource
import com.lfaiska.bestmoviesseries.data.local.entity.SerieLocalEntity
import com.lfaiska.bestmoviesseries.data.mapper.SerieMapper
import com.lfaiska.bestmoviesseries.data.remote.connection.Connection
import com.lfaiska.bestmoviesseries.data.remote.datasource.serie.SerieRemoteDataSource
import com.lfaiska.bestmoviesseries.data.remote.entity.PagedListRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.SerieRemoteEntity
import com.lfaiska.bestmoviesseries.data.repository.base.PagedListModel
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.anyString

class SerieRepositoryTest {

    lateinit var repository: SerieRepository

    @MockK
    lateinit var remote: SerieRemoteDataSource

    @MockK
    lateinit var local: SerieLocalDataSource

    @MockK
    lateinit var connection: Connection

    @MockK
    lateinit var mapper: SerieMapper

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        repository = SerieRepositoryImpl(remote, local, connection, mapper)
    }

    @Test
    fun `when invoke getSeries and there is connection available should retrieve a PagedListModel of SerieModel from remote and save a List of SerieLocalEntity on local`() {
        val serieListModel = mockk<PagedListModel<SerieModel>>()
        val serieListLocal = mockk<List<SerieLocalEntity>>()
        val serieListRemote = mockk<PagedListRemoteEntity<SerieRemoteEntity>>()
        val languageMock = anyString()

        runBlocking {
            every { mapper.mapLocalToModel(serieListLocal) } returns serieListModel
            every { mapper.mapRemoteToLocal(serieListRemote, languageMock) } returns serieListLocal
            every { mapper.mapRemoteToModel(serieListRemote) } returns serieListModel
            coEvery { connection.isAvailable() } returns true
            coEvery { remote.getSeries(anyInt(), languageMock) } returns serieListRemote
            coEvery { local.saveSeries(serieListLocal) } returns Unit

            val result = repository.getSeries(anyInt(), languageMock)

            assert(result == serieListModel)

            coVerify(Ordering.SEQUENCE) {
                connection.isAvailable()
                remote.getSeries(anyInt(), languageMock)
                mapper.mapRemoteToLocal(serieListRemote, languageMock)
                local.saveSeries(serieListLocal)
                mapper.mapRemoteToModel(serieListRemote)
            }
        }
    }

    @Test
    fun `when invoke getSeries and there is no connection available should returns a PagedListModel of SerieModel from local`() {
        val serieListModel = mockk<PagedListModel<SerieModel>>()
        val serieListLocal = mockk<List<SerieLocalEntity>>()
        val languageMock = anyString()

        runBlocking {
            every { mapper.mapLocalToModel(serieListLocal) } returns serieListModel
            coEvery { connection.isAvailable() } returns false
            coEvery { local.getSeries(languageMock) } returns serieListLocal

            val result = repository.getSeries(anyInt(), languageMock)

            assert(result == serieListModel)

            coVerify(Ordering.SEQUENCE) {
                connection.isAvailable()
                local.getSeries(languageMock)
                mapper.mapLocalToModel(serieListLocal)
            }
        }
    }

    @Test
    fun `when invoke getSeries and remote getSeries throws a exception should throws a SerieRepositoryException with method value getSeries`() {
        val serieListModel = mockk<PagedListModel<SerieModel>>()
        val serieListLocal = mockk<List<SerieLocalEntity>>()
        val serieListRemote = mockk<PagedListRemoteEntity<SerieRemoteEntity>>()
        val languageMock = anyString()

        runBlocking {
            every { mapper.mapLocalToModel(serieListLocal) } returns serieListModel
            every { mapper.mapRemoteToLocal(serieListRemote, languageMock) } returns serieListLocal
            every { mapper.mapRemoteToModel(serieListRemote) } returns serieListModel
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