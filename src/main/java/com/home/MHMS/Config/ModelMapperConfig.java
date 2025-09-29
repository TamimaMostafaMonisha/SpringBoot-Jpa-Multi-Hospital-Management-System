package com.home.MHMS.Config;

import com.home.MHMS.DTOs.HospitalDTO;
import com.home.MHMS.Entity.Department;
import com.home.MHMS.Entity.Hospital;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Collectors;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setSkipNullEnabled(true)
                .setAmbiguityIgnored(true);
        // Entity → DTO
//        modelMapper.addMappings(new PropertyMap<Hospital, HospitalDTO>() {
//            @Override
//            protected void configure() {
//                map().setDepartmentIds(
//                        source.getDepartments().stream()
//                                .map(Department::getId)
//                                .collect(Collectors.toList())
//                );
//            }
//        });
        modelMapper.addMappings(new PropertyMap<Hospital, HospitalDTO>() {
            @Override
            protected void configure() {
                map().setDepartmentIds(
                        (source.getDepartments() == null ?
                                java.util.Collections.emptyList() :
                                source.getDepartments().stream()
                                        .map(Department::getId)
                                        .collect(Collectors.toList()))
                );
            }
        });

        // DTO → Entity (basic, departments resolved in Service)
        modelMapper.addMappings(new PropertyMap<HospitalDTO, Hospital>() {
            @Override
            protected void configure() {
                skip().setDepartments(null); // handled in HospitalService
            }
        });

        return modelMapper;
    }

    public HospitalDTO mapToDto(Hospital hospital) {
        if (hospital == null) return null;
        return modelMapper().map(hospital, HospitalDTO.class);
    }

    // ✅ Utility method to map HospitalDTO → Hospital
    public Hospital mapToEntity(HospitalDTO dto) {
        if (dto == null) return null;
        return modelMapper().map(dto, Hospital.class);
    }
}