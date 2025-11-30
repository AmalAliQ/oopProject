# University Management System

A Java-based console application for managing students and employees in a university system. This project demonstrates core Object-Oriented Programming (OOP) concepts including inheritance, polymorphism, encapsulation, and abstraction.

## Table of Contents
- [Features](#features)
- [OOP Concepts](#oop-concepts)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Screenshots](#screenshots)
- [Contributors](#contributors)

##  Features

- **Student Management**
  - Add students with course enrollment
  - Automatic pass/fail calculation (passing grade ≥ 50)
  - Grade validation (0-100 range)

- **Employee Management**
  - Full-time employees with fixed monthly salary
  - Part-time employees with hourly rate calculation
  - Automatic salary computation

- **Input Validation**
  - Name validation (non-empty)
  - Unique ID enforcement
  - Numeric input validation
  - Range validation for grades and salaries

- **Data Display**
  - Unified display system using polymorphism
  - Numbered record listing
  - Clear formatting for all person types

##  OOP Concepts

This project demonstrates four fundamental OOP principles:

### 1. **Inheritance**
```
Person (Abstract)
├── Student
└── Employee (Abstract)
    ├── FullTimeEmployee
    └── PartTimeEmployee
```

### 2. **Polymorphism**
The `displayDetails()` method behaves differently based on the object type:
- Students show: name, ID, course, grade, and pass/fail status
- Full-time employees show: name, ID, and monthly salary
- Part-time employees show: name, ID, hourly rate, hours worked, and calculated salary

### 3. **Encapsulation**
All classes use private fields with public getter methods to control access to data.

### 4. **Abstraction**
Abstract classes (`Person` and `Employee`) define common structure while leaving specific implementations to subclasses.

## 📁 Project Structure

```
oopproject/
├── Person.java              # Abstract parent class
├── Student.java             # Student subclass
├── Employee.java            # Abstract employee class
├── FullTimeEmployee.java    # Full-time employee implementation
├── PartTimeEmployee.java    # Part-time employee implementation
└── UniversityManagementSystem.java  # Main program with UI
```

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Any Java IDE (Eclipse, IntelliJ IDEA, VS Code) or command line

### Installation

1. Clone the repository
```bash
git clone https://github.com/yourusername/university-management-system.git
cd university-management-system
```

2. Compile the project
```bash
javac oopproject/*.java
```

3. Run the application
```bash
java oopproject.UniversityManagementSystem
```

## 💻 Usage

### Main Menu
```
=========================================
   University Management System  
=========================================
1. Add Student
2. Add Full-time Employee
3. Add Part-time Employee
4. Display All Records
5. Exit
=========================================
```

### Sample Data
The system includes pre-loaded sample data:
- **4 Students** (one for each course)
  - Amal (CS230 - 98.5)
  - Sara (MATH150 - 88.0)
  - Noura (SCI101 - 49.0)
  - Huda (ENG103 - 65.0)
- **2 Employees**
  - Dr. Shiekah (Full-time, 15000 SAR)
  - Eng. Abdullah (Part-time, 50 SAR/hour, 20 hours)

### Available Courses
1. CS230 - Object Oriented Programming
2. MATH150 - Discrete Mathematics
3. SCI101 - General Physics 1
4. ENG103 - Technical Writing

## 📸 Screenshots

### Main Menu
![Main Menu](screenshots/main-menu.png)

### Adding a Student
![Add Student](screenshots/add-student.png)

### Input Validation
![Validation](screenshots/validation.png)

### Display All Records
![Display Records](screenshots/display-records.png)

## 🧪 Testing

The system has been tested for:
- ✅ Correct inheritance behavior
- ✅ Polymorphism (displayDetails() method)
- ✅ Input validation (grades, salaries, IDs)
- ✅ Pass/fail computation
- ✅ Salary calculations
- ✅ Duplicate ID prevention
- ✅ Loop functionality (multiple entries)


## 📝 Course Information

- **Course:** CS230 - Object Oriented Programming
- **Institution:** [SEU - Saudi Electronic University]
- **Semester:** Fall 2025

## 📄 License

This project is created for educational purposes as part of CS230 coursework.

## 🙏 Acknowledgments

- Course instructors for project guidance
- Java documentation and community resources

---

**Note:** This is an academic project developed as part of CS230 coursework at [Saudi Electronic University]. The system demonstrates fundamental OOP concepts through a practical application.
