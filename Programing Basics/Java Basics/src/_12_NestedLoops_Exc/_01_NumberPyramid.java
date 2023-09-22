package _12_NestedLoops_Exc;

import java.util.Scanner;

public class _01_NumberPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int printNum = 1;

        for (int rows = 1; rows <= num; rows++) {
            for (int columns = 1; columns <= rows; columns++) {

                if (printNum > num) {
                    break;
                }

                System.out.print(printNum + " ");

                printNum++;
            }

            if (printNum > num) {
                break;
            }

            System.out.println();
        }
    }
}
