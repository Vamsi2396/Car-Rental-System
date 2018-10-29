package data;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javafx.scene.input.Mnemonic;



public class transactionDAO {
    
	static PreparedStatement ps;
	
	public ArrayList searchcar(String startdate , String enddate , String starttime , String endtime , String capacity){
	   	 int status = 0 ;
	   	// String query="select * from reservedcars where startdate>=CAST(? AS DATE) and enddate<=CAST(? as DATE);";
	   	String query = " select cars.CarName from cars where capacity > ? and cars.CarName NOT IN (select CarName from transaction where startdate >CAST(? as DATE) and enddate < CAST(? as DATE) and starttime >= ? and enddate <= ?) " ;
	   		ArrayList<String> mm = null ;
	   		System.out.println("IN DAO");
	   		try {
	   			System.out.println(startdate + " " + enddate + " " + starttime + " " + endtime + " " + capacity);
	   			Class.forName("com.mysql.jdbc.Driver");  
	   			Connection con=DriverManager.getConnection(  
	   				      "jdbc:mysql://localhost:3306/test","root","");  
	   			PreparedStatement ps;
	   			ps=con.prepareStatement(query);
	   		  
	   		    ps.setString(1, capacity);
	   		    ps.setString(2, startdate);
	   		    ps.setString(3, enddate);
	   		    ps.setString(4, starttime);
	   		    ps.setString(5, endtime);
	   		    
	   		    ResultSet rs1 = ps.executeQuery();
	   		    
	   		    mm = new ArrayList<>();
	   		    while(rs1.next()) {
	   		    	System.out.println(rs1.getString(1));
	   		    	mm.add(rs1.getString(1));	

	   		    }
	   		    con.close();
	   		    
	   		} catch (Exception e) {
	   			System.out.println(e);
	   		}
	   		return mm;
	   	 }
	
	public boolean bookcar( String CarName , String Username ,String starttime, String startdate , String endtime ,String enddate){
		String query="INSERT INTO reservedcars(CarName,Username,Starttime,Startdate,Endtime,EndDate) VALUES(?,?,?,?,?,?)";
		boolean status  = false ;;
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
				      "jdbc:mysql://localhost:3306/test","root","");  
			ps=con.prepareStatement(query);
		    ps.setString(1, CarName);
		    ps.setString(2, Username);
		    ps.setString(3, starttime);
		    ps.setString(4, startdate);
		    ps.setString(5, endtime);
		    ps.setString(6, enddate);
		    status = ps.execute();

		    con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		return status;
	}
	

}