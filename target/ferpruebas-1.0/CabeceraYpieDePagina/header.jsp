<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 

<!DOCTYPE html>

<html>
<head>



<title>hi1</title>

  <link type="image/x-icon" href="../image/favicon/Rox.ico" rel="icon" />
  <link type="image/x-icon" href="../image/favicon/Rox.ico" rel="shortcut icon" />
 

<link type="text/css"  href="../framworkhtml/css/bootstrap.min.css" rel="stylesheet" >
<script src="../framworkhtml/js/bootstrap.min.js"></script>
<script src="../framworkhtml/jQuery/jquery.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1"> <!--  Con esto garantizamos que se vea bien en dispositivos móviles --> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

 <%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma","no-cache"); 
response.setHeader("Pragma","no-store");
response.setDateHeader ("Expires", 0);
%>

<script  type="text/javascript">
   window.history.forward(1);
</script> 

<script type="text/javascript">
if(history.forward(1)){
history.replace(history.forward(1));
}
</script>



</head>

<body>

<script>
    window.history.back(none);
</script>


<script  type="text/javascript">
window.history.forward(1);
</script> 


<script type="text/javascript">
if(history.forward(1)){
history.replace(history.forward(1));
}
</script>


	<div>
		<img  width="100%" height="100px" style="margin-bottom: 50px"  
			 src="../image/CabeceraYPieDePagina/nav-example-1.gif">
	</div>
	
	
<form action="RegistroDeUsuario.jsp" method="post" style="display:inline"> 
<input type="submit" value="Registro De Usuario" >
</form>

<form action="RegistroDeAdministrador.jsp" method="post" style="display:inline"> 
<input type="submit" value="Registro De Administrador" >
</form>

 <form action="RegistroDeLibrosNuevos.jsp" method="post"  style="display:inline"> 
<input type="submit" value="Alta de Libros" >
</form>


 <form action="ServletUsuariosDadosDeAlta.html" method="post"  style="display:inline"> 
<input type="submit" value="Usuarios dados de Alta" >
</form>





<form action="ServletAdminDadosDeAlta.html" method="post" style="display:inline"> 
<input type="submit" value="Administradores dados de Alta" >
</form>


<form action="ServletLibrosDadosDeAlta.html" method="post" style="display:inline"> 
<input type="submit" value="Libros dados de Alta" >
</form>


 <form action="ListaDePrestamos.html" method="post" style="display:inline"> 
<input type="submit" value="Prestamo de Libros" >
</form>
	
	
</body>
</html>
