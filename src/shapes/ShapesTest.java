package shapes;

import org.w3c.dom.css.Rect;

public class ShapesTest {
    public static void main(String[] args) {

        Measurable myShape10 = new Measurable() {
            @Override
            public double getPerimeter() {
                return 0;
            }

            @Override
            public double getArea() {
                return 0;
            }
        };

        Measurable myShape = new Square(5);
        System.out.println(myShape.getPerimeter());
        System.out.println(myShape.getArea());
        ((Square) myShape).setLength(4);
        System.out.println(myShape.getPerimeter());
        System.out.println(myShape.getArea());

        Measurable myShape1 = new Rectangle(5, 10);
        System.out.println(myShape1.getPerimeter());
        System.out.println(myShape1.getArea());
        ((Rectangle) myShape1).setLength(4);
        ((Rectangle) myShape1).setWidth(5);
        System.out.println(myShape1.getPerimeter());
        System.out.println(myShape1.getArea());
        System.out.println(((Rectangle) myShape1).getLength());
        System.out.println(((Rectangle) myShape1).getWidth());

        Quadrilateral myShape2 = new Quadrilateral(3, 2) {
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
                return (this.length*2)+(this.width*2);
            }

            @Override
            public double getArea() {
                return this.length*this.width;
            }
        };

        System.out.println(myShape2.getPerimeter());
        myShape2.setWidth(3);
        System.out.println(myShape2.getPerimeter());

    }
}
