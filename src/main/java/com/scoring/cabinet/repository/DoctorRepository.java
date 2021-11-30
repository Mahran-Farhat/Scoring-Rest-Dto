package com.scoring.cabinet.repository;

import com.scoring.cabinet.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {

    public List<Doctor> findBySpeciality(String spec);
    // Select d From Doctor d where d.speciality = :spec (PreparedStatement ---> SQL)
    public List<Doctor> findBySpecialityAndFirstname(String spec, String first);
    // Select d From Doctor d where d.speciality = :spec and d.firstname = :first
    @Query(value="Select d from Doctor d where d.speciality = :spec and "
    +"(d.firstname = :pseudo or d.lastname = :pseudo)")
    public List<Doctor> search(@Param("spec") String s, @Param("pseudo") String p);
}
