package com.home.MHMS.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "hospital")
@EqualsAndHashCode(callSuper = false)
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private HospitalType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_address_id")
    private Address address;

    private String phone;
    private String email;

    private Integer totalBeds;
    private Integer availableBeds;
    private Integer totalDepartments;
    private Integer totalStaff;

    private Integer established;

    private String accreditation;

    @Column(name = "created_dt", updatable = false)
    private LocalDateTime createdDt;

    @Column(name = "last_updated_dt")
    private LocalDateTime lastUpdatedDt;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "updated_by")
    private Long updatedBy;

    @Column(name = "is_active")
    private Boolean isActive = true;


    @ManyToMany
    @JoinTable(
            name = "hospital_department",
            joinColumns = @JoinColumn(name = "hospital_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id")
    )
    private List<Department> departments;


    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<User> users;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<PatientHospital> patientHospitals;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Appointment> appointments;

    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        this.createdDt =now;
        this.lastUpdatedDt = now;
    }

    @PreUpdate
    public void preUpdate() {
        this.lastUpdatedDt = LocalDateTime.now();
    }

}
