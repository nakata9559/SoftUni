package _02_WorkingWithAbstraction_Exc._03_CardsWithPower;

public class Card {
    private enum RankPower {
        ACE(14), TWO(2), THREE(3), FOUR(4),
        FIVE(5), SIX(6), SEVEN(7), EIGHT(8),
        NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13);

        private final int power;
        RankPower(int power) {
            this.power = power;
        }

        public int getValue() {
            return power;
        }
    }
    private enum SuitPower {
        CLUBS(0), DIAMONDS(13), HEARTS(26), SPADES(39);
        private final int power;
        SuitPower(int power) {
            this.power = power;
        }

        public int getPower() {
            return power;
        }
    }

    public static String getCard(String rank, String suit) {
        int power = RankPower.valueOf(rank).getValue() + SuitPower.valueOf(suit).getPower();
        return String.format("Card name: %s of %s; Card power: %d",
                rank, suit, power);
    }
}
