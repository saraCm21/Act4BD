package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Clases.Asistente;
import Clases.Autor;
import conexionBd.Conexion;

public class Autor_Crud {

    public Autor_Crud() {

    }

    public static void agregarAutor(Autor autor) {
        String sql = "INSERT INTO autores (rol, asistente_id) VALUES (?, ?)";
        try (Connection conectar = new Conexion().getConexion();
        	PreparedStatement stmt = conectar.prepareStatement(sql)) {
            stmt.setString(1, autor.getRol());
            stmt.setInt(2, autor.getAsistenteId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void eliminarAutor(int id) {
        String sql = "DELETE FROM autores WHERE id = ?";
        try (Connection conectar = new Conexion().getConexion();
        	PreparedStatement stmt = conectar.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Autor buscarAutor(int id) {
        String sql = "SELECT * FROM autores WHERE id = ?";
        try (Connection conectar = new Conexion().getConexion();
        	PreparedStatement stmt = conectar.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Autor(
                    rs.getString("rol"),
                    rs.getInt("asistente_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Autor> buscarTodosLosAutores() {
        List<Autor> resultados = new ArrayList<>();
        String sql = "SELECT * FROM autores";
        try (Connection conectar = new Conexion().getConexion();
        	PreparedStatement stmt = conectar.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                resultados.add(new Autor(
                    rs.getString("rol"),
                    rs.getInt("asistente_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultados;
    }
    
    public static void buscarAutorConAsistente(int id) {
        String sql = "SELECT * FROM autores WHERE id = ?";
        try (Connection conectar = new Conexion().getConexion();
        	PreparedStatement stmt = conectar.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Autor autor = new Autor(
                    rs.getString("rol"),
                    rs.getInt("asistente_id")
                );

                Asistente_Crud asistenteDAO = new Asistente_Crud();
                Asistente asistente = asistenteDAO.buscarAsistente(autor.getAsistenteId());

                System.out.println("Autor encontrado:");
                System.out.println("ID: " + autor.getId());
                System.out.println("Rol: " + autor.getRol());
                if (asistente != null) {
                    System.out.println("Asistente relacionado:");
                    System.out.println("ID: " + asistente.getId());
                    System.out.println("Nombre: " + asistente.getNombre());
                    System.out.println("Apellido: " + asistente.getApellido());
                    System.out.println("Institución: " + asistente.getInstitucion());
                    System.out.println("Correo: " + asistente.getCorreo());
                    System.out.println("Número: " + asistente.getNumero());
                } else {
                    System.out.println("No se encontró el asistente relacionado.");
                }
            } else {
                System.out.println("No se encontró el autor con ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
