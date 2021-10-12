<%-- 
    Document   : RegistrarVenta
    Created on : 9/10/2021, 04:28:28 PM
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
        <div class="d-flex">
            <div class="col-sm-4">
                <div class="card">
                    <form action="Controlador" method="POST">
                        <div class="card-body">
                            <div class="form-group">
                                <label>Datos del Cliente</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="codigoCliente" class="form-control" placeholder="Codigo">
                                    <input type="submit" name="accion" value="Buscar" class="btn btn-outline-dark">
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="nombresCliente" placeholder="Datos Cliente" class="form-control" >
                                </div>                                                                                  
                            </div>

                            <br>
                            <div class="form-group">
                                <label>Datos Producto</label>

                            </div>

                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="codigoProducto" class="form-control" placeholder="Codigo">
                                    <input type="submit" name="accion" value="Buscar" class="btn btn-outline-dark">
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="nombresCliente" class="form-control" >
                                </div> 
                            </div>
                            <br>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="precio" class="form-control" placeholder="Precio">                         
                                </div>
                                <div class="col-sm-3">
                                    <input type="number" name="cantidad" class="form-control" placeholder="">
                                </div>
                                <div class="col-sm-3">
                                    <input type="text" name="stock" class="form-control" placeholder="stock" >
                                </div> 
                            </div>
                            <br>
                            <div class="form-group">
                                <input type="submit" name="accion" value="Agregar" class="btn btn-outline-primary">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">
                        <div>
                            <label>Numero Serie</label>
                            <input type="text" name="nroSerie" class="form-control">
                        </div>
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
                        </table>
                    </div>
                </div>

            </div>
        </div>


        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.min.js" integrity="sha384-PsUw7Xwds7x08Ew3exXhqzbhuEYmA2xnwc8BuD6SEr+UmEHlX8/MCltYEodzWA4u" crossorigin="anonymous"></script>

    </body>
</html>
