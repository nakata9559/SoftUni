package _08_ForLoop_Exc;

public class _01_NumbersEndingInSeven {
    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {

            if (i % 10 == 7) {
                System.out.println(i);
            }
        }
    }
}
