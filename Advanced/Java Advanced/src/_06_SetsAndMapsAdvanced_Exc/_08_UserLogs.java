package _06_SetsAndMapsAdvanced_Exc;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class _08_UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Map<String, Map<String, Integer>> userData = new TreeMap<>();
        
        String[] tokens = scanner.nextLine().split("\\s+");
        
        while (!"end".equals(tokens[0])) {
            String IPAddress = tokens[0].split("=")[1];
            String user = tokens[2].split("=")[1];
            
            userData.putIfAbsent(user, new LinkedHashMap<>());
            userData.get(user).putIfAbsent(IPAddress, 0);
            userData.get(user).put(IPAddress, userData.get(user).get(IPAddress) + 1);
            
            tokens = scanner.nextLine().split("\\s+");
        }
        
        userData.forEach((k1, v1) -> {
            System.out.println(k1 + ": ");
            AtomicInteger currentSize = new AtomicInteger(0);

            v1.forEach((k2, v2) -> {
                if (currentSize.getAndIncrement() < v1.size() - 1) {
                    System.out.print(k2 + " => " + v2 + ", ");
                } else {
                    System.out.println(k2 + " => " + v2 + ".");
                }
            });
        });
    }
}
