class RCP {
    fun rcp(p1: Hand, p2: Hand): String {
        if (p1 == p2) {
            return "draw"
        }
        return if (p1 == Hand.ROCK) {
            "p1 wins"
        } else if (p2 == Hand.PAPER) {
            "p1 wins"
        } else {
            "p2 wins"
        }
    }
}

enum class Hand {
    ROCK,
    PAPER,
    SCISSOR,
}