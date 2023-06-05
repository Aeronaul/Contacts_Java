package main;

public class Main {
    public static void main(String[] args) {
        ContactList contactList;
        if (args.length > 0) {
            contactList = new ContactList(args[0]);
        } else {
            contactList = new ContactList();
        }
        Menu menu = new Menu(contactList);
        menu.run();
    }
}