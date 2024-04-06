package _24_Exam.restaurant.models.working;

import _24_Exam.restaurant.models.client.Client;
import _24_Exam.restaurant.models.waiter.Waiter;

import java.util.Collection;

public class WorkingImpl implements Working{

    @Override
    public void takingOrders(Client client, Collection<Waiter> waiters) {
        Collection<String> clientOrders = client.getClientOrders();

        waiters.forEach(waiter -> {
            while (waiter.canWork() && clientOrders.iterator().hasNext()) {
                String currentOrder = clientOrders.iterator().next();
                waiter.work();
                waiter.takenOrders().getOrdersList().add(currentOrder);
                clientOrders.remove(currentOrder);
            }
        });
    }
}
