import Suit.*
import Value.*
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test

class CardsTest {
    private lateinit var subject: Cards

    @Before
    fun setUp() {

    }

    @Test
    fun getHand_returnPair_when_同じvalueが2枚ある場合_2() {
        subject = Cards(
            listOf(
                Card(HEART, TWO),
                Card(DIAMOND, TWO),
                Card(SPADE, THREE),
                Card(CLUB, FOUR),
                Card(SPADE, TEN),
            )
        )

        val actual = subject.getHand()

        assertThat(actual, equalTo(Hand.PAIR))
    }

    @Test
    fun getHand_returnPair_when_同じvalueが2枚ある場合_3() {
        subject = Cards(
            listOf(
                Card(HEART, THREE),
                Card(DIAMOND, THREE),
                Card(SPADE, FIVE),
                Card(CLUB, FOUR),
                Card(SPADE, TEN),
            )
        )

        val actual = subject.getHand()

        assertThat(actual, equalTo(Hand.PAIR))
    }

    @Test
    fun getHand_returnPair_when_同じvalueが2枚が2ペア() {
        subject = Cards(
            listOf(
                Card(HEART, THREE),
                Card(DIAMOND, THREE),
                Card(SPADE, FOUR),
                Card(CLUB, FOUR),
                Card(SPADE, TEN),
            )
        )

        val actual = subject.getHand()

        assertThat(actual, equalTo(Hand.TWO_PAIR))
    }

    @Test
    fun getHand_returnPair_when_同じvalueが3枚ある場合() {
        subject = Cards(
            listOf(
                Card(HEART, THREE),
                Card(DIAMOND, THREE),
                Card(SPADE, THREE),
                Card(CLUB, FOUR),
                Card(SPADE, TEN),
            )
        )

        val actual = subject.getHand()

        assertThat(actual, equalTo(Hand.THREE_OF_A_KIND))
    }

//    @Test
//    fun getHand_returnStraight_when_valueが連番() {
//        subject = Cards(
//            listOf(
//                Card(DIAMOND, TEN),
//                Card(HEART, NINE),
//                Card(CLUB, QUEEN),
//                Card(SPADE, JACK),
//                Card(SPADE, KING),
//            )
//        )
//
//        val actual = subject.getHand()
//
//        assertThat(actual, equalTo(Hand.STRAIGHT))
//    }
}