package _00_MoreExercises._10_FinalExamPreparation._04_;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfBarcodes = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfBarcodes; i++) {
            Pattern pattern = Pattern.compile("^(@#+)([A-Z][A-Za-z0-9]{4,}[A-Z])(@#+)$");
            Matcher matcher = pattern.matcher(scanner.nextLine());
            boolean isValid = false;

            while (matcher.find()) {
                isValid = true;
                StringBuilder productGroup = new StringBuilder();
                for (char eachChar : matcher.group(2).toCharArray()) {
                    if (Character.isDigit(eachChar)) {
                        productGroup.append(eachChar);
                    }
                }

                if (productGroup.length() == 0) {
                    System.out.printf("Product group: 00\n");
                } else {
                    System.out.printf("Product group: %s\n",
                            productGroup);
                }
            }
            if (!isValid) {
                System.out.println("Invalid barcode");
            }
        }
    }
}
