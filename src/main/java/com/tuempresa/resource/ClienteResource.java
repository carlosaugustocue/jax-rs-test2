package com.tuempresa.resource;

import com.tuempresa.dao.ClienteDAO;
import com.tuempresa.model.Cliente;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import java.util.ArrayList;

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteResource {

    ClienteDAO clienteDAO = new ClienteDAO();

    @GET
    public List obtenerClientes() {
        return clienteDAO.obtenerClientes();
    }

    @GET
    @Path("/{id}")
    public Cliente obtenerCliente(@PathParam("id") int id) {
        return clienteDAO.obtenerCliente(id);
    }

    @POST
    public void agregarCliente(Cliente cliente) {
        clienteDAO.agregarCliente(cliente);
    }

    @PUT
    @Path("/{id}")
    public void actualizarCliente(@PathParam("id") int id, Cliente cliente) {
        clienteDAO.actualizarCliente(id, cliente);
    }

    @DELETE
    @Path("/{id}")
    public void eliminarCliente(@PathParam("id") int id) {
        clienteDAO.eliminarCliente(id);
    }

//    @GET
//    @Path("/{id}/pedidos")
//    public List obtenerPedidos(@PathParam("id") int id) {
//        return clienteDAO.obtenerPedidos(id);
//    }
}
