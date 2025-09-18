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

    public boolean cook(Dish orderedFood) {
        HashMap<String, Integer> ingredientsRequired = orderedFood.getIngredientsRequired();
        boolean missingIngredients = false;
        for (String ingredient : ingredientsRequired.keySet()) {
            int requiredAmount = ingredientsRequired.get(ingredient);
            int availableAmount = availableIngredients.getOrDefault(ingredient, 0);

            if (requiredAmount > availableAmount) {
                System.out.printf("\nWe are missing %s\n", ingredient);
                System.out.printf("We have %s %s we require %s", availableAmount, ingredient, requiredAmount);
                missingIngredients = true;
            }
        }
        if(missingIngredients){
            return false;
        }

        for (String ingredient : ingredientsRequired.keySet()){
            int requiredAmount = ingredientsRequired.get(ingredient);
            int availableAmount = availableIngredients.getOrDefault(ingredient, 0);
            availableIngredients.put(ingredient, availableAmount - requiredAmount);
        }

        //System.out.printf("\nThe kitchen has made %s for you", orderedFood.getDishName());
        return true;
    }
}
