package _08_InterfacesAndAbstraction_Exc._06_MilitaryElite.soldier.privatE;

import _08_InterfacesAndAbstraction_Exc._06_MilitaryElite.soldier.Private;
import _08_InterfacesAndAbstraction_Exc._06_MilitaryElite.soldier.PrivateImpl;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral{
    private Set<Private> privateSet;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privateSet = new TreeSet<>(Collections.reverseOrder(Comparator.comparing(Private::getId)));
    }

    public void addPrivate(Private priv) {
        this.privateSet.add(priv);
    }

    @Override
    public Set<Private> getPrivate() {
        return this.privateSet;
    }

    @Override
    public String toString() {
        if (this.getPrivate().isEmpty()) {
            return super.toString() + System.lineSeparator() +
                    "Privates:";
        }
        return super.toString() + System.lineSeparator() +
                "Privates:" + System.lineSeparator() +
                "  " + String.join(System.lineSeparator() + "  ", this.getPrivate().stream()
                        .map(String::valueOf)
                        .toArray(String[]::new))
                .trim();
    }
}
