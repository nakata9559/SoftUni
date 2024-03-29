package _23_PastExams._2022_08_August_22.goldDigger.models.operation;

import _23_PastExams._2022_08_August_22.goldDigger.models.discoverer.Discoverer;
import _23_PastExams._2022_08_August_22.goldDigger.models.spot.Spot;

import java.util.Collection;

public interface Operation {
    void startOperation(Spot spot, Collection<Discoverer> discoverers);

}
