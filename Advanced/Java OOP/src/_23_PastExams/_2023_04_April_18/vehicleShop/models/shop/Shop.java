package _23_PastExams._2023_04_April_18.vehicleShop.models.shop;

import _23_PastExams._2023_04_April_18.vehicleShop.models.worker.Worker;
import _23_PastExams._2023_04_April_18.vehicleShop.models.vehicle.Vehicle;

public interface Shop {
    void make(Vehicle vehicle, Worker worker);
}
