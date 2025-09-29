package com.home.MHMS.DTOs;

import com.home.MHMS.Entity.Address;
import lombok.Data;

import java.util.Set;

@Data
public class PatientDTO {

    private Long id;
    private String name;
    private int age;
    private Long hospitalId;
    private Set<Long> doctorIds;
    private Address address;

}
