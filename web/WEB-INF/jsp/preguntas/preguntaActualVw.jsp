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
        <title>Pregunta</title>
        <jsp:include page="../../comunes/head.jsp"/>
    </head>
    <body>
        <!--Inclue el encabezado-->        
        <jsp:include page="../../jspf/encabezado.jspf"/>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <a href="cerrarSesion" style="float:right">Cerrar sesión</a>
                </div>
                <div class="col-12">
                    <p style="float:right">Participante: ${jugador.nombre}</p>
                </div>
                <div class="col-12">
                    
                    
                    <%//<code>Preguntas respondidas: ${preguntasUsuario}</code>%>
                </div>
                
                <div class="col-4 offset-4">
                    <form:form action="enviarRespuesta" method="POST" modelAttribute="preguntaForm">
                    <c:if test="${respondida}">
                        <div class="alert alert-primary" role="alert">
                            Ya respondiste esta pregunta, espera que se habilite la nueva pregunta y da clic en el siguiente enlace 
                        </div>
                        
                        <a href="pregunta" class="btn btn-secondary">Actualizar</a>
                    </c:if>

                            
                    <c:if test="${not respondida}">
                       <!--Enunciado de la pregunta-->
                       <div class="card" style="width: 18rem;">
                        <div class="card-body">
                          <h5 class="card-title">Pregunta!</h5>
                          <p class="card-text">${preguntaActual.enunciado}.</p>
                          <h4 class="card-title">Opciones respuesta</h4>
                          <c:forEach  var="preg" items="${preguntaActual.opcionesRespuesta}">
                                <p>
                                    <input type="checkbox" name="opcionesSeleccionadas" value="${preg.id}"/>
                                    ${preg.descripcion} (${preg.valida})
                                </p>
                            </c:forEach>
                          <input type="submit" class="btn btn-primary" value="Enviar"/>
                        </div>
                      </div>
                    </c:if>
                    </form:form>
                </div>
            </div>
        </div>
    </body>
</html>
