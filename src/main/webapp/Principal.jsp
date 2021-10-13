<%-- 
    Document   : Principal
    Created on : 6/10/2021, 10:17:11 PM
    Author     : daser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-uWxY/CJNBR+1zjPWmfnSnVxwRheevXITnMqoEIeG1LJrdI0GlVs/9cVSyPYXdcSF" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>

        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Navbar</a>

                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="Principal.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="btn btn-outline-dark" style="margin-left: 10px; border: none; color: white" href="Controlador?menu=Producto" target="myFrame">Producto</a>
                        </li>
                        <li class="nav-item">
                            <a class="btn btn-outline-dark" style="margin-left: 10px; border: none; color: white" href="Controlador?menu=Empleado&accion=Listar" target="myFrame">Empleado</a>
                        </li>
                        <li class="nav-item">
                            <a class="btn btn-outline-dark" style="margin-left: 10px; border: none; color: white" href="Controlador?menu=Clientes" target="myFrame">Clientes</a>
                        </li>
                        <li class="nav-item">
                            <a class="btn btn-outline-dark" style="margin-left: 10px; border: none; color: white" href="Controlador?menu=RegistrarVenta&accion=default" target="myFrame">Nueva Venta</a>
                        </li>
                    </ul>
                </div>
                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                        ${usuario.getNombre()}
                    </button>
                    <ul class="dropdown-menu text-center" aria-labelledby="dropdownMenuButton1">
                        <li><a class="dropdown-item" href="#">
                                Photo
                        </a></li>
                        <li><a class="dropdown-item" href="#"></a>${usuario.getUser()}</li>
                        <li><a class="dropdown-item" href="#">User@correo.com</a></li>
                        <div class="dropdown-divider"></div>

                        <form action="Validar" method="POST">
                            <button name="action" values="Salir" class="dropdown-item" href='#'>Salir</button>
                        </form>
                    </ul>
                </div>
            </div>
        </nav>
        
            <div class="m-4" style="height: 530px;">
                <iframe name="myFrame" style="height:100%; width:100%; border:none;">

                </iframe>                                
            </div>      

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.min.js" integrity="sha384-PsUw7Xwds7x08Ew3exXhqzbhuEYmA2xnwc8BuD6SEr+UmEHlX8/MCltYEodzWA4u" crossorigin="anonymous"></script>
    </body>
</html>