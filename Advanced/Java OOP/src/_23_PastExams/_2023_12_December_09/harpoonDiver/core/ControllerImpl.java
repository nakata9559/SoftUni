package _23_PastExams._2023_12_December_09.harpoonDiver.core;

import _23_PastExams._2023_12_December_09.harpoonDiver.common.ConstantMessages;
import _23_PastExams._2023_12_December_09.harpoonDiver.common.ExceptionMessages;
import _23_PastExams._2023_12_December_09.harpoonDiver.models.diver.DeepWaterDiver;
import _23_PastExams._2023_12_December_09.harpoonDiver.models.diver.Diver;
import _23_PastExams._2023_12_December_09.harpoonDiver.models.diver.OpenWaterDiver;
import _23_PastExams._2023_12_December_09.harpoonDiver.models.diver.WreckDiver;
import _23_PastExams._2023_12_December_09.harpoonDiver.models.diving.DivingImpl;
import _23_PastExams._2023_12_December_09.harpoonDiver.models.divingSite.DivingSiteImpl;
import _23_PastExams._2023_12_December_09.harpoonDiver.repositories.DiverRepository;
import _23_PastExams._2023_12_December_09.harpoonDiver.repositories.DivingSiteRepository;
import _23_PastExams._2023_12_December_09.harpoonDiver.models.diving.Diving;
import _23_PastExams._2023_12_December_09.harpoonDiver.models.divingSite.DivingSite;
import _23_PastExams._2023_12_December_09.harpoonDiver.repositories.Repository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller{
    private Repository<Diver> divers;
    private Repository<DivingSite> divingSites;
    private int sitesCount;

    public ControllerImpl() {
        this.divers = new DiverRepository<>();
        this.divingSites = new DivingSiteRepository<>();
    }

    @Override
    public String addDiver(String kind, String diverName) {
        Diver diver;

        switch (kind) {
            case "DeepWaterDiver":
                diver = new DeepWaterDiver(diverName);
                break;

            case "OpenWaterDiver":
                diver = new OpenWaterDiver(diverName);
                break;

            case "WreckDiver":
                diver = new WreckDiver(diverName);
                break;

            default:
                throw new IllegalArgumentException(ExceptionMessages.DIVER_INVALID_KIND);
        }

        this.divers.add(diver);

        return String.format(ConstantMessages.DIVER_ADDED, kind, diverName);
    }

    @Override
    public String addDivingSite(String siteName, String... seaCreatures) {
        DivingSite divingSite = new DivingSiteImpl(siteName);

        divingSite.getSeaCreatures().addAll(List.of(seaCreatures));

        this.divingSites.add(divingSite);

        return String.format(ConstantMessages.DIVING_SITE_ADDED, siteName);
    }

    @Override
    public String removeDiver(String diverName) {
        Diver diver = this.divers.byName(diverName);

        if (diver == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DIVER_DOES_NOT_EXIST, diverName));
        }

        this.divers.remove(diver);

        return String.format(ConstantMessages.DIVER_REMOVE, diverName);
    }

    @Override
    public String startDiving(String siteName) {
        DivingSite divingSite = this.divingSites.byName(siteName);
        Collection<Diver> divers = this.divers.getCollection().stream()
                .filter(diver -> diver.getOxygen() > 30)
                .collect(Collectors.toList());

        if (divers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.SITE_DIVERS_DOES_NOT_EXISTS);
        }

        this.sitesCount++;

        Diving diving = new DivingImpl();

        diving.searching(divingSite, divers);

        long removedDiverCount = divers.stream()
                .filter(diver -> !diver.canDive())
                .count();

        return String.format(ConstantMessages.SITE_DIVING, siteName, removedDiverCount);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format(ConstantMessages.FINAL_DIVING_SITES, this.sitesCount));
        sb.append(System.lineSeparator());

        sb.append(ConstantMessages.FINAL_DIVERS_STATISTICS);

        this.divers.getCollection().forEach(diver -> {
            sb.append(System.lineSeparator());

            sb.append(String.format(ConstantMessages.FINAL_DIVER_NAME, diver.getName()));
            sb.append(System.lineSeparator());

            sb.append(String.format(ConstantMessages.FINAL_DIVER_OXYGEN, diver.getOxygen()));
            sb.append(System.lineSeparator());

            String finalDiverCatch = diver.getSeaCatch().getSeaCreatures().isEmpty() ?
                    "None" :
                    String.join(ConstantMessages.FINAL_DIVER_CATCH_DELIMITER,
                            diver.getSeaCatch().getSeaCreatures());

            sb.append(String.format(ConstantMessages.FINAL_DIVER_CATCH, finalDiverCatch));
        });

        return sb.toString();
    }
}
