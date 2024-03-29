package _20_PastExams._2023_08_August;

import java.util.Scanner;

public class _02_DeliveryBoy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);
        char[][] multiArr = new char[rows][cols];
        int[] boyInitialPosition = fillMultiArr(multiArr, scanner);
        int[] boyCurrentPosition  = boyInitialPosition.clone();

        boolean endOfTrip = false;

        while (!endOfTrip) {
            String command = scanner.nextLine();
            int toRow;
            int toCol;

            switch (command) {
                case "up":
                    toRow = boyCurrentPosition[0] - 1;
                    toCol = boyCurrentPosition[1];
                    if (toRow < 0 || toCol < 0 || toRow >= multiArr.length || toCol >= multiArr[0].length) {
                        System.out.println("The delivery is late. Order is canceled.");
                        multiArr[boyInitialPosition[0]][boyInitialPosition[1]] = ' ';
                        endOfTrip = true;
                        break;
                    }

                    switch (multiArr[toRow][toCol]) {
                        case 'B':
                        case '-':
                        case '.':
                        case 'R':
                            if (multiArr[toRow][toCol] == '-') {
                                multiArr[toRow][toCol] = '.';
                            }
                            boyCurrentPosition = new int[]{toRow, toCol};
                            break;

                        case 'A':
                            multiArr[toRow][toCol] = 'P';
                            boyCurrentPosition = new int[]{toRow, toCol};
                            System.out.println("_04_Encapsulation_Exc._04_PizzaCalories._04_Encapsulation_Exc._04_PizzaCalories.pizzaCalories.Pizza is delivered on time! Next order...");
                            endOfTrip = true;
                            break;

                        case 'P':
                            multiArr[toRow][toCol] = 'R';
                            boyCurrentPosition = new int[]{toRow, toCol};
                            System.out.println("_04_Encapsulation_Exc._04_PizzaCalories._04_Encapsulation_Exc._04_PizzaCalories.pizzaCalories.Pizza is collected. 10 minutes for delivery.");
                            break;
                    }
                    break;

                case "down":
                    toRow = boyCurrentPosition[0] + 1;
                    toCol = boyCurrentPosition[1];
                    if (toRow < 0 || toCol < 0 || toRow >= multiArr.length || toCol >= multiArr[0].length) {
                        System.out.println("The delivery is late. Order is canceled.");
                        multiArr[boyInitialPosition[0]][boyInitialPosition[1]] = ' ';
                        endOfTrip = true;
                        break;
                    }

                    switch (multiArr[toRow][toCol]) {
                        case 'B':
                        case '-':
                        case '.':
                        case 'R':
                            if (multiArr[toRow][toCol] == '-') {
                                multiArr[toRow][toCol] = '.';
                            }
                            boyCurrentPosition = new int[]{toRow, toCol};
                            break;

                        case 'A':
                            multiArr[toRow][toCol] = 'P';
                            boyCurrentPosition = new int[]{toRow, toCol};
                            System.out.println("_04_Encapsulation_Exc._04_PizzaCalories._04_Encapsulation_Exc._04_PizzaCalories.pizzaCalories.Pizza is delivered on time! Next order...");
                            endOfTrip = true;
                            break;

                        case 'P':
                            multiArr[toRow][toCol] = 'R';
                            boyCurrentPosition = new int[]{toRow, toCol};
                            System.out.println("_04_Encapsulation_Exc._04_PizzaCalories._04_Encapsulation_Exc._04_PizzaCalories.pizzaCalories.Pizza is collected. 10 minutes for delivery.");
                            break;
                    }
                    break;

                case "right":
                    toRow = boyCurrentPosition[0];
                    toCol = boyCurrentPosition[1] + 1;
                    if (toRow < 0 || toCol < 0 || toRow >= multiArr.length || toCol >= multiArr[0].length) {
                        System.out.println("The delivery is late. Order is canceled.");
                        multiArr[boyInitialPosition[0]][boyInitialPosition[1]] = ' ';
                        endOfTrip = true;
                        break;
                    }

                    switch (multiArr[toRow][toCol]) {
                        case 'B':
                        case '-':
                        case '.':
                        case 'R':
                            if (multiArr[toRow][toCol] == '-') {
                                multiArr[toRow][toCol] = '.';
                            }
                            boyCurrentPosition = new int[]{toRow, toCol};
                            break;

                        case 'A':
                            multiArr[toRow][toCol] = 'P';
                            boyCurrentPosition = new int[]{toRow, toCol};
                            System.out.println("_04_Encapsulation_Exc._04_PizzaCalories._04_Encapsulation_Exc._04_PizzaCalories.pizzaCalories.Pizza is delivered on time! Next order...");
                            endOfTrip = true;
                            break;

                        case 'P':
                            multiArr[toRow][toCol] = 'R';
                            boyCurrentPosition = new int[]{toRow, toCol};
                            System.out.println("_04_Encapsulation_Exc._04_PizzaCalories._04_Encapsulation_Exc._04_PizzaCalories.pizzaCalories.Pizza is collected. 10 minutes for delivery.");
                            break;
                    }
                    break;

                case "left":
                    toRow = boyCurrentPosition[0];
                    toCol = boyCurrentPosition[1] - 1;
                    if (toRow < 0 || toCol < 0 || toRow >= multiArr.length || toCol >= multiArr[0].length) {
                        System.out.println("The delivery is late. Order is canceled.");
                        multiArr[boyInitialPosition[0]][boyInitialPosition[1]] = ' ';
                        endOfTrip = true;
                        break;
                    }

                    switch (multiArr[toRow][toCol]) {
                        case 'B':
                        case '-':
                        case '.':
                        case 'R':
                            if (multiArr[toRow][toCol] == '-') {
                                multiArr[toRow][toCol] = '.';
                            }
                            boyCurrentPosition = new int[]{toRow, toCol};
                            break;

                        case 'A':
                            multiArr[toRow][toCol] = 'P';
                            boyCurrentPosition = new int[]{toRow, toCol};
                            System.out.println("_04_Encapsulation_Exc._04_PizzaCalories._04_Encapsulation_Exc._04_PizzaCalories.pizzaCalories.Pizza is delivered on time! Next order...");
                            endOfTrip = true;
                            break;

                        case 'P':
                            multiArr[toRow][toCol] = 'R';
                            boyCurrentPosition = new int[]{toRow, toCol};
                            System.out.println("_04_Encapsulation_Exc._04_PizzaCalories._04_Encapsulation_Exc._04_PizzaCalories.pizzaCalories.Pizza is collected. 10 minutes for delivery.");
                            break;
                    }
                    break;
            }
        }

        for (int row = 0; row < multiArr.length; row++) {
            for (int col = 0; col < multiArr[row].length; col++) {
                System.out.print(multiArr[row][col]);
            }
            System.out.println();
        }
    }

    public static int[] fillMultiArr(char[][] multiArr, Scanner scanner) {
        int[] boyPosition = new int[2];

        for (int row = 0; row < multiArr.length ; row++) {
            char[] currentRow = scanner.nextLine().toCharArray();
            for (int col = 0; col < multiArr[row].length; col++) {
                multiArr[row][col] = currentRow[col];
                if (currentRow[col] == 'B') {
                    boyPosition[0] = row;
                    boyPosition[1] = col;
                }
            }
        }

        return boyPosition;
    }
}
