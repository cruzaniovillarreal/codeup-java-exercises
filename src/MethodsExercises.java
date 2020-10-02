import java.util.Scanner;
import java.util.Arrays;
public class MethodsExercises {

//    public static int additionMethod(int num1, int num2) {
//        return num1 + num2;
//    }
//
//    public static int subtractionMethod(int num1, int num2) {
//        return num1 - num2;
//    }
//
//    public static int multiplicationMethod(int num1, int num2) {
//        return num1 * num2;
//    }
//
//    public static long multiplicationLoop(long base, long mult) {
//            if (mult == 0) {
//                return 0;
//            } else if (mult == 1) {
//                return base;
//            } else if (mult == 2) {
//                return base + base;
//            }
//            return base + multiplicationLoop(base, mult - 1);
//    }
//
//    public static float divisionMethod(float num1, float num2) {
//        return num1 / num2;
//    }
//
//    public static int modulusMethod(int num1, int num2) {
//        return num1 % num2;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(additionMethod(5, 7));
//        System.out.println(subtractionMethod(5, 7));
//        System.out.println(multiplicationMethod(5, 7));
//        System.out.println(multiplicationLoop(5, 7));
//        System.out.println(divisionMethod(5, 7));
//        System.out.println(modulusMethod(5, 7));
//    }

    //    public static void multiplicationLoop(int num1, int times) {
//        if (times <= 0) {
//            System.out.println("Done!");
//            return;
//        }
//        num1 += num1;
//        System.out.println(num1);
//        multiplicationLoop(num1, times - 1);
//    }

//    public static int getInteger(int min, int max) {
//        System.out.printf("Enter a number between %s and %s: ", min, max);
//        Scanner newNumber = new Scanner(System.in);
//        int userNumber = newNumber.nextInt();
//
//        if (userNumber >= min && userNumber <= max) {
//            System.out.printf("You're In! %s is between %s and %s \n", userNumber, min, max);
//            return userNumber;
//        } else {
//            System.out.printf("Sorry! %s is not between %s and %s \n", userNumber, min, max);
//            return getInteger(min, max);
//        }
//    }
//
//    public static void main(String[] args) {
//        int userInput = (getInteger(1, 10));
//        System.out.println("User Entered: " + userInput);
//    }


//    public static long recursiveFactorial(long n) {
//        if (n <= 1)
//            return 1;
//        else
//            return n * recursiveFactorial(n - 1);
//    }

//    public static long factorialUsingForLoop() {
//        String userConfirm;
//        long fact;
//        do {
//            System.out.print("Enter a number between 1 and 20: ");
//            Scanner newNumber = new Scanner(System.in);
//            int userNumber = newNumber.nextInt();
//            if (userNumber >= 1 && userNumber <= 20) {
//                System.out.println("Calculating: " + userNumber + "!");
//                fact = recursiveFactorial(userNumber);
////                for loop
////                fact = 1;
////                for (int i = 2; i <= userNumber; i++) {
////                    fact = fact * i;
////                }
//                System.out.println(fact + " has been stored in the variable.");
//                System.out.println("Would you like to calculate the factorial of a new number? [y/N]");
//                Scanner newConfirm = new Scanner(System.in);
//                userConfirm = newConfirm.nextLine();
//            } else {
//                return factorialUsingForLoop();
//            }
//        } while (userConfirm.equalsIgnoreCase("y"));
//        return fact;
//    }
//
//    public static void main(String[] args) {
//        long whateverWeWannaCallIt = (factorialUsingForLoop());
//        System.out.println(whateverWeWannaCallIt);
//    }
//
//

//    public static int randomizer(int min, int max) {
//        int range = (max - min) + 1;
//        return (int) (Math.random() * range) + min;
//    }
//    public static void results(int die1, int die2) {
//        int dieResult1 = randomizer(1, die1);
//        int dieResult2 = randomizer(1, die2);
////        String combinedResults = "Die 1 result: "+dieResult1+"\nDie 2 result: "+dieResult2;
//        System.out.println("Die 1 result: "+dieResult1);
//        System.out.println("Die 2 result: "+dieResult2);
//        System.out.println("Roll again? [y/N]");
//        Scanner toRollAgain = new Scanner(System.in);
//        String rollAgain = toRollAgain.nextLine();
//        if (rollAgain.equalsIgnoreCase("y")) {
//            results(die1, die2);
//        } else {
//            System.out.println("Would you like to pick new die? [y/N]");
//            if (toRollAgain.nextLine().equalsIgnoreCase("y")) {
//                dice();
//            }
//        }
//    }
//    public static void dice() {
//        Scanner userInput = new Scanner(System.in);
//        System.out.print("Enter number of sides for Die 1: ");
//        int die1 = userInput.nextInt();
//        System.out.print("Enter number of sides for Die 2: ");
//        int die2 = userInput.nextInt();
//        System.out.print("Type 'roll' to roll the dice: ");
//        userInput.nextLine();
//        String answerToRoll = userInput.nextLine();
//        if (answerToRoll.isEmpty() || !answerToRoll.equalsIgnoreCase("roll")) {
//            dice();
//        } else {
//            results(die1, die2);
//        }
//    }
//
//    public static void main(String[] args) {
//        dice();
//    }



    public static int randomDiceNum(int numMax) {
        //Defining method for a random number generator
        int numMin = 1;
        int range = (numMax - numMin) + 1;
        return (int) (Math.random() * range) + numMin;
    };

    public static int setDice(int n) {
        return randomDiceNum(n);
    };

    public static int [] reroll(int one, int two) {
        Scanner reroller = new Scanner(System.in);
        int random1 = setDice(one);
        int random2 = setDice(two);
        int [] toReturn = {random1, random2};
        System.out.println("Your random dice roll is [" +random1+", "+random2+"]");
        System.out.println("Would you like to continue?[y/n]");
        String toContinue = reroller.nextLine();
        if(toContinue.equalsIgnoreCase("y")) {
            return reroll(one, two);
        } else {
            return toReturn;
        }
    }

    public static int[] rollDice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of sides for a pair of dice.");
        int sideOne = scanner.nextInt();
        int sideTwo = scanner.nextInt();
        int[] numbers = {setDice(sideOne), setDice(sideTwo)};
        int[] rerolledNumbers= {0, 0};
        System.out.println("Your random dice roll is " + Arrays.toString(numbers) + ". Would you like to continue?[y/n]");
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("y")) {
            rerolledNumbers = reroll(sideOne, sideTwo);
            return rerolledNumbers;
        } else {
            return numbers;
        }
    };

    public static void main(String[] args) {
        int[] randomRoll = rollDice();
        System.out.println(Arrays.toString(randomRoll));
    }
}