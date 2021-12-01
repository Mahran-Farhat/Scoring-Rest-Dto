package com.scoring.cabinet.controller;

import com.scoring.cabinet.dto.DoctorDto;
import com.scoring.cabinet.mapper.DoctorMapper;
import com.scoring.cabinet.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class DoctorDtoRest {

    @Autowired
    DoctorService agent;

    @Autowired
    DoctorMapper mapper;

    @PostMapping("/doctors")
    public DoctorDto agg_doctor(@RequestBody DoctorDto dto){
        return mapper.modelToDto(this.agent.saveorupdate(mapper.dtoToModel(dto)));
    }

    @GetMapping("/doctors")
    public List<DoctorDto> consulte(){
        return mapper.listModelToDta(agent.consulte());
    }

}
