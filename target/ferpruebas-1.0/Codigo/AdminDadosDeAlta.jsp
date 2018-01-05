<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import = "azc.uam.mx.controlador.servlets.*" %>
<%@page import = "java.util.LinkedList"%>
<%@page import = "java.util.List"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page session="true" %>


<t:linksScripsLibraries title="Registro de Usuario">

<jsp:attribute name="head_area">

</jsp:attribute>
<jsp:attribute name="body_area">


<c:choose>
<c:when test="${empty sessionScope.NumEco}">
<c:redirect url="/Codigo/InicioDeSistema.jsp"/>
</c:when>
<c:otherwise>

  
<div align="center">


<label>Te has registrado exitosamente!. Felicitaciones por unirte a la Biblioteca Vasconselos.</label>


<h1>Consulta a base de datos</h1>
<table border="1">
<tr>
<td>Numero Económico</td>
<td>Nombre(s))</td>
<td>Apellido Paterno</td>
<td>Apellido Materno</td>
<td>Edad</td>
<td>Email</td>
<td>Contraseña</td>
</tr>
    
<c:forEach items="${Wow}" var="listaa">
<tr>
<td> 
<c:out value="${listaa.numero_economico}"/>     <td/>
<c:out value="${listaa.nombres}"/>     <td/>
<c:out value="${listaa.apellido_paterno}"/>   <td/>
<c:out value="${listaa.apellido_materno}"/>   <td/>
<c:out value="${listaa.edad}"/>   <td/>
<c:out value="${listaa.correo}"/>   <td/>
<c:out value="${listaa.contrasenia}"/> 
</tr>
</c:forEach> 

</table>

 <form action="LogoutServlet" method="post">
<input type="submit" value="Logout" >
</form>


</div>
  </c:otherwise>
</c:choose>



</jsp:attribute>
</t:linksScripsLibraries>