import java.util.HashMap;

public class Kitchen {
    private final HashMap<String, Integer> ingredients;

    public Kitchen() {
        ingredients = new HashMap<>();

        ingredients.put("Egg", 10);
        ingredients.put("cheese", 10);
        ingredients.put("Spaghetti", 10);
    }


    public void addAvailableIngredients(String ingredient, Integer quantity){
        ingredients.put(ingredient, ingredients.getOrDefault(ingredient, 0) + quantity);
    }

    public void cook(String food) {
        System.out.printf("\nThe kitchen has made %s for you", food);
    }
}
