package main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

abstract class Contact {
    private final LocalDateTime createDateTime;
    Scanner in;
    private String number;
    private LocalDateTime editDateTime;

    Contact() {
        in = new Scanner(System.in);
        createDateTime = LocalDateTime.now();
        setEditDateTime();
    }

    abstract void edit();

    private boolean validateNumber(String number) {
        String phoneNumberRegex = "\\+?(\\([\\da-zA-Z]+\\)|[\\da-zA-Z]+[ -]\\([\\da-zA-Z]{2,}\\)|[\\da-zA-Z]+)([ -][\\da-zA-Z]{2,})*";
        return number.matches(phoneNumberRegex);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        if (validateNumber(number)) {
            this.number = number;
        } else {
            System.out.println("Wrong number format!");
            this.number = "[no number]";
        }
    }

    public void setEditDateTime() {
        editDateTime = LocalDateTime.now();
    }

    public String getCreateDateTime() {
        return createDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
    }

    public String getEditDateTime() {
        return editDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
    }

    public abstract String getIdentifier();

    public abstract String getFields();
}



