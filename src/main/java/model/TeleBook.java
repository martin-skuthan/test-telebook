package model;

import exceptions.ContactAlreadyExistsException;

import java.util.*;

public class TeleBook {
    private Map<String, Contact> contacts;

    public TeleBook() {
        contacts = new HashMap<>();
    }

    public Map<String, Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Map<String, Contact> contacts) {
        this.contacts = contacts;
    }

    public void addContact(Contact contact) {
        if (contact.getContactName() == null || contact.getPhoneNumber() == null) {
            throw new NullPointerException("Conact name and number cannot be null");
        }

        if (contact.getContactName().isEmpty() || contact.getPhoneNumber().isEmpty()) {
            throw new IllegalArgumentException("Conact name and number cannot be empty");
        }

        if (contacts.containsKey(contact.getContactName())) {
            throw new ContactAlreadyExistsException("Contact : " + contact.getContactName() + " already" +
                    "exists in telebook");
        }

        contacts.put(contact.getContactName(), contact);
    }

    public boolean removeContact(String contactName) {
        if (contacts.containsKey(contactName)) {
            contacts.remove(contactName);
            return true;
        }else {
            return false;
        }
    }

    public List<Contact> findAllContactsByName(String contactName) {
        List<Contact> contactsList = new ArrayList<>();
        for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
            if (entry.getKey().contains(contactName)) {
                contactsList.add(entry.getValue());
            }
        }

        return contactsList;
    }

    public List<Contact> findAllContactsByNumber(String number) {
        List<Contact> contactsList = new ArrayList<>();
        for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
            if (entry.getValue().getPhoneNumber().contains(number)) {
                contactsList.add(entry.getValue());
            }
        }

        return contactsList;
    }
}
