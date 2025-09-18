import java.util.HashMap;


public class Dish {

    private final String dishName;
    private final int dishPrice;
    private final HashMap<String, Integer> ingredientsRequired;

    public Dish(String dishName, int dishPrice, HashMap<String, Integer> ingredientsRequired) {
        this.dishName = dishName;
        this.dishPrice = dishPrice;
        this.ingredientsRequired = ingredientsRequired;

    }
    public String getDishName() {
        return dishName;
    }

    public int getDishPrice() {
        return dishPrice;
    }

    public HashMap<String, Integer> getIngredientsRequired() {
        return ingredientsRequired;
    }
}

