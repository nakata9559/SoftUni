package _23_PastExams._2023_04_April_18.vehicleShop.models.shop;

import _23_PastExams._2023_04_April_18.vehicleShop.models.tool.Tool;
import _23_PastExams._2023_04_April_18.vehicleShop.models.worker.Worker;
import _23_PastExams._2023_04_April_18.vehicleShop.models.vehicle.Vehicle;

import java.util.Collection;

public class ShopImpl implements Shop {

    @Override
    public void make(Vehicle vehicle, Worker worker) {
        Collection<Tool> tools = worker.getTools();

        while (worker.canWork() && tools.iterator().hasNext() && !vehicle.reached()) {
            Tool currentTool = tools.iterator().next();
            worker.working();
            currentTool.decreasesPower();
            vehicle.making();
        }
    }
}
