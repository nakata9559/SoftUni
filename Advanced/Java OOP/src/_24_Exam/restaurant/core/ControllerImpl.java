package _24_Exam.restaurant.core;

import _24_Exam.restaurant.models.waiter.Waiter;
import _24_Exam.restaurant.models.working.Working;
import _24_Exam.restaurant.repositories.Repository;
import _24_Exam.restaurant.factory.WaiterFactory;
import _24_Exam.restaurant.models.client.Client;
import _24_Exam.restaurant.models.client.ClientImpl;
import _24_Exam.restaurant.models.working.WorkingImpl;
import _24_Exam.restaurant.repositories.ClientRepository;
import _24_Exam.restaurant.repositories.WaiterRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import static _24_Exam.restaurant.common.ConstantMessages.*;
import static _24_Exam.restaurant.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{
    private Repository<Waiter> waiterRepository;
    private Repository<Client> clientRepository;
    private int servedClients;

    public ControllerImpl() {
        this.waiterRepository = new WaiterRepository();
        this.clientRepository = new ClientRepository();
    }

    @Override
    public String addWaiter(String type, String waiterName) {
        this.waiterRepository.add(WaiterFactory.createWaiter(type, waiterName));

        return String.format(WAITER_ADDED, type, waiterName);
    }

    @Override
    public String addClient(String clientName, String... orders) {
        Client client = new ClientImpl(clientName);
        client.getClientOrders()
                .addAll(Arrays.stream(orders)
                        .collect(Collectors.toList()));

        this.clientRepository.add(client);

        return String.format(CLIENT_ADDED, clientName);
    }

    @Override
    public String removeWaiter(String waiterName) {
        Waiter waiter = this.waiterRepository.byName(waiterName);

        if (null == waiter) {
            throw new IllegalArgumentException(String.format(WAITER_DOES_NOT_EXIST, waiterName));
        }

        this.waiterRepository.remove(waiter);

        return String.format(WAITER_REMOVE, waiterName);
    }

    @Override
    public String removeClient(String clientName) {
        Client client = this.clientRepository.byName(clientName);

        if (null == client) {
            throw new IllegalArgumentException(String.format(CLIENT_DOES_NOT_EXIST, clientName));
        }

        this.clientRepository.remove(client);

        return String.format(CLIENT_REMOVE, clientName);
    }

    @Override
    public String startWorking(String clientName) {
        Collection<Waiter> waiters =
                this.waiterRepository.getCollection();

        if (waiters.isEmpty()) {
            throw new IllegalArgumentException(THERE_ARE_NO_WAITERS);
        }

        Client client = this.clientRepository.byName(clientName);

        Working working = new WorkingImpl();
        working.takingOrders(client, waiters);

        this.servedClients++;

        return String.format(ORDERS_SERVING, clientName);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format(FINAL_CLIENTS_COUNT, this.servedClients));
        sb.append(System.lineSeparator());

        sb.append(FINAL_WAITERS_STATISTICS);

        this.waiterRepository.getCollection()
                .forEach(waiter -> {
                    sb.append(System.lineSeparator());
                    sb.append(String.format(FINAL_WAITER_NAME, waiter.getName()));
                    sb.append(System.lineSeparator());

                    sb.append(String.format(FINAL_WAITER_EFFICIENCY, waiter.getEfficiency()));
                    sb.append(System.lineSeparator());

                    String orders = waiter.takenOrders().getOrdersList().isEmpty() ?
                            "None" :
                            String.join(FINAL_WAITER_ORDERS_DELIMITER,
                                    waiter.takenOrders()
                                            .getOrdersList()
                                            .toArray(String[]::new));
                    sb.append(String.format(FINAL_WAITER_ORDERS, orders));
                });

        return sb.toString();
    }
}
