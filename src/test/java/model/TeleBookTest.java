package model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TeleBookTest {

    private TeleBook teleBook;
    private Map<String, Contact> testMap;

    @BeforeEach
    public void init() {
        teleBook = new TeleBook();
        testMap = Map.ofEntries(
                Map.entry("Adam Nowak", new Contact("Adam Nowak", "222222222")),
                Map.entry("Zuza Biała", new Contact("Zuza Biała", "222222222")),
                Map.entry("Ada Wilczek", new Contact("Ada Wilczek", "333392333")),
                Map.entry("Robert Katzy", new Contact("Robert Katzy", "444444392")),
                Map.entry("Adam Kowalski", new Contact("Adam Kowalski", "555555555"))
        );
    }

    @Test
    public void shouldAddNewContactToTeleBook() {
        //given
        Contact contact = new Contact("Martin", "555555555");

        //when
        teleBook.addContact(contact);

        //then
        assertTrue(teleBook.getContacts().size() == 1);
    }

    @Test
    public void shouldRemoveContactFromTeleBook() {
        //given
        Contact contact = new Contact("Martin", "555555555");
        teleBook.getContacts().put(contact.getContactName(), contact);

        //when
        Contact removedContact = teleBook.removeContact(contact.getContactName());

        //then
        assertAll(
                () -> assertTrue(teleBook.getContacts().size() == 0),
                () -> assertEquals(contact, removedContact)
        );
    }

    @Test
    public void shouldFindContactsForProvidedName() {
        //given
        teleBook.setContacts(testMap);

        //when
        List<Contact> foundContacts = teleBook.findAllContactsByName("Ada");

        //then
        Assertions.assertTrue(foundContacts.size() == 3);
    }


    @Test
    public void shouldFindContactsForProvidedNumber() {
        //given
        teleBook.setContacts(testMap);

        //when
        List<Contact> foundContacts = teleBook.findAllContactsByNumber("392");

        //then
        Assertions.assertTrue(foundContacts.size() == 2);
    }



}