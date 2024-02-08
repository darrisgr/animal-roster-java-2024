package models;

public class Animal {
    private int id;
    private static int nextId = 1;
    private String name;
    private String caretaker;

    public Animal() {
        this.id = nextId;
        nextId++;
    }

    public Animal(String name, String caretaker) {
        this();
        this.name = name;
        this.caretaker = caretaker;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaretaker() {
        return caretaker;
    }

    public void setCaretaker(String caretaker) {
        this.caretaker = caretaker;
    }

    @Override
    public String toString() {
        return name;
    }
}
