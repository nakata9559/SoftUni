package _08_InterfacesAndAbstraction_Exc._06_MilitaryElite.soldier.privatE.specialisedSoldier;

import _08_InterfacesAndAbstraction_Exc._06_MilitaryElite.soldier.privatE.SpecialisedSoldierImpl;

import java.util.*;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    private Set<Mission> missions;
    private enum MissionStatus {
        INPROGRESS("inProgress"), FINISHED("finished");

        private String status;

        MissionStatus (String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }
    }
    private String missionState;

    public CommandoImpl(int id, String firstName, String lastName, double salary, String corps, String... missions) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new LinkedHashSet<>();
        setMissions(missions);
    }

    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public Collection<Mission> getMissions() {
        return Collections.unmodifiableCollection(this.missions);
    }

    @Override
    public String toString() {
        if (this.getMissions().isEmpty()) {
            return super.toString() + System.lineSeparator() +
                    "Missions:";
        }
        return super.toString() + System.lineSeparator() +
                "Missions:" + System.lineSeparator() +
                "  " + String.join(System.lineSeparator() + "  ", this.getMissions().stream()
                .map(String::valueOf)
                .toArray(String[]::new))
                        .trim();
    }

    public void setMissions(String... missions) {
        for (int i = 0; i < missions.length; i += 2) {
        String codeName = missions[i];
        String state = missions[i + 1];

        Arrays.stream(MissionStatus.values())
                .filter(e -> e.getStatus().equals(state))
                .findAny()
                .ifPresent(state1 -> this.addMission(new Mission(codeName, state)));
        }
    }
}
