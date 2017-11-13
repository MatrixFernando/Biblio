
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
<td>ISDN</td>
<td>Titulo</td>
<td>Autor</td>
<td>Edicion</td>
<td>Editorial</td>
<td>Copias De Este Libro</td>

</tr>
    
<c:forEach items="${WowLibros}" var="listaa">
<tr >
<td> 
<c:out value="${listaa.ISDN}"/>     <td/>
<c:out value="${listaa.titulo}"/>     <td/>
<c:out  value="${listaa.autor}"/>   <td/>
<c:out value="${listaa.edicion}"/>   <td/>
<c:out value="${listaa.editorial}"/>   
<td align="center"> <c:out  value="${listaa.copias_De_Este_Libro}" escapeXml="false"/> 
</td>
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