package com.javaTpoint.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javaTpoint.model.StudentStatus;

@Repository
public interface StudentStatusRepository extends CrudRepository<StudentStatus, Integer> {
	StudentStatus findById(int id);
	StudentStatus deleteById(int id);
	StudentStatus status(boolean status);
	
}
