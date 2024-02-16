package _00_MoreExercises._04_ForLoop_MoreExc;

public class _09_Clock {
    public static void main(String[] args) {

        int minutes = 60;
        int hours = 24;

        for (int i = 0; i < hours; i++) {
            for (int j = 0; j < minutes; j++) {
                System.out.println(i + " : " + j);
            }
        }
    }
}
