package _23_PastExams._2023_04_April_08.robotService.entities.services;

import _23_PastExams._2023_04_April_08.robotService.common.ConstantMessages;
import _23_PastExams._2023_04_April_08.robotService.entities.robot.Robot;

public class SecondaryService extends BaseService{
    private static final int CAPACITY = 15;

    public SecondaryService(String name) {
        super(name, CAPACITY);
    }

    @Override
    public void addRobot(Robot robot) {
        if (robot.getClass().getSimpleName().equals("FemaleRobot")) {
            super.addRobot(robot);
        } else {
            throw new IllegalArgumentException(ConstantMessages.UNSUITABLE_SERVICE);
        }
    }
}
