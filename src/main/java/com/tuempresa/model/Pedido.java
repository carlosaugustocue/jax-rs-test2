package com.tuempresa.model;

public class Pedido {
    private int id;
    private int clienteId;
    private String descripcion;

    // Constructor vacío
    public Pedido() {}

    // Constructor con parámetros
    public Pedido(int id, int clienteId, String descripcion) {
        this.id = id;
        this.clienteId = clienteId;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getClienteId() { return clienteId; }
    public void setClienteId(int clienteId) { this.clienteId = clienteId; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
