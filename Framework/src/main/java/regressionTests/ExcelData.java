package regressionTests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import freemarker.core.ParseException;


public class ExcelData {
	private static String fileName;
			//Start the timer once clicked on Button - Call Method
//			long startTime = System.currentTimeMillis();
//			int varPerformance = performanceCheckStatus(driver, "Health Check Sails", "Quote (seconds)", "//li/a[text()='Prepare Bind']",startTime,logger);
			
			
			static int counter;
			
			
			//Writing to excel
			@SuppressWarnings("resource")
			public static ArrayList<String> dataReadingHBDSails(ArrayList<String> list2 , String envFileName, String sheetName) throws EncryptedDocumentException, InvalidFormatException
				{
					
					org.apache.poi.ss.usermodel.Workbook tempWB;
					try {
//						String pID = readProgramID();
						String pID = "1";
//						if(fileName.replace("Data", "DataSheet-" + pID).contains(".xlsx")){
//							tempWB = new XSSFWorkbook(envFileName);
//						}
//						else
										
							InputStream inp = new FileInputStream(envFileName);
//							tempWB = (org.apache.poi.ss.usermodel.Workbook) new HSSFWorkbook(new POIFSFileSystem(inp));					
							tempWB = new XSSFWorkbook(inp);
						org.apache.poi.ss.usermodel.Sheet sheet = tempWB.getSheet(sheetName);
						System.out.println(sheet);
						list2.add(0, sheetName);
						//Row row = sheet.getRow(0);
						//int totalNoOfCols = row.getLastCellNum();
						
						for( int i=0; i<=5;i++)
						{
							Cell value =sheet.getRow(0).getCell(i);
							String values= value.toString();
							System.out.println(values);
							list2.add(i, values);
						}
					}
					catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					catch (IOException e) {
						e.printStackTrace();
					}
					return list2;
				}
				

	//Performance Check based on status in excel - Definition
			public static int performanceCheckStatus(WebDriver driver, String programIDValue , String colStatus, String xpath , long timeseconds ) throws ParseException
		    {
			     ArrayList<String> al_performanceCheck =new ArrayList<String>(); 
				 long startTime = timeseconds;
				 long endTime =12345678910L;
				 int statusTimeSeconds = 0;
	             try {	
	            	WebDriverWait wait = new WebDriverWait(driver, 150);
	            	Thread.sleep(1000);
	            	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	        	    endTime = System.currentTimeMillis();
	        	    long totalTime = endTime - startTime;
	                long l = (totalTime/1000) ;
	                statusTimeSeconds= (int) l;
	    	    
				   //fetching all the col names from Performance check Template 
	                String fileNamePerformance = System.getProperty("user.dir") + "\\Reports\\AutoMacro.xlsm";
	                dataReadingHBDSails(al_performanceCheck, fileNamePerformance, programIDValue);
					FileInputStream inputStream = new FileInputStream(new File(fileNamePerformance));
			        Workbook workbook = WorkbookFactory.create(inputStream);
			         Sheet sheets = workbook.getSheet(programIDValue);
			       
			        int lastRowNo=sheets.getLastRowNum();
			        System.out.println("lastrow "+lastRowNo);
			        
					if(counter==0) {
			        lastRowNo++;
			        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/uuuu");
			        LocalDate localDate = LocalDate.now();
			        //writing current date into template
			        sheets.createRow(lastRowNo).createCell(0).setCellValue(dtf.format(localDate));
			        }
			        counter++;	
			        
			        //writing Total time taken at each status into Template
					int columncount = al_performanceCheck.indexOf(colStatus);
					sheets.getRow(lastRowNo).createCell(columncount).setCellValue(statusTimeSeconds);
					
					inputStream.close();
					FileOutputStream outputStream = new FileOutputStream(fileNamePerformance);
			        workbook.write(outputStream);
			        workbook.close();
			        outputStream.close();
				}
				catch(java.lang.NullPointerException exception){
					exception.printStackTrace();
//					objRC.logFail(logger, "Null value in the column -"+exception, driver);		
				}
				catch(Exception e){
					e.printStackTrace();
//					objRC.logFail(logger, "Failed to identify the object-"+e, driver);
				}
		         return statusTimeSeconds;
		    }			

}
