package robotService.entities.services;

import robotService.entities.robot.Robot;

import static robotService.common.ConstantMessages.UNSUITABLE_SERVICE;

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
            throw new IllegalArgumentException(UNSUITABLE_SERVICE);
        }
    }
}
