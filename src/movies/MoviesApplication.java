package movies;
import util.Input;
import java.util.Scanner;

public class MoviesApplication {
    public static void main(String[] args) {
        boolean toContinue;
        do {
            Input scanner = new Input();
            int answer = scanner.getInt("What would you like to do?\n\n" +
                    "0 - exit\n" +
                    "1 - view all movies\n" +
                    "2 - view movies in the animated category\n" +
                    "3 - view movies in the drama category\n" +
                    "4 - view movies in the horror category\n" +
                    "5 - view movies in the scifi category\n" +
                    "6 - add new movie\n\n" +
                    "Enter your choice: ");
            switch (answer) {
                case 1:
                    for (Movie movie : MoviesArray.findAll()) {
                        System.out.println(movie.nameGetter() + " - " + movie.categoryGetter());
                    }
                    break;
                case 2:
                    for (Movie movie : MoviesArray.findAll()) {
                        if (movie.categoryGetter().equalsIgnoreCase("animated")) {
                            System.out.println(movie.nameGetter());
                        }
                    }
                    break;
                case 3:
                    for (Movie movie : MoviesArray.findAll()) {
                        if (movie.categoryGetter().equalsIgnoreCase("drama")) {
                            System.out.println(movie.nameGetter());
                        }
                    }
                    break;
                case 4:
                    for (Movie movie : MoviesArray.findAll()) {
                        if (movie.categoryGetter().equalsIgnoreCase("horror")) {
                            System.out.println(movie.nameGetter());
                        }
                    }
                    break;
                case 5:
                    for (Movie movie : MoviesArray.findAll()) {
                        if (movie.categoryGetter().equalsIgnoreCase("scifi")) {
                            System.out.println(movie.nameGetter());
                        }
                    }
                    break;
                case 6:
                    String name = new Input().getString("Enter name of movie: ");
                    String category = new Input().getString("Enter category of movie: ");
                    Movie addToArray = new Movie(name, category);
                    Movie[] newList = MoviesArray.addMovie(MoviesArray.findAll(), addToArray);
                    for (Movie movie : newList) {
                        System.out.println(movie.nameGetter() + " - " + movie.categoryGetter());
                    }
                    break;
                default:
                    break;
            }
//            Input proceed = new Input();
//            toContinue = proceed.yesNo("Return to directory? [y/N]");
            toContinue = new Input().yesNo("Return to directory? [y/N]");
        } while(toContinue);
    }
}
