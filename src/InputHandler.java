import java.util.Scanner;

public class InputHandler {

    private static Scanner scanner = new Scanner(System.in);

    public static String getStringInput(){
        return scanner.nextLine();
    }

    public static int getIntInput(){

        while (!scanner.hasNextInt()){
            System.out.println("Wrong input. Write an integer.");
            scanner.nextLine();
        }

        int i = scanner.nextInt();
        scanner.nextLine();

        return i;
    }

    public static int getIntInput(int min, int max){

        while (true){
            int i = getIntInput();

            if( i >= min && i <= max){
                return i;
            }
            System.out.println("Wrong input. Write a number between " + min + " - " + max + ".");
        }
    }
}