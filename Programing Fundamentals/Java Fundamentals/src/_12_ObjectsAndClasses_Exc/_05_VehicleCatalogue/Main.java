package _12_ObjectsAndClasses_Exc._05_VehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Catalog> vehicleDetails = new ArrayList<>();

        while(true) {
            String[] inputDetails = scanner.nextLine().split(" ");
            if (inputDetails[0].equals("End")) {
                break;
            }

            boolean modelAlreadyExists = false;

            for (Catalog checkCatalog : vehicleDetails) {
                if (checkCatalog.getModel().equals(inputDetails[1])) {
                    modelAlreadyExists = true;
                }
            }

            if (modelAlreadyExists) {
                continue;
            }

            Catalog eachVehicleDetails = new Catalog();

            eachVehicleDetails.setTypeOfVehicle(inputDetails[0]);
            eachVehicleDetails.setModel(inputDetails[1]);
            eachVehicleDetails.setColor(inputDetails[2]);
            eachVehicleDetails.setHorsepower(Integer.parseInt(inputDetails[3]));

            vehicleDetails.add(eachVehicleDetails);
        }

        while (true) {
            String inputModel = scanner.nextLine();
            if (inputModel.equals("Close the Catalogue")) {
                break;
            }

            for (Catalog eachVehicle : vehicleDetails) {
                if (eachVehicle.getModel().equals(inputModel)) {
                    System.out.println(eachVehicle.getModelDetails());
                }
            }
        }
        System.out.println(getAverageHorsepower(vehicleDetails));
    }
    public static String getAverageHorsepower(List<Catalog> vehicleDetails) {
        int numOfCars = 0;
        int numOfTrucks = 0;
        int sumOfCarsHorsepower = 0;
        int sumOfTrucksHorsepower = 0;
        double averageCarsHorsepower = 0;
        double averageTrucksHorsepower = 0;

        for (Catalog eachVehicleDetails : vehicleDetails) {
            if (eachVehicleDetails.getTypeOfVehicle().equals("car")) {
                numOfCars++;
                sumOfCarsHorsepower += eachVehicleDetails.getHorsepower();

            } else if (eachVehicleDetails.getTypeOfVehicle().equals("truck")) {
                numOfTrucks++;
                sumOfTrucksHorsepower += eachVehicleDetails.getHorsepower();
            }
        }

        if (numOfCars > 0) {
            averageCarsHorsepower = sumOfCarsHorsepower * 1.0 / numOfCars;
        }

        if (numOfTrucks > 0) {
            averageTrucksHorsepower = sumOfTrucksHorsepower * 1.0 / numOfTrucks;
        }

        return String.format("Cars have average horsepower of: %.2f.%n" +
                        "Trucks have average horsepower of: %.2f.",
                averageCarsHorsepower,
                averageTrucksHorsepower);
    }
}
