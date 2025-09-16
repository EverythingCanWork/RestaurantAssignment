public class Table {
   private boolean isBooked;
   private int tableCode;


   public Table(int tableCode, boolean isBooked) {
       this.tableCode = tableCode;
       this.isBooked = isBooked;

   }

   public void reserveTable(){
       if(isBooked){
           isBooked = false;
       }
   }

}
