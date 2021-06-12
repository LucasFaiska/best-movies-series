package com.lfaiska.bestmoviesseries.data.remote.datasource.serie

import com.lfaiska.bestmoviesseries.data.remote.dto.PagedListRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.dto.SerieDetailRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.dto.SerieRemoteEntity
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
import org.mockito.ArgumentMatchers.*
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
    fun `when invoke getSeries and retrieve a PagedListRemoteEntity of SerieListRemoteEntity from service should returns it`() {
        val serieListRemoteEntityMock = mockk<PagedListRemoteEntity<SerieRemoteEntity>>()
        val languageMock = anyString()

        runBlocking {
            coEvery {
                service.getSeries(anyInt(), languageMock)
            } returns serieListRemoteEntityMock

            val result = dataSource.getSeries(anyInt(), languageMock)

            assert(serieListRemoteEntityMock == result)

            coVerify(Ordering.SEQUENCE) {
                service.getSeries(anyInt(), languageMock)
            }
        }
    }

    @Test(expected = UnauthorizedResourceException::class)
    fun `when invoke getSeries and get a 401 http error from service should throw UnauthorizedResourceException`() {
        val languageMock = anyString()

        runBlocking {
            setupGetSeriesHttpExceptionMock(401)

            dataSource.getSeries(anyInt(), languageMock)

            coVerify(Ordering.SEQUENCE) {
                service.getSeries(anyInt(), languageMock)
            }
        }
    }

    @Test(expected = ResourceNotFoundException::class)
    fun `when invoke getSeries and get a 404 http error from service should throw ResourceNotFoundException`() {
        val languageMock = anyString()

        runBlocking {
            setupGetSeriesHttpExceptionMock(404)

            dataSource.getSeries(anyInt(), languageMock)

            coVerify(Ordering.SEQUENCE) {
                service.getSeries(anyInt(), languageMock)
            }
        }
    }

    @Test(expected = InternalErrorException::class)
    fun `when invoke getSeries and get a 500 http error from service should throw InternalErrorException`() {
        val languageMock = anyString()

        runBlocking {
            setupGetSeriesHttpExceptionMock(500)

            dataSource.getSeries(anyInt(), languageMock)

            coVerify(Ordering.SEQUENCE) {
                service.getSeries(anyInt(), languageMock)
            }
        }
    }

    @Test(expected = UnhandledErrorException::class)
    fun `when invoke getSeries and get another http error from service should throw UnhandledErrorException`() {
        val languageMock = anyString()

        runBlocking {
            setupGetSeriesHttpExceptionMock(417)

            dataSource.getSeries(anyInt(), languageMock)

            coVerify(Ordering.SEQUENCE) {
                service.getSeries(anyInt(), languageMock)
            }
        }
    }

    private fun setupGetSeriesHttpExceptionMock(httpErrorCode: Int) {
        val languageMock = anyString()
        val httpExceptionMock = mockk<HttpException>()

        every { httpExceptionMock.code() } returns httpErrorCode

        coEvery {
            service.getSeries(anyInt(), languageMock)
        } throws httpExceptionMock
    }

    @Test
    fun `when invoke getSerie and retrieve SerieDetailRemoteEntity from service should returns it`() {
        val serieDetailRemoteEntityMock = mockk<SerieDetailRemoteEntity>()
        val serieIdMock = anyLong()

        runBlocking {
            coEvery {
                service.getSerieDetails(serieIdMock)
            } returns serieDetailRemoteEntityMock

            val result = dataSource.getSerieDetails(serieIdMock)

            assert(serieDetailRemoteEntityMock == result)

            coVerify(Ordering.SEQUENCE) {
                service.getSerieDetails(serieIdMock)
            }
        }
    }

    @Test(expected = UnauthorizedResourceException::class)
    fun `when invoke getSerie and get a 401 http error from service should throw UnauthorizedResourceException`() {
        val serieIdMock = anyLong()

        runBlocking {
            setupGetSerieDetailsHttpExceptionMock(serieIdMock, 401)

            dataSource.getSerieDetails(serieIdMock)

            coVerify(Ordering.SEQUENCE) {
                service.getSerieDetails(serieIdMock)
            }
        }
    }

    @Test(expected = ResourceNotFoundException::class)
    fun `when invoke getSerie and get a 404 http error from service should throw ResourceNotFoundException`() {
        val serieIdMock = anyLong()

        runBlocking {
            setupGetSerieDetailsHttpExceptionMock(serieIdMock, 404)

            dataSource.getSerieDetails(serieIdMock)

            coVerify(Ordering.SEQUENCE) {
                service.getSerieDetails(serieIdMock)
            }
        }
    }

    @Test(expected = InternalErrorException::class)
    fun `when invoke getSerie and get a 500 http error from service should throw InternalErrorException`() {
        val serieIdMock = anyLong()

        runBlocking {
            setupGetSerieDetailsHttpExceptionMock(serieIdMock, 500)

            dataSource.getSerieDetails(serieIdMock)

            coVerify(Ordering.SEQUENCE) {
                service.getSerieDetails(serieIdMock)
            }
        }
    }

    @Test(expected = UnhandledErrorException::class)
    fun `when invoke getSerie and get another http error from service should throw UnhandledErrorException`() {
        val serieIdMock = anyLong()

        runBlocking {
            setupGetSerieDetailsHttpExceptionMock(serieIdMock, 417)

            dataSource.getSerieDetails(serieIdMock)

            coVerify(Ordering.SEQUENCE) {
                service.getSerieDetails(serieIdMock)
            }
        }
    }

    private fun setupGetSerieDetailsHttpExceptionMock(serieId: Long, httpErrorCode: Int) {
        val httpExceptionMock = mockk<HttpException>()

        every { httpExceptionMock.code() } returns httpErrorCode

        coEvery {
            service.getSerieDetails(serieId)
        } throws httpExceptionMock
    }

    @Test
    fun `when invoke getSimilarSeries and retrieve a PagedListRemoteEntity of SerieListRemoteEntity from service should returns it`() {
        val serieListRemoteEntityMock = mockk<PagedListRemoteEntity<SerieRemoteEntity>>()
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
    fun `when invoke getSimilarSeries and get a 401 http error from service should throw UnauthorizedResourceException`() {
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
    fun `when invoke getSimilarSeries and get a 404 http error from service should throw ResourceNotFoundException`() {
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
    fun `when invoke getSimilarSeries and get a 500 http error from service should throw InternalErrorException`() {
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
    fun `when invoke getSimilarSeries and get another http error from service should throw UnhandledErrorException`() {
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