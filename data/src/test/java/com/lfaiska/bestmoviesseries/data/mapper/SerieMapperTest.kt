package com.lfaiska.bestmoviesseries.data.mapper

import com.lfaiska.bestmoviesseries.data.local.entity.SerieLocalEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.ListRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.SerieRemoteEntity
import org.junit.Test

class SerieMapperTest {

    @Test
    fun testRemoteToLocal() {
        val remoteSerieList = ListRemoteEntity<SerieRemoteEntity>(
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

        val localSeriesList = remoteSerieList.toLocal()

        assert(
            localSeriesList[0] ==
                    SerieLocalEntity(
                        null,
                        "/vC324sdfcS313vh9QXwijLIHPJp.jpg",
                        5.04,
                        47.432451,
                        "Based on the Pretty Little Liars series of young adult novels by Sara Shepard, the series follows the lives of four girls — Spencer, Hanna, Aria, and Emily — whose clique falls apart after the disappearance of their queen bee, Alison. One year later, they begin receiving messages from someone using the name A who threatens to expose their secrets — including long-hidden ones they thought only Alison knew.",
                        "Pretty Little Liars",
                        "2015-05-27"
                    )
        )

        assert(
            localSeriesList[1] ==
                    SerieLocalEntity(
                        null,
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