<%-- 
    Document   : preguntaActualVw
    Created on : 29/03/2018, 12:20:18 PM
    Author     : Diego
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultados</title>
    </head>
    <body>
        <h1>Resultados de la pregunta actual</h1>
        
        <span>${mensaje}</span>
        
        <c:if test="${esAdmin}">
            
            <h2>Pregunta:</h2>
            <p>${pregunta.enunciado}</p>
            
            
            <table>
                <thead>
                    <tr>
                        <th>Pregunta</th>
                        <th># de respuestas</th>
                        <th>Respuesta correcta</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach  var="opcAct" items="${pregunta.opcionesRespuesta}">
                    <tr>
                        <td>
                            ${opcAct.descripcion}
                        </td>
                        <td>
                            ${resultados[opcAct.id]}
                        </td>
                        <td>
                            <c:if test="${opcAct.valida}">
                                CORRECTA
                            </c:if>
                            <c:if test="${not opcAct.valida}">
                                -
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
            
        <c:if test="${not esAdmin}">
            <form action="loginAsAdmin" method="POST">
                Pass: <input type="password" name="contra">
                <input type="submit" value="Autenticarse"/>
            </form>
        </c:if>

    </body>
</html>
