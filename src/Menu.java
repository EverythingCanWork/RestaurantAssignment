
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private ArrayList<String> foods;
    private ArrayList<Integer> prices;
    Scanner scanner = new Scanner(System.in);
    public Menu(){
        foods = new ArrayList<>();
        prices = new ArrayList<>();

        foods.add("Carbonara");
        prices.add(120);

        foods.add("Bread sticks");
        prices.add(0);

    }
    public void addDish(){
        System.out.println("Enter a dish to add:");
        String newDish = scanner.nextLine();
        foods.add(newDish);
        System.out.println("enter a price for the new dish");
        int newPrice = scanner.nextInt();
        scanner.nextLine();
        prices.add(newPrice);
        System.out.printf("You have added the new dish %s for the price of %s kr\n", newDish, newPrice);
    }
    public void removeDish(){
        System.out.println("which menu item do you wish to remove?");
        showMenu();
        int removeIndex = scanner.nextInt() - 1;
        foods.remove(removeIndex);
        prices.remove(removeIndex);
    }

    public void showMenu(){
        for (int i = 0; i < foods.size(); i++){
            System.out.println((i + 1) + ". " + foods.get(i) + ": " + prices.get(i) + "kr");
        }
    }



    public String getFoods(int order) {

        return foods.get(order);

    }
    public int getPrices(int order){
        return prices.get(order);
    }
}

