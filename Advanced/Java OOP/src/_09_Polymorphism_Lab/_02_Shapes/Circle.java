package _09_Polymorphism_Lab._02_Shapes;

public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
        this.calculateArea();
        this.calculatePerimeter();
    }

    public final Double getRadius() {
        return this.radius;
    }

    @Override
    public void calculatePerimeter() {
        this.setPerimeter(Math.PI * Math.pow(this.getRadius(), 2));
    }

    @Override
    public void calculateArea() {
        this.setArea(2 * Math.PI * this.getRadius());
    }
}
