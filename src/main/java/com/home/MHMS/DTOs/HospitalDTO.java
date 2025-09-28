package com.home.MHMS.DTOs;

import com.home.MHMS.Entity.HospitalType;
import lombok.Data;

import java.util.List;

@Data
public class HospitalDTO {
    private Long id;
    private String name;
    private HospitalType type;
    //private String address;
    private String phone;
    private String email;
    private Integer totalBeds;
    private Integer availableBeds;
    private Integer totalDepartments;
    private Integer totalStaff;
    private Integer established;
    private String accreditation;
    private List<Long> departmentIds;
}
