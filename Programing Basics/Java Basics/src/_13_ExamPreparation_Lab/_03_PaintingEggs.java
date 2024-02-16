package _13_ExamPreparation_Lab;

import java.util.Scanner;

public class _03_PaintingEggs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String eggSize = scanner.nextLine();
        String color = scanner.nextLine();
        int numOfBatches = Integer.parseInt(scanner.nextLine());

        double pricePerBatch = 0;

        switch (eggSize) {
            case "Large":
                switch (color) {
                    case "Red":
                        pricePerBatch = 16;
                        break;
                    case "Green":
                        pricePerBatch = 12;
                        break;
                    case "Yellow":
                        pricePerBatch = 9;
                        break;
                    }
                break;

            case "Medium":
                switch (color) {
                    case "Red":
                        pricePerBatch = 13;
                        break;
                    case "Green":
                        pricePerBatch = 9;
                        break;
                    case "Yellow":
                        pricePerBatch = 7;
                        break;
                }
                break;

            case "Small":
                switch (color) {
                    case "Red":
                        pricePerBatch = 9;
                        break;
                    case "Green":
                        pricePerBatch = 8;
                        break;
                    case "Yellow":
                        pricePerBatch = 5;
                        break;
                }
                break;
        }

        double sumTotal = numOfBatches * pricePerBatch * 0.65;

        if (sumTotal < 0) {
            sumTotal = 0;
        }

        System.out.printf("%.2f leva.", sumTotal);
    }
}
