package com.amemais.repository;

import com.amemais.model.Client;
import com.amemais.model.Exam;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends CrudRepository<Exam, Long> {

}
