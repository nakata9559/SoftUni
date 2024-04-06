package _24_Exam.restaurant.models.working;

import _24_Exam.restaurant.models.client.Client;
import _24_Exam.restaurant.models.waiter.Waiter;

import java.util.Collection;

public interface Working {
    void takingOrders(Client client, Collection<Waiter> waiters);

}
