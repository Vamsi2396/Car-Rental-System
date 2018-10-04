package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.fabric.xmlrpc.base.Array;

import data.ManagerDAO;
import model.ManagerModel;

/**
 * Servlet implementation class ManagerController
 */
@WebServlet("/ManagerController")
public class ManagerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				String sub=request.getParameter("submit");
				System.out.println(sub);
				ManagerDAO user=new ManagerDAO();
				if(sub.equalsIgnoreCase("ViewAllCarsRented")) {
				String startdate = request.getParameter("startdate");
				String enddate = request.getParameter("enddate");
				System.out.println(startdate+ " " + enddate + " " );
				ArrayList<ManagerModel> mm =    user.ViewAllCarsRented(startdate, enddate);
				response.setContentType("text/html");
                
			     
			      PrintWriter out = response.getWriter();
			      out.println("<head>");
			      out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"test.css\" media=\"screen\" />");
			      out.println("</head>");
			      out.println("<img src=\"car4.png\" alt=\"car img\" height=\"100\" width=\"100\">");
			      out.println("<h1> List Of Reservations  <h1>");
			      for (ManagerModel a : mm){
			    	  out.println( a.getCarName() + "   " + a.getReservationid() );  
			    	  out.println( " Start Time "+ a.getStartTime() + " StartDate  " + a.getstartdate() );  
			    	  out.println( " END Time "+ a.getEndTime() + "END Date  " + a.getenddate() );  
			        
			      
			      }
				doGet(request, response);
			}
				else if(sub.equalsIgnoreCase("ViewDetails")) {
					String reservationid = request.getParameter("confirmationid");
					System.out.println(reservationid+ " ");
					ManagerDAO result=new ManagerDAO();
					ArrayList<ManagerModel>  mm =     result.ViewSpecificRental(reservationid);
					response.setContentType("text/html");
	                
				     
				      PrintWriter out = response.getWriter();
				      out.println("<head>");
				      out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"test.css\" media=\"screen\" />");
				      out.println("</head>");
				      out.println("<img src=\"car4.png\" alt=\"car img\" height=\"100\" width=\"100\">");
				      out.println("<h1> Details of  " +  reservationid  + "  <h1>");
				      for (ManagerModel a : mm){
				    	  out.println( a.getCarName() + "   " + a.getReservationid() );  
				    	  out.println( " Start Time "+ a.getStartTime() + " StartDate  " + a.getstartdate() );  
				    	  out.println( " END Time "+ a.getEndTime() + "END Date  " + a.getenddate() );  
				        
				      
				      }
				}
				else if(sub.equalsIgnoreCase("AddCar")) {
					String CarName=request.getParameter("CarName");
					String Capacity=request.getParameter("Capacity");
					String WeekDay=request.getParameter("WeekDay");
					String WeekEnd=request.getParameter("WeekEnd");
					String Week=request.getParameter("Week");
					String Gps=request.getParameter("Gps");
					String OnStar=request.getParameter("OnStar");
					String SiriusXM=request.getParameter("SiriusXM");
					ManagerDAO add=new ManagerDAO();
					add.AddCar(CarName,Capacity,WeekDay,WeekEnd,Week,Gps,OnStar,SiriusXM);
					request.getRequestDispatcher("ManagerHomePage.jsp").forward(request, response);
				
				}
				else if(sub.equalsIgnoreCase("DeleteRental")) {
				String reservationid = request.getParameter("confirmationid");
				System.out.println(reservationid+ " ");
				ManagerDAO result=new ManagerDAO();
				result.delete(reservationid);
				request.getRequestDispatcher("ManagerHomePage.jsp").forward(request, response);
				}
				
				else if(sub.equalsIgnoreCase("UpdateProfile")) {
						HttpSession session = request.getSession();
						String username=request.getParameter("username");
						session.setAttribute("username",username);
						String name=request.getParameter("name");
						String email=request.getParameter("email");
						String phone=request.getParameter("phone");
						String addr=request.getParameter("addr");
						String curpassword=request.getParameter("curpassword");
						String newpassword=request.getParameter("newpassword");
						String conpassword=request.getParameter("conpassword");
						//System.out.println(session.getAttribute("username"));
						ManagerDAO update=new ManagerDAO();
						update.UpdateManager(name, email, phone, addr, newpassword, username);
						request.getRequestDispatcher("ManagerHomePage.jsp").forward(request, response);
						session.invalidate();
					
				}
	}

}
