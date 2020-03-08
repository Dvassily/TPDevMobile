package com.example.tp2exercice5;

import android.app.IntentService;
import android.content.Intent;

import androidx.annotation.Nullable;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SynchDBFileService extends IntentService {
    private static final String CONTACT_FILE = "contacts.csv";
    private MemberDBAdapter dbHelper;

    public SynchDBFileService() {
        super("SynchDBFileService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        dbHelper = new MemberDBAdapter(this);
        dbHelper.open();

        System.out.println("FOOOOOOOOOOOOOOOOOOOOOOOOOOOO");

        try {
            ArrayList<Contact> contacts = fetchFromFile();

            for (Contact contact : contacts) {
                Contact dbContact = dbHelper.find(contact);

                if (dbContact == null) {
                    System.out.println("Debug : Inserted contact : " + contact.getName() + " - " + contact.getFirstName() + " - " + contact.getPhoneNumber());
                    dbHelper.insert(contact);
                }
            }
        } catch (IOException e) {
            System.err.println("Error : Failed to read from " + CONTACT_FILE);
            e.printStackTrace();
        }
    }

    public ArrayList<Contact> fetchFromFile() throws IOException {
        ArrayList<Contact> contactList = new ArrayList<>();
        InputStreamReader isr = new InputStreamReader(getAssets().open(CONTACT_FILE));
        BufferedReader br = new BufferedReader(isr);

        String line;

        do {
            line = br.readLine();

            if (line != null) {
                String tokens[] = line.split(",");

                if (tokens.length == 3) {
                    Contact contact = new Contact(tokens[0], tokens[1], tokens[2]);

                    contactList.add(contact);
                }
            }
        } while (line != null);

        return contactList;
    }
}
