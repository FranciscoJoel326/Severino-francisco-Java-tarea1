
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionEstudiantes {
    private static final List<String> listaEstudiantes = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static final Object lock = new Object();

    public static void main(String[] args) {
        while (true) {
            menu();
            System.out.print("Seleccione: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                System.out.print("Nombre del estudiante: ");
                String nombre = scanner.nextLine();
                System.out.print("Matrícula: ");
                String matricula = scanner.nextLine();

                HiloGuardar hiloEscritura = new HiloGuardar(nombre, matricula);
                hiloEscritura.start();

                try {
                    hiloEscritura.join();
                } catch (InterruptedException e) {
                    System.out.println("Proceso interrupted.");
                }

            } else if (opcion == 2) {
                HiloMostrar hiloLectura = new HiloMostrar();
                hiloLectura.start();

                try {
                    hiloLectura.join();
                } catch (InterruptedException e) {
                    System.out.println("Proceso interrupted.");
                }

            } else if (opcion == 3) {
                System.out.println("Saliendo del sistema...");
                System.exit(0);
            } else {
                System.out.println("Opción inválida.");
            }
            System.out.println("---");
        }
    }

    private static void menu() {
        System.out.print("1. Agregar Estudiante\n2. Mostrar Estudiantes\n3. Salir\n");
    }

    private static class HiloGuardar extends Thread {
        private String nombreEstudiante;
        private String matriculaEstudiante;

        public HiloGuardar(String nombre, String matricula) {
            this.nombreEstudiante = nombre;
            this.matriculaEstudiante = matricula;
        }

        @Override
        public void run() {
            synchronized (lock) {
                String datos = "Matrícula: " + matriculaEstudiante + " | Nombre: " + nombreEstudiante;
                listaEstudiantes.add(datos);
                System.out.println("\n[HILO-ESCRITURA] ¡Estudiante guardado en memoria!");
            }
        }
    }

    private static class HiloMostrar extends Thread {
        @Override
        public void run() {
            synchronized (lock) {
                if (listaEstudiantes.isEmpty()) {
                    System.out.println("\nNo hay estudiantes registrados.");
                } else {
                    System.out.println("\n=== LISTA DE ESTUDIANTES ===");
                    for (String estudiante : listaEstudiantes) {
                        System.out.println(estudiante);
                    }
                }
            }
        }
    }
}
