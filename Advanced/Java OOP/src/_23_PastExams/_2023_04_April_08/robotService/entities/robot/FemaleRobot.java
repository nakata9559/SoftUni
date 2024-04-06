package _23_PastExams._2023_04_April_08.robotService.entities.robot;

public class FemaleRobot extends BaseRobot{
    private static final int INITIAL_KILOGRAMS = 7;

    public FemaleRobot(String name, String kind, double price) {
        super(name, kind, INITIAL_KILOGRAMS, price);
    }
}
