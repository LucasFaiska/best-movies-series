package com.lfaiska.bestmoviesseries.data.repository.serie

import com.lfaiska.bestmoviesseries.data.local.datasource.serie.SerieLocalDataSource
import com.lfaiska.bestmoviesseries.data.local.entity.SerieLocalEntity
import com.lfaiska.bestmoviesseries.data.mapper.SerieListMapper
import com.lfaiska.bestmoviesseries.data.remote.connection.Connection
import com.lfaiska.bestmoviesseries.data.remote.datasource.serie.SerieRemoteDataSource
import com.lfaiska.bestmoviesseries.data.remote.entity.ListRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.SerieRemoteEntity
import com.lfaiska.bestmoviesseries.data.repository.base.ListModel
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class SerieRepositoryTest {

    lateinit var repository: SerieRepository

    @MockK
    lateinit var remote: SerieRemoteDataSource

    @MockK
    lateinit var local: SerieLocalDataSource

    @MockK
    lateinit var connection: Connection

    @MockK
    lateinit var mapper: SerieListMapper

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        repository = SerieRepositoryImpl(remote, local, connection, mapper)
    }

    @Test
    fun `when repository calls getSeries and there is connection available should retrieve a List of SerieModel from remote and save a List of SerieLocalEntity on local`() {
        val serieListModel = mockk<ListModel<SerieModel>>()
        val serieListLocal = mockk<List<SerieLocalEntity>>()
        val serieListRemote = mockk<ListRemoteEntity<SerieRemoteEntity>>()

        runBlocking {
            every { mapper.mapLocalToModel(serieListLocal) } returns serieListModel
            every { mapper.mapRemoteToLocal(serieListRemote) } returns serieListLocal
            every { mapper.mapRemoteToModel(serieListRemote) } returns serieListModel
            coEvery { connection.isAvailable() } returns true
            coEvery { remote.getSeries() } returns serieListRemote
            coEvery { local.saveSeries(serieListLocal) } returns Unit

            val result = repository.getSeries()

            assert(result == serieListModel)

            coVerify(Ordering.SEQUENCE) {
                connection.isAvailable()
                remote.getSeries()
                mapper.mapRemoteToLocal(serieListRemote)
                local.saveSeries(serieListLocal)
                mapper.mapRemoteToModel(serieListRemote)
            }
        }
    }
}