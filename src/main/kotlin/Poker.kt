import Suit.*
import Value.*

class Poker {
    fun judge(black: String, white: String): String {
        val blackHands = black.split(" ").map { map(it) }
        val whiteHands = white.split(" ").map { map(it) }
        val blackHand = Cards(blackHands).getHand()
        val whiteHand = Cards(whiteHands).getHand()

        return if (blackHand == whiteHand) {
            "Tie"
        } else if (blackHand.ordinal > whiteHand.ordinal) {
            "Black wins - ${blackHand}"
        } else {
            "White wins - ${whiteHand}"
        }
    }

    private fun map(str: String): Card {
        val cardMap = mapOf(
            "1D" to Card(DIAMOND, ACE),
            "2D" to Card(DIAMOND, TWO),
            "3D" to Card(DIAMOND, THREE),
            "4D" to Card(DIAMOND, FOUR),
            "5D" to Card(DIAMOND, FIVE),
            "6D" to Card(DIAMOND, SIX),
            "7D" to Card(DIAMOND, SEVEN),
            "8D" to Card(DIAMOND, EIGHT),
            "9D" to Card(DIAMOND, NINE),
            "TD" to Card(DIAMOND, TEN),
            "JD" to Card(DIAMOND, JACK),
            "QD" to Card(DIAMOND, QUEEN),
            "KD" to Card(DIAMOND, KING),
            "1C" to Card(CLUB, ACE),
            "2C" to Card(CLUB, TWO),
            "3C" to Card(CLUB, THREE),
            "4C" to Card(CLUB, FOUR),
            "5C" to Card(CLUB, FIVE),
            "6C" to Card(CLUB, SIX),
            "7C" to Card(CLUB, SEVEN),
            "8C" to Card(CLUB, EIGHT),
            "9C" to Card(CLUB, NINE),
            "TC" to Card(CLUB, TEN),
            "JC" to Card(CLUB, JACK),
            "QC" to Card(CLUB, QUEEN),
            "KC" to Card(CLUB, KING),
            "1S" to Card(SPADE, ACE),
            "2S" to Card(SPADE, TWO),
            "3S" to Card(SPADE, THREE),
            "4S" to Card(SPADE, FOUR),
            "5S" to Card(SPADE, FIVE),
            "6S" to Card(SPADE, SIX),
            "7S" to Card(SPADE, SEVEN),
            "8S" to Card(SPADE, EIGHT),
            "9S" to Card(SPADE, NINE),
            "TS" to Card(SPADE, TEN),
            "JS" to Card(SPADE, JACK),
            "QS" to Card(SPADE, QUEEN),
            "KS" to Card(SPADE, KING),
            "1H" to Card(HEART, ACE),
            "2H" to Card(HEART, TWO),
            "3H" to Card(HEART, THREE),
            "4H" to Card(HEART, FOUR),
            "5H" to Card(HEART, FIVE),
            "6H" to Card(HEART, SIX),
            "7H" to Card(HEART, SEVEN),
            "8H" to Card(HEART, EIGHT),
            "9H" to Card(HEART, NINE),
            "TH" to Card(HEART, TEN),
            "JH" to Card(HEART, JACK),
            "QH" to Card(HEART, QUEEN),
            "KH" to Card(HEART, KING),
        )
        return cardMap[str]!!
    }
}