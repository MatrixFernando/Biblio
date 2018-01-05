

<%@tag description="Simple Template" pageEncoding="UTF-8"%>
 
<%@attribute name="title"%>
<%@attribute name="head_area" fragment="true" %>
<%@attribute name="body_area" fragment="true" %>
<!DOCTYPE html>
<html>
<head>


<title>${title}</title>
    
<link type="text/css"  href="../framworkhtml/css/bootstrap.min.css" rel="stylesheet" >
<script src="../framworkhtml/js/bootstrap.min.js"></script>
<script src="../framworkhtml/jQuery/jquery.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1"> <!--  Con esto garantizamos que se vea bien en dispositivos móviles --> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 



<jsp:invoke fragment="head_area" />
</head>


<body>
 
<jsp:invoke fragment="body_area" />
</body>
</html>

    
       