public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        int myFavoriteNumber;
        myFavoriteNumber = 32;
        System.out.println(myFavoriteNumber);

        String myString;
        myString = "This is my string!";
        System.out.println(myString);

        long myNumber = 123L;
        System.out.println(myNumber);

        float floatNumber = 3.14F;
        System.out.println(floatNumber);

        double anotherNumber = 3.14;
        System.out.println(anotherNumber);

        int x = 5;
        System.out.println(x++);
        System.out.println(x);

        int y = 5;
        System.out.println(++y);
        System.out.println(y);

        String theNumberThree = "three";
        Object o = theNumberThree;
        System.out.println(o);

//        Cannot cast the string "three" to an integer
//        int three = (int) o;

//        Cannot convert int to string "three"
//        int three = (int) "three";

        Object nine = 34 * 2;
        System.out.println(nine);

        x = 4;
        x += 5;
        System.out.println(x);

        x = 3;
        y = 4;
        y *= x;
        System.out.println(y);

        x = 10;
        y = 2;
        x /= y;
        y -= x;
        System.out.println(x);
        System.out.println(y);
    }
}
