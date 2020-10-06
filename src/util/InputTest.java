package util;

import java.util.Scanner;

public class InputTest {

    public static void main(String[] args) {
        Input newScanner = new Input();
        System.out.println(newScanner.getString());
        System.out.println(newScanner.yesNo());
        System.out.println(newScanner.getInt(1, 10));
        System.out.println(newScanner.getInt());
        System.out.println(newScanner.getDouble(10.00, 20.00));
        System.out.println(newScanner.getDouble());
        System.out.println(newScanner.getString("Hello from the parameter!"));
        System.out.println(newScanner.yesNo("Yes"));
        System.out.println(newScanner.getInt(1, 10, "Give me an integer between 1 and 10"));
        System.out.println(newScanner.getInt("Give me an integer.."));
        System.out.println(newScanner.getDouble(10.00, 20.00, "Give me a decimal number between 1 and 10"));
        System.out.println(newScanner.getDouble("Give me a decimal number"));
    }

}
