package es.dwes.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SesionesSinCookiesB")
public class SesionesSinCookiesB extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void procesaSolicitud(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            //Se guarda o crea una sesión asociada a la petición
            HttpSession unaSesion = request.getSession(true);
            //Se almacena la dirección URI de la petición
            String cadenaURI=request.getRequestURI();
            
            // Se imprimen los atributos principales de la sesión
            out.println("<html><head><title>SesionesSinCookiesB</title></head>");
            out.println("<body>");
            out.println("<h1>SesionesSinCookiesB</h1>");
            out.println("<h3>Servlet SesionesSinCookiesB</h3>");
            out.println("Id de sesión (jsessionid): " + unaSesion.getId() + "<br />");
            out.println("Nueva session: <b>" + unaSesion.isNew() + "</b><br />");
            out.println("URI=" + cadenaURI + "<br />");
            out.println("QueryString= " + request.getQueryString() + "<br />");
            out.println("Identificador de sesión obtenido mediante cookie: <b>" +
                    request.isRequestedSessionIdFromCookie() + "</b> <br />");
            out.println("Identificador de sesión obtenido mediante URI: <b>");
            out.println(request.isRequestedSessionIdFromURL() + "</b><br />");
              
            // Reenvío de la sesión (jsessionid) mediante response.encodeURL()
            out.println("<h2>Reenvío de sesión vía URI</h2>");
            out.println("Permite el reenvío de sesión incluso cuando las cookies están deshabilitadas <br /> ");
            out.println("Observa el medio para obtener el identificador de sesión <br /> <br />");
            out.println("<a href=\"" + response.encodeURL("RecuperaSesion") + "\">Reenvío de sesión mediante URI</a>"); 
        }           
        catch (Exception e){ 
            out.println("Se produce una excepción <br />");
            out.println(e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        procesaSolicitud(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        procesaSolicitud(request, response);
    }
}
