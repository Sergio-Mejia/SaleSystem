<%-- 
    Document   : RegistrarVenta
    Created on : 9/10/2021, 04:28:28 PM
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

        <title>JSP Page</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="col-sm-4">
                <div class="card">
                    <form action="Controlador?menu=RegistrarVenta" method="POST">
                        <div class="card-body">
                            <div class="form-group">
                                <label>Datos del Cliente</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="codigoCliente" value="${c.getDni()}" class="form-control" placeholder="Codigo">
                                    <input type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-dark">
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="nombresCliente" value="${c.getNombres()}" placeholder="Datos Cliente" class="form-control" >
                                </div>                                                                                  
                            </div>

                            <br>
                            <div class="form-group">
                                <label>Datos Producto</label>

                            </div>

                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="codigoProducto" value="${producto.getId()}" class="form-control" placeholder="Codigo">
                                    <button type="submit" name="accion" value="Buscarproducto" class="btn btn-outline-dark">Buscar</button>
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="nomproducto" value="${producto.getNombres()}" class="form-control" >
                                </div> 
                            </div>
                            <br>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="precio" value="${producto.getPrecio()}" class="form-control" placeholder="Precio">                         
                                </div>
                                <div class="col-sm-3">
                                    <input type="number" value="1" name="cantidad" class="form-control" placeholder="">
                                </div>
                                <div class="col-sm-3">
                                    <input type="text" name="stock" value="${producto.getStock()}" class="form-control" placeholder="stock" >
                                </div> 
                            </div>
                            <br>
                            <div class="form-group">
                                <button type="submit" name="accion" value="Agregar" class="btn btn-outline-primary">Generar Venta</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-5 ml-auto"> 
                            <label>Número Serie</label>
                            <input type="text" name="nroSerie" value="${nserie}" class="form-control">
                        </div>
                        <br>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Numero</th>
                                    <th>Codigo</th>
                                    <th>Descripcion</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>Subtotal</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${lista}">
                                <tr>
                                    <td>${list.getItem()}</td>
                                    <td>${list.getIdproducto()}</td>
                                    <td>${list.getDescripcion()}</td>
                                    <td>${list.getPrecio()}</td>
                                    <td>${list.getCantidad()}</td>
                                    <td>${list.getSubtotal()}</td>
                                    <td class="d-flex">
                                        <a href="#" class="btn btn-warning">Editar</a>
                                        <a href="#" class="btn btn-danger" style="margin-left: 10px">Eliminar</a>
                                    </td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer d-flex">
                        <div class="col-sm-6">
                            <input type="submit" name="accion" value="Generar Venta" class="btn btn-success">
                            <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
                        </div>
                        <div class="col-sm-4 ml-auto">
                            <input type="text" value="S/. ${totalpagar}0"name="txtTotal" class="form-control">
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.min.js" integrity="sha384-PsUw7Xwds7x08Ew3exXhqzbhuEYmA2xnwc8BuD6SEr+UmEHlX8/MCltYEodzWA4u" crossorigin="anonymous"></script>

    </body>
</html>
