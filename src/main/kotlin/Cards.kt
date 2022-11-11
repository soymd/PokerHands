import Hand.*

class Cards(private val cards: List<Card>) {
    fun getHand(): Hand {
//        val valueList = listOf<Value>(
//            Value.TWO,
//            Value.THREE,
//            Value.FOUR,
//            Value.FIVE,
//            Value.SIX,
//            Value.SEVEN,
//            Value.EIGHT,
//            Value.NINE,
//            Value.TEN,
//            Value.JACK,
//            Value.QUEEN,
//            Value.KING,
//            Value.ACE
//        )
//
//        val sorted = cards.sortedBy { it.value.ordinal }
//
//
//
//        val indexList = mutableListOf<Int>()
//        cards.forEach { card ->
//            indexList.add(valueList.indexOf(card.value))
//        }
//        val itr = indexList.listIterator()
//        var preIndex = itr.next()
//        var straightFlag = true
//        while (itr.hasNext()) {
//            var cur = itr.next()
//            if(cur != preIndex + 1){
//                straightFlag = false
//                break
//            }else{
//                preIndex = cur
//            }
//        }
//        if(straightFlag){
//            return STRAIGHT
//        }


        val map = cards.associate { card ->
            card.value to cards.count { card.value == it.value }
        }
        val pairCount = map.count { it.value == 2 }
        val threeCardCount = map.count { it.value == 3 }
        if (pairCount == 1) {
            return PAIR
        } else if (pairCount == 2) {
            return TWO_PAIR
        } else if (threeCardCount == 1) {
            return THREE_OF_A_KIND
        }

        return NO_HAND
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
    NO_HAND,
    PAIR,
    TWO_PAIR,
    THREE_OF_A_KIND,
    STRAIGHT,
}