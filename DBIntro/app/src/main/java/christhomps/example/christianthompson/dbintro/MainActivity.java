package christhomps.example.christianthompson.dbintro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import Data.DatabaseHandler;
import Model.Contact;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);

        Log.d("DB Count: ", String.valueOf(db.getContactsCount()));

        //Insert contacts
        Log.d("Insert: ", "Inserting...");
//        db.addContact(new Contact("Mike", "0000999"));
//        db.addContact(new Contact("Thai", "1111999"));
//        db.addContact(new Contact("Tiri", "2222999"));
//        db.addContact(new Contact("Riri", "3333999"));

        //Read all contacts
        Log.d("Reading: ", " Reading all contacts...");
        List<Contact> contactList = db.getAllContacts();

        //Get One Contact
        //Contact oneContact = db.getContact(3);
//        oneContact.setName("Paulooooo");
//        oneContact.setPhoneNumber("000000000");

        //Update contact
//        int newContact = db.updateContact(oneContact);
//
//
//        Log.d("One contact: ", "Updated Row: " + String.valueOf(newContact) + " Name: " + oneContact.getName() + "" +
//                ", Phone: " + oneContact.getPhoneNumber());

        //Delete contact
        //db.deleteContact(oneContact);
        for (Contact c : contactList){

            String log = "ID: " + c.getId() + ", Name: " + c.getName() + ", Phone: "
                                + c.getPhoneNumber();

            Log.d("Name", log);
        }
    }
}
