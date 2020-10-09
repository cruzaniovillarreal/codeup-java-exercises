package shapes;

public class Rectangle extends Quadrilateral implements Measurable {

    public  Rectangle(int length, int width) {
        super(length, width);
    }

    @Override
    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public double getPerimeter() {
        return (2*this.length + 2*this.width);
    }

    @Override
    public double getArea() {
        return (length*width);
    }

}
