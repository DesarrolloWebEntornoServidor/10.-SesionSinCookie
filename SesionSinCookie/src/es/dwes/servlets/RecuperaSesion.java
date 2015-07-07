package es.dwes.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "RecuperaSesion", urlPatterns = {"/RecuperaSesion"})
public class RecuperaSesion extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void procesaSolicitud(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            //Se guarda una sesi�n asociada a la petici�n
            HttpSession unaSesion = request.getSession(false);
            //Se almacena la direcci�n URI de la petici�n
            String cadenaURI=request.getRequestURI();
            
            // Se imprimen los atributos principales de la sesi�n
            out.println("<html><head><title>SesionesSinCookiesB</title></head>");
            out.println("<body>");
            out.println("<h1>SesionesSinCookiesB</h1>");
            out.println("<h3>Servlet RecuperaSesion</h3>");
            out.println("Id de sesi�n (jsessionid): " + unaSesion.getId() + "<br />");
            out.println("Nueva session: <b>" + unaSesion.isNew() + "</b><br />");
            out.println("URI=" + cadenaURI + "<br />");
            out.println("QueryString= " + request.getQueryString() + "<br />");
            out.println("Identificador de sesi�n obtenido mediante cookie: <b>" +
                    request.isRequestedSessionIdFromCookie() + "</b> <br />");
            out.println("Identificador de sesi�n obtenido mediante URI: <b>");
            out.println(request.isRequestedSessionIdFromURL() + "</b><br />");
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