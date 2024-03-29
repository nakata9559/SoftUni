package _01_WorkingWithAbstraction_Lab._04_HotelReservation;

public class PriceCalculator {
    public enum Season {
        SPRING(2), SUMMER(4), AUTUMN(1), WINTER(3);
        private int value;

        Season(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
    public enum Discount {
        NONE(0), SECONDVISIT(10), VIP(20);
        private int value;

        Discount(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static double calculatePrice(double pricePerDay,
                                        int numOfDays,
                                        String season,
                                        String discountType) {
        double multiplier = Season.valueOf(season.toUpperCase()).getValue();
        double discount = 1 - (Discount.valueOf(discountType.toUpperCase()).getValue() / 100.0);
        pricePerDay = pricePerDay * multiplier * discount;

        return pricePerDay * numOfDays;
    }
}
