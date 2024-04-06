package _23_PastExams._2023_04_April_08.robotService.core;

import _23_PastExams._2023_04_April_08.robotService.common.ConstantMessages;
import _23_PastExams._2023_04_April_08.robotService.common.ExceptionMessages;
import _23_PastExams._2023_04_April_08.robotService.entities.robot.FemaleRobot;
import _23_PastExams._2023_04_April_08.robotService.entities.robot.MaleRobot;
import _23_PastExams._2023_04_April_08.robotService.entities.robot.Robot;
import _23_PastExams._2023_04_April_08.robotService.entities.services.MainService;
import _23_PastExams._2023_04_April_08.robotService.entities.services.SecondaryService;
import _23_PastExams._2023_04_April_08.robotService.entities.services.Service;
import _23_PastExams._2023_04_April_08.robotService.entities.supplements.MetalArmor;
import _23_PastExams._2023_04_April_08.robotService.entities.supplements.PlasticArmor;
import _23_PastExams._2023_04_April_08.robotService.entities.supplements.Supplement;
import _23_PastExams._2023_04_April_08.robotService.repositories.SupplementRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {
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
                throw new NullPointerException(ExceptionMessages.INVALID_SERVICE_TYPE);
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SERVICE_TYPE, type);
    }

    @Override
    public String addSupplement(String type) {
        switch (type) {
            case "PlasticArmor":
                this.supplements.addSupplement(new PlasticArmor());
                break;

            case "MetalArmor":
                this.supplements.addSupplement(new MetalArmor());
                break;

            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_SUPPLEMENT_TYPE);
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForService(String serviceName, String supplementType) {
        Supplement supplement = this.supplements.findFirst(supplementType);

        if (supplement == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_SUPPLEMENT_FOUND, supplementType));
        }

        this.services.stream()
                .filter(service -> service.getName().equals(serviceName))
                .forEach(service -> service.addSupplement(supplement));

        this.supplements.removeSupplement(supplement);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_IN_SERVICE, supplementType, serviceName);
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
                throw new IllegalArgumentException(ExceptionMessages.INVALID_ROBOT_TYPE);
        }

        this.services.stream()
                .filter(service -> service.getName().equals(serviceName))
                .forEach(service -> service.addRobot(robot));

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_ROBOT_IN_SERVICE, robotType, serviceName);
    }

    @Override
    public String feedingRobot(String serviceName) {
        Service service = this.services.stream()
                .filter(serv -> serv.getName().equals(serviceName))
                .findFirst()
                .orElse(null);

        assert service != null;
        service.feeding();

        return String.format(ConstantMessages.FEEDING_ROBOT, service.getRobots().size());
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

        return String.format(ConstantMessages.VALUE_SERVICE, serviceName, value);
    }

    @Override
    public String getStatistics() {
        return String.join(System.lineSeparator(),
                this.services.stream()
                        .map(Service::getStatistics)
                        .toArray(String[]::new));
    }
}
