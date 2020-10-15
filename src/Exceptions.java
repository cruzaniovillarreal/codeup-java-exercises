import util.Input;

public class Exceptions {


    public static String size(String animal) throws Exception {
        switch (animal) {
            case "dog":
                return "medium";
            case "cat":
                return "small";
            case "horse":
            case "pig":
                return "large";
            default:
                throw new IllegalArgumentException("unknown animal");
        }
    }

    public static void main(String[] args) throws Exception {
        String[] animals = {"cat", "dog", "horse", "pig", "chicken"};
        //Array out of Bounds Exception
        try {
            System.out.println(animals[200]);
        } catch (ArrayIndexOutOfBoundsException aibex) {
            System.out.println("ArrayIndexOutOfBoundsException");
            System.out.println(aibex);
        }

        //Number Format Exception
        try {
            int numHello = new Integer("hello");
            int nameInt = new Input().getInt("Enter your name: ");
            System.out.println(nameInt);
        } catch (Exception ex) {
            System.out.println("General Exception");
        }

        //Illegal Argument
        try {
            for (String animal : animals) {
                System.out.printf("%s", size(animal));
            }
            //Arithmetic Exception
            int num = 1 / 0;
        } catch (IllegalArgumentException iae) {
            System.out.println("Unknown Animal");
            System.out.println("continuing to Math...");
        }



        //Null Pointer Exception
//        if (hello.equals("hello"))
//            System.out.println("Hello!");


    }
}
