import java.util.ArrayList;
import java.util.Scanner;

public class Table {
   private boolean isBooked;
   private int tableCode;
   private String customerName;

   public Table(int tableCode, boolean isBooked, String customerName) {
       this.tableCode = tableCode;
       this.isBooked = isBooked;
       this.customerName = customerName;
   }
    public Table(int tableCode) {
        this.tableCode = tableCode;
        this.isBooked = false;
        this.customerName = "";
    }

   public int getTableCode() {
       return tableCode;
   }
   public void setTableCode(int tableCode) {
       this.tableCode = tableCode;
   }
   public void setCustomerName(String customerName) {
      this.customerName = customerName;
   }

   public void bookTable(String customerName){
       System.out.println("Please enter the table number you want to book: ");
       Scanner scanner = new Scanner(System.in);
       int tableNumber = scanner.nextInt();
       scanner.nextLine();
       for(Table t:tables){
           if(t.getTableCode() == tableNumber){
               System.out.println("Please enter your name: ");
               String name = scanner.nextLine();
               t.bookTable(name);
               break;
           }
       }
       if(isBooked){
           System.out.println("Sorry! The table number: "+ tableCode+ " has already been booked");
           return;
       }else{
           this.isBooked = true;
           this.customerName = customerName;
           System.out.println(" You booked table number : "+ tableCode + " with name: " + customerName );
       }
   }

   public void cancelBookedTable(int tableCode){

      System.out.println("Please enter the table number you want to unbook: ");
       Scanner scanner= new Scanner(System.in);
       int bookedTableNumber = scanner.nextInt();
       scanner.nextLine();
       for(Table t:tables){
           if(t.getTableCode() == bookedTableNumber){
               t.cancelBookedTable(bookedTableNumber);
               System.out.println("You have cancelled the booked table!");
               break;
           }
       }
       if(isBooked){
           this.isBooked = false;
           this.customerName = "";
           System.out.println("you unbooked table number : "+ tableCode + " with name: " + customerName);
       }else{
           System.out.println("This table is not booked");
       }

   }
}
