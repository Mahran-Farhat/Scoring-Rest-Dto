package com.scoring.cabinet.service;

import com.scoring.cabinet.model.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {

    public Doctor saveorupdate(Doctor doctor);
    public void delete_Doctor(long id);
    public Optional<Doctor> find_doctor(long id);
    public List<Doctor> consulte();
    public List<Doctor> search_speciality(String spec);
    public List<Doctor> search_speciality_firstname(String spec,String first);
    public List<Doctor> search_advanced(String spec,String pseudo);

}
