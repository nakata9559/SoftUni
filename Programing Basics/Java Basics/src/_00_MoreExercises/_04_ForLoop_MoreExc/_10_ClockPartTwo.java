package _00_MoreExercises._04_ForLoop_MoreExc;

public class _10_ClockPartTwo {
    public static void main(String[] args) {

        int seconds = 60;
        int minutes = 60;
        int hours = 24;

        for (int i = 0; i < hours; i++) {
            for (int j = 0; j < minutes; j++) {
                for (int k = 0; k < seconds; k++) {
                System.out.println(i + " : " + j + " : " + k);
                }
            }
        }
    }
}