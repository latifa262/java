package controller;

import java.io.IOException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import beans.Client;
import beans.Crenau;
import beans.Salle;
import beans.reserv;
import beans.reservation;
import dao.IDao;
import service.ClientService;
import service.CrenauService;
import service.ReservationService;
import service.SalleService;

/**
 * Servlet implementation class reservation
 */
@WebServlet("/ReservationController")
public class ReservationController extends HttpServlet {
    //private ReservationService os = new ReservationService();
    //private ClientService ms = new ClientService();
    ReservationService rs = new ReservationService();
	SalleService ss = new SalleService();
	ClientService cls = new ClientService();
	CrenauService crs = new CrenauService();

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		/*if (request.getParameter("op").equals("add")) {
			int client = Integer.parseInt(request.getParameter("idClient"));
			int salle = Integer.parseInt(request.getParameter("idSalle"));
			int crenau = Integer.parseInt(request.getParameter("idCreneau"));
            Date date = new Date(request.getParameter("date").replace("-", "/"));

			rs.create(new reservation(ss.findById(salle), crs.findById(crenau) ,cls.findById(client), date));
			response.setContentType("application/json");
			//List<reservation> occupations = rs.findByclient(client);

			Gson json = new Gson();
			//response.getWriter().write(json.toJson(occupations));
		}*/
    	
		if (request.getParameter("op") != null) {
            if (request.getParameter("op").equals("load")) {
                response.setContentType("application/json");
                List<reserv> machines = rs.findAll2();
                Gson json = new Gson();
                response.getWriter().write(json.toJson(machines));
            }else if(request.getParameter("op").equals("delete")){

                
            }else if(request.getParameter("op").equals("update")){            	

                
            

            }
        } else {
        	int nom = Integer.parseInt(request.getParameter("nom"));
        	int code = Integer.parseInt(request.getParameter("code"));
        	int heureDeb = Integer.parseInt(request.getParameter("heureDeb"));
        	Date date = new Date(request.getParameter("date").replace("-", "/"));
        	System.out.println("*****************");
        	System.out.println(date);
        	System.out.println(code);
        	System.out.println(heureDeb);
        	System.out.println(nom);
        	String status="en attente";
            rs.create(new reservation(nom,code,heureDeb, date,status));
            response.setContentType("application/json");
            List<reserv> machines = rs.findAll2();
            Gson json = new Gson();
            response.getWriter().write(json.toJson(machines));
        

    }

    }
        
            

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	 @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        processRequest(request, response);
	    }

	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        processRequest(request, response);
	    }

	    /**
	     * Returns a short description of the servlet.
	     *
	     * @return a String containing servlet description
	     */
	    @Override
	    public String getServletInfo() {
	        return "Short description";
	    }// </editor-fold>

}
