package com.example.tp2exercice1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_CONTACT_LIST = "contact_list";
    private static final String BUNDLE_CONTACT_LIST = "contact_list";
    private static final String BUNDLE_COUNTER = "counter";
    private EditText nameField, firstNameField, phoneField;
    private TextView counterText;
    private ArrayList<Contact> contactList = new ArrayList<>();
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

    private void updateCounterText() {
        ++counter;

        counterText.setText("Displayed " + counter + " times");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.addContactButton) {
            String name = nameField.getText().toString();
            String firstName = firstNameField.getText().toString();
            String phone = phoneField.getText().toString();

            contactList.add(new Contact(name, firstName, phone));
        }

        Intent intent = new Intent(this, ContactListActivity.class);
        intent.putParcelableArrayListExtra(EXTRA_CONTACT_LIST, contactList);

        startActivity(intent);
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
