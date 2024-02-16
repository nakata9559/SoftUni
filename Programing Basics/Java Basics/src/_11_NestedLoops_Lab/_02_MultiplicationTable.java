package _11_NestedLoops_Lab;

public class _02_MultiplicationTable {
    public static void main(String[] args) {


        /*int num1 = 1;
        int num2 = 1;

        while (num1 <= 10) {

            while (num2 <= 10) {

                int result = num1 * num2;
                System.out.println(num1 + " * " + num2 + " = " + result);
                num2++;
            }
            num1++;
            num2 = 1;
        }*/

        for (int num1 = 1; num1 <= 10; num1++) {
            for (int num2 = 1; num2 <= 10; num2++) {
                int result = num1 * num2;
                System.out.println(num1 + " * " + num2 + " = " + result);
            }
        }
    }
}
