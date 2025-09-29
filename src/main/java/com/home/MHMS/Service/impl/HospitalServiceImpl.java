package com.home.MHMS.Service.impl;

import com.home.MHMS.DTOs.HospitalDTO;
import com.home.MHMS.Entity.Hospital;
import com.home.MHMS.Repository.DepartmentRepository;
import com.home.MHMS.Repository.HospitalRepository;
import com.home.MHMS.Service.HospitalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class HospitalServiceImpl implements HospitalService {
    @Autowired
    private HospitalRepository hospitalRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ModelMapper modelMapper;
    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }

        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
    @Override
    public HospitalDTO createHospital(HospitalDTO dto) {
        Hospital hospital = new Hospital();
        BeanUtils.copyProperties(dto,hospital, getNullPropertyNames(dto));
        if(dto.getSelectedDepartmentIds() != null){
            hospital.setSelectedDepartments(
                    new HashSet<>(departmentRepository.findAllById(dto.getSelectedDepartmentIds()))
            );
        }
        hospital = hospitalRepository.save(hospital);
        return modelMapper.map(hospital, HospitalDTO.class);
    }

    @Override
    public List<HospitalDTO> getAllHospitals() {
        return hospitalRepository.findAll()
                .stream()
                .map(h -> modelMapper.map(h, HospitalDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public HospitalDTO getHospitalById(Long id) {
        Hospital hospital = hospitalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hospital not found"));
        return modelMapper.map(hospital, HospitalDTO.class);
    }

    @Override
    public HospitalDTO updateHospital(Long id, HospitalDTO dto) {
        Hospital hospital = hospitalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hospital not found"));

        modelMapper.map(dto, hospital);
        if(dto.getSelectedDepartmentIds() != null){
            hospital.setSelectedDepartments(
                    new HashSet<>(departmentRepository.findAllById(dto.getSelectedDepartmentIds()))
            );
        }
        hospital = hospitalRepository.save(hospital);
        return modelMapper.map(hospital, HospitalDTO.class);
    }

    @Override
    public void deleteHospital(Long id) {
        hospitalRepository.deleteById(id);
    }

}
