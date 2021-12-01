package com.scoring.cabinet.service;

import com.scoring.cabinet.model.Doctor;
import com.scoring.cabinet.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorRepository agent;


    @Override
    public Doctor saveorupdate(Doctor doctor) {
        return agent.save(doctor);
    }

    @Override
    public void delete_Doctor(long id) {

        this.agent.deleteById(id);
    }

    @Override
    public Optional<Doctor> find_doctor(long id) {
        return this.agent.findById(id);
    }

    @Override
    public List<Doctor> consulte() {
        return agent.findAll();
    }

    @Override
    public List<Doctor> search_speciality(String spec) {
        return agent.findBySpeciality(spec);
    }

    @Override
    public List<Doctor> search_speciality_firstname(String spec, String first) {
        return agent.findBySpecialityAndFirstname(spec, first);
    }

    @Override
    public List<Doctor> search_advanced(String spec, String pseudo) {
        return agent.search(spec, pseudo);
    }
}
