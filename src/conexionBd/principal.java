package conexionBd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import CRUD.Asistente_Crud;
import CRUD.Autor_Crud;
import Clases.Asistente;
import Clases.Autor;

public class principal {
    private static Scanner scanner;
    private static Asistente_Crud asistente_crud;

    public principal() {
    	scanner = new Scanner(System.in);
    	asistente_crud = new Asistente_Crud();
    }
   
    public void Menu() {
        int opcion;
        do {
            System.out.println("=== Menú Principal ===");
            System.out.println("1. Agregar Asistente");
            System.out.println("2. Editar Asistente");
            System.out.println("3. Eliminar Asistente");
            System.out.println("4. Buscar Asistente");
            System.out.println("5. Agregar Autor");
            System.out.println("6. Eliminar Autor");
            System.out.println("7. Buscar");
            System.out.println("8. Mostrar listado de aistentes");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarAsistente();
                    break;
                case 2:
                	editarAsistente();
                    break;
                case 3:
                    eliminarAsistente();
                    break;
                case 4:
                    buscarAsistente();
                    break;
                case 5:
                    agregarAutor();
                    break;
                case 6:
                    eliminarAutor();
                    break;
                 case 7:
                    buscar();
                    break;
                 case 8:
                     mostrarAsistentes();
                     break;
                case 9:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);
        
    }
   
    public static void agregarAsistente() {
		System.out.println("=== Agregar Asistente ===");
	    System.out.print("Nombre: ");
	    String nombre = scanner.nextLine();
	    System.out.print("Apellido: ");
	    String apellido = scanner.nextLine();
	    System.out.print("Institución: ");
	    String institucion = scanner.nextLine();
	    System.out.print("Correo: ");
	    String correo = scanner.nextLine();
	    System.out.print("Número: ");
	    String numero = scanner.nextLine();
	
	    Asistente asistente = new Asistente();
	    asistente.setNombre(nombre);
	    asistente.setApellido(apellido);
	    asistente.setInstitucion(institucion);
	    asistente.setCorreo(correo);
	    asistente.setNumero(numero);
	
	    try {
			asistente_crud.agregarAsistente(asistente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    System.out.println("Asistente agregado exitosamente.");
	}
		
    
    public static void editarAsistente() {
    	 System.out.println("=== Editar Asistente ===");
         System.out.print("Ingrese el Nombre: ");
         String nombre = scanner.nextLine();
         System.out.print("Ingrese el Apellido: ");
         String apellido = scanner.nextLine();

         List<Asistente> asistentes = asistente_crud.buscarAsistentesPorParametros(nombre, apellido);
         if (asistentes.isEmpty()) {
             System.out.println("No se encontraron asistentes con ese nombre y apellido.");
             return;
         }

         System.out.println("Asistentes encontrados:");
         for (Asistente asistente : asistentes) {
             System.out.println(asistente.toScript());
         }

         System.out.print("Ingrese el ID: ");
         int id = scanner.nextInt();

         Asistente asistenteEditar = asistente_crud.buscarAsistente(id);
         if (asistenteEditar == null) {
             System.out.println("Asistente no encontrado.");
             return;
         }

         int opcionCampo;
         do {
             System.out.println("=== Campos disponibles para editar ===");
             System.out.println("1. Nombre");
             System.out.println("2. Apellido");
             System.out.println("3. Institución");
             System.out.println("4. Correo");
             System.out.println("5. Número");
             System.out.println("6. Guardar cambios y salir");
             System.out.print("Seleccione el campo que desea editar: ");
             opcionCampo = scanner.nextInt();

             switch (opcionCampo) {
                 case 1:
                     System.out.print("Nuevo Nombre: ");
                     String nuevoNombre = scanner.next();
                     asistenteEditar.setNombre(nuevoNombre);
                     break;
                 case 2:
                     System.out.print("Nuevo Apellido: ");
                     String nuevoApellido = scanner.next();
                     asistenteEditar.setApellido(nuevoApellido);
                     break;
                 case 3:
                     System.out.print("Nueva Institución: ");
                     String nuevaInstitucion = scanner.next();
                     asistenteEditar.setInstitucion(nuevaInstitucion);
                     break;
                 case 4:
                     System.out.print("Nuevo Correo: ");
                     String nuevoCorreo = scanner.next();
                     asistenteEditar.setCorreo(nuevoCorreo);
                     break;
                 case 5:
                     System.out.print("Nuevo Número: ");
                     String nuevoNumero = scanner.next();
                     asistenteEditar.setNumero(nuevoNumero);
                     break;
                 case 6:
                     asistente_crud.editarAsistente(asistenteEditar);
                     System.out.println("Cambios guardados exitosamente.");
                     break;
                 default:
                     System.out.println("Opción no válida. Intente de nuevo.");
             }

         } while (opcionCampo != 6); 
         
         System.out.println(asistenteEditar.toScript());
    	
    }
    
    
    
    private void eliminarAsistente() {
        System.out.println("=== Eliminar Asistente ===");
        System.out.print("Ingrese el Nombre: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el Apellido: ");
        String apellido = scanner.next();

        List<Asistente> asistentes = asistente_crud.buscarAsistentesPorParametros(nombre, apellido);
        if (asistentes.isEmpty()) {
            System.out.println("No se encontraron asistentes con ese nombre y apellido.");
            return;
        }

        System.out.println("Asistentes encontrados:");
        for (Asistente asistente : asistentes) {
            System.out.println(asistente.toScript());
        }

        System.out.print("Ingrese el ID del asistente que desea eliminar: ");
        int id = scanner.nextInt();

        System.out.print("¿Está seguro de que desea eliminar al asistente con ID " + id + "? (s/n): ");
        String confirmacion = scanner.next();
        if (confirmacion.equalsIgnoreCase("s")) {
        	asistente_crud.eliminarAsistente(id);
            System.out.println("Asistente eliminado exitosamente.");
        } else {
            System.out.println("Eliminación cancelada.");
        }
    }
    
    private void buscarAsistente() {
		asistente_crud.buscarAsistentes();

	}
    
    private void agregarAutor() {
		
    	System.out.print("Ingrese el rol del autor: ");
        String rol = scanner.next();

        System.out.print("Ingrese el ID del asistente: ");
        int asistenteId = scanner.nextInt();

        Autor nuevoAutor = new Autor(rol, asistenteId);

        Autor_Crud.agregarAutor(nuevoAutor);
        System.out.println("Autor agregado exitosamente.");

	}
    
    private void eliminarAutor() {
        System.out.print("Ingrese el ID del autor a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Autor_Crud.eliminarAutor(id);
        System.out.println("Autor eliminado exitosamente.");
    }
    
    private void buscar() {
    	System.out.print("Ingrese el ID del autor a buscar: ");
        int id = scanner.nextInt();

        Autor_Crud.buscarAutorConAsistente(id);
	}
    
    private void mostrarAsistentes() {
    	List<Asistente> resultados = new ArrayList<>();
        String sql = "SELECT * FROM asistente";
        try (Connection conectar = new Conexion().getConexion();
        	PreparedStatement stmt = conectar.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                resultados.add(new Asistente(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("institucion"),
                    rs.getString("correo"),
                    rs.getString("numero")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        for (Asistente asistente : resultados) {
			System.out.println(asistente.toScript());
			System.out.println();
		}

	}
    
	public static void main(String[] args) {
			principal p = new principal();
			p.Menu();
	}
 
	
}

















