package com.home.MHMS.Controller;


import com.home.MHMS.DTOs.HospitalDTO;
import com.home.MHMS.Service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospitals")
@RequiredArgsConstructor
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @PostMapping
    public HospitalDTO createHospital(@RequestBody HospitalDTO dto){
        return hospitalService.createHospital(dto);
    }

    @GetMapping
    public List<HospitalDTO> getAllHospitals(){
        return hospitalService.getAllHospitals();
    }

    @GetMapping("/{id}")
    public HospitalDTO getHospitalById(@PathVariable Long id){
        return hospitalService.getHospitalById(id);
    }

    @PutMapping("/{id}")
    public HospitalDTO updateHospital(@PathVariable Long id, @RequestBody HospitalDTO dto){
        return hospitalService.updateHospital(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteHospital(@PathVariable Long id){
        hospitalService.deleteHospital(id);
    }

//    private final HospitalService hospitalService;
//
//    @PostMapping
//    public HospitalDTO createHospital(@RequestBody HospitalDTO dto) {
//        return hospitalService.createHospital(dto);
//    }
//
//    @GetMapping
//    public List<HospitalDTO> getAllHospitals() {
//        return hospitalService.getAllHospitals();
//    }
//
//    @GetMapping("/{id}")
//    public HospitalDTO getHospital(@PathVariable Long id) {
//        return hospitalService.getHospitalById(id);
//    }
//
//    @PutMapping("/{id}")
//    public HospitalDTO updateHospital(@PathVariable Long id, @RequestBody HospitalDTO dto) {
//        return hospitalService.updateHospital(id, dto);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteHospital(@PathVariable Long id) {
//        hospitalService.deleteHospital(id);
//    }
//

}
