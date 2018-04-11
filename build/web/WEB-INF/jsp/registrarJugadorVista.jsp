<%-- 
    Document   : registrarJugador
    Created on : 28/03/2018, 10:09:14 PM
    Author     : Diego
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar jugador</title>
        <jsp:include page="../comunes/head.jsp"/>
    </head>
    <body>
        <!--Inclue el encabezado-->        
        <jsp:include page="../jspf/encabezado.jspf"/>
        <div class="container p-2">
            
            <h1>Registro de un nuevo jugador!</h1>
            <form:form method="POST" action="./registrarJugador" modelAttribute="jugador">
                <label>Nombre</label>
                <form:input path="nombre" required="required" placeholder="Nombre"/>
                <br/>

                <input type="submit" value="Registrar" class="btn btn-primary"/>
            </form:form>
            
            <div class="row">
                <div class="col-6 offset-3">
                    <c:if test="${not empty jugadoresReg}">
                        <h2>Jugadores registrados actualmente</h2>
                        <ol>
                        <c:forEach items="${jugadoresReg}" var="jug">
                            <li>${jug.nombre}</li>
                        </c:forEach>
                        </ol>
                    </c:if>

                    <c:if test="${empty jugadoresReg}">
                        <span style="color:red">Aún no hay jugadores registrado</span>
                    </c:if>
                </div>
             </div>
        </div>
    </body>
</html>
