package _08_ForLoop_Exc;

import java.util.Scanner;

public class _03_Histogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int count = 0;
        int nums1 = 0;
        int nums2 = 0;
        int nums3 = 0;
        int nums4 = 0;
        int nums5 = 0;

        for (int i = 0; i < n; i++) {

            int num = Integer.parseInt(scanner.nextLine());
            count += 1;

            if (1 <= num && num < 200) {
                nums1++;
            } else if (num < 400) {
                nums2++;
            } else if (num < 600) {
                nums3++;
            } else if (num < 800) {
                nums4++;
            } else {
                nums5++;
            }
        }

        double p1 = 1.0 * nums1 / count * 100;
        double p2 = 1.0 * nums2 / count * 100;
        double p3 = 1.0 * nums3 / count * 100;
        double p4 = 1.0 * nums4 / count * 100;
        double p5 = 1.0 * nums5 / count * 100;

        System.out.printf("%.2f%%%n%.2f%%%n%.2f%%%n%.2f%%%n%.2f%%", p1, p2, p3, p4, p5);
    }
}
