package _23_PastExams._2023_04_April_08.robotService.entities.services;

import _23_PastExams._2023_04_April_08.robotService.entities.supplements.Supplement;
import _23_PastExams._2023_04_April_08.robotService.entities.robot.Robot;

import java.util.Collection;

public interface Service {
    String getName();

    void setName(String name);

    Collection<Robot> getRobots();

    Collection<Supplement> getSupplements();

    void addRobot(Robot robot);

    void removeRobot(Robot robot);

    void addSupplement(Supplement supplement);

    void feeding();

    int sumHardness();

    String getStatistics();
}
