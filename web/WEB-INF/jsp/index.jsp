<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    
        <jsp:include page="../comunes/head.jsp"/>
    </head>

    <body>
        <jsp:include page="../jspf/encabezado.jspf"/>
        <div class="container p-2">
            <div class="row">
                <div class="col-4 offset-4 col-sm-6  offset-sm-3">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Participante</h5>
                            <p class="card-text">Para ingresar como participante presion el siguiente botón.</p>
                            <a href="./registrarJugador" class="btn btn-primary">Ingresar</a>
                        </div>
                    </div>
                    
                    <hr/>
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Administrador</h5>
                            <p class="card-text">Para ingresar como participante presion el siguiente botón.</p>
                            <a href="./listaPreguntasAdmin" class="btn btn-primary">Ingreso Admin</a>
                        </div>
                    </div>
                </div>
            </div>
            
            
        </div>
    </body>
</html>
