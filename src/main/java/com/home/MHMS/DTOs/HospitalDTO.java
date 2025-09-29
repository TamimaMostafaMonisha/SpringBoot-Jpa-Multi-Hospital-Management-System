package com.home.MHMS.DTOs;

import com.home.MHMS.Entity.Address;
import com.home.MHMS.Entity.HospitalStatus;
import com.home.MHMS.Entity.HospitalType;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class HospitalDTO {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private Long adminId;
    private Integer totalBeds;
    private Integer availableBeds;
    private Integer totalDepartments;
    private Integer totalStaff;
    private HospitalStatus status;
    private LocalDate established;
    private HospitalType type;
    private String accreditation;
    private Set<Long> selectedDepartmentIds = new HashSet<>();
}
