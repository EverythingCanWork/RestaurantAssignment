public class Table {
   private boolean isBooked;
   private int tableCode;


   public Table(int tableCode, boolean isBooked) {
       this.tableCode = tableCode;
       this.isBooked = isBooked;
   }

   public int getTableCode() {
       return tableCode;
   }

   public boolean isBooked() {
       return isBooked;
   }

   public void bookTable(){
       if(isBooked){
           System.out.println("Sorry! The table number: "+ tableCode+ " has already been booked");
           return;
       }else{
           isBooked = true;
           System.out.println(" You booked table number : "+ tableCode );
       }

   }

}
