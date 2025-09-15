import java.util.ArrayList;
import java.util.Scanner;

public class Staff {
    private ArrayList <String> firstName;
    private ArrayList <String> lastName;
    private ArrayList <Long> personalNumber;
    private ArrayList <Integer> sallery;
    private ArrayList <String> jobTitle;
    Scanner scanner = new Scanner(System.in);

    public Staff() {
        firstName = new ArrayList<>();
        lastName = new ArrayList<>();
        personalNumber = new ArrayList<>();
        sallery = new ArrayList<>();
        jobTitle = new ArrayList<>();

        firstName.add("Rikard");
        lastName.add("koniakowski");
        personalNumber.add(199702180000L);
        sallery.add(100000);
        jobTitle.add("Owner");

        firstName.add("Person2");
        lastName.add("lastname 2");
        personalNumber.add(200103150000L);
        sallery.add(30000);
        jobTitle.add("Chef");

        firstName.add("Person3");
        lastName.add("lastname3");
        personalNumber.add(200203150000L);
        sallery.add(28000);
        jobTitle.add("Server");

    }
    public void hireStaff(){
        System.out.println("Enter the firstname of the new hire:");
        String fName = scanner.nextLine();
        firstName.add(fName);
        System.out.println("enter the lastname of the new hire");
        String lName = scanner.nextLine();
        lastName.add(lName);
        System.out.println("enter the personal number of the new hire(YYYYMMDDXXXX)");
        Long pNumber = scanner.nextLong();
        scanner.nextLine();
        personalNumber.add(pNumber);
        System.out.println("enter the sallary of the new hire");
        int pay = scanner.nextInt();
        scanner.nextLine();
        sallery.add(pay);
        System.out.println("Enter the job title of the new hire");
        String occupation = scanner.nextLine();
        jobTitle.add(occupation);



        System.out.printf("You have added %s %s as a %s with a sallery of %skr and the personal number %s", fName, lName, occupation, pay, pNumber);
    }
    public void fireStaff(){
        System.out.println("which person do you wish to fire?");
        viewStaff();
        int removeIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        System.out.printf("%s %s has been fired", firstName.get(removeIndex), lastName.get(removeIndex));
        firstName.remove(removeIndex);
        lastName.remove(removeIndex);
        jobTitle.remove(removeIndex);
        sallery.remove(removeIndex);
        personalNumber.remove(removeIndex);

    }

    public void viewStaff(){
        for (int i = 0; i < firstName.size(); i++){
            System.out.printf("\nFirstname: %s Lastname: %s Job Title: %s Sallery: %s Personal number: %s\n", firstName.get(i), lastName.get(i), jobTitle.get(i), sallery.get(i), personalNumber.get(i));
        }
    }

}


