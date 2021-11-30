package com.scoring.cabinet.repository;

import com.scoring.cabinet.model.Rdv;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface RdvRepository extends CrudRepository<Rdv,Long> {
}
