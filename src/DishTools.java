import java.sql.SQLOutput;

public class DishTools {

    public static final int AVERAGE_COST_OF_DISH_IN_CENT = 13000;

    public static void shoutDishName(Dish dish) {
        System.out.print(dish.nameOfDish.toUpperCase());
    }

    public static void analyzeDishCost(Dish dish) {
        if (dish.costInCents > AVERAGE_COST_OF_DISH_IN_CENT) {
            System.out.println("\nMore expensive than average");
        } else {
            System.out.println("\nLess expensive than average");
        }
    }

    public static void flipRecommendation(Dish dish) {
        dish.wouldRecommend = !dish.wouldRecommend;
        System.out.println(dish.wouldRecommend);
    }
}
