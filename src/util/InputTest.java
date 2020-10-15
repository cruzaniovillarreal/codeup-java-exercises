package util;

import java.util.Scanner;

public class InputTest {

    public static void main(String[] args) {
        Input newScanner = new Input();
        System.out.println(newScanner.getInt(1, 10, "Give me an integer between 1 and 10: "));
        System.out.println(newScanner.getInt("Give me an integer: "));
        System.out.println(newScanner.getDouble(10, 20, "Give me a decimal number between 10 and 20: "));
        System.out.println(newScanner.getDouble("Give me a decimal number: "));
    }

}
