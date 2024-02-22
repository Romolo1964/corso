<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="model.Film" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
ArrayList<Film> ar=(ArrayList)request.getAttribute("listaFilm");
for (int cont=0;cont<ar.size();cont++){
	
	
	out.println(ar.get(cont).getTitle());
}


%>
</body>
</html>