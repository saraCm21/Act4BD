package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Clases.Asistente;
import conexionBd.Conexion;

public class Asistente_Crud {

    public void agregarAsistente(Asistente asistente) {
        String sql = "INSERT INTO solicitudcompras (nombre, apellido, institucion, correo, numero) VALUES (?, ?, ?, ?, ?)";
        try (Connection conectar = new Conexion().getConexion();
             PreparedStatement insertar = conectar.prepareStatement(sql)) {
            insertar.setString(1, asistente.getNombre());
            insertar.setString(2, asistente.getApellido());
            insertar.setString(3, asistente.getInstitucion());
            insertar.setString(4, asistente.getCorreo());
            insertar.setString(5, asistente.getNumero());
            insertar.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editarAsistente(Asistente asistente) {
        String sql = "UPDATE solicitudcompras SET nombre=?, apellido=?, institucion=?, correo=?, numero=? WHERE id=?";
        try (Connection conectar = new Conexion().getConexion();
             PreparedStatement actualizar = conectar.prepareStatement(sql)) {
            actualizar.setString(1, asistente.getNombre());
            actualizar.setString(2, asistente.getApellido());
            actualizar.setString(3, asistente.getInstitucion());
            actualizar.setString(4, asistente.getCorreo());
            actualizar.setString(5, asistente.getNumero());
            actualizar.setInt(6, asistente.getId());
            actualizar.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarAsistente(int id) {
        String sql = "DELETE FROM solicitudcompras WHERE id=?";
        try (Connection conectar = new Conexion().getConexion();
             PreparedStatement eliminar = conectar.prepareStatement(sql)) {
            eliminar.setInt(1, id);
            eliminar.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Asistente buscarAsistente(int id) {
        String sql = "SELECT * FROM solicitudcompras WHERE id=?";
        Asistente asistente = null;
        try (Connection conectar = new Conexion().getConexion();
             PreparedStatement buscar = conectar.prepareStatement(sql)) {
            buscar.setInt(1, id);
            ResultSet rs = buscar.executeQuery();
            if (rs.next()) {
                asistente = new Asistente();
                asistente.setId(rs.getInt("id"));
                asistente.setNombre(rs.getString("nombre"));
                asistente.setApellido(rs.getString("apellido"));
                asistente.setInstitucion(rs.getString("institucion"));
                asistente.setCorreo(rs.getString("correo"));
                asistente.setNumero(rs.getString("numero"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return asistente;
    }

    public List<Asistente> buscarAsistentesPorParametros(String nombre, String apellido) {
        List<Asistente> asistentes = new ArrayList<>();
        String sql = "SELECT * FROM solicitudcompras WHERE nombre LIKE ? AND apellido LIKE ?";
        try (Connection conectar = new Conexion().getConexion();
             PreparedStatement buscar = conectar.prepareStatement(sql)) {
            buscar.setString(1, "%" + nombre + "%");
            buscar.setString(2, "%" + apellido + "%");
            ResultSet rs = buscar.executeQuery();
            while (rs.next()) {
                Asistente asistente = new Asistente();
                asistente.setId(rs.getInt("id"));
                asistente.setNombre(rs.getString("nombre"));
                asistente.setApellido(rs.getString("apellido"));
                asistente.setInstitucion(rs.getString("institucion"));
                asistente.setCorreo(rs.getString("correo"));
                asistente.setNumero(rs.getString("numero"));
                asistentes.add(asistente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return asistentes;
    }
}
