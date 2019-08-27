package com.javaTpoint.service;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaTpoint.StudentApplication;
import com.javaTpoint.dao.Loader;
import com.javaTpoint.model.StudentStatus;
import com.javaTpoint.service.StudentStatusService;

@Service
public class BufferReadService implements Loader
{
	private static final Logger logger = LogManager.getLogger(StudentApplication.class);
	
	@Autowired
	private StudentStatusService studentStatusService;
	
	
	@Override
	public void load() {

        try {
                // Always wrap FileReader in BufferedReader.
            BufferedReader br = new BufferedReader( new FileReader("D://text.txt"));
            StudentStatus studentStatus=new StudentStatus();
            String i;
		
			while((i=br.readLine())!= null)
            {  
				studentStatus.setId(Integer.parseInt(i));
				studentStatus.setStatus(true);
				studentStatusService.addUser(studentStatus);
            } // Always close files.
		
			 br.close();
            logger.info("Sucess");        }        
        catch(IOException ex) {
           ex.printStackTrace();
        }
		
	}
}
