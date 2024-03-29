package _02_WorkingWithAbstraction_Exc._02_CardRank;

enum CardRank {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;

    public static void printCardRanks() {
        System.out.println("Card Ranks:");
        for (CardRank cardRank : CardRank.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n",
                    cardRank.ordinal(),
                    cardRank.name());
        }
    }
}
