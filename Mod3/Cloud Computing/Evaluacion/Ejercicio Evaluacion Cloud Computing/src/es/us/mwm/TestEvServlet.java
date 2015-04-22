package es.us.mwm;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class TestEvServlet extends HttpServlet {	
		
	Map<String, User> entradas;
		
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		
		resp.setContentType("text/html");
		resp.getWriter().println("<html><head></head><body>");
		
		UserService userService = UserServiceFactory.getUserService();
		String thisURL = req.getRequestURI();
		
		if (req.getUserPrincipal() != null) {
			String username = req.getUserPrincipal().getName();
			resp.getWriter().println("<p>Hello, "+username+"! Puedes salir en <a href=\"" + userService.createLogoutURL(thisURL) + "\"> sign out</a>.</p>");
			
			resp.getWriter().println("Posts de " + username);
			resp.getWriter().println("<table>");
			resp.getWriter().println("<tr><td>Titulo</td><td>Fecha</td><td>Cuerpo</td></tr>");
			Query entradasQuery = new Query("Entrada");
			List<Entity> resultados = datastore.prepare(entradasQuery).asList(FetchOptions.Builder.withDefaults());
			for (Entity elemento:resultados){
				resp.getWriter().println("<tr>");
				resp.getWriter().println("<td>"+elemento.getProperty("fecha")+"</td>");
				resp.getWriter().println("<td>"+elemento.getProperty("titulo")+"</td>");
				resp.getWriter().println("<td>"+elemento.getProperty("texto")+"</td></tr>");
			}
			resp.getWriter().println("</table>");
			resp.getWriter().println("<p> <a href=\"index.html\">Volver a insertar un post</a></p>");
		}else{
			resp.getWriter().println("<p>Please <a href=\"" + userService.createLoginURL(thisURL) + "\">sign in</a>.</p>");
			
			}
		
		
		resp.getWriter().println("</body></html>");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {		
		
		if (req.getUserPrincipal() != null){
			
			String username = req.getUserPrincipal().getName();
			
			String fecha = req.getParameter("fechaEntrada");
			String titulo = req.getParameter("tituloEntrada");
			String texto = req.getParameter("textoEntrada");
			
			Entrance entrada = new Entrance(fecha,texto,titulo);
			User user = new User();		
			List<Entrance> entrances = new ArrayList<Entrance>();
			entrances.add(entrada);
			
			user.setUsername(username);
			user.setEntrances(entrances);
			
			entradas = new HashMap<String, User>();
			entradas.put(user.getUsername(), user);
			saveData();
			resp.sendRedirect("testev");
			
			} else {				
				resp.sendRedirect("testev");				
			}        		
	}
	
	public void saveData(){
		for(Entry<String, User> userEntry:entradas.entrySet()){
		User user = userEntry.getValue();
		storeEntity(user);
		}
	}
	
	public void storeEntity(User user){
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		
		Entity userEntity = new Entity("User",user.getUsername());
		datastore.put(userEntity);
		Key userKey = userEntity.getKey();
		for(Entrance entrada:user.getEntrances()){
			Entity entradaEntity = new Entity("Entrada",entrada.getTitulo(),userKey);
			entradaEntity.setProperty("fecha", entrada.getFecha());
			entradaEntity.setProperty("texto", entrada.getTexto());
			entradaEntity.setProperty("titulo", entrada.getTitulo());
			datastore.put(entradaEntity);
		}			
	}
}
