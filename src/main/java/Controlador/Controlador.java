/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Config.GenerarSerie;
import Modelo.ClienteDAO;
import Modelo.Cliente;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daser
 */
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Empleado em = new Empleado();
    EmpleadoDAO emDao = new EmpleadoDAO();
    Cliente c = new Cliente();
    ClienteDAO cdao = new ClienteDAO();
    Producto p = new Producto();
    ProductoDAO pdao = new ProductoDAO();
    Venta v = new Venta();           
    List<Venta> lista = new ArrayList<>();
    int item=0;
    int cod;
    String Descripcion;
    double precio;
    int cantidad;
    double subtotal;
    double totalpagar;
    String numeroSerie;
    VentaDAO vdao = new VentaDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        String menu = request.getParameter("menu");
        int ide = 0;

        if (menu.equals("Empleado")) {
            switch (accion) {
                case "Listar":
                    List list = emDao.Listar();
                    request.setAttribute("empleados", list);
                    break;

                case "Agregar":
                    String Dni = request.getParameter("txtDni");
                    String Nombres = request.getParameter("txtNombre");
                    String Tel = request.getParameter("txtTelefono");
                    String Estado = request.getParameter("txtEstado");
                    String User = request.getParameter("txtUsuario");

                    em.setDNI(Dni);
                    em.setNombre(Nombres);
                    em.setTel(Tel);
                    em.setEstado(Estado);
                    em.setUser(User);

                    emDao.Agregar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Empleado e = emDao.ListarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String Dni2 = request.getParameter("txtDni");
                    String Nombres2 = request.getParameter("txtNombre");
                    String Tel2 = request.getParameter("txtTelefono");
                    String Estado2 = request.getParameter("txtEstado");
                    String User2 = request.getParameter("txtUsuario");

                    em.setDNI(Dni2);
                    em.setNombre(Nombres2);
                    em.setTel(Tel2);
                    em.setEstado(Estado2);
                    em.setUser(User2);
                    em.setId(ide);

                    emDao.Agregar(em);
                    emDao.Editar(em);

                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    emDao.Eliminar(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }

        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }

        if (menu.equals("Clientes")) {
            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }

        if (menu.equals("Producto")) {
            request.getRequestDispatcher("Productos.jsp").forward(request, response);
        }

        if (menu.equals("RegistrarVenta")) {
            switch (accion) {
                case "BuscarCliente":
                    String dni = request.getParameter("codigoCliente");
                    c.setDni(dni);
                    c = cdao.Buscar(dni);
                    request.setAttribute("c", c);
                    break;
                case "Buscarproducto":
                    
                    int id = Integer.parseInt(request.getParameter("codigoProducto"));
                    p = pdao.ListarId(id);
                    request.setAttribute("c", c);
                    request.setAttribute("producto", p);
                    request.setAttribute("lista", lista);
                    request.setAttribute("totalpagar", totalpagar);
                    
                    break;
                case "Agregar":
                    request.setAttribute("c", c);
                    totalpagar = 0.0;
                    item = item+1;
                    cod = p.getId();
                    Descripcion = request.getParameter("nomproducto");
                    precio = Double.parseDouble(request.getParameter("precio"));
                    cantidad = Integer.parseInt(request.getParameter("cantidad"));
                    subtotal=precio*cantidad;
                    v= new Venta();
                    v.setItem(item);
                    v.setIdproducto(cod);
                    v.setDescripcion(Descripcion);
                    v.setPrecio(precio);
                    v.setCantidad(cantidad);
                    v.setSubtotal(subtotal);
                    lista.add(v);
                    for (int i = 0; i <lista.size(); i++) {
                        totalpagar=totalpagar+lista.get(i).getSubtotal();
                    }
                    request.setAttribute("totalpagar", totalpagar);
                    request.setAttribute("lista", lista);
                    break;
                    
                case "GenerarVenta":
                    v.setIdcliente(c.getId());
                    v.setIdempleado(2);
                    v.setNumserie(numeroSerie);
                    v.setFecha("2021/10/13");
                    v.setMonto(totalpagar);
                    v.setEstado("1");
                    vdao.guardarVenta(v);
                    
                    int idv = Integer.parseInt(vdao.IdVentas());
                    
                    for(int i=0; i<lista.size(); i++){
                        v = new Venta();
                        v.setId(idv);
                        v.setIdproducto(lista.get(i).getIdproducto());
                        v.setCantidad(lista.get(i).getCantidad());
                        v.setPrecio(lista.get(i).getPrecio());
                        vdao.guardarDetalleVenta(v);
                    }
                    break;
                    
                default:
                    numeroSerie = vdao.GenerarSerie();
                    if(numeroSerie==null){
                        numeroSerie = "00000001";
                        request.setAttribute("nserie", numeroSerie);
                    }else{
                        int incrementar = Integer.parseInt(numeroSerie);
                        GenerarSerie gs = new GenerarSerie();
                        numeroSerie = gs.numeroSerie(incrementar);
                        request.setAttribute("nserie", numeroSerie);
                    }
                    
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
            }

            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
