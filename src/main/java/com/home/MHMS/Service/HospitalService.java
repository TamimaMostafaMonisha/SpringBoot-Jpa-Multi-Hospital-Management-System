package com.home.MHMS.Service;

import com.home.MHMS.Config.ModelMapperConfig;
import com.home.MHMS.DTOs.HospitalDTO;
import com.home.MHMS.Entity.Department;
import com.home.MHMS.Entity.Hospital;
import com.home.MHMS.Repository.DepartmentRepository;
import com.home.MHMS.Repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//@Service
//@RequiredArgsConstructor
public interface HospitalService {

    HospitalDTO createHospital(HospitalDTO hospitalDTO);
    List<HospitalDTO> getAllHospitals();
    HospitalDTO getHospitalById(Long id);
    HospitalDTO updateHospital(Long id, HospitalDTO hospitalDTO);
    void deleteHospital(Long id);

//    private final HospitalRepository hospitalRepository;
//    private final DepartmentRepository departmentRepository;
////    private final ModelMapperConfig modelMapper;
//   private final ModelMapper modelMapper;
//
//    public HospitalDTO createHospital(HospitalDTO dto) {
//        Hospital hospital = modelMapper.map(dto, Hospital.class);
//        System.out.println("Mapped hospital: " + hospital);
//
//        if (dto.getDepartmentIds() != null) {
//            List<Department> departments = departmentRepository.findAllById(dto.getDepartmentIds());
//            hospital.setDepartments(departments);
//        }
//
//        Hospital saved = hospitalRepository.save(hospital);
//        return modelMapper.map(saved, HospitalDTO.class);
//    }
//
//    public List<HospitalDTO> getAllHospitals() {
//        return hospitalRepository.findAll()
//                .stream()
//                .map(h -> modelMapper.map(h, HospitalDTO.class))
//                .collect(Collectors.toList());
//    }
//
//    public HospitalDTO getHospitalById(Long id) {
//        Hospital hospital = hospitalRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Hospital not found"));
//        return modelMapper.map(hospital, HospitalDTO.class);
//    }
//
//    public HospitalDTO updateHospital(Long id, HospitalDTO dto) {
//        Hospital hospital = hospitalRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Hospital not found"));
//
//        hospital.setName(dto.getName());
//        hospital.setType(dto.getType());
//        hospital.setAddress(dto.getAddress());
//        hospital.setPhone(dto.getPhone());
//        hospital.setEmail(dto.getEmail());
//        hospital.setTotalBeds(dto.getTotalBeds());
//        hospital.setAvailableBeds(dto.getAvailableBeds());
//        hospital.setTotalDepartments(dto.getTotalDepartments());
//        hospital.setTotalStaff(dto.getTotalStaff());
//        hospital.setEstablished(dto.getEstablished());
//        hospital.setAccreditation(dto.getAccreditation());
//
//        if (dto.getDepartmentIds() != null) {
//            List<Department> departments = departmentRepository.findAllById(dto.getDepartmentIds());
//            hospital.setDepartments(departments);
//        }
//
//        Hospital updated = hospitalRepository.save(hospital);
//        return modelMapper.map(updated, HospitalDTO.class);
//    }
//
//    public void deleteHospital(Long id) {
//        hospitalRepository.deleteById(id);
//    }


}
