package oopproject;

public abstract class Person {
    private String name;
    private int    id;

    public Person(String name, int id) {
        this.name = name;
        this.id   = id; }
    public abstract void displayDetails();
    public String getName() { return name; }
    public int    getId()   { return id;   }
    
}
