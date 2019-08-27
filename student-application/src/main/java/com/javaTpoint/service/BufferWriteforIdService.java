package com.javaTpoint.service;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javaTpoint.StudentApplication;
import com.javaTpoint.service.StudentStatusService;


@Service
public class BufferWriteforIdService extends ExportData
{   

	@Autowired  
	private StudentStatusService studentStatusService; 

	private static final Logger logger = LogManager.getLogger(StudentApplication.class);

	@Override

	public void exportToExcel()
	{  
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Student Status Detail");

		Map<Integer, Object[]> data = new HashMap<Integer, Object[]>();
		int rownum = 0;	
		data.put(0, new Object[] {"Student ID", "Student Status"});
		for(int i=1;i<=60;i++)
		{
			data.put(i, new Object[] {studentStatusService.getUser(i).getId(), studentStatusService.getUser(i).isStatus()});
		}
		Set<Integer> keyset = data.keySet();
		for (Integer key : keyset)
		{
			Row row = sheet.createRow(rownum++);
			Object [] objArr = data.get(key);
			int cellnum = 0;
			for (Object obj : objArr)
			{
				Cell cell = row.createCell(cellnum++);
				if(obj instanceof Integer) 
					cell.setCellValue((Integer)obj);
				else if(obj instanceof String)
					cell.setCellValue((String)obj);
				else if(obj instanceof Boolean)
					cell.setCellValue((Boolean)obj);
			}
		}

		try {
			FileOutputStream out = 
					new FileOutputStream(new File("D:\\StudId\\ExcelFile.xls"));
			workbook.write(out);
			out.close();
			workbook.close();
			logger.info("Excel written successfully..");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		}
	}	



	@Override
	public void exportToPdf()
	{
		try
		{    
			 //Loading an existing document
			 PDDocument doc = new PDDocument();
			 PDPage page = new PDPage();
		      doc.addPage(page);
		      //Creating a PDF Document
		     
		      PDPageContentStream contentStream = new PDPageContentStream(doc, page); 
		       
		      //Begin the Content stream 
		      contentStream.beginText();
		      
		       
		      //Setting the font to the Content stream
		      contentStream.setFont( PDType1Font.TIMES_ROMAN, 8 );
		       
		      //Setting the leading
		      contentStream.setLeading(14.5f);
		      
			    //Setting the position for the line
		      contentStream.newLineAtOffset(15, 775);

               
		     String out1= "Id" +"   "+"Status";
		     contentStream.showText(out1);
		     
		     
		      for(int i=1;i<=60;i++)
		      {
		    	  String out = studentStatusService.getUser(i).getId()+"       " + studentStatusService.getUser(i).isStatus();
		    	 contentStream.newLine();
		    	 contentStream.showText(out);
		      }
		      
		      
		      
		      //Ending the content stream
		      contentStream.endText();

		      logger.info("Content added");

		      //Closing the content stream
		      contentStream.close();

		      //Saving the document
		      doc.save(new File("D:\\StudId\\shwet.pdf"));
		            
		      //Closing the document
		      doc.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}


//		BufferedWriter bw = null;
//		try
//		{
//			String mycontent =idGenerator();
//			File file = new File("D:\\StudId\\shwet.pdf");
//
//			/* This logic will make sure that the file 
//			 * gets created if it is not present at the
//			 * specified location*/
//			if (!file.exists())
//			{
//				file.createNewFile();
//			}
//
//			FileWriter fw = new FileWriter(file);
//			bw = new BufferedWriter(fw);
//			bw.write(mycontent);
//			logger.info("File written Successfully");
//
//		}
//		catch (IOException ioe)
//		{
//			ioe.printStackTrace();
//		}
//		finally
//		{ 
//			try
//			{
//				if(bw!=null)
//					bw.close();
//			}
//			catch(Exception ex)
//			{
//				logger.error("Error in closing the BufferedWriter"+ex);
//			}






