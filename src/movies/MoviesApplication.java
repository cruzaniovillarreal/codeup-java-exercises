package movies;
import util.Input;
import java.util.Scanner;

public class MoviesApplication {
    public static void main(String[] args) {
        System.out.println();
        Input scanner = new Input();
        int answer = scanner.getInt("What would you like to do?\n\n" +
                "0 - exit\n" +
                "1 - view all movies\n" +
                "2 - view movies in the animated category\n" +
                "3 - view movies in the drama category\n" +
                "4 - view movies in the horror category\n" +
                "5 - view movies in the scifi category\n\n" +
                "Enter your choice: ");
        switch (answer) {
            case 1:
                for (Movie movie : MoviesArray.findAll()) {
                    System.out.println(movie.nameGetter()+" - "+movie.categoryGetter());
                }
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            default:

                break;
        }
//        if (answer == 1){
//            for (Movie movie : MoviesArray.findAll()) {
//                System.out.println(movie.nameGetter()+" - "+movie.categoryGetter());
//            }
//        } else {
//            System.out.println("Would you like to view our movies by category?");
//        }
    }
}
