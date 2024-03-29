package _23_PastExams._2023_12_December_19.climbers.models.climbing;

import _23_PastExams._2023_12_December_19.climbers.models.mountain.Mountain;
import _23_PastExams._2023_12_December_19.climbers.models.climber.Climber;

import java.util.Collection;

public class ClimbingImpl implements Climbing{

    @Override
    public void conqueringPeaks(Mountain mountain, Collection<Climber> climbers) {
        Collection<String> peaks = mountain.getPeaksList();

        climbers.forEach(climber -> {
            while (climber.canClimb() && peaks.iterator().hasNext()) {
                String currentPeak = peaks.iterator().next();
                climber.climb();
                climber.getRoster().getPeaks().add(currentPeak);
                peaks.remove(currentPeak);
            }
        });
    }
}
