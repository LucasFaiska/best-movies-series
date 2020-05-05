package com.lfaiska.bestmoviesseries.data.repository.serie

import com.lfaiska.bestmoviesseries.data.local.datasource.serie.SerieLocalDataSource
import com.lfaiska.bestmoviesseries.data.local.entity.SerieDataLocalEntity
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
    fun `when repository calls getSeries and there is connection available should retrieve a ListModel of SerieModel from remote and save a List of SerieLocalEntity on local`() {
        val serieListModel = mockk<PagedListModel<SerieModel>>()
        val serieListLocal = mockk<List<SerieDataLocalEntity>>()
        val serieListRemote = mockk<PagedListRemoteEntity<SerieRemoteEntity>>()

        runBlocking {
            every { mapper.mapLocalToModel(serieListLocal) } returns serieListModel
            every { mapper.mapRemoteToLocal(serieListRemote) } returns serieListLocal
            every { mapper.mapRemoteToModel(serieListRemote) } returns serieListModel
            coEvery { connection.isAvailable() } returns true
            coEvery { remote.getSeries(anyInt()) } returns serieListRemote
            coEvery { local.saveSeries(serieListLocal) } returns Unit

            val result = repository.getSeries(anyInt())

            assert(result == serieListModel)

            coVerify(Ordering.SEQUENCE) {
                connection.isAvailable()
                remote.getSeries(anyInt())
                mapper.mapRemoteToLocal(serieListRemote)
                local.saveSeries(serieListLocal)
                mapper.mapRemoteToModel(serieListRemote)
            }
        }
    }

    @Test
    fun `when repository calls getSeries and there is no connection available should returns a ListModel of SerieModel from local`() {
        val serieListModel = mockk<PagedListModel<SerieModel>>()
        val serieListLocal = mockk<List<SerieDataLocalEntity>>()

        runBlocking {
            every { mapper.mapLocalToModel(serieListLocal) } returns serieListModel
            coEvery { connection.isAvailable() } returns false
            coEvery { local.getSeries() } returns serieListLocal

            val result = repository.getSeries(anyInt())

            assert(result == serieListModel)

            coVerify(Ordering.SEQUENCE) {
                connection.isAvailable()
                local.getSeries()
                mapper.mapLocalToModel(serieListLocal)
            }
        }
    }

    @Test
    fun `when repository calls getSeries and remote getSeries throws a exception should throws a SerieRepositoryException with method value getSeries`() {
        val serieListModel = mockk<PagedListModel<SerieModel>>()
        val serieListLocal = mockk<List<SerieDataLocalEntity>>()
        val serieListRemote = mockk<PagedListRemoteEntity<SerieRemoteEntity>>()

        runBlocking {
            every { mapper.mapLocalToModel(serieListLocal) } returns serieListModel
            every { mapper.mapRemoteToLocal(serieListRemote) } returns serieListLocal
            every { mapper.mapRemoteToModel(serieListRemote) } returns serieListModel
            coEvery { connection.isAvailable() } returns true
            coEvery { remote.getSeries(anyInt()) } throws Exception()
            coEvery { local.saveSeries(serieListLocal) } returns Unit

            try {
                repository.getSeries(anyInt())
            } catch (exception: SerieRepositoryException) {
                assert(exception.method == "getSeries")
            }

            coVerify(Ordering.SEQUENCE) {
                connection.isAvailable()
                remote.getSeries(anyInt())
            }
        }
    }
}