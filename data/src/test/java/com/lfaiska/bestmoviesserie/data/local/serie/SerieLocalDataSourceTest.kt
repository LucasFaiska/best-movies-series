package com.lfaiska.bestmoviesserie.data.local.serie

import com.lfaiska.bestmoviesseries.data.local.dao.SerieDao
import com.lfaiska.bestmoviesseries.data.local.datasource.serie.SerieLocalDataSource
import com.lfaiska.bestmoviesseries.data.local.datasource.serie.SerieLocalDataSourceImpl
import com.lfaiska.bestmoviesseries.data.local.entity.MovieLocalEntity
import com.lfaiska.bestmoviesseries.data.local.entity.SerieLocalEntity
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class SerieLocalDataSourceTest {
    private lateinit var dataSource: SerieLocalDataSource

    @MockK
    private lateinit var dao: SerieDao

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        dataSource = SerieLocalDataSourceImpl(dao)
    }

    @Test
    fun `when local data source call room get series successfully should return a list of SerieLocalEntity`() {
        val serieListLocalEntityMock = mockk<List<SerieLocalEntity>>()

        runBlocking {
            coEvery {
                dao.getSeries()
            } returns serieListLocalEntityMock

            val result = dataSource.getSeries()

            assert(serieListLocalEntityMock == result)

            coVerify(Ordering.SEQUENCE) {
                dao.getSeries()
            }
        }
    }
}