import Hand.*
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before

import org.junit.Test

class RCPTest {
    private lateinit var subject: RCP

    @Before
    fun setUp() {
        subject = RCP()
    }

    @Test
    fun rcp_p1wins_when_p1isRock_p2isScissor() {
        val actual = subject.rcp(ROCK, SCISSOR)

        assertThat(actual, equalTo("p1 wins"))
    }

    @Test
    fun rcp_p2wins_when_p1isScissor_p2isRock() {
        val actual = subject.rcp(SCISSOR, ROCK)

        assertThat(actual, equalTo("p2 wins"))
    }

    @Test
    fun rcp_p1wins_when_p1isScissor_p2isPaper() {
        val actual = subject.rcp(SCISSOR, PAPER)

        assertThat(actual, equalTo("p1 wins"))
    }

    @Test
    fun rcp_draw_when_p1isPaper_p2isPaper() {
        val actual = subject.rcp(PAPER, PAPER)

        assertThat(actual, equalTo("draw"))
    }

    @Test
    fun rcp_draw_when_p1isScissor_p2isScissor() {
        val actual = subject.rcp(SCISSOR, SCISSOR)

        assertThat(actual, equalTo("draw"))
    }

    @Test
    fun rcp_draw_when_p1isRock_p2isRock() {
        val actual = subject.rcp(ROCK, ROCK)

        assertThat(actual, equalTo("draw"))
    }

}