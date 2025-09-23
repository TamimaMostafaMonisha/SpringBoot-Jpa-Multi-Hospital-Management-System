package com.home.MHMS.DTOs;

import java.util.Set;

public class DoctorDTO {

    private Long id;
    private String name;
    private String specialization;
    private Long hospitalId;
    private Set<Long> patientIds;
}
