package main;

class Organization extends Contact {

    private static final long serialVersionUID = 100L;
    private String name;
    private String address;

    Organization() {
        super();
        System.out.print("Enter the organization name: ");
        setName(in.nextLine());
        System.out.print("Enter the address: ");
        setAddress(in.nextLine());
        System.out.print("Enter the number: ");
        setNumber(in.nextLine());
    }

    @Override
    void edit() {
        System.out.print("Select a field (name, surname, number): ");
        String field = in.nextLine();
        switch (field) {
            case "name" -> {
                System.out.print("Enter name: ");
                setName(in.nextLine());
            }
            case "address" -> {
                System.out.print("Enter address: ");
                setAddress(in.nextLine());
            }
            case "number" -> {
                System.out.print("Enter number: ");
                setNumber(in.nextLine());
            }
            default -> System.out.println("Invalid field!");
        }
        setEditDateTime();
    }

    @Override
    public String getIdentifier() {
        return getName();
    }

    @Override
    public String getFields() {
        return getName() + getAddress() + getNumber();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Organization name: " + getName() +
                "\nAddress: " + getAddress() +
                "\nNumber: " + getNumber() +
                "\nTime created: " + getCreateDateTime() +
                "\nTime last edit: " + getEditDateTime();
    }

}

