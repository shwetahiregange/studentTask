package com.javaTpoint.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaTpoint.dao.StudentStatusRepository;
import com.javaTpoint.model.StudentStatus;

@Transactional
@Service
public class StudentStatusService {
	 @Autowired 
	 private  StudentStatusRepository studentStatusRepository; 
	 
	 public StudentStatusService(StudentStatusRepository studentStatusRepository) {
		 super();
		 this.studentStatusRepository= studentStatusRepository;
	 }
	 
		public StudentStatus addUser(StudentStatus studentStatus)
	    {   
			return studentStatusRepository.save(studentStatus);
	    }
		
		public  StudentStatus getUser(int id)
		{  
			return  studentStatusRepository.findById(id);

		}
		public StudentStatus delete(int id)
		{  
			return studentStatusRepository.deleteById(id);
			   
		}
		
		public StudentStatus setStatus(StudentStatus studentStatus)
		{
			return studentStatusRepository.status(true);
		}
}
