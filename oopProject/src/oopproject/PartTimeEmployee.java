package oopproject;

public class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(String name, int id, double hourlyRate, int hoursWorked) {
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public void displayDetails() {
        System.out.println("Type: Part-Time Employee"); 
        System.out.println("ID: " + getId() + " | Name: " + getName());
        System.out.println("Rate: " + hourlyRate + " | Hours: " + hoursWorked);
        System.out.println("Total Salary: " + calculateSalary() + " SAR");
        System.out.println("-----------------------------------------");
    }
}