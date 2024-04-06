package _24_Exam.restaurant.models.waiter;

import _24_Exam.restaurant.models.orders.TakenOrders;

public interface Waiter {
    String getName();

    int getEfficiency();

    boolean canWork();

    TakenOrders takenOrders();


    void work();
}
