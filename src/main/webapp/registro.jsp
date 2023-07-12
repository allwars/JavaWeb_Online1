<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio de Sesión</title>
</head>
<body>
	<form action="registrousuario" method="post">
		<input type="hidden" name="registro" value=iniciarRegistro />
		<table>
			<tr>
				<td>Usuario</td>
				<td><input type="text" name="nombre" /></td>
			</tr>
			<tr>
				<td>Clave</td>
				<td><input type="password" name="clave" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Registrar"/></td>
			</tr>
		</table>
		<div>
			<p>
				<%
					String resultado = (String)request.getAttribute("mensaje");
					String mensaje = "";
					if (resultado != null) {
						mensaje = resultado;
					}
				%>
				<%=mensaje %>
			</p>
		</div>
	</form>
</body>
</html>