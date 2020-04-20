package com.lfaiska.bestmoviesseries.data.remote.datasource.serie

import com.lfaiska.bestmoviesseries.data.remote.datasource.serie.SerieRemoteDataSource
import com.lfaiska.bestmoviesseries.data.remote.datasource.serie.SerieRemoteDataSourceImpl
import com.lfaiska.bestmoviesseries.data.remote.entity.ListRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.SerieDetailRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.SerieRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.exception.InternalErrorException
import com.lfaiska.bestmoviesseries.data.remote.exception.ResourceNotFoundException
import com.lfaiska.bestmoviesseries.data.remote.exception.UnauthorizedResourceException
import com.lfaiska.bestmoviesseries.data.remote.exception.UnhandledErrorException
import com.lfaiska.bestmoviesseries.data.remote.service.SerieService
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyLong
import retrofit2.HttpException

class SerieRemoteDataSourceTest {

    private lateinit var dataSource: SerieRemoteDataSource

    @MockK
    private lateinit var service: SerieService

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        dataSource = SerieRemoteDataSourceImpl(service)
    }

    @Test
    fun `when remote data source call service get series successfully should return a SerieListRemoteEntity`() {
        val serieListRemoteEntityMock = mockk<ListRemoteEntity<SerieRemoteEntity>>()

        runBlocking {
            coEvery {
                service.getSeries()
            } returns serieListRemoteEntityMock

            val result = dataSource.getSeries()

            assert(serieListRemoteEntityMock == result)

            coVerify(Ordering.SEQUENCE) {
                service.getSeries()
            }
        }
    }

    @Test(expected = UnauthorizedResourceException::class)
    fun `when remote data source call service get series with 401 http error should throw UnauthorizedResourceException`() {
        runBlocking {
            setupGetSeriesHttpExceptionMock(401)

            dataSource.getSeries()

            coVerify(Ordering.SEQUENCE) {
                service.getSeries()
            }
        }
    }

    @Test(expected = ResourceNotFoundException::class)
    fun `when remote data source call service get series with 404 http error should throw ResourceNotFoundException`() {
        runBlocking {
            setupGetSeriesHttpExceptionMock(404)

            dataSource.getSeries()

            coVerify(Ordering.SEQUENCE) {
                service.getSeries()
            }
        }
    }

    @Test(expected = InternalErrorException::class)
    fun `when remote data source call service get series with 500 http error should throw InternalErrorException`() {
        runBlocking {
            setupGetSeriesHttpExceptionMock(500)

            dataSource.getSeries()

            coVerify(Ordering.SEQUENCE) {
                service.getSeries()
            }
        }
    }

    @Test(expected = UnhandledErrorException::class)
    fun `when remote data source call service get series with another http error should throw UnhandledErrorException`() {
        runBlocking {
            setupGetSeriesHttpExceptionMock(417)

            dataSource.getSeries()

            coVerify(Ordering.SEQUENCE) {
                service.getSeries()
            }
        }
    }

    private fun setupGetSeriesHttpExceptionMock(httpErrorCode: Int) {
        val httpExceptionMock = mockk<HttpException>()

        every { httpExceptionMock.code() } returns httpErrorCode

        coEvery {
            service.getSeries()
        } throws httpExceptionMock
    }

    @Test
    fun `when remote data source call service get serie details successfully should return a SerieDetailRemoteEntity`() {
        val serieDetailRemoteEntityMock = mockk<SerieDetailRemoteEntity>()
        val serieIdMock = anyLong()

        runBlocking {
            coEvery {
                service.getSerie(serieIdMock)
            } returns serieDetailRemoteEntityMock

            val result = dataSource.getSerie(serieIdMock)

            assert(serieDetailRemoteEntityMock == result)

            coVerify(Ordering.SEQUENCE) {
                service.getSerie(serieIdMock)
            }
        }
    }

    @Test(expected = UnauthorizedResourceException::class)
    fun `when remote data source call service get serie details with 401 http error should throw UnauthorizedResourceException`() {
        val serieIdMock = anyLong()

        runBlocking {
            setupGetSerieDetailsHttpExceptionMock(serieIdMock, 401)

            dataSource.getSerie(serieIdMock)

            coVerify(Ordering.SEQUENCE) {
                service.getSerie(serieIdMock)
            }
        }
    }

    @Test(expected = ResourceNotFoundException::class)
    fun `when remote data source call service get serie details with 404 http error should throw ResourceNotFoundException`() {
        val serieIdMock = anyLong()

        runBlocking {
            setupGetSerieDetailsHttpExceptionMock(serieIdMock, 404)

            dataSource.getSerie(serieIdMock)

            coVerify(Ordering.SEQUENCE) {
                service.getSerie(serieIdMock)
            }
        }
    }

    @Test(expected = InternalErrorException::class)
    fun `when remote data source call service get serie details with 500 http error should throw InternalErrorException`() {
        val serieIdMock = anyLong()

        runBlocking {
            setupGetSerieDetailsHttpExceptionMock(serieIdMock, 500)

            dataSource.getSerie(serieIdMock)

            coVerify(Ordering.SEQUENCE) {
                service.getSerie(serieIdMock)
            }
        }
    }

    @Test(expected = UnhandledErrorException::class)
    fun `when remote data source call service get serie details with another http error should throw UnhandledErrorException`() {
        val serieIdMock = anyLong()

        runBlocking {
            setupGetSerieDetailsHttpExceptionMock(serieIdMock, 417)

            dataSource.getSerie(serieIdMock)

            coVerify(Ordering.SEQUENCE) {
                service.getSerie(serieIdMock)
            }
        }
    }

    private fun setupGetSerieDetailsHttpExceptionMock(serieId: Long, httpErrorCode: Int) {
        val httpExceptionMock = mockk<HttpException>()

        every { httpExceptionMock.code() } returns httpErrorCode

        coEvery {
            service.getSerie(serieId)
        } throws httpExceptionMock
    }

    @Test
    fun `when remote data source call service get similar series successfully should return a SerieListRemoteEntity`() {
        val serieListRemoteEntityMock = mockk<ListRemoteEntity<SerieRemoteEntity>>()
        val serieIdMock = anyLong()

        runBlocking {
            coEvery {
                service.getSimilarSeries(serieIdMock)
            } returns serieListRemoteEntityMock

            val result = dataSource.getSimilarSeries(serieIdMock)

            assert(serieListRemoteEntityMock == result)

            coVerify(Ordering.SEQUENCE) {
                service.getSimilarSeries(serieIdMock)
            }
        }
    }

    @Test(expected = UnauthorizedResourceException::class)
    fun `when remote data source call service get similar series with 401 http error should throw UnauthorizedResourceException`() {
        val serieIdMock = anyLong()

        runBlocking {
            setupGetSimilarSeriesHttpExceptionMock(serieIdMock, 401)

            dataSource.getSimilarSeries(serieIdMock)

            coVerify(Ordering.SEQUENCE) {
                service.getSimilarSeries(serieIdMock)
            }
        }
    }

    @Test(expected = ResourceNotFoundException::class)
    fun `when remote data source call service get similar series with 404 http error should throw ResourceNotFoundException`() {
        val serieIdMock = anyLong()

        runBlocking {
            setupGetSimilarSeriesHttpExceptionMock(serieIdMock, 404)

            dataSource.getSimilarSeries(serieIdMock)

            coVerify(Ordering.SEQUENCE) {
                service.getSimilarSeries(serieIdMock)
            }
        }
    }

    @Test(expected = InternalErrorException::class)
    fun `when remote data source call service get similar series with 500 http error should throw InternalErrorException`() {
        val serieIdMock = anyLong()

        runBlocking {
            setupGetSimilarSeriesHttpExceptionMock(serieIdMock, 500)

            dataSource.getSimilarSeries(serieIdMock)

            coVerify(Ordering.SEQUENCE) {
                service.getSimilarSeries(serieIdMock)
            }
        }
    }

    @Test(expected = UnhandledErrorException::class)
    fun `when remote data source call service get similar series with another http error should throw UnhandledErrorException`() {
        val serieIdMock = anyLong()

        runBlocking {
            setupGetSimilarSeriesHttpExceptionMock(serieIdMock, 417)

            dataSource.getSimilarSeries(serieIdMock)

            coVerify(Ordering.SEQUENCE) {
                service.getSimilarSeries(serieIdMock)
            }
        }
    }

    private fun setupGetSimilarSeriesHttpExceptionMock(serieId: Long, httpErrorCode: Int) {
        val httpExceptionMock = mockk<HttpException>()

        every { httpExceptionMock.code() } returns httpErrorCode

        coEvery {
            service.getSimilarSeries(serieId)
        } throws httpExceptionMock
    }
}