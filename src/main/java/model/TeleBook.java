package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        contacts.put(contact.getContactName(), contact);
    }

    public Contact removeContact(String contactName) {
         return contacts.remove(contactName);
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
