import java.util.List;
import java.util.Scanner;

public class Main {
public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
        PersonaDAO personaDAO = new PersonaDAO();

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar persona");
            System.out.println("2. Listar personas");
            System.out.println("3. Actualizar persona");
            System.out.println("4. Eliminar persona");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar buffer de entrada

            switch (opcion) {
                case 1 -> {
                    System.out.println("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.println("Edad: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();  // Limpiar buffer de entrada
                    Persona persona = new Persona(nombre, apellido, edad);
                    personaDAO.agregarPersona(persona);
                    System.out.println("Persona agregada.");
                }

                case 2 -> {
                    List<Persona> personas = personaDAO.obtenerPersonas();
                    for (Persona p : personas) {
                        System.out.println("ID: " + p.getId() + ", Nombre: " + p.getNombre() + ", Apellido: " + p.getApellido() + ", Edad: " + p.getEdad());
                    }
                }

                case 3 -> {
                    System.out.println("ID de la persona a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine();  // Limpiar buffer
                    System.out.println("Nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.println("Nuevo apellido: ");
                    String nuevoApellido = scanner.nextLine();
                    System.out.println("Nueva edad: ");
                    int nuevaEdad = scanner.nextInt();
                    scanner.nextLine();  // Limpiar buffer
                    Persona personaActualizar = new Persona(nuevoNombre, nuevoApellido, nuevaEdad);
                    personaActualizar.setId(idActualizar);
                    personaDAO.actualizarPersona(personaActualizar);
                    System.out.println("Persona actualizada.");
                }

                case 4 -> {
                    System.out.println("ID de la persona a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    personaDAO.eliminarPersona(idEliminar);
                    System.out.println("Persona eliminada.");
                }

                case 5 -> {
                    System.out.println("Saliendo...");
                    System.exit(0);
                    //scanner.close();
                }
                    
                }
            }
    }
        
    }
}

