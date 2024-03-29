package _23_PastExams._2023_12_December_09.harpoonDiver.models.diving;

import _23_PastExams._2023_12_December_09.harpoonDiver.models.diver.Diver;
import _23_PastExams._2023_12_December_09.harpoonDiver.models.divingSite.DivingSite;

import java.util.Collection;

public class DivingImpl implements Diving{

    @Override
    public void searching(DivingSite divingSite, Collection<Diver> divers) {
        Collection<String> seaCatches = divingSite.getSeaCreatures();

        divers.forEach(diver -> {
            while (diver.canDive() && seaCatches.iterator().hasNext()) {
                String seaCatch = seaCatches.iterator().next();
                diver.shoot();
                diver.getSeaCatch().getSeaCreatures().add(seaCatch);
                seaCatches.remove(seaCatch);
            }
        });
    }
}
