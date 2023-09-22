package _02_BasicSyntax_ConditionalStatements_And_Loops_Exc;

import java.util.Scanner;

public class _10_PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double lightsaberPrice = Double.parseDouble(scanner.nextLine());
        double robePrice = Double.parseDouble(scanner.nextLine());
        double beltPrice = Double.parseDouble(scanner.nextLine());

        double lightsabersCount = Math.ceil(students * 1.1);
        int beltsFree = students / 6;

        double priceTotal = lightsabersCount * lightsaberPrice + students * robePrice + (students - beltsFree) * beltPrice;

        if ( budget >= priceTotal) {
            System.out.printf("The money is enough - it would cost %.2flv.", priceTotal);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", priceTotal - budget);
        }
    }
}
