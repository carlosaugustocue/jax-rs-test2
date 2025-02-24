package com.tuempresa.resource;

import com.tuempresa.dao.ClienteDAO;
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
}
