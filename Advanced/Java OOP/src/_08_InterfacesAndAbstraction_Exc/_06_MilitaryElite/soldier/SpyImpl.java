package _08_InterfacesAndAbstraction_Exc._06_MilitaryElite.soldier;

import _08_InterfacesAndAbstraction_Exc._06_MilitaryElite.SoldierImpl;

public class SpyImpl extends SoldierImpl implements Spy{
    private String codeNumber;

    public SpyImpl(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() +
                "Code Number: " + this.getCodeNumber();
    }
}
