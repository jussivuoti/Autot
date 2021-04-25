package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import model.Auto;
import model.dao.Dao;

/**
 * Servlet implementation class Autot
 */
@WebServlet("/autot/*")
public class Autot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Autot() {
        super();
        System.out.println("Autot.Autot()");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	     System.out.println("Autot.doGet()");
	     String pathInfo = request.getPathInfo(); //Haetaan kutsun hakutiedot esim. /audi
	     System.out.println("polku: " +pathInfo);
	     String hakusana = pathInfo.replace("/", "");
	     
	     
	     Dao dao = new Dao();
	     ArrayList<Auto> autot = dao.listaaKaikki(hakusana);
	     System.out.println(autot);
	     String strJSON = new JSONObject().put("autot", autot).toString(); //Muuttaa JSONiksi
	     response.setContentType("application/json");
	     PrintWriter out = response.getWriter();
	     out.println(strJSON);     
	     
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("Autot.doPost()");
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Autot.doPut()");
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Autot.doDelete()");
	}

}
