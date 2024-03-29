package _23_PastExams._2022_08_August_22.goldDigger.core;

import _23_PastExams._2022_08_August_22.goldDigger.models.discoverer.Anthropologist;
import _23_PastExams._2022_08_August_22.goldDigger.models.discoverer.Archaeologist;
import _23_PastExams._2022_08_August_22.goldDigger.models.discoverer.Discoverer;
import _23_PastExams._2022_08_August_22.goldDigger.models.discoverer.Geologist;
import _23_PastExams._2022_08_August_22.goldDigger.models.operation.Operation;
import _23_PastExams._2022_08_August_22.goldDigger.models.operation.OperationImpl;
import _23_PastExams._2022_08_August_22.goldDigger.models.spot.Spot;
import _23_PastExams._2022_08_August_22.goldDigger.models.spot.SpotImpl;
import _23_PastExams._2022_08_August_22.goldDigger.repositories.DiscovererRepository;
import _23_PastExams._2022_08_August_22.goldDigger.repositories.Repository;
import _23_PastExams._2022_08_August_22.goldDigger.repositories.SpotRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static _23_PastExams._2022_08_August_22.goldDigger.common.ConstantMessages.*;
import static _23_PastExams._2022_08_August_22.goldDigger.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Discoverer> discovererRepository;
    private Repository<Spot> spotRepository;
    private int inspectedSpots;

    public ControllerImpl() {
        this.discovererRepository = new DiscovererRepository();
        this.spotRepository = new SpotRepository();
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {
        Discoverer discoverer;

        switch (kind) {
            case "Anthropologist":
                discoverer = new Anthropologist(discovererName);
                break;
            case "Archaeologist":
                discoverer = new Archaeologist(discovererName);
                break;
            case "Geologist":
                discoverer = new Geologist(discovererName);
                break;
            default:
                throw new IllegalArgumentException(DISCOVERER_INVALID_KIND);
        }

        this.discovererRepository.add(discoverer);

        return String.format(DISCOVERER_ADDED, kind, discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {
        Spot spot = new SpotImpl(spotName);

        Arrays.stream(exhibits)
                .forEach(exhibit -> spot.getExhibits()
                        .add(exhibit));

        this.spotRepository.add(spot);

        return String.format(SPOT_ADDED, spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        Discoverer discoverer = this.discovererRepository.byName(discovererName);

        if (discoverer == null) {
            throw new IllegalArgumentException(String.format(DISCOVERER_DOES_NOT_EXIST, discovererName));
        } else {
            this.discovererRepository.remove(discoverer);
        }

        return String.format(DISCOVERER_EXCLUDE, discovererName);
    }

    @Override
    public String inspectSpot(String spotName) {
        List<Discoverer> discoverers = this.discovererRepository.getCollection()
                .stream()
                .filter(discoverer -> discoverer.getEnergy() > 45)
                .collect(Collectors.toList());

        if (discoverers.isEmpty()) {
            throw new IllegalArgumentException(SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }

        Spot spot = this.spotRepository.byName(spotName);

        Operation operation = new OperationImpl();

        operation.startOperation(spot, discoverers);

        this.inspectedSpots++;

        long excludedDiscoverers = discoverers
                .stream()
                .filter(discoverer -> discoverer.getEnergy() == 0)
                .count();

        return String.format(INSPECT_SPOT, spotName, excludedDiscoverers);
    }

    @Override
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format(FINAL_SPOT_INSPECT, this.inspectedSpots));
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(FINAL_DISCOVERER_INFO);

        this.discovererRepository.getCollection()
                .forEach(discoverer -> {
                    stringBuilder.append(System.lineSeparator());
                    stringBuilder.append(String.format(FINAL_DISCOVERER_NAME, discoverer.getName()));
                    stringBuilder.append(System.lineSeparator());
                    stringBuilder.append(String.format(FINAL_DISCOVERER_ENERGY, discoverer.getEnergy()));
                    stringBuilder.append(System.lineSeparator());

                    String museums = discoverer.getMuseum().getExhibits().isEmpty() ?
                            String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS, "None") :
                            String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS,
                                    String.join(FINAL_DISCOVERER_MUSEUM_EXHIBITS_DELIMITER,
                                    discoverer.getMuseum().getExhibits()));

                    stringBuilder.append(museums);
                });

        return stringBuilder.toString();
    }
}
