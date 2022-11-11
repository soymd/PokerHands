import Hand.*

class Cards(private val cards: List<Card>) {
    fun getHand(): Hand {
        val isFlush = isFlush()
        val isStraight = isStraight()

        if (isFlush && isStraight) {
            return STRAIGHT_FLUSH
        } else if (isFlush) {
            return FLUSH
        } else if (isStraight) {
            return STRAIGHT
        }

        val pairHand = findPairHands(cards)
        if (pairHand != null) {
            return pairHand
        }
        val maxCard = cards.maxOf { it.value.ordinal }
        return Hand.values().find { it.ordinal == maxCard } ?: HIGH_CARD_TWO
    }

    private fun findPairHands(cards: List<Card>): Hand? {
        val map = cards.groupingBy { it.value }.eachCount()
        val pairCount = map.count { it.value == 2 }
        val threeCardCount = map.count { it.value == 3 }
        val fourCardCount = map.count { it.value == 4 }
        if (threeCardCount == 1 && pairCount == 1) {
            return FULL_HOUSE
        } else if (fourCardCount == 1) {
            return FOUR_OF_A_KIND
        } else if (threeCardCount == 1) {
            return THREE_OF_A_KIND
        } else if (pairCount == 2) {
            return TWO_PAIR
        } else if (pairCount == 1) {
            return PAIR
        }
        return null
    }

    private fun isFlush(): Boolean {
        val count = cards.count { it.suit == cards.first().suit }
        return count == 5
    }

    private fun isStraight(): Boolean {
        val sorted = cards.sortedBy { it.value.ordinal }
        var count = sorted.first().value.ordinal
        for (i in 1..4) {
            if (count != sorted[i].value.ordinal - 1) {
                return false
            }
            count = sorted[i].value.ordinal
        }
        return true
    }
}

data class Card(
    val suit: Suit,
    val value: Value,
)

enum class Suit {
    DIAMOND,
    CLUB,
    SPADE,
    HEART,
}

enum class Value {
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING,
    ACE,
}

enum class Hand {
    HIGH_CARD_TWO,
    HIGH_CARD_THREE,
    HIGH_CARD_FOUR,
    HIGH_CARD_FIVE,
    HIGH_CARD_SIX,
    HIGH_CARD_SEVEN,
    HIGH_CARD_EIGHT,
    HIGH_CARD_NINE,
    HIGH_CARD_TEN,
    HIGH_CARD_JACK,
    HIGH_CARD_QUEEN,
    HIGH_CARD_KING,
    HIGH_CARD_ACE,
    PAIR,
    TWO_PAIR,
    THREE_OF_A_KIND,
    STRAIGHT,
    FLUSH,
    FULL_HOUSE,
    FOUR_OF_A_KIND,
    STRAIGHT_FLUSH,
}