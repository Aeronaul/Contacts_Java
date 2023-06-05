package main;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

class Person extends Contact {

    private String name;
    private String surname;
    private LocalDate birthdate;
    private String gender;

    Person() {
        super();
        System.out.print("Enter the name: ");
        setName(in.nextLine());
        System.out.print("Enter the surname: ");
        setSurname(in.nextLine());
        System.out.print("Enter the birthdate (YYYY-MM-DD)");
        setBirthdate(in.nextLine());
        System.out.print("Enter the gender (M, F): ");
        setGender(in.nextLine());
        System.out.print("Enter the number: ");
        setNumber(in.nextLine());
    }

    @Override
    void edit() {
        System.out.print("Select a field (name, surname, birth, gender, number): ");
        String field = in.nextLine();
        switch (field) {
            case "name" -> {
                System.out.print("Enter name: ");
                setName(in.nextLine());
            }
            case "surname" -> {
                System.out.print("Enter surname: ");
                setSurname(in.nextLine());
            }
            case "birth" -> {
                System.out.print("Enter birthdate: ");
                setBirthdate(in.nextLine());
            }
            case "gender" -> {
                System.out.print("Enter gender: ");
                setGender(in.nextLine());
            }
            case "number" -> {
                System.out.print("Enter number: ");
                setNumber(in.nextLine());
            }
            default -> System.out.println("Invalid field!");
        }
        setEditDateTime();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthdate() {
        return birthdate != null ? birthdate.toString() : "[no data]";
    }

    public void setBirthdate(String birthdate) {
        try {
            this.birthdate = LocalDate.parse(birthdate);
        } catch (DateTimeParseException dtpe) {
            System.out.println("Bad birth date!");
            this.birthdate = null;
        }
    }

    public String getGender() {
        return gender != null ? gender : "[no data]";
    }

    public void setGender(String gStr) {
        if (gStr.matches("[MF]")) {
            this.gender = gStr.equals("M") ? "Male" : "Female";
        } else {
            this.gender = null;
            System.out.println("Bad gender!");
        }
    }

    @Override
    public String toString() {
        return "Name: " + getName() +
                "\nSurname: " + getSurname() +
                "\nBirth date: " + getBirthdate() +
                "\nGender: " + getGender() +
                "\nNumber: " + getNumber() +
                "\nTime created: " + getCreateDateTime() +
                "\nTime last edit: " + getEditDateTime();
    }

    @Override
    public String getIdentifier() {
        return getName() + " " + getSurname();
    }

    @Override
    public String getFields() {
        return getName() + getSurname() + getBirthdate() + getNumber();
    }

}
