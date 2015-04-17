package es.us.mwm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class HolaMundoServlet extends HttpServlet {
	
	private Map<String, User> tasks;
	private static DatastoreService dataStore = DatastoreServiceFactory.getDatastoreService();
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		initTasks();
		resp.setContentType("text/html");
		UserService userService = UserServiceFactory.getUserService();
		String thisURL = req.getRequestURI();
		
		if(req.getUserPrincipal()!=null){
			String username	= req.getUserPrincipal().getName();
			resp.getWriter().println("<p>Hello,	"+username+
					"!You can<a href=\""+userService.createLogoutURL(thisURL)+"\">signout</a>.</p>");
			resp.getWriter().println("Tareas del dia");
			resp.getWriter().println("<table>");
			resp.getWriter().println("<tr><td>Tarea</td><td>Horas</td></tr>");
			for(Task task:tasks.get(username).getTasks()){
				resp.getWriter().println("<tr>");
				resp.getWriter().println("<td>"+task.getName()+"</td>");
				resp.getWriter().println("<td>"+task.getHours()+"</td></tr>");
			}
			resp.getWriter().println("</table>");
		}else{
			resp.getWriter().println("<p>Please<a href=\""+
					userService.createLoginURL(thisURL)	+"\">sign in</a>.</p>");
		}
			resp.getWriter().println("</body></html>");
	}	
	
	public void initTasks(){
		tasks = new HashMap<String, User>();
		Task task1 = new Task("Preparar classe",20);
		Task task2 = new Task("Desarrolloss	ejemplo",4);
		Task task3 = new Task("Revisar presupuestos",12);
		List<Task> danlossTasks	= new ArrayList<Task>();
		User danloss = new User();
		danloss.setUsername("ddanloss@gmail.com");
		danlossTasks.add(task1);
		danlossTasks.add(task2);
		danloss.setTasks(danlossTasks);
		User danmarjim = new User();
		danmarjim.setUsername("danmarjim@gmail.com");
		List<Task> danmarjimTasks = new ArrayList<Task>();
		danmarjimTasks.add(task3);
		danmarjim.setTasks(danmarjimTasks);
		tasks.put(danloss.getUsername(), danloss);
		tasks.put(danmarjim.getUsername(), danmarjim);
	}
	
}
