package servlets;

import java.io.IOException;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Piste;

/**
 * Servlet implementation class AeroportDatas
 */
@WebServlet("/aeroport")
public class AeroportDatas extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AeroportDatas() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HashMap<String,Piste> al = new HashMap<String,Piste>();
		Piste p1 = new Piste(2, 1500, 6, "N", 1);
		Piste p2 = new Piste(3, 2500, 10, "S", 1);
		Piste p3 = new Piste(4, 600, 6, "E", 1);
		Piste p4 = new Piste(5, 1500, 6, "O", 1);
		al.put("Piste 1", p1);
		al.put("Piste 2", p2);
		al.put("Piste 3", p3);
		al.put("Piste 4", p4);
		
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
		mapper.writeValue(response.getWriter(), al);
		System.out.println(response);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
