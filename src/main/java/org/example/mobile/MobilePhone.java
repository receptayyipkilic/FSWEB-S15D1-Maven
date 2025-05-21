package org.example.mobile;
import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;

    }

    public MobilePhone(String myNumber, List<Contact> contacts) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>(contacts);
    }

    public String getMyNumber() {
        return myNumber;
    }

    public ArrayList<Contact> getMyContacts() {
        return myContacts;
    }

    public boolean addNewContact(Contact contact) {
        for (Contact c : myContacts) {
            if (c.getName().equals(contact.getName())) {
                return false;
            }
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact current = myContacts.get(i);
            if (current.getName().equals(oldContact.getName())) {
                myContacts.set(i, newContact);
                return true;
            }
        }
        return false;
    }

    public boolean removeContact(Contact contact) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(contact.getName())) {
                myContacts.remove(i);
                return true;
            }
        }
        return false;
    }

    public Contact queryContact(String name) {
        for (Contact c : myContacts) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

    public int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public int findContact(Contact contact) {
        return findContact(contact.getName());
    }

    public void printContacts() {
        System.out.println("Contact List:");
        for (Contact c : myContacts) {
            System.out.println(c.getName() + " -> " + c.getPhoneNumber());
        }
    }
}
