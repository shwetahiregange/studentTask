package com.javaTpoint.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.javaTpoint.StudentApplication;
import com.javaTpoint.model.StudentName;
import com.javaTpoint.model.StudentStatus;
import com.javaTpoint.service.BufferReadService;
import com.javaTpoint.service.BufferWriteforIdService;
import com.javaTpoint.service.BufferWriteforNameService;
import com.javaTpoint.service.FileReadService;
import com.javaTpoint.service.StudentNameService;
import com.javaTpoint.service.StudentStatusService;


@Controller
public class HomeController {

	private static final Logger logger = LogManager.getLogger(StudentApplication.class);

	@Autowired  
	private StudentNameService studentNameService;  

	@Autowired  
	private StudentStatusService studentStatusService; 

	@Autowired  
	private FileReadService i1;

	@Autowired  
	private BufferReadService i2;

	@Autowired  
	private BufferWriteforIdService e1;

	@Autowired
	private BufferWriteforNameService e2;

	@RequestMapping("/")  
	public String indexPage()
	{  
		return "index";  
	}

	@RequestMapping("/generate")  
	public String generateIdPage()
	{  
		return "idgen";  
	}

	@PostMapping(value="/Generate")  
	public String idGenerate()
	{  
		logger.debug("Id generation");
		for(int i=1;i<=20;i++)
		{
			StudentStatus studentStatus=new StudentStatus();
			studentStatus.setId(i);
			studentStatus.setStatus(true);
			studentStatusService.addUser(studentStatus);
		}
		logger.debug("Id generated successfully");

		return "successpage";  
	}

	@RequestMapping("/addstud")  
	public String addStudent(){ 

		return "addstudent";  
	}
     
	@PostMapping(value="/Addition")  
	public String addUser( int id,StudentName studentName)
	{  
		logger.debug("Id generation");
		StudentStatus updateRow= studentStatusService.getUser(id);
		updateRow.setStatus(false);
		studentNameService.addUser(studentName);
		studentStatusService.addUser(updateRow); 
		logger.debug("Id generated successfully");
		return "successpage";
	}
	
	@RequestMapping("/searchstud")  
	public String searchStudent(){  
		return "searchstudent";  
	}

	@GetMapping(value="/Search")  
	public ModelAndView getUser(int id,Model map){  
		
		
		map.addAttribute("ss", studentNameService.getUser(id));
		logger.debug("Id generated successfully");
		return new ModelAndView("studentsearch");
		
	} 

	@GetMapping(value="/liststud")  


	public ModelAndView getUsers(StudentName studentName, Model map){    
		map.addAttribute("tt", studentNameService.getAllUsers());
		logger.debug("Id generated successfully");
		return new ModelAndView("liststudent");
	}

	@RequestMapping(value="/deleteStud")  
	public String deletePage(){  
		return "deleteStudent";  
	}

	@GetMapping(value="/Delete")  
	public String deleteStudent(int id){ 
		
		studentNameService.delete(id);
		StudentStatus updateRow= studentStatusService.getUser(id);
		updateRow.setStatus(true);
		studentStatusService.addUser(updateRow);
		logger.debug("Id generated successfully");
		return "successpage";  
	}

	@RequestMapping(value="/updateStud")  
	public String updatePage(){  
		return "updateStudent";  
	}

	@PostMapping(value="/Update")  
	public String updateStudent(StudentName studentName){  
		StudentName updateRecord= studentNameService.getUser(studentName.getId());
		updateRecord.setName(studentName.getName());
		studentNameService.addUser(updateRecord);
		logger.debug("Id generated successfully");

		return "successpage";  
	}


	//	Page that Returns the Loadid using FileReader 

	@RequestMapping(value="/loadid")  
	public String loadIdPage(){  
		return "loadId";  
	}

	//		Method of loading FileReader

	@RequestMapping(value="/Load", method = RequestMethod.POST)  
	public String loadIdFromFileReadr(FileReadService fileReadService)
	{  
		i1.load();
		return "successpage";
	}

	@RequestMapping(value="/Load1", method = RequestMethod.POST)  
	public String loadIdFromBufferReadr(BufferReadService bufferReadService)
	{  
		i2.load();
		return "successpage";
	}

	@RequestMapping(value="/writeid")  
	public String writeDataPage()
	{  
		return "writeId";  
	}

	@RequestMapping(value="/writestatus")  
	public String writeIdToFile()
	{  
		return "writeStatus";  
	}

	@RequestMapping(value="/Write1", method = RequestMethod.POST)  
	public String writeIdToText(BufferWriteforIdService bufferWriteforIdService)
	{  
		e1.exportIdToText();
		return "successpage";
	}

	@RequestMapping(value="/Write2", method = RequestMethod.POST)  
	public String writeIdToExcel(BufferWriteforIdService bufferWriteforIdService)
	{  
		e1.exportToExcel();
		return "successpage";
	}

	@RequestMapping(value="/Write3", method = RequestMethod.POST)  
	public String writeIdToPdf(BufferWriteforIdService bufferWriteforIdService)
	{  
		e1.exportToPdf();
		return "successpage";
	}

	@RequestMapping(value="/writename")  
	public String writeNameToFile()
	{  
		return "writeName";  
	}

	@RequestMapping(value="/Write4", method = RequestMethod.POST)  
	public String writeNameToText(BufferWriteforNameService bufferWriteforNameService )
	{  
		e2.exportNameToText();
		return "successpage";
	}

	@RequestMapping(value="/Write5", method = RequestMethod.POST)  
	public String writeNameToExcel(BufferWriteforNameService bufferWriteforNameService)
	{  
		e2.exportToExcel();
		return "successpage";
	}

	@RequestMapping(value="/Write6", method = RequestMethod.POST)  
	public String writeNameToPdf(BufferWriteforNameService bufferWriteforNameService)
	{  
		e2.exportToPdf();
		return "successpage";
	}



}

