package shapes;
import shapes.Rectangle;

class Square extends Rectangle {
    public Square(int side) {
        super(side, side);
    }

    public int getPerimeter() {
        System.out.println("Using Square Perimeter Override!");
        return 4 * this.length;
    }

    public int getArea() {
        System.out.println("Using Square Area Override!");
        return (int)Math.pow(this.length, 2);
    }
}


