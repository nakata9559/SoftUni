package _14_Workshop_Exc;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.addFirst(1);
        doublyLinkedList.addFirst(2);
        doublyLinkedList.addFirst(3);
        doublyLinkedList.addFirst(4);
        doublyLinkedList.addLast(5);
        doublyLinkedList.addLast(6);
        doublyLinkedList.addLast(7);
        doublyLinkedList.addLast(8);

        int[] arr = doublyLinkedList.toArray();

        System.out.println(String.join(" ", Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .toArray(String[]::new)));

        doublyLinkedList.forEach(System.out::print);
    }
}
