package com.javaTpoint.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doThrow;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.javaTpoint.model.StudentStatus;

@RunWith(MockitoJUnitRunner.class)
public class BufferReadServiceTest {
	
	
	
	@Mock
	private StudentStatusService studentStatusService;
	
	@Mock
	private BufferReadService bufferReadService;
	
	
	
	@Test
	public void  loadTest() throws IOException  {
		
        StudentStatus studentStatus=new StudentStatus();
		
		doThrow(new RuntimeException()).when(bufferReadService).load();
		
		assertThat(studentStatusService.addUser(studentStatus));
//		
//		doAnswer(new Answer() {
//			public Object answer(InvocationOnMock invocation) throws Throwable{
//				Object[] arguments=invocation.getArguments();
//				return null;
//			}
//		}).when(bufferReadService).load();
//		

	}
	

}
