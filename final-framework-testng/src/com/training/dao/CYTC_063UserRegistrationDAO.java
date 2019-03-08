package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.CYTC_063UserRegistrationBean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

// Data Access Object 
public class CYTC_063UserRegistrationDAO {
	
	Properties properties; 
	
	public CYTC_063UserRegistrationDAO() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<CYTC_063UserRegistrationBean> getuserregistration1(){
		String sql = properties.getProperty("get.userregistration1"); 
		
		GetConnection gc  = new GetConnection(); 
		List<CYTC_063UserRegistrationBean> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<CYTC_063UserRegistrationBean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				CYTC_063UserRegistrationBean temp = new CYTC_063UserRegistrationBean(); 
				temp.setloginname(gc.rs1.getString(1));
				temp.setfullname(gc.rs1.getString(2));
				temp.setemail(gc.rs1.getString(3));
				temp.setbirthday(gc.rs1.getString(4));
				temp.setaddress(gc.rs1.getString(5));
				temp.setpostcode(gc.rs1.getString(6));
				temp.setcity(gc.rs1.getString(7));
				temp.setphone(gc.rs1.getString(8));
				temp.setmobile(gc.rs1.getString(9));
				temp.setfax(gc.rs1.getString(10));
				temp.seturl(gc.rs1.getString(11));
				temp.setpassword(gc.rs1.getString(12));
				temp.setconfirmpassword(gc.rs1.getString(13));
				temp.setcomments(gc.rs1.getString(14));

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	
	public static void main(String[] args) {
		new CYTC_063UserRegistrationDAO().getuserregistration1().forEach(System.out :: println);
	}
	
	
}
