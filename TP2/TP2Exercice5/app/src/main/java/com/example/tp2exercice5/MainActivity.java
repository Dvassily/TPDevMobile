package com.example.tp2exercice5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // public static final String EXTRA_CONTACT_LIST = "contact_list";
    private static final String BUNDLE_CONTACT_LIST = "contact_list";
    private static final String BUNDLE_COUNTER = "counter";
    private EditText nameField, firstNameField, phoneField;
    private TextView counterText;
    private ArrayList<Contact> contactList = new ArrayList<>();
    private int counter = 0;
    private MemberDBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dbAdapter = new MemberDBAdapter(this);
        dbAdapter.open();

        Intent intent = new Intent(this, SynchDBFileService.class);
        startService(intent);

        setContentView(R.layout.activity_main);

        nameField = findViewById(R.id.nameField);
        firstNameField = findViewById(R.id.firstNameField);
        phoneField = findViewById(R.id.phoneField);
        counterText = findViewById(R.id.counterText);

        Button addContactButton = findViewById(R.id.addContactButton);
        Button showListButton = findViewById(R.id.showListButton);

        addContactButton.setOnClickListener(this);
        showListButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.addContactButton) {
            String name = nameField.getText().toString();
            String firstName = firstNameField.getText().toString();
            String phone = phoneField.getText().toString();

            Contact contact = new Contact(name, firstName, phone);

            dbAdapter.insert(contact);
        }

        Intent intent = new Intent(this, ContactListActivity.class);
        // intent.putParcelableArrayListExtra(EXTRA_CONTACT_LIST, contactList);

        startActivity(intent);

    }

    private void updateCounterText() {
        ++counter;

        counterText.setText("Displayed " + counter + " times");
    }

    // Exercice 2
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putParcelableArrayList(BUNDLE_CONTACT_LIST, contactList);
        savedInstanceState.putInt(BUNDLE_COUNTER, counter);
    }

    // Exercice 2
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        contactList = savedInstanceState.getParcelableArrayList(BUNDLE_CONTACT_LIST);
        counter = savedInstanceState.getInt(BUNDLE_COUNTER);
    }

    // Exercice 2
    @Override
    protected void onResume() {
        super.onResume();

        updateCounterText();
    }
}
