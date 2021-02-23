package controller;

import exceptions.NoSuchOptionException;
import model.Contact;
import model.TeleBook;
import options.Options;

import java.util.List;
import java.util.Scanner;

public class TeleBookController {
    private Scanner scanner = new Scanner(System.in);
    private TeleBook teleBook = new TeleBook();

    public void controlLoop() {
        Options option = null;
        do {
            printOptions();
            try{
                option = getOptionFromTheUser();
                performAction(option);
            }catch (NoSuchOptionException ex) {
                System.out.println("Nie ma takiej opcji, spróbuj jeszcze raz");
            }
        }while (option != Options.END);
        close();
    }

    private void printOptions() {
        System.out.println(">>>Opcje:");
        for (Options option : Options.values()) {
            System.out.println(option);
        }
    }

    private void performAction(Options option) {
        switch (option) {
            case ADD_CONTACT:
                addContact();
                break;
            case FIND_BY_NAME:
                findByContactName();
                break;
            case FIND_BY_NUMBER:
                findByNumber();
                break;
            case DELETE_CONTACT:
                removeContact();
                break;
        }
    }

    private Options getOptionFromTheUser() {
        System.out.println("Podaj opcje:");
        int option = scanner.nextInt();
        scanner.nextLine();
        return Options.getFromOptionFromInt(option);
    }

    private void addContact() {
        String contactName = getContactNameFromUser();
        String number = getNumberFromUser();
        try{
            teleBook.addContact(new Contact(contactName, number));
        }catch (IllegalArgumentException ex) {
            System.out.println("Imie ani numer nie mogę być puste");
        }
    }


    private void removeContact() {
        String contactName = getContactNameFromUser();
        if (teleBook.removeContact(contactName)) {
            System.out.println("Kontakt: " + contactName + " został usunięty");
        }else {
            System.out.println("Nie znaleziono kontaktu o podanej nazwie");
        }
    }

    private void findByContactName() {
        String contactName = getContactNameFromUser();
        List<Contact> contacts = teleBook.findAllContactsByName(contactName);
        consumeList(contacts);
    }

    private void findByNumber() {
        String number = getNumberFromUser();
        List<Contact> contacts = teleBook.findAllContactsByNumber(number);
        consumeList(contacts);
    }

    private void consumeList(List<Contact> contacts) {
        if (contacts.size() != 0){
            contacts.forEach(System.out::println);
        }else {
            System.out.println("Nie odnaleziono rekordów");
        }
    }

    private String getNumberFromUser() {
        System.out.println("Podaj numer");
        return scanner.nextLine();
    }

    private String getContactNameFromUser() {
        System.out.println("Podaj nazwę");
        return scanner.nextLine();
    }

    private void close() {
        scanner.close();
        System.out.println("Koniec. Bye bye");
    }




}
