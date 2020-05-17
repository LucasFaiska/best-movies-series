package com.lfaiska.bestmoviesseries.data.local.serie

import com.lfaiska.bestmoviesseries.data.local.dao.SerieDao
import com.lfaiska.bestmoviesseries.data.local.datasource.serie.SerieLocalDataSource
import com.lfaiska.bestmoviesseries.data.local.datasource.serie.SerieLocalDataSourceImpl
import com.lfaiska.bestmoviesseries.data.local.entity.SerieLocalEntity
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
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
        val languageMock = anyString()

        runBlocking {
            coEvery {
                dao.getSeries(languageMock)
            } returns serieListLocalEntityMock

            val result = dataSource.getSeries(languageMock)

            assert(serieListLocalEntityMock == result)

            coVerify(Ordering.SEQUENCE) {
                dao.getSeries(languageMock)
            }
        }
    }

    @Test
    fun `when local data source call room get series with a Exceptions should throws it`() {
        val exceptionMock = mockk<Exception>()
        val languageMock = anyString()

        runBlocking {
            coEvery {
                dao.getSeries(languageMock)
            } throws exceptionMock

            try {
                dataSource.getSeries(languageMock)
            } catch (exception: Exception) {
                assert(exceptionMock == exception)
            }

            coVerify(Ordering.SEQUENCE) {
                dao.getSeries(languageMock)
            }
        }
    }

    @Test
    fun `when local data source call room save series successfully should save a list of SerieLocalEntity on room database`() {
        val serieListLocalEntityMock = mockk<List<SerieLocalEntity>>()

        runBlocking {
            coEvery {
                dao.saveSeries(serieListLocalEntityMock)
            } returns Unit

            dataSource.saveSeries(serieListLocalEntityMock)

            coVerify(Ordering.SEQUENCE) {
                dao.saveSeries(serieListLocalEntityMock)
            }
        }
    }

    @Test
    fun `when local data source call room save series with a Exceptions should throws it`() {
        val serieListLocalEntityMock = mockk<List<SerieLocalEntity>>()
        val exceptionMock = mockk<Exception>()

        runBlocking {
            coEvery {
                dao.saveSeries(serieListLocalEntityMock)
            } throws exceptionMock

            try {
                dataSource.saveSeries(serieListLocalEntityMock)
            } catch (exception: Exception) {
                assert(exceptionMock == exception)
            }

            coVerify(Ordering.SEQUENCE) {
                dao.saveSeries(serieListLocalEntityMock)
            }
        }
    }
}