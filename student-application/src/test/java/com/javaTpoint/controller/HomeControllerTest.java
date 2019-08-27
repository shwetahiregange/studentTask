package com.javaTpoint.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.javaTpoint.model.StudentName;
import com.javaTpoint.model.StudentStatus;
import com.javaTpoint.service.BufferReadService;
import com.javaTpoint.service.BufferWriteforIdService;
import com.javaTpoint.service.BufferWriteforNameService;
import com.javaTpoint.service.FileReadService;
import com.javaTpoint.service.StudentNameService;
import com.javaTpoint.service.StudentStatusService;

@RunWith(SpringRunner.class)
public class HomeControllerTest {


	private MockMvc mvc;

	@Mock
	private StudentNameService studentNameService;

	@Mock
	private StudentStatusService studentStatusService;

	@Mock
	private BufferReadService bufferReadService;

	@Mock
	private FileReadService fileReadService;

	@Mock
	private BufferWriteforIdService bufferWriteforIdService;

	@Mock
	private BufferWriteforNameService bufferWriteforNameService;

	@InjectMocks
	private HomeController homeController;

	@Before
	public void setUp() throws Exception{
		mvc= MockMvcBuilders.standaloneSetup(homeController).build();
	}


	@Test
	public void indexPageTest() throws Exception 
	{
		mvc.perform(get("/"))
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("index"));
	}

	@Test
	public void generateIdPageTest() throws Exception 
	{
		mvc.perform(get("/generate"))
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("idgen"));
	}

	@Test
	public void idGenerateTest() throws Exception 
	{
		StudentStatus studentStatus=new StudentStatus();
		when(studentStatusService.addUser(studentStatus)).thenReturn(studentStatus);
		mvc.perform(MockMvcRequestBuilders.post("/Generate"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.forwardedUrl("successpage"));
	}

	@Test
	public void addStudentTest() throws Exception 
	{
		mvc.perform(get("/addstud"))
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("addstudent"));
	}

	@Test
	public void addUserTest() throws Exception 
	{
//		
//		StudentName studentName=new StudentName();
//		StudentStatus updateRow=studentStatusService.getUser(1);
//		updateRow.setStatus(false);
//
//		when(studentNameService.addUser(studentName)).thenReturn(studentName);
//		when(studentStatusService.addUser(updateRow)).thenReturn(updateRow);
//		assertEquals(updateRow, studentStatusService.addUser(updateRow));
		mvc.perform(MockMvcRequestBuilders.post("/Addition"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.forwardedUrl("successpage"));
	}

	@Test
	public void searchStudentTest() throws Exception 
	{
		mvc.perform(get("/searchstud"))
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("searchstudent"));
	}

	@Test
	public void getUserTest() throws Exception 
	{
		StudentName studentName=new StudentName();

		when(studentNameService.getUser(1)).thenReturn(studentName);
		mvc.perform(MockMvcRequestBuilders.get("/Search"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.forwardedUrl("studentsearch"));
	}

	@Test
	public void getUsersTest() throws Exception 
	{
		ArrayList<StudentName> studentName=new ArrayList<StudentName> ();

		when(studentNameService.getAllUsers()).thenReturn(studentName);
		mvc.perform(get("/liststud"))
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("liststudent"));
	}

	@Test
	public void deletePageTest() throws Exception 
	{
		mvc.perform(get("/deleteStud"))
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("deleteStudent"));
	}

	@Test
	public void deleteStudentTest() throws Exception 
	{
//		StudentName studentName=new StudentName();
//		StudentStatus studentStatus=new StudentStatus();
//		when(studentNameService.delete(1));
//		when(studentStatusService.getUser(1));
//		when(studentStatusService.addUser(studentStatus)).thenReturn(studentStatus);
		mvc.perform(get("/Delete"))
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("successpage"));
	}

	@Test
	public void updatePageTest() throws Exception 
	{
		mvc.perform(get("/updateStud"))
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("updateStudent"));
	}

	@Test
	public void updateStudentTest() throws Exception 
	{
//		StudentName studentName=new StudentName();
//		StudentName updateRecord= studentNameService.getUser(studentName.getId());
//
//		Mockito.when(studentNameService.getUser(studentName.getId())).thenReturn(updateRecord);
//		updateRecord.setName("shweta");
//		Mockito.when(studentNameService.addUser(updateRecord)).thenReturn(updateRecord);
		

		mvc.perform(post("/Update"))
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("successpage"));
	}
	


	@Test
	public void loadIdPageTest() throws Exception 
	{
		mvc.perform(get("/loadid"))
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("loadId"));
	}

	@Test
	public void loadIdFromFileReadrTest() throws Exception 
	{
		mvc.perform(post("/Load"))
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("successpage"));
	}

	@Test
	public void loadIdFromBufferReadrTest() throws Exception 
	{
		mvc.perform(post("/Load1"))
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("successpage"));
	}

	@Test
	public void writeDataPageTest() throws Exception 
	{
		mvc.perform(get("/writeid"))
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("writeId"));
	}

	@Test
	public void writeIdToFileTest() throws Exception 
	{
		mvc.perform(get("/writestatus"))
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("writeStatus"));
	}

	@Test
	public void writeIdToTextTest() throws Exception 
	{
		mvc.perform(post("/Write1"))
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("successpage"));
	}

	@Test
	public void writeIdToExcelTest() throws Exception 
	{
		mvc.perform(post("/Write2"))
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("successpage"));
	}

	@Test
	public void writeIdToPdfTest() throws Exception 
	{
		mvc.perform(post("/Write3"))
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("successpage"));
	}


	@Test
	public void writeNameToFileTest() throws Exception 
	{
		mvc.perform(get("/writename"))
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("writeName"));
	}

	@Test
	public void writeNameToTextTest() throws Exception 
	{
		mvc.perform(post("/Write4"))
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("successpage"));
	}

	@Test
	public void writeNameToExcelTest() throws Exception 
	{
		mvc.perform(post("/Write5"))
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("successpage"));
	}

	@Test
	public void writeNameToPdfTest() throws Exception 
	{
		mvc.perform(post("/Write6"))
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("successpage"));
	}



}
