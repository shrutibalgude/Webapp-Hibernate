package api;
import java.io.IOException;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Personservley
 */
public class Personservlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String apiUrl=request.getRequestURI();
		String name=apiUrl.substring("/Person/*".length());
		Person person=DataStore .getInstance().getPerson(name);
		
		if(person!=null) {
			String json="{\n";
			json+="\"pid\":"+JSONObject.quote(Integer.toString(person.getPid()))+",\n";
			json+="\"name\":"+JSONObject.quote(person.getName())+",\n";
			json+="\"address\":"+JSONObject.quote(person.getAddress())+",\n";
			json+="}";
			response.getOutputStream().print(json);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
