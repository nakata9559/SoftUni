package _23_PastExams._2022_08_August_22.goldDigger.models.operation;

import _23_PastExams._2022_08_August_22.goldDigger.models.discoverer.Discoverer;
import _23_PastExams._2022_08_August_22.goldDigger.models.spot.Spot;

import java.util.Collection;

public class OperationImpl implements Operation {
    @Override
    public void startOperation(Spot spot, Collection<Discoverer> discoverers) {
        Collection<String> spots = spot.getExhibits();

        discoverers.forEach(discoverer -> {
            while (discoverer.canDig() && spots.iterator().hasNext()) {
                discoverer.dig();
                String currentSpot = spots.iterator().next();
                discoverer.getMuseum().getExhibits().add(currentSpot);
                spots.remove(currentSpot);
            }
        });

    }
}
