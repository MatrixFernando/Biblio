<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page session="true" %>
 
<t:linksScripsLibraries title="Registro de Usuario">


<jsp:attribute name="head_area">


</jsp:attribute>
<jsp:attribute name="body_area">




<div align="center">


<table>
<tr>
<td>Sistema de Biblioteca</td>
</tr>
<tr>
<td>
  <c:out value="${requestScope.error}" />
<c:out value="${error}"/>

<c:if test="${not empty error}">
<div style="text-align: center"><strong>
<font color="red">error </font>
</strong>
</div>
</c:if>

</td>
</tr>
<tr>
<td>
<form action="WOW.html" method="post" >
<input name="lastLogon" type="hidden" value="<%= new java.lang.Long(System.currentTimeMillis()).toString() %>"/>


<c:out value="----->>>> lastLogonmmm"></c:out>
<table>


<tr>
<td>Número de Usuario:


</td>
<td>
<input   type="text"  size="20"   name="NumeroEconmico"  pattern="[0-9]{9,16}" maxlength="16" title="Tamaño no valido">

<c:out value="${NumeroEconmico}"/>
<c:out value="${message1}"/>
</td>
</tr>

<tr>
<td>ISDN:</td>
<td>
<input type="text" size="20" maxlength="240" name="contrasenia">
<c:out value="${contrasenia}"/>
</td>
</tr>

<tr>
<td colspan="2" align="center"><input type="submit" value="Prestamo" > </td>
</tr>

</table>
</form>
</td>
</tr>

</table>
</div>



</jsp:attribute>
</t:linksScripsLibraries>