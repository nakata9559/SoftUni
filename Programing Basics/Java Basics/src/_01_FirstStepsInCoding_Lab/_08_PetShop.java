package _01_FirstStepsInCoding_Lab;

import java.util.Scanner;

public class _08_PetShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int DogFood = Integer.parseInt(scanner.nextLine());
        int CatFood = Integer.parseInt(scanner.nextLine());
        double Sum = (DogFood * 2.5) + (CatFood * 4);
        System.out.println(Sum + " lv.");
    }
}
