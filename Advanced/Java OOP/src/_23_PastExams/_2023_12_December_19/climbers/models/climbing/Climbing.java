package _23_PastExams._2023_12_December_19.climbers.models.climbing;

import _23_PastExams._2023_12_December_19.climbers.models.mountain.Mountain;
import _23_PastExams._2023_12_December_19.climbers.models.climber.Climber;

import java.util.Collection;

public interface Climbing {
    void conqueringPeaks(Mountain mountain, Collection<Climber> climbers);

}
