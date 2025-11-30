package oopproject;

public class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }

    @Override
    public void displayDetails() {
        System.out.println("Type: Full-Time Employee");
        System.out.println("ID: " + getId() + " | Name: " + getName());
        System.out.println("Salary: " + monthlySalary + " SAR");
        System.out.println("-----------------------------------------");
    }
}