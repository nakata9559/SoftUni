package _23_PastExams._2023_12_December_19.climbers.core;

import _23_PastExams._2023_12_December_19.climbers.common.ConstantMessages;
import _23_PastExams._2023_12_December_19.climbers.common.ExceptionMessages;
import _23_PastExams._2023_12_December_19.climbers.models.mountain.Mountain;
import _23_PastExams._2023_12_December_19.climbers.repositories.MountainRepository;
import _23_PastExams._2023_12_December_19.climbers.repositories.Repository;
import _23_PastExams._2023_12_December_19.climbers.models.climber.Climber;
import _23_PastExams._2023_12_December_19.climbers.models.climber.RockClimber;
import _23_PastExams._2023_12_December_19.climbers.models.climber.WallClimber;
import _23_PastExams._2023_12_December_19.climbers.models.climbing.Climbing;
import _23_PastExams._2023_12_December_19.climbers.models.climbing.ClimbingImpl;
import _23_PastExams._2023_12_December_19.climbers.models.mountain.MountainImpl;
import _23_PastExams._2023_12_December_19.climbers.repositories.ClimberRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller{
    private Repository<Climber> climbers;
    private Repository<Mountain> mountains;
    private int climbedMountains;

    public ControllerImpl() {
        this.climbers = new ClimberRepository<>();
        this.mountains = new MountainRepository<>();
    }

    @Override
    public String addClimber(String type, String climberName) {
        Climber climber;

        switch (type) {
            case "RockClimber":
                climber = new RockClimber(climberName);
                break;

            case "WallClimber":
                climber = new WallClimber(climberName);
                break;

            default:
                throw new IllegalArgumentException(ExceptionMessages.CLIMBER_INVALID_TYPE);
        }

        this.climbers.add(climber);

        return String.format(ConstantMessages.CLIMBER_ADDED, type, climberName);
    }

    @Override
    public String addMountain(String mountainName, String... peaks) {
        Mountain mountain = new MountainImpl(mountainName);
        mountain.getPeaksList()
                .addAll(Arrays.stream(peaks)
                        .collect(Collectors.toList()));

        this.mountains.add(mountain);

        return String.format(ConstantMessages.MOUNTAIN_ADDED, mountainName);
    }

    @Override
    public String removeClimber(String climberName) {
        Climber climber = this.climbers.byName(climberName);

        if (climber == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.CLIMBER_DOES_NOT_EXIST, climberName));
        }

        this.climbers.remove(climber);

        return String.format(ConstantMessages.CLIMBER_REMOVE, climberName);
    }

    @Override
    public String startClimbing(String mountainName) {
        Mountain mountain = this.mountains.byName(mountainName);
        Collection<Climber> climbers = this.climbers.getCollection();
//                .stream()
//                .filter(Climber::canClimb)
//                .collect(Collectors.toList());

        if (climbers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.THERE_ARE_NO_CLIMBERS);
        }

        this.climbedMountains++;

        Climbing climbing = new ClimbingImpl();
        climbing.conqueringPeaks(mountain, climbers);

        long removedClimberCount = climbers.stream()
                .filter(climber -> !climber.canClimb())
                .count();


        return String.format(ConstantMessages.PEAK_CLIMBING, mountainName, removedClimberCount);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format(ConstantMessages.FINAL_MOUNTAIN_COUNT, this.climbedMountains));
        sb.append(System.lineSeparator());

        sb.append(ConstantMessages.FINAL_CLIMBERS_STATISTICS);

        this.climbers.getCollection()
                .forEach(climber -> {
                    sb.append(System.lineSeparator());
                    sb.append(String.format(ConstantMessages.FINAL_CLIMBER_NAME, climber.getName()));
                    sb.append(System.lineSeparator());

                    sb.append(String.format(ConstantMessages.FINAL_CLIMBER_STRENGTH, climber.getStrength()));
                    sb.append(System.lineSeparator());

                    String conqueredPeaks = climber.getRoster().getPeaks().isEmpty() ?
                            "None" :
                            String.join(ConstantMessages.FINAL_CLIMBER_FINDINGS_DELIMITER,
                                    climber.getRoster()
                                            .getPeaks()
                                            .toArray(String[]::new));

                    sb.append(String.format(ConstantMessages.FINAL_CLIMBER_PEAKS, conqueredPeaks));
                });

        return sb.toString();
    }
}
