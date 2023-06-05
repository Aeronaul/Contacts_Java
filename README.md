# Contacts (Java)

This project involves a program to create contacts (like on the mobile phone) and search for people or organizations by name.

* User can add two types of contacts: Person, and Organization. 
* Each type has its own set of fields with some fields in common between both types. 
* The phone number is checked with regex to ensure it is a valid number. 
* The list of contacts is saved to an external file which can be passed in as a command line argument to enable serialization.
* The program loads data from this file the next time it is run with the same command line argument.
