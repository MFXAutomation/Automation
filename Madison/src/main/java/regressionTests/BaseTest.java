package regressionTests;


import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.observer.ExtentObserver;

//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import functions.Reporting;
import tech.grasshopper.reporter.ExtentPDFReporter;

public class BaseTest {

	public static ExtentSparkReporter html;
	
	public static ExtentReports extent;
	
	
	public static ExtentPDFReporter pdf;
	public static String pol;
	
	public static String claim;
	
	
	public static int iterCount=0;
	public static int size=0;
	public static int arr[]=new int[10];
	public static String testarr[]=new String[10];
	public static String testcase;
	static int rowNum=0;
	static int rowCount=0;

	public static int i=1;
	@BeforeSuite
	public void SuiteSetUp() throws IOException {
		dataset();
		Reporting report= new Reporting();
	    extent = new ExtentReports();
	    Reporting.extent2= new ExtentReports();
//	    Reporting.extHTMLReporter =report.locReport(System.getProperty("user.dir"));
	    
	    
	    html= new ExtentSparkReporter(System.getProperty("user.dir") +"\\test-output\\Test2.html");
	    
	   
	 
	    pdf=new ExtentPDFReporter(System.getProperty("user.dir") +"\\test-output\\TestResults.pdf");
	    
//	    ((Object) report).extReport();
	    extent.attachReporter(html);
	    extent.attachReporter(pdf);
//	    html.config().setDocumentTitle("Madison Test Report");
//	    html.config().setReportName("Madison Mutual Report");
//	   
	    html.loadXMLConfig(System.getProperty("user.dir")+"\\extent-config.xml");
	    
	    String color=Color.black.toString();
	    pdf.config().setSystemAttributeColor(Color.black.toString());
//	    pdf.loadXMLConfig(System.getProperty("user.dir")+"\\extent-config.xml");
//	    pdf.config().setReportName("Automation Report");
//	    pdf.config().setReporter(html);
	    pdf.config().setTitle("Madison Test Report");
	    
	  
	   
	   
	}
	
	
	@AfterClass
	public void details() {
//		if (!pol.isEmpty()) {
//			extent.setSystemInfo("Policy Number " + i, pol);
//
//		}
		
//		 if (!claim.isEmpty()) {
//			extent.setSystemInfo("Claim Number " + i, claim);
//
//		}
		i++;
	}
	 
	
	@BeforeTest
	public void rowNum() {
		
		iterCount=arr[rowCount]-1;
		testcase=testarr[rowCount];
		
		System.out.println(iterCount);
	}
	
	
	@AfterTest
	public void updateRowCount() {
		rowCount++;
	}
	
//	public void SuiteFinish() {
//		extent.flush();
//	}
	@AfterSuite
	public void testrun() throws AddressException, MessagingException, IOException {
		
//		otklcwsumjfkhxjg
		extent.flush();
	
	String to="292850@conneqtcorp.com"; //
//	String to1="ashirke@fcci-group.com";
	String from="292850@conneqtcorp.com";
//	 String to="shirkeamey1@gmail.com";
//	 String from="pcsetups67@gmail.com";
//	String host="smtp.gmail.com";
	String host2="outlook.office365.com"; 
//	 String host2="smtp.office365.com";
//	String host2="52.98.57.162";
	String body="Hi ,\n \nPlease find report attached \n \nAuto generate mail"; // String pass="TruptiS@01";
//	 String pass="otklcwsumjfkhxjg";
	String pass="TruptiS@002";

	Properties prop=System.getProperties();
	
	
//	prop.put("mail.smtp.starttls.enable","true");
	
//	prop.setProperty("mail.smtp.host", host); // prop.put("mail.smtp.host",host);
	prop.put("mail.smtp.user",from);
	prop.put("mail.smtp.password", pass);
	prop.put("mail.smtp.port", "587");
//	prop.put("mail.smtp.ssl.trust", host);
	prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
	prop.put("mail.smtp.starttls.enable", "true");
	prop.put("mail.smtp.auth", "true");
	Session session = Session.getDefaultInstance(prop);

	Message message=new MimeMessage(session);

	message.setFrom(new InternetAddress(from));
	message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//	message.addRecipient(Message.RecipientType.TO, new InternetAddress(to1));
	message.setSubject("testng report"); message.setText(body);

	BodyPart msgbodypart=new MimeBodyPart();
	msgbodypart.setText(body);

	MimeBodyPart attach=new MimeBodyPart();
	String filename=System.getProperty("user.dir") +"\\test-output\\TestResults.pdf";
	attach.attachFile(filename);

	Multipart mltipart=new MimeMultipart();
	mltipart.addBodyPart(msgbodypart);
	mltipart.addBodyPart(attach);



	message.setContent(mltipart);

	Transport transport=session.getTransport("smtp");
	transport.connect(host2,-1,from,pass);
//	 Transport.send(message);
	transport.sendMessage(message,message.getAllRecipients());
	transport.close();
}
	
	public void dataset() throws IOException {

		File file = new File(System.getProperty("user.dir")+"\\Regression_Suite.xlsx");
		FileInputStream fs = new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet sheet = wb.getSheet("RegressionSuite");

		int rowcount = sheet.getPhysicalNumberOfRows();

		int colcount = sheet.getRow(0).getLastCellNum();
//	
		int last = sheet.getLastRowNum();

		int count = 0;
		DataFormatter formatter = new DataFormatter();
		
		for (int i = 0; i <= last; i++) {

			String flag = formatter.formatCellValue(sheet.getRow(i).getCell(2));
			String test=formatter.formatCellValue(sheet.getRow(i).getCell(0));
			if (flag.equalsIgnoreCase("Yes")) {
				rowNum=i;
//				System.out.println("row number "+rowNum);
				arr[count]=i;
				testarr[count]=test;
				
				count++;
			}
		}
//		System.out.println(count);
	}
	
}

