package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.CYTC_063UserRegistrationBean;
import com.training.dao.CYTC_063UserRegistrationDAO;
import com.training.readexcel.CYTC_061UserRegistrationValidationPOIApache;
import com.training.readexcel.CYTC_062MultipleUserRegistrationTestPOIApache;
import com.training.readexcel.CYTC_065AccessProvideToMultipleUserTestPOIApache;
import com.training.readexcel.ReadExcel;


public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<CYTC_063UserRegistrationBean> list = new CYTC_063UserRegistrationDAO().getuserregistration1(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(CYTC_063UserRegistrationBean temp : list){
			Object[]  obj = new Object[14]; 
			obj[0] = temp.getloginname();
			obj[1] = temp.getfullname();
			obj[2] = temp.getemail();
			obj[3] = temp.getbirthday();
			obj[4] = temp.getaddress();
			obj[5] = temp.getpostcode();
			obj[6] = temp.getcity();
			obj[7] = temp.getphone();
			obj[8] = temp.getmobile();
			obj[9] = temp.getfax();
			obj[10] = temp.geturl();
			obj[11] = temp.getpassword();
			obj[12] = temp.getconfirmpassword();
			obj[13] = temp.getcomments();
			
			result[count ++] = obj; 
		}
		return result;
	}
	
	@DataProvider(name = "excel-inputs1")
	public Object[][] getExcelData1(){
		String fileName ="C:/Users/MaheshVenkataswamy/Desktop/Selenium projects - Manipal/TestData.xlsx"; 
		return new CYTC_061UserRegistrationValidationPOIApache().getExcelContent(fileName); 
	}
	
	@DataProvider(name = "excel-inputs2")
	public Object[][] getExcelData2(){
		String fileName ="C:/Users/MaheshVenkataswamy/Desktop/Selenium projects - Manipal/TestData.xlsx";
		return new CYTC_062MultipleUserRegistrationTestPOIApache().getExcelContent(fileName); 
	}
	
	@DataProvider(name = "excel-inputs3")
	public Object[][] getExcelData3(){
		String fileName ="C:/Users/MaheshVenkataswamy/Desktop/Selenium projects - Manipal/TestData.xlsx"; 
		return new CYTC_065AccessProvideToMultipleUserTestPOIApache().getExcelContent(fileName); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}
}
