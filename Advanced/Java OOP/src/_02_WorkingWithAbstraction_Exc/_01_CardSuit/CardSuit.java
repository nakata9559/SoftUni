package _02_WorkingWithAbstraction_Exc._01_CardSuit;

enum CardSuit {
    CLUBS, DIAMONDS, HEARTS, SPADES;

    public static void printCardSuits() {
        System.out.println("Card Suits:");
        for (CardSuit cardSuit : CardSuit.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n",
                    cardSuit.ordinal(),
                    cardSuit.name());
        }
    }
}
