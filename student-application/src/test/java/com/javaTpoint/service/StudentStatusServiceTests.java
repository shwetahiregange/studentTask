package com.javaTpoint.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.javaTpoint.dao.StudentStatusRepository;
import com.javaTpoint.model.StudentStatus;

@RunWith(MockitoJUnitRunner.class)
public class StudentStatusServiceTests {

	@Mock
	private StudentStatusRepository studentStatusRepository;
	
	@InjectMocks
	private StudentStatusService studentStatusServiceMock;
	
	@Test
	public void addUserTest() {
		StudentStatus studentStatus= new StudentStatus();
		
		Mockito.when(studentStatusServiceMock.addUser(studentStatus)).thenReturn(studentStatus);
		assertEquals(studentStatus,studentStatusRepository.save(studentStatus));
		
	}
	
	@Test
	public void getUserTest() {
		StudentStatus studentStatus= new StudentStatus();
		
		when(studentStatusServiceMock.getUser(1)).thenReturn(studentStatus);
		assertEquals(studentStatus,studentStatusRepository.findById(1));
		
	}
	
	@Test
	public void deleteTest() {
		StudentStatus studentStatus= new StudentStatus();
		
		when(studentStatusServiceMock.delete(1)).thenReturn(studentStatus);
		assertEquals(studentStatus,studentStatusRepository.deleteById(1));
		
	}
	
	@Test
	public void setStatusTest() {
		StudentStatus studentStatus= new StudentStatus();
		
		when(studentStatusServiceMock.setStatus(studentStatus)).thenReturn(studentStatus);
		assertEquals(studentStatus,studentStatusRepository.status(true));
		
	}

	
}
