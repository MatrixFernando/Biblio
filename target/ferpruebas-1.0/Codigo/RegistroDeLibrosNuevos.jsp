


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>



<t:linksScripsLibraries title="Registro de Libros">


<jsp:attribute name="head_area">


</jsp:attribute>
<jsp:attribute name="body_area">

<c:choose>
<c:when test="${empty sessionScope.NumEco}">
<c:redirect url="/Codigo/InicioDeSistema.jsp"/>
</c:when>
<c:otherwise>
  


<div class="container"> 
<div align="center">

<table>
<tr>
<td>Registro de Libros de nuevo ingreso a la biblioteca</td>
</tr>
<tr>
<td>
<form action="AltaDeLibros.html" method="post" >
<table>

<tr>
<td>ISDN:
</td>
<td>
<input   type="text"  size="20"   name="ISDN"  pattern="[0-9]{9,16}" maxlength="16" title="Tamaño no valido">

<c:out value="${ISDN}"/>
<c:out value="${message2}"/>
</td>
</tr>


<tr>
<td>Titulo:</td>
										<!-- No valida los espacios Vacios --> 
<td>
<input type="text" size="20" name="titulo" maxlength="50" pattern="[A-Za-z]{2,50}" title="El ó los nombre(s) deben tener minimo 2 caracteres">
  <c:out value="${Titulo}"/>
</td>

</tr>

<tr>
<td>Autor:</td> 

<td>
 <input type="text" size="20" name="autor" maxlength="50" pattern="[A-Za-z]{2,}" title="El ó los apellido(s) deben tener minimo 2 caracteres">
 <c:out value="${Autor}"/>
 </td>
</tr>

<tr>
<td>Edicion:</td> 

<td>
 <input type="text" size="20" name="edicion" maxlength="50" pattern="[A-Za-z]{2,}" title="El ó los apellido(s) deben tener minimo 2 caracteres">
 <c:out value="${Edicion}"/>
 </td>
</tr>


<tr>
<td>Editorial:</td> 

<td>
 <input type="text" size="20" name="editorial" maxlength="50" pattern="[A-Za-z]{2,}" title="El ó los apellido(s) deben tener minimo 2 caracteres">
 <c:out value="${Editorial}"/>
 </td>
</tr>




<tr>
<td>Cantidad de libros iguales a este</td>
<td>

<input type="text" size="20" name="copias"  pattern="[0-9]{1,3}" maxlength="3" title="Los menores de edad no pueden ingresar">
<c:out value="${Copias_De_Este_Libro}"/>
</td>
</tr>



<tr>
<td colspan="2" align="center"><input type="submit" value="Registro Completo" > </td>
</tr>

</table>
</form>
</td>
</tr>

</table>
</div>

</div>

 </c:otherwise>
</c:choose>

</jsp:attribute>
</t:linksScripsLibraries>