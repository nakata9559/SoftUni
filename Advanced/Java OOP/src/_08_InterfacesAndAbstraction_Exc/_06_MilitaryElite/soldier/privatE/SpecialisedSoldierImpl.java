package _08_InterfacesAndAbstraction_Exc._06_MilitaryElite.soldier.privatE;

import _08_InterfacesAndAbstraction_Exc._06_MilitaryElite.soldier.PrivateImpl;

import java.util.Arrays;

public abstract class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
    private enum Corps {
        AIRFORCES("Airforces"), MARINES("Marines");

        private String corp;

        Corps (String corp) {
            this.corp = corp;
        }

        public String getCorp() {
            return corp;
        }
    }
    private String corps;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        setCorps(corps);
    }

    @Override
    public String getCorps() {
        return this.corps;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() +
                "Corps: " + this.getCorps();
    }

    private void setCorps(String corps) {
        Corps corp = Arrays.stream(Corps.values())
                .filter(e -> e.getCorp().equals(corps))
                .findAny()
                .orElse(null);

        if (corp == null) {
            throw new IllegalArgumentException("Invalid corps");
        } else {
            this.corps = corps;
        }
    }
}
