package shapes;
import util.Input;

public class CircleApp {

    public static void main(String[] args) {
        Input userInputForRadius = new Input();
        do {
            Circle newCircle = new Circle(userInputForRadius.getDouble(1, 100, "Enter radius 1-100: "));
            Circle.countSetter();
            System.out.println("The area of the circle is: "+newCircle.getArea());
            System.out.println("The circumference of the circle is: "+newCircle.getCircumference());
        } while (userInputForRadius.yesNo("\nCreate another circle?"));
        System.out.print("You created: "+Circle.countGetter()+" circles");
    }
}
