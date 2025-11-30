package oopproject;

public class Student extends Person {
    private String course;
    private double grade;

    public Student(String name, int id, String course, double grade) {
        super(name, id);
        this.course = course;
        this.grade = grade;
    }

    public boolean isPass() {
        return grade >= 50;
    }

    @Override
    public void displayDetails() {
        String status = isPass() ? "Pass" : "Fail";
        System.out.println("Type: Student");
        System.out.println("ID: " + getId() + " | Name: " + getName());
        System.out.println("Course: " + course + " | Grade: " + grade);
        System.out.println("Result: " + status);
        System.out.println("-----------------------------------------");
    }
}