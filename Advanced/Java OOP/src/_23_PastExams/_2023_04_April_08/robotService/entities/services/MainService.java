package _23_PastExams._2023_04_April_08.robotService.entities.services;

import _23_PastExams._2023_04_April_08.robotService.common.ConstantMessages;
import _23_PastExams._2023_04_April_08.robotService.entities.robot.Robot;

public class MainService extends BaseService{
    private static final int CAPACITY = 30;

    public MainService(String name) {
        super(name, CAPACITY);
    }

    @Override
    public void addRobot(Robot robot) {
        if (robot.getClass().getSimpleName().equals("MaleRobot")) {
            super.addRobot(robot);
        } else {
            throw new IllegalArgumentException(ConstantMessages.UNSUITABLE_SERVICE);
        }
    }
}
