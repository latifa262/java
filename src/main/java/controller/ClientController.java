package controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.Client;
import beans.Crenau;
import service.ClientService;
import service.CrenauService;

/**
 * Servlet implementation class ClientController
 */
@WebServlet("/ClientController")
public class ClientController extends HttpServlet {
	
private ClientService cs = new ClientService();
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

		if (request.getParameter("op") != null) {
            if (request.getParameter("op").equals("load")) {
                response.setContentType("application/json");
                List<Client> clients = cs.findAll();
                Gson json = new Gson();
                response.getWriter().write(json.toJson(clients));
            }
            
            else if(request.getParameter("op").equals("delete")){
                int id = Integer.parseInt(request.getParameter("id"));
                cs.delete(cs.findById(id));
                response.setContentType("application/json");
                List<Client> clients = cs.findAll();
                Gson json = new Gson();
                response.getWriter().write(json.toJson(clients));
            }
            else if(request.getParameter("op").equals("update")){
                int id = Integer.parseInt(request.getParameter("id"));
                String nom = request.getParameter("nom");
                String prenom = request.getParameter("prenom");

                  
                Client m = cs.findById(id);
                 System.out.println(id);
                 m.setNom(nom);
                 m.setPrenom(prenom);

                 cs.update(m);
                response.setContentType("application/json");
                List<Client> clients = cs.findAll();
                Gson json = new Gson();
                response.getWriter().write(json.toJson(clients));
                
            }
        } else {
        	String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
             
            cs.create(new Client(nom, prenom));
            response.setContentType("application/json");
            List<Client> clients = cs.findAll();
            Gson json = new Gson();
            response.getWriter().write(json.toJson(clients));
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
