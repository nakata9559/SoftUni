package _23_PastExams._2023_08_August_15.handball;

public class HandballPlayer {
    private String name;
    private boolean isActive;

    public HandballPlayer(String name){
        this.setName(name);
        this.setActive(true);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }
}
