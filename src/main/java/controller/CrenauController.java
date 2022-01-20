package controller;

import java.io.IOException;
import java.security.Timestamp;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mysql.cj.result.LocalTimeValueFactory;

import beans.Crenau;
import beans.Salle;
import service.CrenauService;

/**
 * Servlet implementation class bb
 */
@WebServlet(urlPatterns = {"/CrenauController"})
public class CrenauController extends HttpServlet {

	private CrenauService crs = new CrenauService();
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

		if (request.getParameter("op") != null) {
            if (request.getParameter("op").equals("load")) {
                response.setContentType("application/json");
                List<Crenau> crenau = crs.findAll();
                Gson json = new Gson();
                response.getWriter().write(json.toJson(crenau));
            }else if(request.getParameter("op").equals("delete")){
                int id = Integer.parseInt(request.getParameter("id"));
                crs.delete(crs.findById(id));
                response.setContentType("application/json");
                List<Crenau> crenau = crs.findAll();
                Gson json = new Gson();
                response.getWriter().write(json.toJson(crenau));
            }
            else if(request.getParameter("op").equals("update")){
                int id = Integer.parseInt(request.getParameter("id"));
                Time heureDeb = Time.valueOf(request.getParameter("heureDeb")+ ":00");
                Time heureFin = Time.valueOf(request.getParameter("heureFin")+":00");
                //(req.getP..() + ":00")
                  
                Crenau m = crs.findById(id);
                 System.out.println(id);
                 m.setHeureDeb(heureDeb);
                 m.setHeureFin(heureFin);

                 crs.update(m);
                response.setContentType("application/json");
                List<Crenau> crenau = crs.findAll();
                Gson json = new Gson();
                response.getWriter().write(json.toJson(crenau));
                
            }
        } else {
            Time heureDeb = Time.valueOf(request.getParameter("heureDeb")+":00");
            Time heureFin = Time.valueOf(request.getParameter("heureFin")+":00");
			
				//SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
				//Date heureFin = new Date(request.getParameter("heureFin"));
				//format.format(date);
				//Time heureFin = new Time(request.getParameter("heureFin"));
        	    //String heureDeb = new SimpleDateFormat("HH:mm:ss").format((new Date()));
        	    //String heureFin = new SimpleDateFormat("HH:mm:ss").format((new Date()));
        	//SimpleDateFormat dtf = new SimpleDateFormat("hh:mm:ss");
           //String s1=dtf.format(heureDeb);
           //String s2=dtf.format(heureFin);

        	    //SimpleDateFormat heureDeb = new SimpleDateFormat("HH:mm:ss");
				//Date heureFin = new SimpleDateFormat("HH:mm:ss").parse(request.getParameter("heureFin"));
	            crs.create(new Crenau(heureDeb, heureFin));
	            response.setContentType("application/json");
	            List<Crenau> crenau = crs.findAll();
	            Gson json = new Gson();
	            response.getWriter().write(json.toJson(crenau));
			
        }
        
        
    }

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
    }

}
