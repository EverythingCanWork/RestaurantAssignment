import java.util.ArrayList;
import java.util.HashMap;

public class Kitchen {
    private HashMap<String, Integer> ingredients;

    public Kitchen() {
        ingredients = new HashMap<>();

    }




    public void cook(String food) {
        System.out.printf("The kitchen has made %s for you", food);
    }
}
