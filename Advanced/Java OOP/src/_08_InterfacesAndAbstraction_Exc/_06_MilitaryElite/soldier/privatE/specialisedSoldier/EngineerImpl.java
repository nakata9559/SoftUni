package _08_InterfacesAndAbstraction_Exc._06_MilitaryElite.soldier.privatE.specialisedSoldier;

import _08_InterfacesAndAbstraction_Exc._06_MilitaryElite.soldier.privatE.SpecialisedSoldierImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private Collection<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, String corps, String... repairs) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList<>();
        setRepairs(repairs);
    }

    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public Collection<Repair> getRepairs() {
        return Collections.unmodifiableCollection(this.repairs);
    }

    @Override
    public String toString() {
        if (this.getRepairs().isEmpty()) {
            return super.toString() + System.lineSeparator() +
                    "Repairs:";
        }
        return super.toString() + System.lineSeparator() +
                "Repairs:" + System.lineSeparator() +
                "  " + String.join(System.lineSeparator() + "  ", this.getRepairs().stream()
                .map(String::valueOf)
                .toArray(String[]::new))
                        .trim();
    }

    private void setRepairs(String... repairs) {
        for (int i = 0; i < repairs.length; i += 2) {
            String partName = repairs[i];
            int hoursWorked = Integer.parseInt(repairs[i + 1]);
            addRepair(new Repair(partName, hoursWorked));
        }
    }
}
