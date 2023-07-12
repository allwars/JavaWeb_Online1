package controlador;
import entidad.registrousuario;
import javax.servlet.ServletException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import modelo.ModeloRegistro;

@WebServlet("/registrousuario")

public class ServletRegistro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//String registro = request.getParameter("registro");
		this.iniciarRegistro(request, response);
	}

	private void iniciarRegistro(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String clave = request.getParameter("clave");
		
		ModeloRegistro modelo = new ModeloRegistro();
		
		registrousuario registrousuario = modelo.iniciarRegistro(nombre, clave);

		
		if (registrousuario == null) {
			HttpSession sesion = request.getSession();
			sesion.setAttribute("registrousuario", registrousuario);
			response.sendRedirect("index.jsp");
		} else {
			HttpSession sesion = request.getSession();
			sesion.setAttribute("registrousuario", registrousuario);
			response.sendRedirect("index.jsp");
		}
		
	}
	}


