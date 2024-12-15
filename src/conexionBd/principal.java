package conexionBd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class principal {
	private Conexion conexionBD;
    private Connection conexion;
    private Scanner teclado;

    public principal() {

    }
		
    public void Menu() {
        System.out.println("Menú");
        System.out.println("1. Agregar asistente");
        System.out.println("2. Agregar autor");
        System.out.println("3. Ver lista de asistentes");
        System.out.println("4. Ver lista de autores");
        System.out.println("5. Buscar");
        System.out.println("6. Editar datos");
        System.out.println("7. Salir");
        System.out.print("Ingrese su opción: ");
        int opcion = teclado.nextInt();

        switch (opcion) {
            case 1:
//                agregarAsistente();
                break;
            case 2:
//                agregarAutor();
                break;
            case 3:
//                verListaAsistentes();
                break;
            case 4:
//                verListaAutores();
                break;
            case 5:
//                buscar();
                break;
            case 6:
//                editarDatos();
                break;
            case 7:
                System.out.println("Gracias por utilizar el sistema");
                conexionBD.closeConexion();
                System.exit(0);
                break;
            default:
                System.out.println("Opción inválida");
                Menu();
        }
    }
    
//    public void agregarAsistente() {
//    	
//    	String id = "1";
//         String nombre = "sara";
//         String apellido = "castellano";
//         String institucion= "caratgena";
//         String correo= "hejekek";
//         String numero = "6382651";
//        Conexion conexion = new Conexion();
//        
//		try {
//		    Connection conectar = conexion.getConexion();
//		    PreparedStatement insertar = conectar.prepareStatement("insert into asistente (nombre, apellido, institucion, correo, numero) VALUES (?, ?, ?, ?, ?)");
//		    insertar.setString(1, nombre);
//		    insertar.setString(2, apellido);
//		    insertar.setString(3, institucion);
//		    insertar.setString(4, correo);
//		    insertar.setString(5, numero);
//		    insertar.executeUpdate();
//		   conexion.closeConexion();
//		} catch (Exception e) {
//		    e.printStackTrace();
//		} 
   
		
 
}
