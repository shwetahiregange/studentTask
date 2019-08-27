package com.javaTpoint.service;

import java.io.BufferedWriter;



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.javaTpoint.StudentApplication;
import com.javaTpoint.service.StudentNameService;
import com.javaTpoint.service.StudentStatusService;

abstract class ExportData
{   
	private static final Logger logger = LogManager.getLogger(StudentApplication.class);
	@Autowired  
	private StudentStatusService studentStatusService; 
	
	@Autowired  
	private StudentNameService studentNameService;
	
	public String idGenerate()
	{   String out="";
		for(int i=1;i<=60;i++)
		{
			out= out+ studentStatusService.getUser(i).getId()+"   " + studentStatusService.getUser(i).isStatus()+"\n";
		}
		return out;  
	}
	
	public String nameGenerate()
	{   String out="";
		for(int i=1;i<=2;i++)
		{
			out= out+ studentNameService.getUser(i).getId()+"   " + studentNameService.getUser(i).getName()+"\n";
		}
		return out;  
	}
	
	abstract void exportToExcel();
	abstract void exportToPdf();


	public void exportIdToText()
	{   
	
		BufferedWriter bw = null;
		try
		{
			String mycontent = idGenerate();
			
			//Specify the file name and path here
			File file = new File("D:\\StudId\\TextFile.txt");

			/* This logic will make sure that the file 
			 * gets created if it is not present at the
			 * specified location*/
			if (!file.exists())
			{
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			bw.write(mycontent);
			logger.info("File written Successfully");

		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		finally
		{ 
			try
			{
				if(bw!=null)
					bw.close();
			}
			catch(Exception ex)
			{
				logger.error("Error in closing the BufferedWriter"+ex);
			}
		}
	}
	
	
	public void exportNameToText()
	{   

		
		BufferedWriter bw = null;
		try
		{
			String mycontent = nameGenerate();
			
			//Specify the file name and path here
			File file = new File("D:\\StudName\\TextFile.txt");

			/* This logic will make sure that the file 
			 * gets created if it is not present at the
			 * specified location*/
			if (!file.exists())
			{
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			bw.write(mycontent);
			logger.info("File written Successfully");

		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		finally
		{ 
			try
			{
				if(bw!=null)
					bw.close();
			}
			catch(Exception ex)
			{
				logger.error("Error in closing the BufferedWriter"+ex);
			}
		}
	}
}
