import java.util.HashMap;

public class Kitchen {
    private final HashMap<String, Integer> availableIngredients;
    private HashMap<String, Integer> ingredientsRequiered;

    public Kitchen() {
        availableIngredients = new HashMap<>();
        ingredientsRequiered = new HashMap<>();

        availableIngredients.put("Egg", 2);
        availableIngredients.put("Cheese", 1);
        availableIngredients.put("Spaghetti", 1);
    }


    public void addAvailableIngredients(String ingredient, Integer quantity){
        availableIngredients.put(ingredient, availableIngredients.getOrDefault(ingredient, 0) + quantity);
    }
    public boolean checkRequiredIngredientsStock(Dish orderedFood){
        HashMap<String, Integer> ingredientsRequired = orderedFood.getIngredientsRequired();

        for (String ingredient : ingredientsRequired.keySet()) {
            int requiredAmount = ingredientsRequired.get(ingredient);
            int availableAmount = availableIngredients.getOrDefault(ingredient, 0);

            if (requiredAmount > availableAmount) {
                return false;
            }
        }
        return true;
    }
    public boolean cook(Dish orderedFood) {
        HashMap<String, Integer> ingredientsRequired = orderedFood.getIngredientsRequired();
        if(checkRequiredIngredientsStock(orderedFood)) {
            for (String ingredient : ingredientsRequired.keySet()) {
                int requiredAmount = ingredientsRequired.get(ingredient);
                int availableAmount = availableIngredients.getOrDefault(ingredient, 0);
                availableIngredients.put(ingredient, availableAmount - requiredAmount);
            }
            return true;
        }else {
            System.out.println("Out of ingredients");
        }
        return false;
    }
}
