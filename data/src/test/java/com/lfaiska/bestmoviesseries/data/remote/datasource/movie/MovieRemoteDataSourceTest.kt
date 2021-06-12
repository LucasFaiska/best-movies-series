package com.lfaiska.bestmoviesseries.data.remote.datasource.movie

import com.lfaiska.bestmoviesseries.data.remote.dao.PagedListRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.dao.MovieDetailRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.dao.MovieRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.exception.InternalErrorException
import com.lfaiska.bestmoviesseries.data.remote.exception.ResourceNotFoundException
import com.lfaiska.bestmoviesseries.data.remote.exception.UnauthorizedResourceException
import com.lfaiska.bestmoviesseries.data.remote.exception.UnhandledErrorException
import com.lfaiska.bestmoviesseries.data.remote.service.MovieService
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyLong
import retrofit2.HttpException

class MovieRemoteDataSourceTest {

    private lateinit var dataSource: MovieRemoteDataSource

    @MockK
    private lateinit var service: MovieService

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        dataSource = MovieRemoteDataSourceImpl(service)
    }

    @Test
    fun `when remote data source call service get movies successfully should return a list of MovieRemoteEntity`() {
        val movieListRemoteEntityMock = mockk<PagedListRemoteEntity<MovieRemoteEntity>>()

        runBlocking {
            coEvery {
                service.getMovies()
            } returns movieListRemoteEntityMock

            val result = dataSource.getMovies()

            assert(movieListRemoteEntityMock == result)

            coVerify(Ordering.SEQUENCE) {
                service.getMovies()
            }
        }
    }

    @Test(expected = UnauthorizedResourceException::class)
    fun `when remote data source call service get movies with 401 http error should throw UnauthorizedResourceException`() {
        runBlocking {
            setupGetSeriesHttpExceptionMock(401)

            dataSource.getMovies()

            coVerify(Ordering.SEQUENCE) {
                service.getMovies()
            }
        }
    }

    @Test(expected = ResourceNotFoundException::class)
    fun `when remote data source call service get movies with 404 http error should throw ResourceNotFoundException`() {
        runBlocking {
            setupGetSeriesHttpExceptionMock(404)

            dataSource.getMovies()

            coVerify(Ordering.SEQUENCE) {
                service.getMovies()
            }
        }
    }

    @Test(expected = InternalErrorException::class)
    fun `when remote data source call service get movies with 500 http error should throw InternalErrorException`() {
        runBlocking {
            setupGetSeriesHttpExceptionMock(500)

            dataSource.getMovies()

            coVerify(Ordering.SEQUENCE) {
                service.getMovies()
            }
        }
    }

    @Test(expected = UnhandledErrorException::class)
    fun `when remote data source call service get movies with another http error should throw UnhandledErrorException`() {
        runBlocking {
            setupGetSeriesHttpExceptionMock(417)

            dataSource.getMovies()

            coVerify(Ordering.SEQUENCE) {
                service.getMovies()
            }
        }
    }

    private fun setupGetSeriesHttpExceptionMock(httpErrorCode: Int) {
        val httpExceptionMock = mockk<HttpException>()

        every { httpExceptionMock.code() } returns httpErrorCode

        coEvery {
            service.getMovies()
        } throws httpExceptionMock
    }

    @Test
    fun `when remote data source call service get movie details successfully should return a SerieDetailRemoteEntity`() {
        val movieDetailRemoteEntityMock = mockk<MovieDetailRemoteEntity>()
        val movieIdMock = anyLong()

        runBlocking {
            coEvery {
                service.getMovie(movieIdMock)
            } returns movieDetailRemoteEntityMock

            val result = dataSource.getMovie(movieIdMock)

            assert(movieDetailRemoteEntityMock == result)

            coVerify(Ordering.SEQUENCE) {
                service.getMovie(movieIdMock)
            }
        }
    }

    @Test(expected = UnauthorizedResourceException::class)
    fun `when remote data source call service get movie details with 401 http error should throw UnauthorizedResourceException`() {
        val movieIdMock = anyLong()

        runBlocking {
            setupGetSerieDetailsHttpExceptionMock(movieIdMock, 401)

            dataSource.getMovie(movieIdMock)

            coVerify(Ordering.SEQUENCE) {
                service.getMovie(movieIdMock)
            }
        }
    }

    @Test(expected = ResourceNotFoundException::class)
    fun `when remote data source call service get movie details with 404 http error should throw ResourceNotFoundException`() {
        val movieIdMock = anyLong()

        runBlocking {
            setupGetSerieDetailsHttpExceptionMock(movieIdMock, 404)

            dataSource.getMovie(movieIdMock)

            coVerify(Ordering.SEQUENCE) {
                service.getMovie(movieIdMock)
            }
        }
    }

    @Test(expected = InternalErrorException::class)
    fun `when remote data source call service get movie details with 500 http error should throw InternalErrorException`() {
        val movieIdMock = anyLong()

        runBlocking {
            setupGetSerieDetailsHttpExceptionMock(movieIdMock, 500)

            dataSource.getMovie(movieIdMock)

            coVerify(Ordering.SEQUENCE) {
                service.getMovie(movieIdMock)
            }
        }
    }

    @Test(expected = UnhandledErrorException::class)
    fun `when remote data source call service get movie details with another http error should throw UnhandledErrorException`() {
        val movieIdMock = anyLong()

        runBlocking {
            setupGetSerieDetailsHttpExceptionMock(movieIdMock, 417)

            dataSource.getMovie(movieIdMock)

            coVerify(Ordering.SEQUENCE) {
                service.getMovie(movieIdMock)
            }
        }
    }

    private fun setupGetSerieDetailsHttpExceptionMock(movieId: Long, httpErrorCode: Int) {
        val httpExceptionMock = mockk<HttpException>()

        every { httpExceptionMock.code() } returns httpErrorCode

        coEvery {
            service.getMovie(movieId)
        } throws httpExceptionMock
    }

    @Test
    fun `when remote data source call service get similar movies successfully should return a list of MovieRemoteEntity`() {
        val movieListRemoteEntityMock = mockk<PagedListRemoteEntity<MovieRemoteEntity>>()
        val movieIdMock = anyLong()

        runBlocking {
            coEvery {
                service.getSimilarMovies(movieIdMock)
            } returns movieListRemoteEntityMock

            val result = dataSource.getSimilarMovies(movieIdMock)

            assert(movieListRemoteEntityMock == result)

            coVerify(Ordering.SEQUENCE) {
                service.getSimilarMovies(movieIdMock)
            }
        }
    }

    @Test(expected = UnauthorizedResourceException::class)
    fun `when remote data source call service get similar movies with 401 http error should throw UnauthorizedResourceException`() {
        val movieIdMock = anyLong()

        runBlocking {
            setupGetSimilarSeriesHttpExceptionMock(movieIdMock, 401)

            dataSource.getSimilarMovies(movieIdMock)

            coVerify(Ordering.SEQUENCE) {
                service.getSimilarMovies(movieIdMock)
            }
        }
    }

    @Test(expected = ResourceNotFoundException::class)
    fun `when remote data source call service get similar movies with 404 http error should throw ResourceNotFoundException`() {
        val movieIdMock = anyLong()

        runBlocking {
            setupGetSimilarSeriesHttpExceptionMock(movieIdMock, 404)

            dataSource.getSimilarMovies(movieIdMock)

            coVerify(Ordering.SEQUENCE) {
                service.getSimilarMovies(movieIdMock)
            }
        }
    }

    @Test(expected = InternalErrorException::class)
    fun `when remote data source call service get similar movies with 500 http error should throw InternalErrorException`() {
        val movieIdMock = anyLong()

        runBlocking {
            setupGetSimilarSeriesHttpExceptionMock(movieIdMock, 500)

            dataSource.getSimilarMovies(movieIdMock)

            coVerify(Ordering.SEQUENCE) {
                service.getSimilarMovies(movieIdMock)
            }
        }
    }

    @Test(expected = UnhandledErrorException::class)
    fun `when remote data source call service get similar movies with another http error should throw UnhandledErrorException`() {
        val movieIdMock = anyLong()

        runBlocking {
            setupGetSimilarSeriesHttpExceptionMock(movieIdMock, 417)

            dataSource.getSimilarMovies(movieIdMock)

            coVerify(Ordering.SEQUENCE) {
                service.getSimilarMovies(movieIdMock)
            }
        }
    }

    private fun setupGetSimilarSeriesHttpExceptionMock(movieId: Long, httpErrorCode: Int) {
        val httpExceptionMock = mockk<HttpException>()

        every { httpExceptionMock.code() } returns httpErrorCode

        coEvery {
            service.getSimilarMovies(movieId)
        } throws httpExceptionMock
    }
}