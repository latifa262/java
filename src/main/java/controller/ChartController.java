package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.ReservationService;
import service.SalleService;

/**
 * Servlet implementation class chart
 */
@WebServlet("/ChartController")
public class ChartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReservationService os = new ReservationService();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChartController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("op").equals("salle")) {
			response.setContentType("application/json");
			Gson json = new Gson();
			response.getWriter().write(json.toJson(os.plusresrv()));

		}
		else if (request.getParameter("op").equals("monthly")) {
			response.setContentType("application/json");
			Gson json = new Gson();
			response.getWriter().write(json.toJson(os.parmois()));
		}
	}
}
