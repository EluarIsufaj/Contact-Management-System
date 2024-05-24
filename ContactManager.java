import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContactManager {
    private List<Contact> contacts;
    public ContactManager(){
        contacts = new ArrayList<>();
    }
    public void  addContact(Contact contact){
        contacts.add(contact);
    }

    public void displayContact(){
        for(Contact contact:contacts){
            System.out.println(contact);
        }
    }

    public void saveContactToFile(String filename){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
            oos.writeObject(contacts);
            System.out.println("Contact saved to " + filename);
        }catch (IOException e){
            System.out.println("Error saving the contact to file.");
            e.printStackTrace();
        }
    }

    public void loadContactsFromFile(String filename){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
            contacts = (List<Contact>) ois.readObject();
            System.out.println("Contact loaded from " + filename);
        }
        catch (IOException | ClassNotFoundException e){
            System.err.println("Error loading the contacts from file");
            e.printStackTrace();
        }

    }

}