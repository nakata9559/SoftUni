package _23_PastExams._2023_04_April_18.vehicleShop.core;

import _23_PastExams._2023_04_April_18.vehicleShop.common.ConstantMessages;
import _23_PastExams._2023_04_April_18.vehicleShop.common.ExceptionMessages;
import _23_PastExams._2023_04_April_18.vehicleShop.models.shop.Shop;
import _23_PastExams._2023_04_April_18.vehicleShop.models.tool.Tool;
import _23_PastExams._2023_04_April_18.vehicleShop.models.worker.Worker;
import _23_PastExams._2023_04_April_18.vehicleShop.repositories.VehicleRepository;
import _23_PastExams._2023_04_April_18.vehicleShop.models.shop.ShopImpl;
import _23_PastExams._2023_04_April_18.vehicleShop.models.tool.ToolImpl;
import _23_PastExams._2023_04_April_18.vehicleShop.models.vehicle.Vehicle;
import _23_PastExams._2023_04_April_18.vehicleShop.models.vehicle.VehicleImpl;
import _23_PastExams._2023_04_April_18.vehicleShop.models.worker.FirstShift;
import _23_PastExams._2023_04_April_18.vehicleShop.models.worker.SecondShift;
import _23_PastExams._2023_04_April_18.vehicleShop.repositories.Repository;
import _23_PastExams._2023_04_April_18.vehicleShop.repositories.WorkerRepository;

import java.util.Collection;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller{
    private Repository<Worker> workers;
    private Repository<Vehicle> vehicles;
    private int madeVehicles;

    public ControllerImpl() {
        this.workers = new WorkerRepository<>();
        this.vehicles = new VehicleRepository<>();
    }

    @Override
    public String addWorker(String type, String workerName) {
        switch (type) {
            case "FirstShift":
                this.workers.add(new FirstShift(workerName));
                break;

            case "SecondShift":
                this.workers.add(new SecondShift(workerName));
                break;

            default:
                throw new IllegalArgumentException(ExceptionMessages.WORKER_TYPE_DOESNT_EXIST);
        }

        return String.format(ConstantMessages.ADDED_WORKER, type, workerName);
    }

    @Override
    public String addVehicle(String vehicleName, int strengthRequired) {
        Vehicle vehicle = new VehicleImpl(vehicleName, strengthRequired);

        this.vehicles.add(vehicle);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_VEHICLE, vehicleName);
    }

    @Override
    public String addToolToWorker(String workerName, int power) {
        Worker worker = this.workers.findByName(workerName);

        if (null == worker) {
            throw new IllegalArgumentException(ExceptionMessages.HELPER_DOESNT_EXIST);
        }

        Tool tool = new ToolImpl(power);

        worker.addTool(tool);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOOL_TO_WORKER, power, workerName);
    }

    @Override
    public String makingVehicle(String vehicleName) {
        Collection<Worker> workers = this.workers.getWorkers()
                .stream()
                .filter(worker -> worker.getStrength() > 70)
                .collect(Collectors.toList());

        if (workers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.NO_WORKER_READY);
        }

        Vehicle vehicle = this.vehicles.findByName(vehicleName);

        Shop shop = new ShopImpl();

        long brokenTools = 0;

        while (workers.iterator().hasNext() && !vehicle.reached()) {
            Worker worker = workers.iterator().next();

            shop.make(vehicle, worker);

            brokenTools += worker.getTools()
                    .stream()
                    .filter(Tool::isUnfit)
                    .count();
        }

        String vehicleCondition;

        if (vehicle.reached()) {
            vehicleCondition = "done";
            this.madeVehicles++;

        } else {
            vehicleCondition = "not done";
        }

        return String.format(ConstantMessages.VEHICLE_DONE + ConstantMessages.COUNT_BROKEN_INSTRUMENTS,
                vehicleName,
                vehicleCondition,
                brokenTools);
    }

    @Override
    public String statistics() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%d vehicles are ready!", this.madeVehicles));
        sb.append(System.lineSeparator());

        sb.append("Info for workers:");
        sb.append(System.lineSeparator());

        this.workers.getWorkers()
                .forEach(worker -> {
                    long countTools = worker.getTools()
                            .stream()
                            .filter(tool -> !tool.isUnfit())
                            .count();

                    sb.append(String.format("Name: %s, Strength: %d%n" +
                            "Tools: %d fit left%n",
                            worker.getName(),
                            worker.getStrength(),
                            countTools));
                });

        return sb.toString().trim();
    }
}
