import Suit.*
import Value.*
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class PokerTest {
    private lateinit var subject: Poker

    @Before
    fun setUp() {
        subject = Poker()
    }

    @Test
    fun `judge return black win when black is straight flush and white is high card two`() {
        val actual = subject.judge(
            listOf(
                Card(HEART, TWO),
                Card(HEART, THREE),
                Card(HEART, FOUR),
                Card(HEART, FIVE),
                Card(HEART, SIX),
            ),
            listOf(
                Card(HEART, TWO),
                Card(DIAMOND, ACE),
                Card(SPADE, FOUR),
                Card(CLUB, FIVE),
                Card(HEART, SIX),
            )
        )

        assertThat(actual, equalTo("Black wins - STRAIGHT_FLUSH"))
    }

    @Test
    fun `judge return white win when black is 3card and white is four card`() {
        val actual = subject.judge(
            listOf(
                Card(HEART, THREE),
                Card(DIAMOND, THREE),
                Card(SPADE, THREE),
                Card(CLUB, FOUR),
                Card(SPADE, TEN),
            ),
            listOf(
                Card(HEART, TWO),
                Card(CLUB, TWO),
                Card(SPADE, TWO),
                Card(DIAMOND, TWO),
                Card(HEART, JACK),
            )
        )

        assertThat(actual, equalTo("White wins - FOUR_OF_A_KIND"))
    }

    @Test
    fun `judge return Tie when black is straight flush and white is straight flush`() {
        val actual = subject.judge(
            listOf(
                Card(HEART, TWO),
                Card(HEART, THREE),
                Card(HEART, FOUR),
                Card(HEART, FIVE),
                Card(HEART, SIX),
            ),
            listOf(
                Card(CLUB, TWO),
                Card(CLUB, THREE),
                Card(CLUB, FOUR),
                Card(CLUB, FIVE),
                Card(CLUB, SIX),
            ),
        )

        assertThat(actual, equalTo("Tie"))
    }
}