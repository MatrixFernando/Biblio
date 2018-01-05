<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page session="true"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

Long ok = (Long)	session.getAttribute("NumEco");
System.out.println("wwww "+ok);

%>
jjjjjjjjjjjjjjjjjjjjjjjjhhh

<c:out value="${sessionScope.NumEco}" />
<c:out value="${sessionScope.NumEco}" />
llllllppllllllllllllllllllooolllllllll




<c:set var="salary" scope="session" value="${2000*2}"/>
<p>Your salary is : <c:out value="${salary}"/></p>
kkkkkkkkk
<c:out default="null"  value="${sessionScope.NumEco}"/>
<c:choose>
    
   <c:when test="${empty sessionScope.NumEco}">
       Salary is very low to survive.
    </c:when>
    <c:when test="${salary > 1000}">
        Salary is very good.
    </c:when>
    <c:otherwise>
        No comment sir...
    </c:otherwise>
</c:choose>

 <form action="Codigo/RegistroDeLibrosNuevos.jsp" method="post"  style="display:inline"> 
<input type="submit" value="Alta de Libros" >
</form>


</body>
</html>