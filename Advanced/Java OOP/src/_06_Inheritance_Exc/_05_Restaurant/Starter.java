package _06_Inheritance_Exc._05_Restaurant;

import java.math.BigDecimal;

public class Starter extends Food{
    public Starter(String name, BigDecimal price, double grams) {
        super(name, price, grams);
    }
}
