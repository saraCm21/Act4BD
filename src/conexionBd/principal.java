package conexionBd;

import java.util.List;
import java.util.Scanner;
import CRUD.Asistente_Crud;
import Clases.Asistente;

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
            System.out.println("5. Salir");
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
    
	public static void main(String[] args) {
			principal p = new principal();
			p.Menu();
	}
 
	
}

















