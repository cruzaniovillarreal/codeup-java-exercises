public class MethodsExercises {

    public static int additionMethod(int num1, int num2) {
        return num1 + num2;
    }

    public static int subtractionMethod(int num1, int num2) {
        return num1 - num2;
    }

    public static int multiplicationMethod(int num1, int num2) {
        return num1 * num2;
    }

    public static long multiplicationLoop(long base, long mult) {
            if (mult == 0) {
                return 0;
            } else if (mult == 1) {
                return base;
            } else if (mult == 2) {
                return base + base;
            }
            return base + multiplicationLoop(base, mult - 1);
    }

    public static float divisionMethod(float num1, float num2) {
        return num1 / num2;
    }

    public static int modulusMethod(int num1, int num2) {
        return num1 % num2;
    }

    public static void main(String[] args) {
        System.out.println(additionMethod(5, 7));
        System.out.println(subtractionMethod(5, 7));
        System.out.println(multiplicationMethod(5, 7));
        System.out.println(multiplicationLoop(5, 7));
        System.out.println(divisionMethod(5, 7));
        System.out.println(modulusMethod(5, 7));
    }

    //    public static void multiplicationLoop(int num1, int times) {
//        if (times <= 0) {
//            System.out.println("Done!");
//            return;
//        }
//        num1 += num1;
//        System.out.println(num1);
//        multiplicationLoop(num1, times - 1);
//    }
}
