package com.scoring.cabinet.mapper;

import com.scoring.cabinet.dto.DoctorDto;
import com.scoring.cabinet.model.Doctor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DoctorMapper {

    public DoctorMapper(){

    }

    public Doctor dtoToModel(DoctorDto dto){
        Doctor d = new Doctor();
        d.setId(dto.getAt01());
        d.setFirstname(dto.getAt02());
        d.setLastname(dto.getAt03());
        d.setSpeciality(dto.getAt04());
        return d;
    }

    public DoctorDto modelToDto(Doctor model){

        DoctorDto dto = new DoctorDto();
        dto.setAt01(model.getId());
        dto.setAt02(model.getFirstname());
        dto.setAt03(model.getLastname());
        dto.setAt04(model.getSpeciality());
        dto.setAt05(model.getFirstname() +" "+model.getLastname());
        return dto;
    }

    public List<Doctor> listDtoToModel(List<DoctorDto> dtos){
        return dtos.stream().map(item -> dtoToModel(item)).collect(Collectors.toList());
    }

    public List<DoctorDto> listModelToDto(List<Doctor> models){
        return models.stream().map(item -> modelToDto(item)).collect(Collectors.toList());
    }


}
