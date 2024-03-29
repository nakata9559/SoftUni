package _06_Inheritance_Exc._03_PlayersAndMonsters;

public class Main {
    public static void main(String[] args) {
        MuseElf museElf = new MuseElf("Gosho", 70);
        SoulMaster soulMaster = new SoulMaster("Pesho", 80);
        BladeKnight bladeKnight = new BladeKnight("Stamat", 255);

        System.out.println(museElf);
        System.out.println(soulMaster);
        System.out.println(bladeKnight);
    }
}
