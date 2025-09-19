import java.util.ArrayList;
import java.util.Scanner;

public class Table {
   private boolean isBooked;
   private int tableCode;
   private String customerName;

    public Table(int tableCode) {
        this.tableCode = tableCode;
        this.isBooked = false;
        this.customerName = "";
    }

   public int getTableCode() {
       return tableCode;
   }

   public void setCustomerName(String customerName) {
      this.customerName = customerName;
   }

   public boolean getIsBooked() {
           return isBooked;
    }
    public String getCustomerName(){
        return customerName;
    }
    public void setIsBooked(boolean isBooked) {
       this.isBooked = isBooked;
    }

   public void cancelBookedTable(){
       this.isBooked = false;
   }
}
