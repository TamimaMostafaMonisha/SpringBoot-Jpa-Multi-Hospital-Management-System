package com.home.MHMS.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "selectedDepartments")
    private Set<Hospital> hospitals;

    @ManyToMany
    @JoinTable(
            name = "department_doctor",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id")
    )
    private Set<Doctor> doctors;
//    private String code;
//    private String description;
//
//    @ManyToMany
//    @JoinTable(
//            name = "department_doctor",
//            joinColumns = @JoinColumn(name = "department_id"),
//            inverseJoinColumns = @JoinColumn(name = "doctor_id")
//    )
//    @JsonInclude(JsonInclude.Include.NON_NULL)
//    private Set<Doctor> doctors = new HashSet<>();
}