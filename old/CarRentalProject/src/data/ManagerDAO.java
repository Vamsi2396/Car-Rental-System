package data;

import java.sql.*;

import model.ManagerModel;

public class ManagerDAO {
	static Connection con;
	static PreparedStatement ps;
	ManagerModel viewMy=null;
public void ViewAllCarsRented(String startdate,String enddate) {
	String query="select * from reservedcars where startdate>=CAST(? AS DATE) and enddate<=CAST(? as DATE);";
	try {
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
			      "jdbc:mysql://localhost:3306/carrental","root","");  
		ps=con.prepareStatement(query);
	    ps.setString(1, startdate);
	    ps.setString(2, enddate);
	    ResultSet rs1 = ps.executeQuery();
	    while(rs1.next()) {
	    	viewMy = new ManagerModel();
	    	viewMy.setReservationid(rs1.getString("Reservationid"));
	    	viewMy.setCarName(rs1.getString("CarName"));
	    	viewMy.setStartTime(rs1.getString("StartTime"));
	    	viewMy.setstartdate(rs1.getString("StartDate"));
	    	viewMy.setEndTime(rs1.getString("EndTime"));
	    	viewMy.setenddate(rs1.getString("EndDate"));
	    	System.out.println(viewMy.getReservationid());
	    	System.out.println(viewMy.getCarName());
	    	System.out.println(viewMy.getStartTime());
	    	System.out.println(viewMy.getstartdate());
	    	System.out.println(viewMy.getEndTime());
	    	System.out.println(viewMy.getenddate());
	    	
	    }
	    con.close();
//	    return rs;
	} catch (Exception e) {
		System.out.println(e);
	}
}
public void ViewSpecificRental(String Reservationid){
	
String query="select * from reservedcars where Reservationid=?";
try {
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection(  
		      "jdbc:mysql://localhost:3306/carrental","root","");  
	ps=con.prepareStatement(query);
    ps.setString(1, Reservationid);
    ResultSet rs1 = ps.executeQuery();
    while(rs1.next()) {
    	viewMy = new ManagerModel();
    	viewMy.setReservationid(rs1.getString("Reservationid"));
    	viewMy.setCarName(rs1.getString("CarName"));
    	viewMy.setStartTime(rs1.getString("StartTime"));
    	viewMy.setstartdate(rs1.getString("StartDate"));
    	viewMy.setEndTime(rs1.getString("EndTime"));
    	viewMy.setenddate(rs1.getString("EndDate"));
    	System.out.println(viewMy.getReservationid());
    	System.out.println(viewMy.getCarName());
    	System.out.println(viewMy.getStartTime());
    	System.out.println(viewMy.getstartdate());
    	System.out.println(viewMy.getEndTime());
    	System.out.println(viewMy.getenddate());
    	
    }
    con.close();
//    return rs;
} catch (Exception e) {
	System.out.println(e);
}
}
public void AddCar(String CarName,String Capacity, String WeekDay,String WeekEnd,String Week, String Gps,String OnStar,String SiriusXM){
	
String query="INSERT INTO CARS VALUES(?,?,?,?,?,?,?,?)";
try {
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection(  
		      "jdbc:mysql://localhost:3306/carrental","root","");  
	ps=con.prepareStatement(query);
    ps.setString(1, CarName);
    ps.setString(2, Capacity);
    ps.setString(3, WeekDay);
    ps.setString(4, WeekEnd);
    ps.setString(5, Week);
    ps.setString(6, Gps);
    ps.setString(7, OnStar);
    ps.setString(8, SiriusXM);
    ps.execute();
//    while(rs1.next()) {
//    	viewMy = new ManagerModel();
//    	viewMy.setReservationid(rs1.getString("Reservationid"));
//    	viewMy.setCarName(rs1.getString("CarName"));
//    	viewMy.setStartTime(rs1.getString("StartTime"));
//    	viewMy.setstartdate(rs1.getString("StartDate"));
//    	viewMy.setEndTime(rs1.getString("EndTime"));
//    	viewMy.setenddate(rs1.getString("EndDate"));
//    	System.out.println(viewMy.getReservationid());
//    	System.out.println(viewMy.getCarName());
//    	System.out.println(viewMy.getStartTime());
//    	System.out.println(viewMy.getstartdate());
//    	System.out.println(viewMy.getEndTime());
//    	System.out.println(viewMy.getenddate());
//    	
//    }
    con.close();
//    return rs;
} catch (Exception e) {
	System.out.println(e);
}
}

}

