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
        <title>Administrador</title>
        <jsp:include page="../../comunes/head.jsp"/>
    </head>
    <body>
        <!--Inclue el encabezado-->        
        <jsp:include page="../../jspf/encabezado.jspf"/>
        
        <div class="container">
            <h1>Lista de preguntas!</h1>
            <%//<h2>¿Es admin?: ${esAdmin}</h2>%>

            <span>${mensaje}</span>

            <c:if test="${esAdmin}">
                <div class="row">
                    <div class="col-12 col-sm-9">
                        <c:forEach  var="preg" items="${preguntas}">
                            <div class="row">
                                <div class="col-10 col-sm-9">

                                    <p>
                                         <strong>${preg.id}</strong>-${preg.enunciado}
                                    </p>
                                </div>
                                <div class="col-2 col-sm-3">
                                    <a href="marcarActual?idPreg=${preg.id}" class="btn btn-primary">Seleccionar</a>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="col-12 col-sm-3">
                        <h4>Preguntas seleccionadas previamente</h4>
                        <p>${preguntasSeleccionadas}</p>
                        <a href="resultados" target="_blank" class="btn btn-info">Ver resultados</a>
                        <%//<a href="XXX">Seleccionar aleatoria</a>%>
                    </div>
                </div>
            </c:if>
        </div>
            
        <c:if test="${not esAdmin}">
            <div class="container">
            <form action="loginAsAdmin" method="POST">
                Contraseña: <input type="password" name="contra" required="required">
                <div class="m-2">
                    <input type="submit" value="Autenticarse" class="btn btn-primary"/>
                </div>
            </form>
            </div>
        </c:if>

    </body>
</html>
