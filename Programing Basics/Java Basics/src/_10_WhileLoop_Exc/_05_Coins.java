package _10_WhileLoop_Exc;

import java.util.Scanner;

public class _05_Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double change = Double.parseDouble(scanner.nextLine());

        int coins2Leva = 0;
        int coins1Lev = 0;
        int coins50Stotinki = 0;
        int coins20Stotinki = 0;
        int coins10Stotinki = 0;
        int coins5Stotinki = 0;
        int coins2Stotinki = 0;
        int coins1Stotinka = 0;

        while (change > 0) {

            if (change >= 2){
                coins2Leva++;
                change -= 2;

            } else if (change >= 1) {
                coins1Lev++;
                change -= 1;

            } else if (change >= 0.5) {
                coins50Stotinki++;
                change -= 0.5;

            } else if (change >= 0.2) {
                coins20Stotinki++;
                change -= 0.2;

            } else if (change >= 0.1) {
                coins10Stotinki++;
                change -= 0.1;

            } else if (change >= 0.05) {
                coins5Stotinki++;
                change -= 0.05;

            } else if (change >= 0.02) {
                coins2Stotinki++;
                change -= 0.02;

            } else if (change >= 0.01) {
                coins1Stotinka++;
                change -= 0.01;

            }
            change = Math.round(change * 100.0) / 100.0;
        }
        System.out.println(coins2Leva + coins1Lev + coins50Stotinki + coins20Stotinki + coins10Stotinki + coins5Stotinki + coins2Stotinki + coins1Stotinka);
    }
}
