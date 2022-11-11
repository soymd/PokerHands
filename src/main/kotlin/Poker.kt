class Poker {
    fun judge(black: List<Card>, white: List<Card>):String {
        val blackHand = Cards(black).getHand()
        val whiteHand = Cards(white).getHand()

        if(blackHand == whiteHand) {
            return "Tie"
        } else if (blackHand.ordinal > whiteHand.ordinal){
            return "Black wins - ${blackHand}"
        } else {
            return "White wins - ${whiteHand}"
        }
    }
}