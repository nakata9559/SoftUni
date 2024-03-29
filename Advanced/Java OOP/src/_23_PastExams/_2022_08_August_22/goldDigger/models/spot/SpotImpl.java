package _23_PastExams._2022_08_August_22.goldDigger.models.spot;

import java.util.ArrayList;
import java.util.Collection;

import static _23_PastExams._2022_08_August_22.goldDigger.common.ExceptionMessages.SPOT_NAME_NULL_OR_EMPTY;


public class SpotImpl implements Spot {
    private String name;
    private Collection<String> exhibits;

    public SpotImpl(String name) {
        setName(name);
        this.exhibits = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(SPOT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<String> getExhibits() {
        return this.exhibits;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
