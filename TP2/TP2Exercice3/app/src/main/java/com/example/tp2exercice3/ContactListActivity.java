package com.example.tp2exercice3;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ContactListActivity extends AppCompatActivity {
    private ArrayList<Contact> contactList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        try {
            initContactList();

            ListView listView = findViewById(R.id.list);

            listView.setAdapter(new ContactAdapter(this, contactList));
        } catch (IOException e) {
            System.err.println("Error : Failed to read from" + MainActivity.CONTACT_FILE);
            e.printStackTrace();
        }

        Button backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void initContactList() throws IOException {
        FileInputStream fis = ContactListActivity.this.openFileInput(MainActivity.CONTACT_FILE);
        InputStreamReader isr = new InputStreamReader(fis);
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
    }
}
