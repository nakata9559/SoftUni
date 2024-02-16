package _08_ForLoop_Exc;

import java.util.Scanner;

public class _05_Salary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tabs = Integer.parseInt(scanner.nextLine());
        int salary = Integer.parseInt(scanner.nextLine());

        int facebookFee = 150;
        int instagramFee = 100;
        int redditFee = 50;

        for (int i = 0; i < tabs; i++) {

            String website = scanner.nextLine();

            switch (website) {

                case "Facebook":
                    salary -= facebookFee;
                    break;
                case "Instagram":
                    salary -= instagramFee;
                    break;
                case "Reddit":
                    salary -= redditFee;
                    break;
            }
            if (salary <= 0) {
                System.out.println("You have lost your salary.");
                break;
            }
        }
         if (salary > 0) {
            System.out.println(salary);
        }
    }
}
