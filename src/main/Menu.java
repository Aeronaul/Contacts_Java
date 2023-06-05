package main;

import java.util.Scanner;

class Menu {
    ContactList contactList;
    Scanner in;

    Menu(ContactList contactList) {
        this.contactList = contactList;
        in = new Scanner(System.in);
    }

    void run() {
        boolean exit = false;
        while (!exit) {
            String action = mainMenu();
            switch (action) {
                case "add" -> addMenu();
                case "list" -> listMenu();
                case "search" -> searchMenu();
                case "count" -> displayCount();
                case "exit" -> exit = true;
                default -> System.out.println("Invalid action!");
            }
            contactList.serialize();
            System.out.println();
        }
    }

    private void listMenu() {
        displayList();
        System.out.println();

        System.out.print("[list] Enter action ([number], back): ");
        String action = in.nextLine();
        if (action.matches("\\d")) {
            int index = Integer.parseInt(action) - 1;
            System.out.println(contactList.get(index));
            System.out.println();
            recordMenu(contactList, index);
        } else if (!action.equals("back")) {
            System.out.println("Invalid option.");
        }
    }

    String mainMenu() {
        String action = "";
        while (!action.matches("add|list|search|count|exit")) {
            System.out.print("[menu] Enter action (add, list, search, count, exit): ");
            action = in.nextLine();
        }
        return action;
    }

    void addMenu() {
        System.out.print("Enter the type (person, organization): ");
        switch (in.next().toLowerCase()) {
            case "person" -> contactList.add(new Person());
            case "organization" -> contactList.add(new Organization());
            default -> {
                System.out.println("Invalid type.");
                return;
            }
        }
        System.out.println("The record added!");
    }

    void searchMenu() {
        if (contactList.size() == 0) {
            System.out.println("No records found!");
            return;
        }

        System.out.print("Enter search query: ");
        ContactList searchResults = contactList.query(in.nextLine());

        System.out.printf("Found %d result%s\n", searchResults.size(), searchResults.size() == 1 ? ":" : "s:");
        for (int j = 0; j < searchResults.size(); j++) {
            System.out.printf("%d. %s\n", j + 1, searchResults.get(j).getIdentifier());
        }

        System.out.print("[search] Enter action ([number], back, again): ");
        String action = in.nextLine();
        switch (action) {
            case "again":
                searchMenu();
                break;
            case "back":
                break;
            default:
                if (action.matches("\\d")) {
                    int index = Integer.parseInt(action) - 1;
                    System.out.println();
                    System.out.println(searchResults.get(index));
                    recordMenu(contactList, searchResults, index);
                } else {
                    System.out.println("Invalid option.");
                }
        }
    }

    private void recordMenu(ContactList contactList, ContactList searchResults, int index) {
        String action = "";
        while (!action.equals("menu")) {
            System.out.print("[record] Enter action (edit, delete, menu): ");
            action = in.nextLine();
            switch (action) {
                case "edit" -> {
                    searchResults.get(index).edit();
                    contactList.serialize();
                    System.out.println("Saved");
                    System.out.println(contactList.get(index));
                }
                case "delete" -> contactList.remove(searchResults.get(index));
                default -> System.out.println("Invalid option.");
            }
            System.out.println();
        }
    }

    private void recordMenu(ContactList contactList, int index) {
        recordMenu(contactList, contactList, index);
    }

    void displayList() {
        contactList.list();
    }

    void displayCount() {
        System.out.printf("The Phone Book has %d records.", contactList.size());
    }
}
