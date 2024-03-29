package _09_Polymorphism_Lab._02_Shapes;

public class Rectangle extends Shape {
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
        this.calculateArea();
        this.calculatePerimeter();
    }

    public final Double getHeight() {
        return this.height;
    }

    public final Double getWidth() {
        return this.width;
    }

    @Override
    public void calculatePerimeter() {
        this.setPerimeter(2 * this.getHeight() + 2 * this.getWidth());
    }

    @Override
    public void calculateArea() {
        this.setArea(this.getHeight() * this.getWidth());
    }
}
