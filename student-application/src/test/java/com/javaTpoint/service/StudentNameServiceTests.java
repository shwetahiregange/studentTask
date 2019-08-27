package com.javaTpoint.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.javaTpoint.dao.StudentNameRepository;
import com.javaTpoint.model.StudentName;

@RunWith(MockitoJUnitRunner.class)
public class StudentNameServiceTests {
	
	@Mock
	private StudentNameRepository studentNameRepository;
	
	@InjectMocks
	private StudentNameService studentNameServiceMock;

	
	@Test
	public void addUserTest() {
		StudentName studentName= new StudentName();
		
		when(studentNameServiceMock.addUser(studentName)).thenReturn(studentName);
		assertEquals(studentName,studentNameRepository.save(studentName));
		
	}
	
	@Test
	public void getUserTest() {
		StudentName studentName= new StudentName();
		
		when(studentNameServiceMock.getUser(1)).thenReturn(studentName);
		assertEquals(studentName,studentNameRepository.findById(1));
		
	}
	
	@Test
	public void getAllUsersTest() {
		ArrayList<StudentName> studentName= new ArrayList<StudentName>();
		
		when(studentNameServiceMock.getAllUsers()).thenReturn(studentName);
		assertEquals(studentName,studentNameRepository.findAll());
		
	}
	
	
	@Test
	public void deleteTest() {
		StudentName studentName= new StudentName();
		
		when(studentNameServiceMock.delete(1)).thenReturn(studentName);
		assertEquals(studentName,studentNameRepository.deleteById(1));
		
	}
	
	

}
