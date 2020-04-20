package com.lfaiska.bestmoviesseries.data.local.movie

import com.lfaiska.bestmoviesseries.data.local.dao.MovieDao
import com.lfaiska.bestmoviesseries.data.local.datasource.movie.MovieLocalDataSource
import com.lfaiska.bestmoviesseries.data.local.datasource.movie.MovieLocalDataSourceImpl
import com.lfaiska.bestmoviesseries.data.local.entity.MovieLocalEntity
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import java.lang.Exception

class MovieLocalDataSourceTest {
    private lateinit var dataSource: MovieLocalDataSource

    @MockK
    private lateinit var dao: MovieDao

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        dataSource = MovieLocalDataSourceImpl(dao)
    }

    @Test
    fun `when local data source call room get movies successfully should return a list of MovieLocalEntity`() {
        val movieListLocalEntityMock = mockk<List<MovieLocalEntity>>()

        runBlocking {
            coEvery {
                dao.getMovies()
            } returns movieListLocalEntityMock

            val result = dataSource.getMovies()

            assert(movieListLocalEntityMock == result)

            coVerify(Ordering.SEQUENCE) {
                dao.getMovies()
            }
        }
    }

    @Test
    fun `when local data source call room get movies with a Exceptions should throws it`() {
        val exceptionMock = mockk<Exception>()

        runBlocking {
            coEvery {
                dao.getMovies()
            } throws exceptionMock

            try {
                dataSource.getMovies()
            } catch (exception: Exception) {
                assert(exceptionMock == exception)
            }

            coVerify(Ordering.SEQUENCE) {
                dao.getMovies()
            }
        }
    }

    @Test
    fun `when local data source call room save movies successfully should save a list of MovieLocalEntity on local`() {
        val movieListLocalEntityMock = mockk<List<MovieLocalEntity>>()

        runBlocking {
            coEvery {
                dao.saveMovies(movieListLocalEntityMock)
            } returns Unit

            dataSource.saveMovies(movieListLocalEntityMock)

            coVerify(Ordering.SEQUENCE) {
                dao.saveMovies(movieListLocalEntityMock)
            }
        }
    }
}