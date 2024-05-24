import java.util.Scanner;

public class ContactManagementSystem {
    public static void  main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ContactManager contactManager = new ContactManager();

        while (true){
            System.out.println("\nContact management system");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Save Contact to file");
            System.out.println("4. Select Contacts from File");
            System.out.println("5. Exit");
            System.out.println("Select an option ");

            int choise = scanner.nextInt();
            scanner.nextLine();

            switch (choise){
                case 1:
                    System.out.println("Enter a name ");
                    String name = scanner.nextLine();
                    System.out.println("Enter email ");
                    String email = scanner.nextLine();
                    System.out.println("Enter phone number ");
                    String phoneNumber = scanner.nextLine();

                    Contact  contact = new Contact(name,email,phoneNumber);
                    contactManager.addContact(contact);
                    System.out.println("Contact added.");
                    break;
                case 2:
                    contactManager.displayContact();
                    break;
                case 3:
                    contactManager.saveContactToFile("contact.txt");
                    break;
                case 4:
                    contactManager.loadContactsFromFile("contact.txt");
                    break;
                case 5:
                    System.out.println("Exiting the Contact Management System");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choise. Please try again");
            }

        }
    }
}
