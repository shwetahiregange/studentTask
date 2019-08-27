package com.javaTpoint.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javaTpoint.model.StudentName;
@Repository
public interface StudentNameRepository extends CrudRepository<StudentName, Integer>
{
StudentName findById(int id);
StudentName deleteById(int id);

}
