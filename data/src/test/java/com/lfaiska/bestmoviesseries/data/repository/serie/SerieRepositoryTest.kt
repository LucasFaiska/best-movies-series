package com.lfaiska.bestmoviesseries.data.repository.serie

import com.lfaiska.bestmoviesseries.data.local.datasource.serie.SerieLocalDataSource
import com.lfaiska.bestmoviesseries.data.local.entity.SerieLocalEntity
import com.lfaiska.bestmoviesseries.data.remote.connection.Connection
import com.lfaiska.bestmoviesseries.data.remote.datasource.serie.SerieRemoteDataSource
import com.lfaiska.bestmoviesseries.data.remote.entity.ListRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.SerieRemoteEntity
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
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

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        //repository = SerieRepositoryImpl(remote, local, connection)
    }

    @Test
    fun `when repository calls getSeries and there is connection available should retrieve a List of SerieModel from remote and save a List of SerieLocalEntity on local`() {
        /*val listRemoteEntityMocked = mockk<ListRemoteEntity<SerieRemoteEntity>>(relaxUnitFun = true)
        val serieRemoteListMocked = mockk<List<SerieRemoteEntity>>(relaxUnitFun = true)
        val serieLocalListMocked = mockk<List<SerieLocalEntity>>(relaxUnitFun = true)
        val serieModelListMocked = mockk<List<SerieModel>>(relaxUnitFun = true)

        runBlocking {
            coEvery {
                connection.isAvailable()
            } returns true

            coEvery {
                remote.getSeries()
            } returns listRemoteEntityMocked

            coEvery {
                listRemoteEntityMocked.results
            } returns serieRemoteListMocked

            coEvery {
                local.saveSeries(serieLocalListMocked)
            } returns Unit

            val result = repository.getSeries()

            assert(result == serieRemoteListMocked)
        }*/
    }
}