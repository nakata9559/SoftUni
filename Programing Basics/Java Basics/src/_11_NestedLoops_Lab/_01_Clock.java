package _11_NestedLoops_Lab;

public class _01_Clock {
    public static void main(String[] args) {

        int hours = 0;
        int minutes = 0;

        while (hours < 24) {

            while (minutes < 60){
                System.out.println(hours + ":" + minutes);

                //System.out.printf("%d:%02d%n",hours, minutes); //За 2 цифри в минутите

                minutes++;
            }
            minutes = 0;
            hours++;
        }
    }
}
