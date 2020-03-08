package com.example.tp2exercice4;

import android.os.Parcel;
import android.os.Parcelable;

class Contact implements Parcelable {
    private String name;
    private String firstName;
    private String phoneNumber;

    public Contact(String name, String firstName, String phoneNumber) {
        this.name = name;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
    }

    public Contact(Parcel in) {
        name = in.readString();
        firstName = in.readString();
        phoneNumber = in.readString();
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(firstName);
        dest.writeString(phoneNumber);
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel source) {
            return new Contact(source);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[0];
        }
    };

    @Override
    public String toString() {
        return getFirstName() + " " + getName() + " - " + getPhoneNumber();
    }
}
