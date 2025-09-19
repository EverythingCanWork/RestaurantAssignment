import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        System.out.println("\nWelcome to the restaurant!");
        restaurant.displayRoleMenu(Restaurant.Role.startMenu);
        mainloop:
        while(true){
            int choice = InputHandler.getIntInput();

            switch (choice){
                case 1:
                    if (restaurant.open){
                        restaurant.customerMenu();
                    }
                    else{
                        System.out.println("Restaurant is currently closed, Please wait for Staff or Admin to open the restaurant.");
                    }
                    break;
                case 2:
                    restaurant.staffMenu();
                    break;
                case 3:
                    restaurant.adminMenu();
                    break;
                case 4:
                    restaurant.displayRoleMenu(Restaurant.Role.startMenu);
                    break;
                case 5:
                    break mainloop;
                default:
                    System.out.println("Please select a valid option");
                    break;
            }
        }
    }
  }