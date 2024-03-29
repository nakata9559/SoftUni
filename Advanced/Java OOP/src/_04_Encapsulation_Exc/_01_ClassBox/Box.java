package _04_Encapsulation_Exc._01_ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    public double calculateSurfaceArea() {
        return 2 * (this.length  * this.width +
                this.length * this.height +
                this.width * this.height);
    }

    public double calculateLateralSurfaceArea() {
        return 2 * (this.length + this.width) * this.height;
    }

    public double calculateVolume() {
        return this.length * this.width * this.height;
    }

    private void setLength(double length) {
        dataValidation("Length", length);
        this.length = length;
    }

    private void setWidth(double width) {
        dataValidation("Width", width);
        this.width = width;
    }

    private void setHeight(double height) {
        dataValidation("Height", height);
        this.height = height;
    }

    private void dataValidation(String side, double value) {
        if (value <= 0) {
            throw new IllegalArgumentException(side + " cannot be zero or negative");
        }
    }
}
