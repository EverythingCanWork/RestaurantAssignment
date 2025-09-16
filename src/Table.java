public class Table {
   private boolean isBooked;
   private int tableCode;


   public Table(int tableCode, boolean isBooked) {
       this.tableCode = tableCode;
       this.isBooked = isBooked;
   }

   public void bookTable(Table table ){
       if(table.isBooked){
           System.out.println("The table"+ table.tableCode+ " has been booked");
           return;
       }else{
           table.isBooked = true;
           System.out.println("The table"+ table.tableCode+ " has been booked");

       }

   }

}
