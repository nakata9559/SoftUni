package _07_InterfacesAndAbstraction_Lab._06_Ferrari;

public class Ferrari implements Car{
    private final String MODEL = "488-Spider";
    private String driverName;
    private String model;

    public Ferrari(String driverName) {
        this.driverName = driverName;
        this.model = MODEL;
    }



    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "brum-brum-brum-brrrrr";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s",
                this.model,
                this.brakes(),
                this.gas(),
                this.driverName);
    }
}
