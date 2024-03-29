package _02_WorkingWithAbstraction_Exc._06_GreedyTimes;

import java.util.*;

public class Bag {
    private long capacity;
    private Map<String, Long> gold;
    private Map<String, Long> gems;
    private Map<String, Long> cash;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.gold = new TreeMap<>(Comparator.reverseOrder());
        this.gems = new TreeMap<>(Comparator.reverseOrder());
        this.cash = new TreeMap<>(Comparator.reverseOrder());
    }

    public void addGold(String type, long amount) {
        if (this.capacity - amount < 0) {
            return;
        }
        if (this.gold.isEmpty()) {
            this.gold.put(type, amount);
            this.capacity -= amount;

        } else {
            if (!this.gold.containsKey(type)) {
                this.gold.put(type, 0L);
            }

            this.gold.put(type, this.gold.get(type) + amount);
            this.capacity -= amount;
        }
    }

    public String getGold() {
        if (this.gold.isEmpty()) {
            return "";
        }
        return "<Gold> $" + this.getTotalGoldAmount() + System.lineSeparator() +
                "##" + String.join(System.lineSeparator() + "##",
                Arrays.stream(this.gold.entrySet()
                                .stream()
                                .map(e -> String.format("%s - %d", e.getKey(), e.getValue()))
                                .toArray(String[]::new))
                        .toArray(String[]::new));
    }

    public long getTotalGoldAmount() {
        if (this.gold.isEmpty()) {
            return 0;
        }
        return this.gold.values()
                .stream()
                .mapToLong(Long::longValue)
                .sum();
    }

    public void addGems(String gemType, long gemQuantity) {
        if (this.capacity - gemQuantity < 0) {
            return;
        }
        if (this.getTotalGoldAmount() >= gemQuantity
                && this.gems.isEmpty()) {

            this.gems.put(gemType, gemQuantity);
            this.capacity -= gemQuantity;

        } else if (this.getTotalGoldAmount() >= this.gems.values()
                .stream()
                .mapToLong(Long::longValue)
                .sum() + gemQuantity) {

            if (!this.gems.containsKey(gemType)) {
            this.gems.put(gemType, 0L);
            }

            this.gems.put(gemType, this.gems.get(gemType) + gemQuantity);
            this.capacity -= gemQuantity;
        }
    }

    public String getGems() {
        if (this.gems.isEmpty()) {
            return "";
        }
        return System.lineSeparator() +
                "<Gem> $" + this.getTotalGemsQuantity() + System.lineSeparator() +
                "##" + String.join(System.lineSeparator() + "##",
                Arrays.stream(this.gems.entrySet()
                                .stream()
                                .map(e -> String.format("%s - %d", e.getKey(), e.getValue()))
                                .toArray(String[]::new))
                        .toArray(String[]::new));
    }

    public long getTotalGemsQuantity() {
        return this.gems.values()
                .stream()
                .mapToLong(Long::longValue)
                .sum();
    }

    public void addCash(String currency, long cashAmount) {
        if (this.capacity - cashAmount < 0) {
            return;
        }
        if (!this.gems.isEmpty()
                && this.cash.isEmpty()
                && this.gems.values()
                .stream()
                .mapToLong(Long::longValue)
                .sum() >= cashAmount) {

            this.cash.put(currency, cashAmount);
            this.capacity -= cashAmount;

        } else if (this.gems.values()
                .stream()
                .mapToLong(Long::longValue)
                .sum() >= this.cash.values()
                .stream()
                .mapToLong(Long::longValue)
                .sum() + cashAmount) {

            if (!this.cash.containsKey(currency)) {
                this.cash.put(currency, 0L);
            }

            this.cash.put(currency, this.cash.get(currency) + cashAmount);
            this.capacity -= cashAmount;
        }
    }

    public String getCash() {
        if (this.cash.isEmpty()) {
            return "";
        }
        return System.lineSeparator() +
                "<Cash> $" + this.getTotalCashAmount() + System.lineSeparator() +
                "##" + String.join(System.lineSeparator() + "##",
                Arrays.stream(this.cash.entrySet()
                                .stream()
                                .map(e -> String.format("%s - %d", e.getKey(), e.getValue()))
                                .toArray(String[]::new))
                        .toArray(String[]::new));
    }

    public long getTotalCashAmount() {
        return this.cash.values()
                .stream()
                .mapToLong(Long::longValue)
                .sum();
    }

    @Override
    public String toString() {
        return String.format("%s" +
                "%s" +
                "%s",
                this.getGold(),
                this.getGems(),
                this.getCash());
    }
}
