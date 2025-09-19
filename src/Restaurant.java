import java.util.ArrayList;

public class Restaurant {
    boolean open = true;
    Menu menu = new Menu();
    Kitchen kitchen = new Kitchen();
    Staff staff = new Staff();
    ArrayList<Table> tables = new ArrayList<>();

    public Restaurant() {
       for(int i = 1; i <= 10; i++) {
           tables.add(new Table(i));
       }
    }
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
                System.out.println("5. Booking system");
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
    }
    public void customerMenu() {

        int currentBill = 0;
        boolean[] payedStatus = {false};
        customerMenuLoop:
        while(true) {
            displayRoleMenu(Role.customer);
            int choice = InputHandler.getIntInput();

            switch (choice) {
                case 1:
                    showMenuWithAvailability();
                    pauseUntilEnter();
                    break;
                case 2:
                    currentBill = processOrder(takeOrder(), currentBill, payedStatus);
                    pauseUntilEnter();
                    break;

                case 4:
                    break;
                case 5:
                    handleBooking();
                    break;
                case 6:
                    System.out.println("Thank you and come again!");
                    break customerMenuLoop;
                default:
                    System.out.println("Please select a valid number");
                    break;
            }
        }
    }
    private int handlePayChoice(int foodPrice,int currentBill, boolean[] payed, Dish dishOrdered){
        System.out.println("\nWould you like to: ");
        System.out.println("1. Pay now");
        System.out.println("2. Cancel this order");
        System.out.println("3. Continue ordering");
        int payChoice = InputHandler.getIntInput();

        switch (payChoice) {
            case 1:
                System.out.printf("You have payed your bill of %skr\n", currentBill);
                payed[0] = true;
                currentBill = 0;
                break;
            case 2:
                kitchen.cancelOrder(dishOrdered);
                currentBill = currentBill - foodPrice;
                break;
            case 3:
                System.out.println("Continue your ordering");
                currentBill = processOrder(takeOrder(), currentBill, payed);
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
            int choice = InputHandler.getIntInput();

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
                case 6:
                    kitchen.addAvailableIngredients();
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
            int choice = InputHandler.getIntInput();

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
    public void pauseUntilEnter(){
        System.out.println("\nPress Enter to continue...\n");
    }

    public void bookTable() {
        System.out.println("Please enter the table number you want to book: ");
        int tableNumber = InputHandler.getIntInput();

        if(tableNumber <=0 || tableNumber >= 10){
            System.out.println("Invalid table number! Please try again");
            return;
        }
        Table selectedTable=null;

        for (Table t : tables) {
            if (t.getTableCode() == tableNumber) {
                selectedTable = t;
                break;
            }
        }
        assert selectedTable != null;
        if(!selectedTable.getIsBooked()){
                System.out.println("Please enter your name: ");
                String name = InputHandler.getStringInput();
                selectedTable.setIsBooked(true);
                selectedTable.setCustomerName(name);

                System.out.println("Reservation confirmed");
                System.out.println("Table number: "+ selectedTable.getTableCode());
                System.out.println("Booked under: "+ selectedTable.getCustomerName());

        }else{
                System.out.println("Sorry! The table number: "+ selectedTable.getTableCode()+ " has already been booked! ");
            }
    }
    public void cancelBooking(){
        System.out.println("Please enter the table number you want to unbook: ");
        int bookedTableNumber = InputHandler.getIntInput();

        if(bookedTableNumber <=0 || bookedTableNumber >= 10){
            System.out.println("Invalid table number! Please try again");
            return;
        }

        Table selectedTable=null;
        for(Table t:tables){
            if(t.getTableCode() == bookedTableNumber){
                selectedTable = t;
                break;
            }
        }
        assert selectedTable != null;
        if(selectedTable.getIsBooked()){
               selectedTable.cancelBookedTable();
                System.out.println("You unbooked table: : "+ selectedTable.getTableCode());
                System.out.println("It was booked under: "+ selectedTable.getCustomerName());
        }else{
            System.out.println("This table is not yet booked!");
        }
    }
    public void handleBooking(){

        bookingloop:
        while(true){
            System.out.println("===Welcome to the booking System!===");
            System.out.println("1. Book a table");
            System.out.println("2. Cancel a booking");
            System.out.println("3. Back to previous menu");

            int bookingChoice = InputHandler.getIntInput();

            switch (bookingChoice) {
            case 1:
                bookTable();
                break;
            case 2:
                cancelBooking();
                break;
            case 3:
                break bookingloop;
            default:
                System.out.println("Please select a valid option");
                break;
        }
        }
    }
    public void showMenuWithAvailability() {
        System.out.println("=====MENU=====");
        for (int i = 0; i < menu.getDishes().size(); i++) {
            Dish dish = menu.getDishes().get(i);
            boolean ingredientAvailable = kitchen.checkRequiredIngredientsStock(dish);
            String availability;
            if (ingredientAvailable) {
                availability = "(Available)";
            } else {
                availability = "(Out of stock)";
            }
            System.out.printf("%s. %s : %s kr %s\n", (i + 1), dish.getDishName(), dish.getDishPrice(), availability);
        }
    }
    public Dish takeOrder() {
        showMenuWithAvailability();
        System.out.print("Please enter your order: ");
        int foodOrderIndex = InputHandler.getIntInput() - 1;
        Dish dishOrdered = menu.getFoods(foodOrderIndex);
        return dishOrdered;
    }

    public int processOrder(Dish dishOrdered, int currentBill, boolean[] payed) {
        if (kitchen.cook(dishOrdered)) {
            int orderPrice = dishOrdered.getDishPrice();
            System.out.printf("\nYou have ordered %s for %skr", dishOrdered.getDishName(), orderPrice);
            currentBill = currentBill + orderPrice;
            System.out.printf("your current bill is %s", currentBill);
            pauseUntilEnter();

            if (currentBill > 0) {
                currentBill = handlePayChoice(orderPrice, currentBill, payed, dishOrdered);
            }
        }
        return currentBill;
    }
}
