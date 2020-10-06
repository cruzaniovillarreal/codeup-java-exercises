package shapes;

public class Circle {
    private double radius;
    private static int counter = 0;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * (Math.pow(this.radius, 2));
    };

    public double getCircumference() {
        return 2*Math.PI*this.radius;
    };

    public static int countGetter() {
        return counter;
    };

    public static void countSetter() {
        counter = counter+1;
    };
}
