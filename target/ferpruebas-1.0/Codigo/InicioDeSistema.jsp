<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page import="java.lang.Long" %>

<!DOCTYPE html>
<html>
<head>
	<title>S.B.R.P</title>
	<link type="image/x-icon" href="../image/favicon/Rox.ico" rel="icon" />
	<link type="image/x-icon" href="../image/favicon/Rox.ico" rel="shortcut icon" />
	<link type="text/css" href="../framworkhtml/CSSpropio/Stilos.css" rel="stylesheet" >
	<link type="text/css"  href="../framworkhtml/css/bootstrap.min.css" rel="stylesheet" >
	<script src="../framworkhtml/js/bootstrap.min.js"></script>
	<script src="../framworkhtml/jQuery/jquery.js"></script>
	<script type="text/javascript" src="../framworkhtml/JSpropio/JSArchivo.js" ></script>
	<meta name="viewport" content="width=device-width, initial-scale=1"> <!--  Con esto garantizamos que se vea bien en dispositivos móviles --> 
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<%
	response.setHeader("Cache-Control","no-cache"); 
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma","no-cache"); 
	response.setHeader("Pragma","no-store");
	response.setDateHeader ("Expires", 0);
	%>
</head>

<body>

<header >
	<img id="header" src="../image/CabeceraYPieDePagina/nav-example-1.gif">
</header>
<div  class="container"> 
	<div align="center">
		<div id="titulo_principal">Sistema Bibliotecario <p>para la renovación de prestamo</p></div>
		<table>
			<tr>
				<td id="erroreslogin">
					<strong><c:out value="${error}" /> </strong>
				</td>
			</tr>
			<tr>
			<td>
				<form action="WOW.html" method="post" >
					<table>
						<tr>
							<td class="texto"><strong>Número Económico:</strong>
							</td>
							<td>
								<input  class="NumeroEconmicoCss" type="text"    name="NumeroEconmico"  pattern="[0-9]{9,16}" maxlength="16" title="Tamaño no valido">

								<c:out value="${NumeroEconmico}"/>
								<c:out value="${message1}"/>
							</td>
						</tr>

						<tr>
							<td class="texto"><strong>Contraseña: </strong></td>
							<td>
								<input class="NumeroEconmicoCss" type="password" maxlength="240" name="contrasenia">
								<c:out value="${contrasenia}"/>
							</td>
						</tr>

						<tr>
							<td colspan="2" align="center"><input id="boton1"  type="submit" value="Inicio de sesión" > </td>
						</tr>

					</table>
				</form>
			</td>
		</tr>

	</table>
</div>

</div>

<footer >
	<div >Sistema creado por: Miguel Fernando Vallejo Ortiz</div>
	<img   id="footer"  src="../image/CabeceraYPieDePagina/nav-example-4.gif">
</footer>
</body>
</html>