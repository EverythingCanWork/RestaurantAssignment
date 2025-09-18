
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {
    private ArrayList<Dish> dishes;
    Scanner scanner = new Scanner(System.in);

    public Menu() {
        dishes = new ArrayList<>();

        // Carbonara
        HashMap<String, Integer> carbonaraIngredients = new HashMap<>();
        carbonaraIngredients.put("Egg", 2);
        carbonaraIngredients.put("Cheese", 1);
        carbonaraIngredients.put("Spaghetti", 1);
        Dish carbonara = new Dish("Carbonara", 120, carbonaraIngredients);


        // Breadsticks
        HashMap<String, Integer> breadsticksIngredients = new HashMap<>();
        breadsticksIngredients.put("Flour", 1);
        breadsticksIngredients.put("Butter", 1);
        Dish breadsticks = new Dish("Breadsticks", 0, breadsticksIngredients);

        // Salad
        HashMap<String, Integer> saladIngredients = new HashMap<>();
        saladIngredients.put("Lettuce", 1);
        saladIngredients.put("Tomato", 1);
        saladIngredients.put("Cucumber", 1);
        saladIngredients.put("Cheese", 1);
        Dish salad = new Dish("Salad", 80, saladIngredients);

        dishes.add(carbonara);
        dishes.add(breadsticks);
        dishes.add(salad);
    }

    public void showMenu() {
        System.out.println("=====MENU=====");
        for (int i = 0; i < dishes.size(); i++) {
            Dish dish = dishes.get(i);
            System.out.println((i + 1) + ". " + dish.getDishName() + ": " + dish.getDishPrice() + "kr");
        }
    }

    public void addDish() {
        System.out.println("Enter a dish to add:");
        String newDish = scanner.nextLine();
        System.out.println("enter a price for the new dish");
        int price = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the number of ingredients");
        int numberOfIngredients = scanner.nextInt();
        scanner.nextLine();
        HashMap<String, Integer> ingredientsRequiered = new HashMap<>();

        for (int i = 0; i < numberOfIngredients; i++) {
            System.out.println("Enter the first ingredient:");
            String ingredient = scanner.nextLine();
            System.out.println("Enter the number of that ingredient:");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            ingredientsRequiered.put(ingredient, quantity);
        }
        Dish newDishObject = new Dish(newDish, price, ingredientsRequiered);
        dishes.add(newDishObject);


    }
    public void removeDish(){
        System.out.println("which menu item do you wish to remove?");
        showMenu();
        int removeIndex = scanner.nextInt() - 1;
        dishes.remove(removeIndex);
    }
    public Dish getFoods(int order) {

        return dishes.get(order);

    }

}




