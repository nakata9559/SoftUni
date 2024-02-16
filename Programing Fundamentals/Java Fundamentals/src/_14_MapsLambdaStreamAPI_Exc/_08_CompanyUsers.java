package _14_MapsLambdaStreamAPI_Exc;

import java.util.*;

public class _08_CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, List<String>> companyData = new LinkedHashMap<>();

        while (true) {
            String[] input = scanner.nextLine().split(" -> ");
            if (input[0].equals("End")) {
                break;
            }

            String company = input[0];
            String employeeID = input[1];

            if (!companyData.containsKey(company)) {
                companyData.put(company, new ArrayList<>());
                companyData.get(company).add(employeeID);
            } else {
                if (!companyData.get(company).contains(employeeID)) {
                    companyData.get(company).add(employeeID);
                }
            }
        }

        for (Map.Entry<String, List<String>> entry : companyData.entrySet()) {
            System.out.printf("%s%n-- %s%n",
                    entry.getKey(),
                    String.join("\n-- ", entry.getValue()));
        }
    }
}
