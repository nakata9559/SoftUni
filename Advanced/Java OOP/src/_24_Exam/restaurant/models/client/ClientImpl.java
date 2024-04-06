package _24_Exam.restaurant.models.client;

import java.util.ArrayList;
import java.util.Collection;

import static _24_Exam.restaurant.common.ExceptionMessages.CLIENT_NAME_NULL_OR_EMPTY;

public class ClientImpl implements Client{
    private String name;
    private Collection<String> clientOrders;

    public ClientImpl(String name) {
        this.setName(name);
        this.clientOrders = new ArrayList<>();
    }

    @Override
    public Collection<String> getClientOrders() {
        return this.clientOrders;
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (null == name || name.trim().isEmpty()) {
            throw new NullPointerException(CLIENT_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }
}
