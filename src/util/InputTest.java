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
    }

}
