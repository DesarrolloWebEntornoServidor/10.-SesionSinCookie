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
            //Se guarda o crea una sesi�n asociada a la petici�n
            HttpSession unaSesion = request.getSession(true);
            //Se almacena la direcci�n URI de la petici�n
            String cadenaURI=request.getRequestURI();
            
            // Se imprimen los atributos principales de la sesi�n
            out.println("<html><head><title>SesionesSinCookiesB</title></head>");
            out.println("<body>");
            out.println("<h1>SesionesSinCookiesB</h1>");
            out.println("<h3>Servlet SesionesSinCookiesB</h3>");
            out.println("Id de sesi�n (jsessionid): " + unaSesion.getId() + "<br />");
            out.println("Nueva session: <b>" + unaSesion.isNew() + "</b><br />");
            out.println("URI=" + cadenaURI + "<br />");
            out.println("QueryString= " + request.getQueryString() + "<br />");
            out.println("Identificador de sesi�n obtenido mediante cookie: <b>" +
                    request.isRequestedSessionIdFromCookie() + "</b> <br />");
            out.println("Identificador de sesi�n obtenido mediante URI: <b>");
            out.println(request.isRequestedSessionIdFromURL() + "</b><br />");
              
            // Reenv�o de la sesi�n (jsessionid) mediante response.encodeURL()
            out.println("<h2>Reenv�o de sesi�n v�a URI</h2>");
            out.println("Permite el reenv�o de sesi�n incluso cuando las cookies est�n deshabilitadas <br /> ");
            out.println("Observa el medio para obtener el identificador de sesi�n <br /> <br />");
            out.println("<a href=\"" + response.encodeURL("RecuperaSesion") + "\">Reenv�o de sesi�n mediante URI</a>"); 
        }           
        catch (Exception e){ 
            out.println("Se produce una excepci�n <br />");
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
