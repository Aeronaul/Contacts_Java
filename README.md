# Contacts (Java)

A terminal-based application to create contacts and search for people or organizations by name.

* User can add two types of contacts: Person, and Organization. 
* Each type has its own set of fields with some fields in common between both types. 
* The phone number is checked with regex to ensure it is a valid number. 
* The list of contacts is saved to an external file which can be passed in as a command line argument to enable serialization.
* The program loads data from this file the next time it is run with the same command line argument.

## Getting Started
To get a local copy of the project up and running on your machine, follow these steps:

### Prerequisites
- Java Development Kit (JDK) 17 or higher
- Git

### Installation
1. Clone the repository:
```
git clone https://github.com/Aeronaul/Contacts_Java.git
```
2. Compile the Java source files:
```
cd Contacts_Java/src
```
```
javac main/*.java
```
3. Run the application:
```
java main.Main
```

## Acknowledgements
The Java programming language.

## Contact
For any questions or inquiries, please contact me at: aeronaul@proton.me.
