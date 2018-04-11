<%-- 
    Document   : registrarJugador
    Created on : 28/03/2018, 10:09:14 PM
    Author     : Diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tablero</title>
    </head>
    <body>
        <!--Inclue el encabezado-->
        <jsp:include page="../jspf/encabezado.jspf"/>
        
        <h1>Pantalla principal del juego!</h1>
        <h2>Info jugador: ${jugador}</h2>
        <p>Acá de alguna forma debería mostrar el juego</p>
        <code>Jugadores: ${jugadores}</code>
        <h2>Lista de jugadores inscritos</h2>
        <ol>
        <c:forEach var="jugValue" items="${jugadores}">
            <li><c:out value="${jugValue.nombre}"></c:out></li>
        </c:forEach>
        </ol>        
        
        <jsp:include page="../jspf/pie.jsp"/>
    </body>
</html>
