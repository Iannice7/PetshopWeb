<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="it.betacom.dao.ClienteDao" %>
<jsp:useBean id="c" class="it.betacom.bean.Cliente"></jsp:useBean>
<jsp:setProperty property="*" name="c"/>
<%
int i = ClienteDao.save(c);
if(i>0){
	out.print("Accesso effettuato");
	//Thread.sleep(20);
	//response.sendRedirect("login.html");
	
}else{
	//response.sendRedirect("registrer.html");
	out.print("Salvataggio Fallito");
}
%>