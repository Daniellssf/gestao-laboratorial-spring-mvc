package com.amemais.repository;

import com.amemais.model.Administrator;
import org.springframework.data.repository.CrudRepository;

public interface AdministratorRepository extends CrudRepository <Administrator, Long> {

    Administrator findByUsername(String username);
}
