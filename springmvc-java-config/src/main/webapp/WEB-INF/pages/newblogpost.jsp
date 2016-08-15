<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/starter-template.css" rel="stylesheet"/>
<script src="${pageContext.request.contextPath}/resources/js/jquery-2.1.4.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>


<title>New Blog Post</title>
</head>
<body>
<h1>New Blog POST </h1>

 <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="brand" href="${pageContext.request.contextPath}"><b>Udemy</b></a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li class="active"><a href="${pageContext.request.contextPath}">Home</a></li>
              <li><a href="${pageContext.request.contextPath}/promo.html">Promo</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>
    
   <div class="container">
    
      <h1>New Blog Post</h1>
      <c:if test="${not empty message}" >
      	${message}<br/>
      </c:if>
      
      <form action="${pageContext.request.contextPath}/saveBlogPost" method="post">
      	<table class="table	">
      		<tr><td>Title</td><td><input name="title" type="text"/></td></tr>
      		<tr><td>Content</td><td><textarea name="content" ></textarea></td></tr>
      		<tr><td>Draft</td><td><input type="checkbox" name="draft"/></td></tr>
      		<tr><td colspan="2"><input  type="submit" value="Save"/></td></tr>

      	</table>
      </form>
      
    </div> <!-- /container -->
    
       <footer class="footer">
      	<div class="container">
        	<p class="text-muted"><b>ecme 2016 Please feel free to ask me questions by sending email to edgar.mercado@gmail.com</b></p>
		    <a href="<%=request.getContextPath()%>?language=en">EN</a>
 			<a href="<%=request.getContextPath()%>?language=es">ES</a> 
 			 			<spring:message code="language" /> | 
 			<spring:message code="welcome.text" />
 			<br/>
 			<br/>			
        </div>
    </footer>
    
</body>
</html>