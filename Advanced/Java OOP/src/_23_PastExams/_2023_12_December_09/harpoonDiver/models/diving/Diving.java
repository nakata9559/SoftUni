package _23_PastExams._2023_12_December_09.harpoonDiver.models.diving;

import _23_PastExams._2023_12_December_09.harpoonDiver.models.diver.Diver;
import _23_PastExams._2023_12_December_09.harpoonDiver.models.divingSite.DivingSite;

import java.util.Collection;

public interface Diving {

    void searching(DivingSite divingSite, Collection<Diver> divers);
}
