<%-- 
    Document   : Empleado
    Created on : 9/10/2021, 04:28:43 PM
    Author     : daser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-uWxY/CJNBR+1zjPWmfnSnVxwRheevXITnMqoEIeG1LJrdI0GlVs/9cVSyPYXdcSF" crossorigin="anonymous">

        <title>Empleado</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-6">
                <div class="card-body">
                    <form action="Controlador?menu=Empleado" method="POST">
                        <div class="form-group">
                            <label>DNI</label>
                            <input type="text" value="${empleado.getDNI()}" name="txtDni" class="form-control">                            
                        </div>
                        <div class="form-group"
                            <label>Nombre</label>
                            <input type="text" value="${empleado.getNombre()}" name="txtNombre" class="form-control">                            
                        </div>
                        <div class="form-group">
                            <label>Telefono</label>
                            <input type="text" value="${empleado.getTel()}" name="txtTelefono" class="form-control">                            
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text" value="${empleado.getEstado()}" name="txtEstado" class="form-control">                            
                        </div>
                        <div class="form-group">
                            <label>Usuario</label>
                            <input type="text" value="${empleado.getUser()}" name="txtUsuario" class="form-control">                            
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-success">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-primary">
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>DNI</th>
                            <th>Nombres</th>
                            <th>Telefono</th>
                            <th>Estado</th>
                            <th>User</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var='em' items='${empleados}'>
                        <tr>
                            <td>${em.getId()}</td>
                            <td>${em.getDNI()}</td>
                            <td>${em.getNombre()}</td>
                            <td>${em.getTel()}</td>
                            <td>${em.getEstado()}</td>
                            <td>${em.getUser()}</td>
                            <td>
                                <a class="btn btn-warning" href="Controlador?menu=Empleado&accion=Editar&id=${em.getId()}">Editar</a>
                                <a class="btn btn-danger" href="Controlador?menu=Empleado&accion=Eliminar&id=${em.getId()}">Eliminar</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>


        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.min.js" integrity="sha384-PsUw7Xwds7x08Ew3exXhqzbhuEYmA2xnwc8BuD6SEr+UmEHlX8/MCltYEodzWA4u" crossorigin="anonymous"></script>

    </body>
</html>
