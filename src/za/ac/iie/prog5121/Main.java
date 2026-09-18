package za.ac.iie.prog5121;
import java.util.Scanner;

public class Main {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
Login login = new Login();

          System.out.print("Enter First Name: ");
          String firstName = scanner.nextLine();

          System.out.print("Enter Last Name: ");
          String lastName = scanner.nextLine();

          System.out.print("Enter Username: ");
          String username = scanner.nextLine();

          System.out.print("Enter Password: ");
          String password = scanner.nextLine();

          System.out.print("Enter Cellphone (e.g. +27821234567): ");
          String CellNumber = scanner.nextLine();

          String registrationResult = login.registerUser(username, password, CellNumber, firstName, lastName);
          System.out.println(registrationResult);

if (login.checkUserName(username) && login.checkPassword(password) && login.checkCellPhoneNumber(CellNumber)) {
          //login.storeUser(firstName, lastName, username, password);
          System.out.println("\n---LOGIN---");

          System.out.print("Enter Username to login: ");
          String loginUser = scanner.nextLine();

          System.out.print("Enter Password to login: ");
          String loginPass = scanner.nextLine();
         
          String status = login.returnLoginStatus(loginUser, loginPass);
          System.out.println(status);
  } 
else {
         System.out.println("\nRegistration failed, please try again.");
  }
scanner.close();
  }
}
