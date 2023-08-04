<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page import="java.util.Random,java.text.*"%>
<%@ page import="by.training.finalproject.dao.*"%>
<%@ page import="by.training.finalproject.dto.*"%>
<%@ page import="java.util.List"%>
<%@ page errorPage = "error.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Java In HTML</title>
</head>
<body>


<c:forEach items="${roles}" var="id">
 <h3>${id.id}</h3>
 <ul>

   <c:forEach items="${roles}" var="name">
       <li>
          ${name.roleName}
       </li>
   </c:forEach>
 </ul>

</c:forEach>


    <a href="${pageContext.request.contextPath}/showRoles">Try Again</a>

</body>
</html>