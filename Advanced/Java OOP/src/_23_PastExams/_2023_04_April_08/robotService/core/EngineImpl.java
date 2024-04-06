package _23_PastExams._2023_04_April_08.robotService.core;

import _23_PastExams._2023_04_April_08.robotService.common.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private Controller controller;
    private BufferedReader reader;

    public EngineImpl() {
        this.controller = new ControllerImpl(); //TODO implement first
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();

                if (result.equals("End")) {
                    break;
                }
            } catch (NullPointerException | IllegalArgumentException | IllegalStateException | IOException |
                     ClassNotFoundException | NoSuchMethodException e) {
                result = e.getMessage();
            }

            System.out.println(result);
        }
    }

    private String processInput() throws IOException, ClassNotFoundException, NoSuchMethodException {
        String input = this.reader.readLine();
        String[] tokens = input.split("\\s+");

        Command command = Command.valueOf(tokens[0]);
        String result = null;
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        switch (command) {
            case AddService:
                result = addService(data);
                break;
            case AddSupplement:
                result = addSupplement(data);
                break;
            case SupplementForService:
                result = supplementForService(data);
                break;
            case AddRobot:
                result = addRobot(data);
                break;
            case FeedingRobot:
                result = feedingRobot(data);
                break;
            case SumOfAll:
                result = sumOfAll(data);
                break;
            case Statistics:
                result = getStatistics();
                break;
            case End:
                result = Command.End.name();
                break;
        }
        return result;
    }

    private String addService(String[] data) {
        String serviceType = data[0];
        String serviceName = data[1];

        return this.controller.addService(serviceType, serviceName);
    }
    private String addSupplement(String[] data) {
        String supplementType = data[0];

        return this.controller.addSupplement(supplementType);
    }

    private String supplementForService(String[] data) throws ClassNotFoundException, NoSuchMethodException {
        String serviceName = data[0];
        String supplementType = data[1];

        return this.controller.supplementForService(serviceName, supplementType);
    }

    private String addRobot(String[] data) {
        String serviceName = data[0];
        String robotType = data[1];
        String robotName = data[2];
        String robotKind = data[3];
        double price = Double.parseDouble(data[4]);

        return this.controller.addRobot(
                serviceName,
                robotType,
                robotName,
                robotKind,
                price);
    }

    private String feedingRobot(String[] data) {
        String serviceName = data[0];

        return this.controller.feedingRobot(serviceName);
    }

    private String sumOfAll(String[] data) {
        String serviceName = data[0];

        return this.controller.sumOfAll(serviceName);
    }

    private String getStatistics() {
        return this.controller.getStatistics();
    }
}