
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
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
  
  
<p align="center"> 


<div class="container"> 
<div align="center">

<table>
<tr>
<td>Registro de Usuario</td>
</tr>

<tr>
<td>
<form action="AltaDeUsuario.html" method="post" >
<table>


<tr>
<td>Nombre:</td>							<!-- No valida los espacios vacios --> 
<td>
<input type="text" size="20" name="nombres" maxlength="50" pattern="[A-Za-zñÑáéíóúÁÉÍÓÚüÜ]{2,50}+( )+(A-Za-zñÑáéíóúÁÉÍÓÚüÜ){2,50}" title="El ó los nombre(s) deben tener minimo 2 caracteres">
<strong>
<font color="red"><c:out value="${nombres}" /> </font>
</strong>

</td>
</tr>

<tr>
<td>Apellido Paterno:</td> 
<td>
<input type="text" size="20" name="apellido_paterno" maxlength="50" pattern="[A-Za-z]{2,}" title="El ó los apellido(s) deben tener minimo 2 caracteres">
<strong>
<font color="red"><c:out value="${apellido_paterno}" /> </font>
</strong>
</td>
</tr>

<tr>
<td>Apellido Materno:</td> 
<td>
<input type="text" size="20" name="apellido_materno" maxlength="50" pattern="[A-Za-z]{2,}" title="El ó los apellido(s) deben tener minimo 2 caracteres">

<strong>
<font color="red"><c:out value="${apellido_materno}" /> </font>
</strong>

</td>
</tr>


<tr>
<td>Edad:
</td>
<td>
<input type="text" size="20" name="edad"   maxlength="3" title="Los menores de edad no pueden ingresar">
<strong>
<font color="red"><c:out value="${edad}" /> </font>
</strong>
</td>
</tr>

<tr>
<td>Correo:</td>
<td>
<input type="email" size="20"  name="correo" pattern="[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{1,5}" maxlength="320" title="No es un email valido">
<strong>
<font color="red"><c:out value="${correo}" /> </font>
</strong>
</td>
 
</tr>

<tr>
<td>Matricula:
</td>
<td>
<input   type="text"  size="20"   name="matricula"   maxlength="16" title="Tamaño no valido">
<strong>
<font color="red">
<c:out value="${matricula}" />
</font>
</strong>
<strong>
<font color="red">
<c:out value="${message2}" /> </font>
</strong>
</td>
</tr>

<tr>
<td>Contraseña</td>
<td>
<input type="password" size="20" maxlength="240" name="contrasenia">
<strong>
<font color="red"><c:out value="${contrasenia}" /> </font>
</strong>
</td>
</tr>

<tr>
<td>Confirmar contraseña </td>
<td>
<input type="password" size="20" maxlength="240" name="confirmarcontrasenia">
<strong>
<font color="red">
<c:out value="${confirmarcontrasenia}" />
<c:out value="${passwordValido2}" />
</font>
</strong>
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
 <form action="LogoutServlet" method="post">
<input type="submit" value="Logout" >
</form>


</c:otherwise>
</c:choose>

</jsp:attribute>
</t:linksScripsLibraries>