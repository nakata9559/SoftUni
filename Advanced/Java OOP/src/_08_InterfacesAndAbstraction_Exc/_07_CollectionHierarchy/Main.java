package _08_InterfacesAndAbstraction_Exc._07_CollectionHierarchy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] elementsToAdd = scanner.nextLine().split("\\s+");
        int removeOperations = Integer.parseInt(scanner.nextLine());

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();
        int resultAddedCols = elementsToAdd.length;

        if (resultAddedCols >= 100) {
            resultAddedCols = 100;
        }

        if (removeOperations >= resultAddedCols) {
            removeOperations = resultAddedCols;
        }

        int[][] resultAdded = new int[3][resultAddedCols];
        String[][] resultRemoved = new String[2][removeOperations];

        for (int i = 0; i < elementsToAdd.length && i < 100; i++) {
            resultAdded[0][i] = addCollection.add(elementsToAdd[i]);
            resultAdded[1][i] = addRemoveCollection.add(elementsToAdd[i]);
            resultAdded[2][i] = myList.add(elementsToAdd[i]);
        }

        for (int i = 0; i < removeOperations; i++) {
            resultRemoved[0][i] = addRemoveCollection.remove();
            resultRemoved[1][i] = myList.remove();
        }

        for (int[] row : resultAdded) {
            System.out.println(String.join(" ",
                    Arrays.stream(row)
                            .mapToObj(String::valueOf)
                            .toArray(String[]::new)));
        }

        for (String[] row : resultRemoved) {
            System.out.println(String.join(" ", row));
        }
    }
}
