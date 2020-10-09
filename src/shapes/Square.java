package shapes;
import shapes.Rectangle;

public class Square extends Quadrilateral {

    public Square(int side) {
        super(side, side);
    }

    @Override
    public void setLength(int side) {
            this.length = side;
            this.width = side;
    }

    @Override
    public void setWidth(int side) {
        this.length = side;
        this.width = side;
    }

    @Override
    public double getPerimeter() {
        System.out.println("Using Square Override");
        return (4*this.length);
    }

    @Override
    public double getArea() {
        System.out.println("Using Square Override");
        return (Math.pow(this.length, 2));
    }
}


