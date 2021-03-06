package controller;
import data.CancelReservationDAO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CancelReservations
 */
@WebServlet("/CancelReservations")
public class CancelReservations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelReservations() {
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
		String confirmationid = request.getParameter("confirmationid");
		String UTAID = request.getParameter("UTAID");
		System.out.println(confirmationid+ " " + UTAID + " " );
		CancelReservationDAO can=new CancelReservationDAO();
		can.Cancel(confirmationid);
		request.getRequestDispatcher("CancelReservation.jsp").forward(request, response);
		doGet(request, response);
	}

}
