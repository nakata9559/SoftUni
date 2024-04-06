package _24_Exam.restaurant.models.waiter;

public class HalfTimeWaiter extends BaseWaiter{
    private static final int INITIAL_EFFICIENCY = 4;

    public HalfTimeWaiter(String name) {
        super(name, INITIAL_EFFICIENCY);
    }

    @Override
    public void work() {
        super.setEfficiency(Math.max(0, super.getEfficiency() - 2));
    }
}
