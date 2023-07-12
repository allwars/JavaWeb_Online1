package controlador;

import java.io.IOException;

import entidad.usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.ModeloUsuario;

@WebServlet("/usuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tipo = request.getParameter("tipo");
		
		if ("iniciarSesion".equals(tipo)) {
			this.iniciarSesion(request, response);
		} else if ("cerrarSesion".equals(tipo)) {
			this.cerrarSesion(request, response);
		}
	}
	
	private void iniciarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String clave = request.getParameter("clave");

		ModeloUsuario modelo = new ModeloUsuario();
		usuario usuario = modelo.iniciarSesion(nombre, clave);

		if (usuario == null) {
			request.setAttribute("mensaje", "Error nombre de usuario y/o clave");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			HttpSession sesion = request.getSession();
			sesion.setAttribute("usuario", usuario);
			response.sendRedirect("principal.jsp");
		}
	}
	
	private void cerrarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		sesion.invalidate();
		request.setAttribute("mensaje", "Iniciar sesión");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}