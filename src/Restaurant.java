import java.util.Scanner;

public class Restaurant {
    boolean open = false;
    Scanner scanner = new Scanner(System.in);
    Menu menu = new Menu();
    Kitchen kitchen = new Kitchen();
    Staff staff = new Staff();
    Table[] tables = {
            new Table(1, false),
            new Table(2, false),
            new Table(3, false)
    };

    public enum Role {
        staff,
        admin,
        customer,
        startMenu
    }


    public void displayRoleMenu(Role role){
        switch (role) {
            case staff:
                System.out.println(" ===StaffMenu=== ");
                System.out.println("1. Open/close restaurant");
                System.out.println("2. Add a dish to the menu");
                System.out.println("3. Remove a dish from menu");
                System.out.println("4. View current menu");
                System.out.println("5. Display options again");
                System.out.println("0. Go back");
                break;
            case admin:
                System.out.println(" ===Admin=== ");
                System.out.println("1. View menu");
                System.out.println("2. Add a dish to the menu");
                System.out.println("3. Remove a dish from menu");
                System.out.println("4. View staff");
                System.out.println("5. Fire staff");
                System.out.println("6. Hire staff");
                System.out.println("7. Open/Close restaurant");
                System.out.println("8. Display options again");
                System.out.println("0. Go back");
                break;
            case customer:
                System.out.println(" ===Restaurant=== ");
                System.out.println("1. See The Menu");
                System.out.println("2. Order");

                System.out.println("4. Display options again");
                System.out.println("5. Book a table");
                System.out.println("6. Leave restaurant");
                break;
            case startMenu:
                System.out.println("Please select your role.");
                System.out.println("1. Customer");
                System.out.println("2. Staff");
                System.out.println("3. Admin");
                System.out.println("4. Relist options");
                System.out.println("5. Quit");
                break;
        }

    }
    public void changeRestaurantStatus(){

        if (!open) {
            if (!staff.minimumStaff()){
                System.out.println("You need to have one chef and one server to be able to open the restaurant.\n");
                return;
            } else{
                open = true;
                System.out.println("You have opened the restaurant!\n");
            }
        } else {
            open = false;
            System.out.println("You have closed the restaurant\n");
        }
        displayRoleMenu(Role.staff);
    }
    public void customerMenu() {
        displayRoleMenu(Role.customer);
        int currentBill = 0;
        boolean[] payed = {false};
        customerMenuLoop:
        while(true) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Menu: ");
                    menu.showMenu();
                    break;
                case 2:
                    System.out.print("Please enter your order: ");
                    int foodOrderIndex = scanner.nextInt() - 1;
                    Dish dishOrdered = menu.getFoods(foodOrderIndex);
                    String foodOrdered = dishOrdered.getDishName();
                    int foodPrice = dishOrdered.getDishPrice();
                    scanner.nextLine();
                    System.out.printf("\nYou have ordered %s for %skr", foodOrdered, foodPrice);
                    kitchen.cook(foodOrdered);
                    currentBill = currentBill + foodPrice;

                    scanner.nextLine();

                    currentBill = handlePayChoice(foodOrdered,foodPrice,currentBill,payed);

                    break;

                case 4:
                    displayRoleMenu(Role.customer);
                    break;

                case 5:
                    System.out.println("Please select table number");
                    int tableNumber = scanner.nextInt();
                    scanner.nextLine();
                    for(Table t:tables){
                        if(t.getTableCode() == tableNumber){
                            t.bookTable();
                            break;
                        }
                    }
                    break;
                case 6:
                    if (currentBill == 0) {
                        System.out.println("Thank you and come again!");
                        break customerMenuLoop;
                    } else {
                        System.out.println("You have not yet payed!");
                        System.out.printf("you still have a bill of %skr", currentBill);
                    }
                    break;
                default:
                    System.out.println("Please select a valid number");
                    break;
            }
        }
    }
    private int handlePayChoice(String foodOrdered, int foodPrice,int currentBill, boolean[] payed){
        System.out.println("\nWould you like to: ");
        System.out.println("1. Pay now");
        System.out.println("2. Cancel this order");
        System.out.println("3. Continue ordering");
        int payChoice = scanner.nextInt();
        scanner.nextLine();
        switch (payChoice) {
            case 1:
                System.out.printf("You have payed your bill of %skr\n", currentBill);
                payed[0] = true;
                currentBill = 0;
                break;
                case 2:
                    System.out.println("Your order of %s has been canceled.\n");
                    currentBill = currentBill - foodPrice;
                    break;
                    case 3:
                        System.out.println("Continue your ordering"); //TODO: Antingen ta bort alternativet så man bara kan beställa en rätt, eller lägga till funktonaliten
                    menu.showMenu();
                    break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
        }
        return currentBill;
    }

    public void staffMenu() {
        displayRoleMenu(Role.staff);

        staffMenuLoop:
        while(true){
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    changeRestaurantStatus();
                    break;
                case 2:
                    menu.addDish();
                    break;
                case 3:
                    menu.removeDish();
                    break;
                case 4:
                    menu.showMenu();
                    break;
                case 5:
                    displayRoleMenu(Role.staff);
                    break;
                case 0:
                    displayRoleMenu(Role.startMenu);
                    break staffMenuLoop;
                default:
                    System.out.println("please select a valid number");
                    displayRoleMenu(Role.staff);

            }
        }

    }
    public void adminMenu() {
        displayRoleMenu(Role.admin);

        adminMenuLoop:
        while(true){
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 1:
                    menu.showMenu();
                    break;
                case 2:
                    menu.addDish();
                    break;
                case 3:
                    menu.removeDish();
                    break;
                case 4:
                    staff.viewStaff();
                    break;
                case 5:
                    staff.fireStaff();
                    break;
                case 6:
                    staff.hireStaff();
                    break;
                case 7:
                    changeRestaurantStatus();
                    break;
                case 8:
                    displayRoleMenu(Role.admin);
                    break;
                case 0:
                    displayRoleMenu(Role.startMenu);
                    break adminMenuLoop;
                default:
                    System.out.println("please enter a valid number");
                    break;


            }

        }
    }
}
