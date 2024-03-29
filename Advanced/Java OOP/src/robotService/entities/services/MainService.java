package robotService.entities.services;

import robotService.entities.robot.Robot;

import static robotService.common.ConstantMessages.UNSUITABLE_SERVICE;

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
            throw new IllegalArgumentException(UNSUITABLE_SERVICE);
        }
    }
}
