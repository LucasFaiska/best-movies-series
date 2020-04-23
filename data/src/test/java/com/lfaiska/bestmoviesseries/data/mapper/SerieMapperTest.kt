package com.lfaiska.bestmoviesseries.data.mapper

import com.lfaiska.bestmoviesseries.data.local.entity.SerieLocalEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.ListRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.SerieRemoteEntity
import com.lfaiska.bestmoviesseries.data.repository.entity.SerieDTO
import org.junit.Before
import org.junit.Test

class SerieMapperTest {

    lateinit var remoteSerieList: ListRemoteEntity<SerieRemoteEntity>
    lateinit var localSerieList: List<SerieLocalEntity>

    @Before
    fun setup() {
        remoteSerieList = ListRemoteEntity(
            page = 0,
            results = listOf(
                SerieRemoteEntity(
                    31917,
                    "/vC324sdfcS313vh9QXwijLIHPJp.jpg",
                    5.04,
                    47.432451,
                    "Based on the Pretty Little Liars series of young adult novels by Sara Shepard, the series follows the lives of four girls — Spencer, Hanna, Aria, and Emily — whose clique falls apart after the disappearance of their queen bee, Alison. One year later, they begin receiving messages from someone using the name A who threatens to expose their secrets — including long-hidden ones they thought only Alison knew.",
                    "Pretty Little Liars",
                    "2015-05-27"
                ),
                SerieRemoteEntity(
                    62560,
                    "/esN3gWb1P091xExLddD2nh4zmi3.jpg",
                    7.5,
                    37.882356,
                    "A contemporary and culturally resonant drama about a young programmer, Elliot, who suffers from a debilitating anti-social disorder and decides that he can only connect to people by hacking them. He wields his skills as a weapon to protect the people that he cares about. Elliot will find himself in the intersection between a cybersecurity firm he works for and the underworld organizations that are recruiting him to bring down corporate America.",
                    "Mr. Robot",
                    "2015-05-27"
                )
            )
        )

        localSerieList = listOf(
            SerieLocalEntity(
                31917,
                "/vC324sdfcS313vh9QXwijLIHPJp.jpg",
                5.04,
                47.432451,
                "Based on the Pretty Little Liars series of young adult novels by Sara Shepard, the series follows the lives of four girls — Spencer, Hanna, Aria, and Emily — whose clique falls apart after the disappearance of their queen bee, Alison. One year later, they begin receiving messages from someone using the name A who threatens to expose their secrets — including long-hidden ones they thought only Alison knew.",
                "Pretty Little Liars",
                "2015-05-27"
            ),
            SerieLocalEntity(
                62560,
                "/esN3gWb1P091xExLddD2nh4zmi3.jpg",
                7.5,
                37.882356,
                "A contemporary and culturally resonant drama about a young programmer, Elliot, who suffers from a debilitating anti-social disorder and decides that he can only connect to people by hacking them. He wields his skills as a weapon to protect the people that he cares about. Elliot will find himself in the intersection between a cybersecurity firm he works for and the underworld organizations that are recruiting him to bring down corporate America.",
                "Mr. Robot",
                "2015-05-27"
            )
        )
    }

    @Test
    fun testRemoteToLocal() {
        val seriesListLocalMappedFromRemote = remoteSerieList.toLocal()

        assert(
            seriesListLocalMappedFromRemote[0] ==
                    SerieLocalEntity(
                        31917,
                        "/vC324sdfcS313vh9QXwijLIHPJp.jpg",
                        5.04,
                        47.432451,
                        "Based on the Pretty Little Liars series of young adult novels by Sara Shepard, the series follows the lives of four girls — Spencer, Hanna, Aria, and Emily — whose clique falls apart after the disappearance of their queen bee, Alison. One year later, they begin receiving messages from someone using the name A who threatens to expose their secrets — including long-hidden ones they thought only Alison knew.",
                        "Pretty Little Liars",
                        "2015-05-27"
                    )
        )

        assert(
            seriesListLocalMappedFromRemote[1] ==
                    SerieLocalEntity(
                        62560,
                        "/esN3gWb1P091xExLddD2nh4zmi3.jpg",
                        7.5,
                        37.882356,
                        "A contemporary and culturally resonant drama about a young programmer, Elliot, who suffers from a debilitating anti-social disorder and decides that he can only connect to people by hacking them. He wields his skills as a weapon to protect the people that he cares about. Elliot will find himself in the intersection between a cybersecurity firm he works for and the underworld organizations that are recruiting him to bring down corporate America.",
                        "Mr. Robot",
                        "2015-05-27"
                    )
        )
    }

    @Test
    fun testRemoteToDTO() {
        val seriesListDTOMappedFromRemote = remoteSerieList.toDTO()

        assert(
            seriesListDTOMappedFromRemote[0] ==
                    SerieDTO(
                        31917,
                        "/vC324sdfcS313vh9QXwijLIHPJp.jpg",
                        5.04,
                        47.432451,
                        "Based on the Pretty Little Liars series of young adult novels by Sara Shepard, the series follows the lives of four girls — Spencer, Hanna, Aria, and Emily — whose clique falls apart after the disappearance of their queen bee, Alison. One year later, they begin receiving messages from someone using the name A who threatens to expose their secrets — including long-hidden ones they thought only Alison knew.",
                        "Pretty Little Liars",
                        "2015-05-27"
                    )
        )

        assert(
            seriesListDTOMappedFromRemote[1] ==
                    SerieDTO(
                        62560,
                        "/esN3gWb1P091xExLddD2nh4zmi3.jpg",
                        7.5,
                        37.882356,
                        "A contemporary and culturally resonant drama about a young programmer, Elliot, who suffers from a debilitating anti-social disorder and decides that he can only connect to people by hacking them. He wields his skills as a weapon to protect the people that he cares about. Elliot will find himself in the intersection between a cybersecurity firm he works for and the underworld organizations that are recruiting him to bring down corporate America.",
                        "Mr. Robot",
                        "2015-05-27"
                    )
        )
    }

    @Test
    fun testLocalToDTO() {
        val seriesListDTOMappedFromLocal = localSerieList.toDTO()

        assert(
            seriesListDTOMappedFromLocal[0] ==
                    SerieDTO(
                        31917,
                        "/vC324sdfcS313vh9QXwijLIHPJp.jpg",
                        5.04,
                        47.432451,
                        "Based on the Pretty Little Liars series of young adult novels by Sara Shepard, the series follows the lives of four girls — Spencer, Hanna, Aria, and Emily — whose clique falls apart after the disappearance of their queen bee, Alison. One year later, they begin receiving messages from someone using the name A who threatens to expose their secrets — including long-hidden ones they thought only Alison knew.",
                        "Pretty Little Liars",
                        "2015-05-27"
                    )
        )

        assert(
            seriesListDTOMappedFromLocal[1] ==
                    SerieDTO(
                        62560,
                        "/esN3gWb1P091xExLddD2nh4zmi3.jpg",
                        7.5,
                        37.882356,
                        "A contemporary and culturally resonant drama about a young programmer, Elliot, who suffers from a debilitating anti-social disorder and decides that he can only connect to people by hacking them. He wields his skills as a weapon to protect the people that he cares about. Elliot will find himself in the intersection between a cybersecurity firm he works for and the underworld organizations that are recruiting him to bring down corporate America.",
                        "Mr. Robot",
                        "2015-05-27"
                    )
        )
    }
}