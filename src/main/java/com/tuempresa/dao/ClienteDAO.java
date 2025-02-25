package com.tuempresa.dao;

import com.tuempresa.model.Cliente;
import com.tuempresa.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    public List<Cliente> obtenerClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String query = "SELECT * FROM clientes";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("telefono")
                );
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public Cliente obtenerCliente(int id) {
        Cliente cliente = null;
        String query = "SELECT * FROM clientes WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                cliente = new Cliente(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("telefono")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
}
        return cliente;
    }

    public void agregarCliente(Cliente cliente) {
        String query = "INSERT INTO clientes (nombre, email, telefono) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getEmail());
            pstmt.setString(3, cliente.getTelefono());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarCliente(Cliente cliente) {
        String query = "UPDATE clientes SET nombre = ?, email = ?, telefono = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getEmail());
            pstmt.setString(3, cliente.getTelefono());
            pstmt.setInt(4, cliente.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarCliente(int id) {
        String query = "DELETE FROM clientes WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
