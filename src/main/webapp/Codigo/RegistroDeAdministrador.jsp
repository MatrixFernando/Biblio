


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
 
  


<div class="container"> 
<div align="center">

<table>
<tr>
<td>Registro de Administrador Usando el Metodo Post</td>
</tr>
<tr>
<td>
<form action="AltaDeAdministrador.html" method="post" >
<table>


<tr>
<td>Número Económico:
</td>
<td>
<input type="text"  size="20"   name="numero_economico"  pattern="[0-9]{9,16}" maxlength="16" title="Tamaño no valido">
<c:out value="${numero_economico}"/>
<c:out value="${message2}"/>
</td>
</tr>


<tr>
<td>Nombre:</td>
										<!-- No valida los espacios Vacios --> 
										<!-- Faltan acentos y Dierecis pingüino -->
<td>
<input type="text" size="20" name="nombres" maxlength="50" pattern="[A-Za-z]{2,50}" title="El ó los nombre(s) deben tener minimo 2 caracteres">
  <c:out value="${nombres}"/>
</td>
</tr>

<tr>
<td>Apellido Paterno:</td> 

<td>
 <input type="text" size="20" name="apellido_paterno" maxlength="50" pattern="[A-Za-z]{2,}" title="El ó los apellido(s) deben tener minimo 2 caracteres">
 <c:out value="${apellido_paterno}"/>
 </td>
</tr>


<tr>
<td>Apellido Materno:</td> 
<td>
 <input type="text" size="20" name="apellido_materno" maxlength="50" pattern="[A-Za-z]{2,}" title="El ó los apellido(s) deben tener minimo 2 caracteres">
 <c:out value="${apellido_materno}"/>
 </td>
</tr>

<tr>
<td>Edad:
</td>
<td>

<input type="text" size="20" name="edad"  pattern="[0-9]{2,3}" maxlength="3" title="Los menores de edad no pueden ingresar">
<c:out value="${edad}"/>
</td>
</tr>

<tr>
<td>Correo:</td>
<td>

<input type="email" size="20"  name="correo" pattern="[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{1,5}" maxlength="320" title="No es un email valido">
<c:out value="${correo}"/>
</td>
 
</tr>



<tr>
<td>Contraseña</td>
<td>
<input type="password" size="20" maxlength="240" name="contrasenia">
<c:out value="${contrasenia}"/>
</td>
</tr>

<tr>
<td>Confirmar contraseña </td>
<td>
<input type="password" size="20" maxlength="240" name="confirmarcontrasenia">
<c:out value="${confirmarcontrasenia}"/>  
<c:out value="${passwordValido2}"/> 
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

<c:out value="${sessionScope.NumEco}" />


  </c:otherwise>
</c:choose>



</jsp:attribute>
</t:linksScripsLibraries>