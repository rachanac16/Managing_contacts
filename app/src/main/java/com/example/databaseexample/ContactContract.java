package com.example.databaseexample;

public final class ContactContract {
    private ContactContract(){}


    public static class ContactEntry{
        public static final String TABLE_NAME="contact_info";
        public static final String ID="contact_id";
        public static final String NAME="contact_name";
        public static final String EMAIL="contact_email";

    }
}
