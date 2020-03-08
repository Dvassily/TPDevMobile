package com.example.tp2exercice3;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends ArrayAdapter<Contact> {
    private final Activity context;
    private final ArrayList<Contact> contacts;

    public ContactAdapter(Activity context, ArrayList<Contact> contacts) {
        super(context, R.layout.item_contact, contacts);

        this.context = context;
        this.contacts = contacts;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Contact contact = getItem(position);

        LayoutInflater inflater = context.getLayoutInflater();
        View contactView = inflater.inflate(R.layout.item_contact, null, true);

        TextView firstNameText = contactView.findViewById(R.id.contactFirstName);
        TextView nameText = contactView.findViewById(R.id.contactName);
        TextView phoneText = contactView.findViewById(R.id.contactPhoneNumber);

        firstNameText.setText(contact.getFirstName());
        nameText.setText(contact.getName());
        phoneText.setText(contact.getPhoneNumber());

        return contactView;
    }
}
