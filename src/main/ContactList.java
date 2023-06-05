package main;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

class ContactList implements Serializable {
    private final String filename;
    private ArrayList<Contact> contactList;

    public ContactList() {
        contactList = new ArrayList<>();
        this.filename = null;
    }

    public ContactList(String filename) {
        this.filename = filename;
        deserialize();
    }

    public void serialize() {
        if (filename == null) return;
        try (ObjectOutputStream oStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            oStream.writeObject(contactList);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deserialize() {
        try (ObjectInputStream oStream = new ObjectInputStream(new FileInputStream(filename))) {
            contactList = (ArrayList<Contact>) oStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            contactList = new ArrayList<>();
        }
    }

    public void add(Contact contact) {
        contactList.add(contact);
    }


    public void remove(Contact contact) {
        contactList.remove(contact);
    }

    public void list() {
        for (int i = 0; i < contactList.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, contactList.get(i).getIdentifier());
        }
    }

    public int size() {
        return contactList.size();
    }

    public Contact get(int index) {
        return contactList.get(index);
    }

    public ContactList query(String regex) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        ContactList searchResults = new ContactList();
        for (Contact contact : contactList) {
            if (pattern.matcher(contact.getFields()).find()) {
                searchResults.add(contact);
            }
        }
        return searchResults;
    }
}