class RCP {
    fun rcp(p1: RcpHand, p2: RcpHand): String {
        if (p1 == p2) {
            return "draw"
        }
        return if (p1 == RcpHand.ROCK) {
            "p1 wins"
        } else if (p2 == RcpHand.PAPER) {
            "p1 wins"
        } else {
            "p2 wins"
        }
    }
}

enum class RcpHand {
    ROCK,
    PAPER,
    SCISSOR,
}