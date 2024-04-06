package _23_PastExams._2022_04_April_09.fairyShop.models;

import java.util.Collection;

public interface Helper {
    void work();

    void addInstrument(Instrument instrument);

    boolean canWork();

    String getName();

    int getEnergy();

    Collection<Instrument> getInstruments();
}
