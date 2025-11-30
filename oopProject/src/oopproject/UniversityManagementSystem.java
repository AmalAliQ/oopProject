package oopproject;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * University Management System - Main Program
 * 
 * This program manages students and employees in a university.
 * It uses Object-Oriented Programming concepts:
 * - Inheritance: Student and Employee classes extend Person class
 * - Polymorphism: displayDetails() method works differently for each type
 * - Encapsulation: Private fields with public getter methods
 * - Abstraction: Abstract Person and Employee classes
 * 
 * @author Amal Alqahtani 
 */

public class UniversityManagementSystem {
    
    // store all (students and employees) in one place
    static ArrayList<Person> list = new ArrayList<>();
    
    static Scanner input = new Scanner(System.in);
    
    // Four sample courses 
    static String[] availableCourses = {
        "CS230 - Object Oriented Programming", 
        "MATH150 - Discrete Mathematics", 
        "SCI101 - General Physics 1", 
        "ENG103 - Technical Writing" };

    /**
     * Main method - This is where the program starts
     *Shows menu and handles user choices in a loop  */
    public static void main(String[] args) {
        initializeData(); 
        boolean running = true;  
        while (running) {
            // Display menu
            System.out.println("\n=========================================");
            System.out.println("   University Management System  ");
            System.out.println("=========================================");
            System.out.println("1. Add Student");
            System.out.println("2. Add Full-time Employee");
            System.out.println("3. Add Part-time Employee");
            System.out.println("4. Display All Records");
            System.out.println("5. Exit");
            System.out.println("=========================================");
            
            System.out.print("Select option (1-5): ");
            int choice = getValidInt();
            switch (choice) {
                case 1: 
                    addStudent(); 
                    break;
                case 2: 
                    addFullTimeEmployee(); 
                    break;
                case 3: 
                    addPartTimeEmployee(); 
                    break;
                case 4: 
                    displayAll(); 
                    break;
                case 5: 
                    // Option 5: Stop the program
                    running = false;
                    System.out.println("\n=========================================");
                    System.out.println("Thank you for using the system. Goodbye!");
                    System.out.println("=========================================");
                    break;
                default:         
                    System.out.println("Invalid option. Please enter 1 to 5");
            }
        }
        
        input.close();
    }

    /**
     * add a new student to the system
     * 
     * Steps:
     * 1. Get student name (cannot be empty)
     * 2. Get unique ID (cannot be duplicate)
     * 3. Select course from available courses
     * 4. Enter grade (must be between 0 and 100)
     * 5. Create student object and add to list
     */
    public static void addStudent() {
        System.out.println("\n--- Add Student ---");
        
        // Get student name with validation
        String name;
        do {
            System.out.print("Enter Name: ");
            name = input.nextLine().trim(); 
            
            if (name.isEmpty()) {
                System.out.println("Error: Name cannot be empty. Please try again.");
            }
        } while (name.isEmpty()); 
        
        // Get unique ID ( for no duplicates)
        int id = getUniqueId();
        
        // Show available courses 
        System.out.println("\nAvailable Courses:");
        for (int i = 0; i < availableCourses.length; i++) {
            System.out.println((i + 1) + ". " + availableCourses[i]);
        }
        
        int courseChoice;
        do {
            System.out.print("Enter Course Number (1-" + availableCourses.length + "): ");
            courseChoice = getValidInt();
            
            // Check if choice is in valid range
            if (courseChoice < 1 || courseChoice > availableCourses.length) {
                System.out.println("Error: Please choose a number between 1 and " + availableCourses.length);
            }
        } while (courseChoice < 1 || courseChoice > availableCourses.length);
        String course = availableCourses[courseChoice - 1];
        
        // Get grade with validation (must be 0-100)
        double grade;
        do {
            System.out.print("Enter Grade (0-100): ");
            grade = getValidDouble();
            if (grade < 0 || grade > 100) {
                System.out.println("Error: Grade must be between 0 and 100.");
            }
        } while (grade < 0 || grade > 100);
        list.add(new Student(name, id, course, grade));
        System.out.println("Success: Student added to [" + course + "] successfully.");
    }

    /**
     * add a new full-time employee to the system
     * Full-time employee has a fixed monthly salary.
     * 
     * Steps:
     * 1. Get employee name (cannot be empty)
     * 2. Get unique ID
     * 3. Enter monthly salary (cannot be negative)
     * 4. Create employee object and add to list
     */
    public static void addFullTimeEmployee() {
        System.out.println("\n--- Add Full-Time Employee ---");
        
        // Get employee name with validation
        String name;
        do {
            System.out.print("Enter Name: ");
            name = input.nextLine().trim(); 
            if (name.isEmpty()) {
                System.out.println("Error: Name cannot be empty. Please try again.");
            } } while (name.isEmpty()); 
        int id = getUniqueId();
        
        // Get monthly salary with validation
        double salary;
        do {
            System.out.print("Enter Monthly Salary: ");
            salary = getValidDouble();
            if (salary < 0) {
                System.out.println("Error: Salary cannot be negative.");
            }
        } while (salary < 0);
        list.add(new FullTimeEmployee(name, id, salary));
        System.out.println("Success: Full-Time Employee added successfully.");
    }

    /**
     * add a new part-time employee to the system
     * Part-time employee is paid by the hour.
     * Salary = hourly rate × hours worked
     * 
     * Steps:
     * 1. Get employee name (cannot be empty)
     * 2. Get unique ID
     * 3. Enter hourly rate (cannot be negative)
     * 4. Enter hours worked (cannot be negative)
     * 5. Create employee object and add to list
     */
    public static void addPartTimeEmployee() {
        System.out.println("\n--- Add Part-Time Employee ---");
        
        // Get employee name with validation
        String name;
        do {
            System.out.print("Enter Name: ");
            name = input.nextLine().trim(); 
            if (name.isEmpty()) {
                System.out.println("Error: Name cannot be empty. Please try again."); }
        } while (name.isEmpty()); 
        int id = getUniqueId();
        
        // Get hourly rate with validation
        double rate;
        do {
            System.out.print("Enter Hourly Rate: ");
            rate = getValidDouble();
            if (rate < 0) {
                System.out.println("Error: Hourly rate cannot be negative. Try again.");
            }
        } while (rate < 0);
        int hours;
        do {
            System.out.print("Enter Hours Worked: ");
            hours = getValidInt();
            if (hours < 0) {
                System.out.println("Error: Hours cannot be negative. Try again.");
            }
        } while (hours < 0);
        list.add(new PartTimeEmployee(name, id, rate, hours));
        System.out.println("Success: Part-Time Employee added successfully.");
    }
    
    /**
     * display all records in the system
     * 
     * POLYMORPHISM:
     * - The same method displayDetails() works differently
     * - For Student: shows name, ID, course, grade, pass/fail
     * - For FullTimeEmployee: shows name, ID, monthly salary
     * - For PartTimeEmployee: shows name, ID, rate, hours, total salary
     */
    public static void displayAll() {
        System.out.println("\n========================================");
        System.out.println("           ALL RECORDS                  ");
        System.out.println("========================================");
        
        if (list.isEmpty()) {
            System.out.println("No records found in the system");
        } else {
            int count = 1;
            for (Person p : list) {
                System.out.print(count + ". ");
                p.displayDetails(); // This is polymorphism
                count++;
            }
        }
        System.out.println("========================================");
    }

    /**
     * sample data 
     * Purpose: To test the system and show how it works
     */
    public static void initializeData() {
        list.add(new Student("Amal", 101, availableCourses[0], 98.5));  
        list.add(new Student("Sara", 102, availableCourses[1], 88.0));  
        list.add(new Student("Noura", 103, availableCourses[2], 49.0)); 
        list.add(new Student("Huda", 104, availableCourses[3], 65.0));  
        list.add(new FullTimeEmployee("Dr. Shiekah", 201, 15000.0));
        list.add(new PartTimeEmployee("Eng. Abdullah", 301, 50.0, 20));
        
    }

    /**
     * gets unique ID from user
     * this prevents duplicate IDs in the system
     */
    public static int getUniqueId() {
        while (true) {
            System.out.print("ِEnter ID: ");
            int id = getValidInt();
            if (id <= 0) {
                System.out.println("Error: ID must be a positive number");
                continue; }
         // Check for duplicate ID
            boolean exists = false;
            for (Person p : list) {
                if (p.getId() == id) {
                    exists = true;
                    break; 
                }}
            if (exists) {
                System.out.println("Error: ID already taken. Please enter a different ID");
            } else {
                return id;
            }
        }
    }

    /**
     * Reads and validates integer input
     */
    public static int getValidInt() {
        while (!input.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            input.next();         }        
        int val = input.nextInt();
        input.nextLine(); 
        return val;    }
    /**
     * Reads and validates double input
     */
    public static double getValidDouble() {
        while (!input.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a number: ");
            input.next(); 
        }        
        double val = input.nextDouble();
        input.nextLine(); 
        return val;
    }
}
