public class Table {
   private boolean isBooked;
   private int tableCode;
   private String isAvailable;

   public Table(int tableCode, boolean isBooked) {
       this.tableCode = tableCode;
       this.isBooked = isBooked;
       this.isAvailable = isBooked ? "Yes" : "No";
   }

   public void reserveTable(){

   }

}
