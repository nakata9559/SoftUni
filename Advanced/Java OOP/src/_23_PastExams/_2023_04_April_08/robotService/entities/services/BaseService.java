package _23_PastExams._2023_04_April_08.robotService.entities.services;

import _23_PastExams._2023_04_April_08.robotService.common.ConstantMessages;
import _23_PastExams._2023_04_April_08.robotService.common.ExceptionMessages;
import _23_PastExams._2023_04_April_08.robotService.entities.supplements.Supplement;
import _23_PastExams._2023_04_April_08.robotService.entities.robot.Robot;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseService implements Service{
    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Robot> robots;

    public BaseService(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.supplements = new ArrayList<>();
        this.robots = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.SERVICE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    @Override
    public Collection<Robot> getRobots() {
        return this.robots;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return this.supplements;
    }

    @Override
    public void addRobot(Robot robot) {
        if (this.capacity > this.robots.size()) {
            this.robots.add(robot);
        } else {
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_ROBOT);
        }
    }

    @Override
    public void removeRobot(Robot robot) {
        this.robots.remove(robot);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }

    @Override
    public void feeding() {
        this.robots.forEach(Robot::eating);
    }

    @Override
    public int sumHardness() {
        return this.supplements.stream()
                .mapToInt(Supplement::getHardness)
                .sum();
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s %s:",
                this.getName(),
                this.getClass().getSimpleName()));
        sb.append(System.lineSeparator());

        sb.append("Robots: ");
        if (this.robots.isEmpty()) {
            sb.append("none");
        } else {
            StringBuilder sb1 = new StringBuilder();
            this.robots.forEach(robot -> sb1.append(robot.getName()).append(" "));
            sb.append(sb1.toString().trim());
        }
        sb.append(System.lineSeparator());

        sb.append(String.format("Supplements: %d Hardness: %d",
                this.getSupplements().size(),
                this.getSupplements().stream().mapToInt(Supplement::getHardness).sum()));

        return sb.toString();
    }
}
