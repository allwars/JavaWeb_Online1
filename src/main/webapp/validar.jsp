<% 
	if (session.getAttribute("usuario") == null) {
		request.setAttribute("mensaje", "Debe autenticarse para ingresar al sistema");
		pageContext.forward("index.jsp");
	}
%>