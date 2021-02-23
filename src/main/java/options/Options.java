package options;

import exceptions.NoSuchOptionException;

public enum Options {
    ADD_CONTACT(0, "Dodaj kontakt"),
    FIND_BY_NAME(1, "Szukaj po nazwie"),
    FIND_BY_NUMBER(2, "Szukaj po telefonie"),
    DELETE_CONTACT(3, "Usuń"),
    END(4, "Koniec");

    private int value;
    private String description;

    Options(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public static Options getFromOptionFromInt(int option) {
        try {
            return Options.values()[option];
        }catch (ArrayIndexOutOfBoundsException ex) {
            throw new NoSuchOptionException("There is no option: " + option);
        }
    }




}
