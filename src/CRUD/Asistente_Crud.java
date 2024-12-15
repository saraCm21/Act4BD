package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Clases.Asistente;
import conexionBd.Conexion;

public class Asistente_Crud {

    public void agregarAsistente(Asistente asistente) {
        String sql = "INSERT INTO asistente (nombre, apellido, institucion, correo, numero) VALUES (?, ?, ?, ?, ?)";
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
        String sql = "UPDATE asistente SET nombre=?, apellido=?, institucion=?, correo=?, numero=? WHERE id=?";
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
        String sql = "DELETE FROM asistente WHERE id=?";
        try (Connection conectar = new Conexion().getConexion();
             PreparedStatement eliminar = conectar.prepareStatement(sql)) {
            eliminar.setInt(1, id);
            eliminar.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Asistente buscarAsistente(int id) {
        String sql = "SELECT * FROM asistente WHERE id=?";
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
        String sql = "SELECT * FROM asistente WHERE nombre LIKE ? AND apellido LIKE ?";
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
    
    public List<Asistente> buscarAsistentesPorNombre(String nombre) {
    	List<Asistente> asistentes = new ArrayList<>();
        String sql = "SELECT * FROM asistente WHERE nombre LIKE ?";
        try (Connection conectar = new Conexion().getConexion();
             PreparedStatement buscar = conectar.prepareStatement(sql)) {
            buscar.setString(1, "%" + nombre + "%");
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

    public List<Asistente> buscarAsistentesPorApellido(String apellido) {
    	List<Asistente> asistentes = new ArrayList<>();
        String sql = "SELECT * FROM asistente WHERE apellido LIKE ?";
        try (Connection conectar = new Conexion().getConexion();
             PreparedStatement buscar = conectar.prepareStatement(sql)) {
            buscar.setString(1, "%" + apellido + "%");
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

    public List<Asistente> buscarAsistentesPorInstitucion(String institucion) {
        List<Asistente> resultados = new ArrayList<>();
        String sql = "SELECT * FROM asistentes WHERE institucion LIKE ?";
        try (Connection conectar = new Conexion().getConexion();
        	PreparedStatement stmt = conectar.prepareStatement(sql)) {
            stmt.setString(1, "%" + institucion + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            	Asistente asistente = new Asistente();
                asistente.setId(rs.getInt("id"));
                asistente.setNombre(rs.getString("nombre"));
                asistente.setApellido(rs.getString("apellido"));
                asistente.setInstitucion(rs.getString("institucion"));
                asistente.setCorreo(rs.getString("correo"));
                asistente.setNumero(rs.getString("numero"));
                resultados.add(asistente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultados;
    }

    public List<Asistente> buscarAsistentesPorCorreo(String correo) {
        List<Asistente> resultados = new ArrayList<>();
        String sql = "SELECT * FROM asistentes WHERE correo LIKE ?";
        try (Connection conectar = new Conexion().getConexion();
        	PreparedStatement stmt = conectar.prepareStatement(sql)) {
            stmt.setString(1, "%" + correo + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            	Asistente asistente = new Asistente();
                asistente.setId(rs.getInt("id"));
                asistente.setNombre(rs.getString("nombre"));
                asistente.setApellido(rs.getString("apellido"));
                asistente.setInstitucion(rs.getString("institucion"));
                asistente.setCorreo(rs.getString("correo"));
                asistente.setNumero(rs.getString("numero"));
                resultados.add(asistente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultados;
    }

    public List<Asistente> buscarAsistentes() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Buscar Asistente ===");
        System.out.println("1. Buscar por Nombre");
        System.out.println("2. Buscar por Apellido");
        System.out.println("3. Buscar por Institución");
        System.out.println("4. Buscar por Correo");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();

        List<Asistente> asistentesEncontrados = new ArrayList<>();

        switch (opcion) {
            case 1:
                System.out.print("Ingrese el Nombre: ");
                String nombre = scanner.next();
                asistentesEncontrados = buscarAsistentesPorNombre(nombre);
                for ( Asistente asistente : asistentesEncontrados) {
					System.out.println(asistente.toScript());
				}
                break;
            case 2:
                System.out.print("Ingrese el Apellido: ");
                String apellido = scanner.next();
                asistentesEncontrados = buscarAsistentesPorApellido(apellido);
                for ( Asistente asistente : asistentesEncontrados) {
					System.out.println(asistente.toScript());
				}
                break;
            case 3:
                System.out.print("Ingrese la Institución: ");
                String institucion = scanner.next();
                asistentesEncontrados = buscarAsistentesPorInstitucion(institucion);
                for ( Asistente asistente : asistentesEncontrados) {
					System.out.println(asistente.toScript());
				}
                break;
            case 4:
                System.out.print("Ingrese el Correo: ");
                String correo = scanner.next();
                asistentesEncontrados = buscarAsistentesPorCorreo(correo);
                for ( Asistente asistente : asistentesEncontrados) {
					System.out.println(asistente.toScript());
				}
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }

        return asistentesEncontrados;
    }

}
