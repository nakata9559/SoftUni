package _23_PastExams._2023_04_April_08.robotService.entities.robot;

public class MaleRobot extends BaseRobot{
    private static final int INITIAL_KILOGRAMS = 9;

    public MaleRobot(String name, String kind, double price) {
        super(name, kind, INITIAL_KILOGRAMS, price);
    }

    @Override
    public void eating() {
        super.eating();
        super.eating();
        super.eating();
    }
}
