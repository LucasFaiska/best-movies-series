package com.lfaiska.bestmoviesseries.data.local.serie

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
import java.lang.Exception

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

    @Test
    fun `when local data source call room get series with a Exceptions should throws it`() {
        val exceptionMock = mockk<Exception>()

        runBlocking {
            coEvery {
                dao.getSeries()
            } throws exceptionMock

            try {
                dataSource.getSeries()
            } catch (exception: Exception) {
                assert(exceptionMock == exception)
            }

            coVerify(Ordering.SEQUENCE) {
                dao.getSeries()
            }
        }
    }
}