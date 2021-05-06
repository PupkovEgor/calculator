package Package;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
@WebServlet(name="Adm", urlPatterns="/Admin")
public class Admin extends  HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestCalc Calc = RequestCalc.fromRequestParameters(request);
		Calc.setAsRequestAttributesAndCalculate(request);
		 
		request.getRequestDispatcher("/FormAdm.jsp").forward(request, response);
		
	}
	
	private static class RequestCalc {
		private final String length;
		private final String width;
		private final String height;
		private final String fl_count;
		private final String otdelka;
		private final String type;
						
		private RequestCalc (String dlina, String shirina, String visota, String floor_count, String otdelka, String type) {
			this.length = dlina;
			this.width = shirina;
			this.height = visota;
			this.fl_count = floor_count;
			this.otdelka = otdelka;	
			this.type = type;
		}
		public static RequestCalc fromRequestParameters (HttpServletRequest request) {
			return new RequestCalc(
				request.getParameter("length"),
				request.getParameter("width"),
				request.getParameter("height"),
				request.getParameter("floor"),
				request.getParameter("otdelka"),
				request.getParameter("type")
				);
			}
				
		public void setAsRequestAttributesAndCalculate(HttpServletRequest request) {
			Connection con =null;
            Statement stmt=null;
            con = getConnection();
            try {
            stmt = con.createStatement();
            String query;
            Double try_length = 0.0;
            Double try_width = 0.0;
            Double try_height = 0.0;
    		int try_fl_count = 0;
    		int try_otdelka = 0;    		
            try { 
            	try_length=Double.parseDouble(length);
            	try_width=Double.parseDouble(width);
            	try_height=Double.parseDouble(height);
            	try_fl_count = Integer.parseInt(fl_count);
            	try_otdelka = Integer.parseInt(otdelka);
    			}
    			catch (NumberFormatException e) {
    					
    			}
            switch (type) {
            case "1": {
            	query = "UPDATE settings SET length ='"+try_length+"' WHERE type = 'uptSummer'";
            	stmt.executeUpdate(query);
            	query = "UPDATE settings SET width ='"+try_width+"' WHERE type = 'uptSummer'"; 
            	stmt.executeUpdate(query);
            	query = "UPDATE settings SET height ='"+try_height+"' WHERE type = 'uptSummer'"; 
            	stmt.executeUpdate(query);
            	query = "UPDATE settings SET floor ='"+try_fl_count+"' WHERE type = 'uptSummer'"; 
            	stmt.executeUpdate(query);
            	query = "UPDATE settings SET otdelka ='"+try_otdelka+"' WHERE type = 'uptSummer'";    
            	stmt.executeUpdate(query);
            	break;
            }
            case "2":{
            	query = "UPDATE settings SET length ='"+try_length+"' WHERE type = 'uptWinter'"; 
            	stmt.executeUpdate(query);
            	query = "UPDATE settings SET width ='"+try_width+"' WHERE type = 'uptWinter'"; 
            	stmt.executeUpdate(query);
            	query = "UPDATE settings SET height ='"+try_height+"' WHERE type = 'uptWinter'"; 
            	stmt.executeUpdate(query);
            	query = "UPDATE settings SET floor ='"+try_fl_count+"' WHERE type = 'uptWinter'"; 
            	stmt.executeUpdate(query);
            	query = "UPDATE settings SET otdelka ='"+try_otdelka+"' WHERE type = 'uptWinter'";   
            	stmt.executeUpdate(query);
            	break;
            }
            case "3":{
            	query = "UPDATE settings SET length = (SELECT length FROM default_settings WHERE type = 'summer') WHERE type = 'uptSummer'"; 
            	stmt.executeUpdate(query);
            	query = "UPDATE settings SET width = (SELECT width FROM default_settings WHERE type = 'summer') WHERE type = 'uptSummer'"; 
            	stmt.executeUpdate(query);
            	query = "UPDATE settings SET height = (SELECT height FROM default_settings WHERE type = 'summer') WHERE type = 'uptSummer'"; 
            	stmt.executeUpdate(query);
            	query = "UPDATE settings SET floor = (SELECT floor FROM default_settings WHERE type = 'summer') WHERE type = 'uptSummer'"; 
            	stmt.executeUpdate(query);
            	query = "UPDATE settings SET otdelka = (SELECT otdelka FROM default_settings WHERE type = 'summer')WHERE type = 'uptSummer'";   
            	stmt.executeUpdate(query);
            	break;
            }
            case "4":{
            	query = "UPDATE settings SET length = (SELECT length FROM default_settings WHERE type = 'winter') WHERE type = 'uptWinter'"; 
            	stmt.executeUpdate(query);
            	query = "UPDATE settings SET width = (SELECT width FROM default_settings WHERE type = 'winter') WHERE type = 'uptWinter'"; 
            	stmt.executeUpdate(query);
            	query = "UPDATE settings SET height = (SELECT height FROM default_settings WHERE type = 'winter') WHERE type = 'uptWinter'"; 
            	stmt.executeUpdate(query);
            	query = "UPDATE settings SET floor = (SELECT floor FROM default_settings WHERE type = 'winter') WHERE type = 'uptWinter'"; 
            	stmt.executeUpdate(query);
            	query = "UPDATE settings SET otdelka = (SELECT otdelka FROM default_settings WHERE type = 'winter')WHERE type = 'uptWinter'";   
            	stmt.executeUpdate(query);
            	break; 
            }
            }
            
		}catch (SQLException sqlEx ){
			}
		}
	
	
	
	
	
	public static Connection getConnection() {
        String driver = "com.mysql.jdbc.Driver";
        final String url = "jdbc:mysql://remotemysql.com:3306/smszCuaCce";
        final String user = "smszCuaCce";
        final String password = "fjrxusR9mP";
        try {
            Class.forName(driver);
            java.sql.Connection con = DriverManager.getConnection(url,user,password);
            return con;

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Exception " + e);
            return null;
        }
    }

	}
}
