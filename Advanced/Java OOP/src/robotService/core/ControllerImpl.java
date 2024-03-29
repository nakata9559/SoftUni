package robotService.core;

import robotService.entities.robot.FemaleRobot;
import robotService.entities.robot.MaleRobot;
import robotService.entities.robot.Robot;
import robotService.entities.services.MainService;
import robotService.entities.services.SecondaryService;
import robotService.entities.services.Service;
import robotService.entities.supplements.MetalArmor;
import robotService.entities.supplements.PlasticArmor;
import robotService.entities.supplements.Supplement;
import robotService.repositories.SupplementRepository;

import java.util.ArrayList;
import java.util.Collection;

import static robotService.common.ConstantMessages.*;
import static robotService.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{
    private static final Supplement PLASTIC_ARMOR = new PlasticArmor();
    private static final Supplement METAL_ARMOR = new MetalArmor();
    private SupplementRepository supplements;
    private Collection<Service> services;

    public ControllerImpl() {
        this.supplements = new SupplementRepository();
        this.services = new ArrayList<>();
    }

    @Override
    public String addService(String type, String name) {
        switch (type) {
            case "MainService":
                this.services.add(new MainService(name));
                break;

            case "SecondaryService":
                this.services.add(new SecondaryService(name));
                break;

            default:
                throw new NullPointerException(INVALID_SERVICE_TYPE);
        }

        return String.format(SUCCESSFULLY_ADDED_SERVICE_TYPE, type);
    }

    @Override
    public String addSupplement(String type) {
        switch (type) {
            case "PlasticArmor":
                this.supplements.addSupplement(PLASTIC_ARMOR);
                break;

            case "MetalArmor":
                this.supplements.addSupplement(METAL_ARMOR);
                break;

            default:
                throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }

        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForService(String serviceName, String supplementType) {
        Supplement supplement;

        switch (supplementType) {
            case "PlasticArmor":
                supplement = PLASTIC_ARMOR;
                break;

            case "MetalArmor":
                supplement = METAL_ARMOR;
                break;

            default:
                throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        }

        if (this.supplements.removeSupplement(supplement)) {
            this.services.stream()
                    .filter(service -> service.getName().equals(serviceName))
                    .forEach(service -> service.addSupplement(supplement));

        }

        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_SERVICE, supplementType, serviceName);
    }

    @Override
    public String addRobot(String serviceName, String robotType, String robotName, String robotKind, double price) {
        Robot robot;

        switch (robotType) {
            case "MaleRobot":
                robot = new MaleRobot(robotName, robotKind, price);
                break;

            case "FemaleRobot":
                robot = new FemaleRobot(robotName, robotKind, price);
                break;

            default:
                throw new IllegalArgumentException(INVALID_ROBOT_TYPE);
        }

        this.services.stream()
                .filter(service -> service.getName().equals(serviceName))
                .forEach(service -> service.addRobot(robot));

        return String.format(SUCCESSFULLY_ADDED_ROBOT_IN_SERVICE, robotType, serviceName);
    }

    @Override
    public String feedingRobot(String serviceName) {
        Service service = this.services.stream()
                .filter(serv -> serv.getName().equals(serviceName))
                .findFirst()
                .orElse(null);

        assert service != null;
        service.feeding();

        return String.format(FEEDING_ROBOT, service.getRobots().size());
    }

    @Override
    public String sumOfAll(String serviceName) {
        Service service = this.services.stream()
                .filter(serv -> serv.getName().equals(serviceName))
                .findFirst()
                .orElse(null);

        assert service != null;
        double value = service.getSupplements()
                .stream()
                .mapToDouble(Supplement::getPrice)
                .sum();
        value += service.getRobots()
                .stream()
                .mapToDouble(Robot::getPrice)
                .sum();

        return String.format(VALUE_SERVICE, serviceName, value);
    }

    @Override
    public String getStatistics() {
        return String.join(System.lineSeparator(),
                this.services.stream()
                        .map(Service::getStatistics)
                        .toArray(String[]::new));
    }
}
