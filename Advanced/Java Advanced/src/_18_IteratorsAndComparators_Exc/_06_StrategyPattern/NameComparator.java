package _18_IteratorsAndComparators_Exc._06_StrategyPattern;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        if (p1.getName().length() > p2.getName().length()) {
            return 1;
        } else if (p1.getName().length() < p2.getName().length()) {
            return -1;
        } else {
            if (p1.getName().toLowerCase().charAt(0) > p2.getName().toLowerCase().charAt(0)) {
                return 1;
            } else if (p1.getName().toLowerCase().charAt(0) < p2.getName().toLowerCase().charAt(0)) {
                return -1;
            }
        }
        return 0;
    }
}
