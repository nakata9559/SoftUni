package _00_MoreExercises._05_WhileLoop_MoreExc;

public class _04_NumbersDividedByThreeWithoutReminder {
    public static void main(String[] args) {

        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                System.out.println(i);
            }
        }
    }
}
