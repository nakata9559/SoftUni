package _08_InterfacesAndAbstraction_Exc._06_MilitaryElite;

import _08_InterfacesAndAbstraction_Exc._06_MilitaryElite.soldier.Private;
import _08_InterfacesAndAbstraction_Exc._06_MilitaryElite.soldier.PrivateImpl;
import _08_InterfacesAndAbstraction_Exc._06_MilitaryElite.soldier.SpyImpl;
import _08_InterfacesAndAbstraction_Exc._06_MilitaryElite.soldier.privatE.LieutenantGeneralImpl;
import _08_InterfacesAndAbstraction_Exc._06_MilitaryElite.soldier.privatE.specialisedSoldier.CommandoImpl;
import _08_InterfacesAndAbstraction_Exc._06_MilitaryElite.soldier.privatE.specialisedSoldier.EngineerImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Soldier> soldiers = new ArrayList<>();
        List<Private> privates = new ArrayList<>();

        String[] input = scanner.nextLine().split("\\s+");

        while (!"End".equals(input[0])) {
            String rank = input[0];
            int id = Integer.parseInt(input[1]);
            String firstName = input[2];
            String lastName = input[3];
            double salary;

            switch (rank) {
                case "Private":
                    salary = Double.parseDouble(input[4]);
                    PrivateImpl aPrivate = new PrivateImpl(id, firstName, lastName, salary);
                    privates.add(aPrivate);
                    soldiers.add(aPrivate);
                    break;

                case "LieutenantGeneral":
                    salary = Double.parseDouble(input[4]);
                    List<Integer> ids = new ArrayList<>();

                    for (int i = 5; i < input.length; i++) {
                        ids.add(Integer.parseInt(input[i]));
                    }

                    LieutenantGeneralImpl lieutenantGeneral = new LieutenantGeneralImpl(id, firstName, lastName, salary);
                    for (int currentId : ids) {
                        privates.stream()
                                .filter(e -> e.getId() == currentId)
                                .forEach(lieutenantGeneral::addPrivate);
                    }
                    soldiers.add(lieutenantGeneral);
                    break;

                case "Engineer":
                    salary = Double.parseDouble(input[4]);
                    String corps1 = input[5];
                    String[] repairs = new String[input.length - 6];

                    for (int i = 6; i < input.length; i++) {
                        repairs[i - 6] = input[i];
                    }
                    try {
                        EngineerImpl engineer = new EngineerImpl(id, firstName, lastName, salary, corps1, repairs);
                        soldiers.add(engineer);
                    } catch (IllegalArgumentException ignored) {}
                    break;

                case "Commando":
                    salary = Double.parseDouble(input[4]);
                    String corps2 = input[5];
                    String[] missions = new String[input.length - 6];

                    for (int i = 6; i < input.length; i++) {
                        missions[i - 6] = input[i];
                    }
                    try {
                        CommandoImpl commando = new CommandoImpl(id, firstName, lastName, salary, corps2, missions);
                        soldiers.add(commando);
                    } catch (IllegalArgumentException ignored) {}
                    break;

                case "Spy":
                    String codeNumber = input[4];
                    SpyImpl spy = new SpyImpl(id, firstName, lastName, codeNumber);
                    soldiers.add(spy);
                    break;
            }

            input = scanner.nextLine().split("\\s+");
        }

        soldiers.forEach(System.out::println);
    }
}
