package com.P2.CBS.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name= "first_name",nullable = false)
    private String firstName;

    @NotNull
    @Column(name= "last_name",nullable = false)
    private String lastName;

   // @Column(name = "date_of_birth", columnDefinition = "DATE")
   @Column(name = "date_of_birth")
   private LocalDate dateOfBirth;

    // Constructors
    public Employee() {}

    public Employee(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}


//package com.P2.CBS.model;
//
//import jakarta.persistence.*;
//import java.time.LocalDate;
//import org.hibernate.annotations.JdbcTypeCode;
//import org.hibernate.type.SqlTypes;
//
//@Entity
//@Table(name = "employees")
//public class Employee {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false)
//    private String firstName;
//
//    @Column(nullable = false)
//    private String lastName;
//
//    @Column(name = "date_of_birth")
//    private LocalDate dateOfBirth;
//
//    // Constructors
//    public Employee() {}
//
//    public Employee(String firstName, String lastName, LocalDate dateOfBirth) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//       // this.dateOfBirth = dateOfBirth;
//    }
//
//    // Getters and setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
////    public LocalDate getDateOfBirth() {
////        return dateOfBirth;
////    }
////
////    public void setDateOfBirth(LocalDate dateOfBirth) {
////        this.dateOfBirth = dateOfBirth;
////    }
//}
//


//package com.P2.CBS.model;
//
//import jakarta.persistence.*;
//import java.time.LocalDate;
//import jakarta.validation.constraints.NotNull;
//
//@Entity
//@Table(name = "employees")
//public class Employee {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @NotNull
//    private Long id;
//
//    @NotNull
//    @Column(nullable = false)
//    private String firstName;
//
//    @NotNull
//    @Column(nullable = false)
//    private String lastName;
//
//    // This field is optional, add it if necessary
//    private LocalDate dateOfBirth;
//
//    // You can add other fields as needed (e.g., email, phone number)
//
//    // Default constructor
//    public Employee() {}
//
//    // Constructor with parameters
//    public Employee(String firstName, String lastName, LocalDate dateOfBirth) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.dateOfBirth = dateOfBirth;
//    }
//
//    // Getters and setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public LocalDate getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public void setDateOfBirth(LocalDate dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }
//}


//package com.P2.CBS.model;
//
//import jakarta.persistence.*;
//import java.time.LocalDate;
//import com.P2.CBS.converter.LocalDateAttributeConverter;
//
//import jakarta.validation.constraints.NotNull;
//
//@Entity
//@Table(name = "employees")
//public class Employee {
//
////    @Id
////    @GeneratedValue(strategy = GenerationType.AUTO)
////    private Long id; // Changed from Integer to Long
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id; // Change Long to Integer
//
//
//    @NotNull
//    private String firstName;
//
//    @NotNull
//    private String lastName;
//
//
////    @Convert(converter = LocalDateAttributeConverter.class)
////    @Column(name = "date_of_birth")
//    private LocalDate dateOfBirth;
//
//    // Constructors
//    public Employee() {}
//
//    public Employee(String firstName, String lastName, LocalDate dateOfBirth) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.dateOfBirth = dateOfBirth;
//    }
//
//    // Getters and setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public LocalDate getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public void setDateOfBirth(LocalDate dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }
//}
//

