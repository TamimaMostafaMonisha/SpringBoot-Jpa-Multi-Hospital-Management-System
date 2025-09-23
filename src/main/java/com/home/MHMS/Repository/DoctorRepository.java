package com.home.MHMS.Repository;

import com.home.MHMS.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository  extends JpaRepository<Doctor,Long> {
}
