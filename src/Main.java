import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        Scanner scanner = new Scanner(System.in);

        mainloop:
        while(true){
            System.out.println("\nWelcome to the restaurant!");
            restaurant.displayRoleMenu(Restaurant.Role.startMenu);
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    if (restaurant.open){
                        restaurant.customerMenu();
                    }
                    else{
                        System.out.println("Restaurant is currently closed, We are open between 10 and 21.");
                    }
                    break;
                case 2:
                    restaurant.staffMenu();
                    break;
                case 3:
                    restaurant.adminMenu();
                    break;
                case 4:
                    break mainloop;


            }


        }
    }
  }
