package _08_InterfacesAndAbstraction_Exc._06_MilitaryElite.soldier.privatE.specialisedSoldier;

public class Mission {
    private String codeName;
    private String state;

    public Mission(String codeName, String state) {
        this.codeName = codeName;
        this.state = state;
    }

    public void finish() {
        this.state = "finished";
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s",
                this.codeName,
                this.state);
    }
}
