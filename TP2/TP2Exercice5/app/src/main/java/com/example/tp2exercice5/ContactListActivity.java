package com.example.tp2exercice5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ContactListActivity extends AppCompatActivity {
    private ArrayList<Contact> contactList = new ArrayList<>();
    private MemberDBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dbAdapter = new MemberDBAdapter(this);
        dbAdapter.open();

        setContentView(R.layout.activity_contact_list);

        initContactList();

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(new ContactAdapter(this, contactList));
        Button backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void initContactList() {
        contactList = dbAdapter.findAll();
    }
}
