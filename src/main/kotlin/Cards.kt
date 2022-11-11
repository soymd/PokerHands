import Hand.*

class Cards(private val cards: List<Card>) {
    fun getHand(): Hand {
        val isFlush = isFlush()
        val straightFlag = isStraight()

        if (isFlush && straightFlag) {
            return STRAIGHT_FLUSH
        } else if (isFlush) {
            return FLUSH
        } else if (straightFlag) {
            return STRAIGHT
        }

        val map = cards.associate { card ->
            card.value to cards.count { card.value == it.value }
        }
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

        val maxCard = cards.maxOf { it.value.ordinal }
        return Hand.values().find { it.ordinal == maxCard } ?: HIGH_CARD_TWO
    }

    private fun isFlush(): Boolean {
        val suitMap = cards.associate { card ->
            card.suit to cards.count { card.suit == it.suit }
        }
        val suitCount = suitMap.count { suit -> suit.value == 5 }
        return suitCount == 1
    }

    private fun isStraight(): Boolean {
        val sorted = cards.sortedBy { it.value.ordinal }
        val indexList = mutableListOf<Int>()
        sorted.forEach { card ->
            indexList.add(Value.values().indexOf(card.value))
        }
        val itr = indexList.listIterator()
        var preIndex = itr.next()
        var straightFlag = true
        while (itr.hasNext()) {
            var cur = itr.next()
            if (cur != preIndex + 1) {
                straightFlag = false
                break
            } else {
                preIndex = cur
            }
        }
        return straightFlag
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