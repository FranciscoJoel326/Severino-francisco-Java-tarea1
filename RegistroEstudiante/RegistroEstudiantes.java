import java.util.Scanner;
import java.util.Locale;

public class RegistroEstudiantes {

    public static void validarEstudiante(String nombre, int edad, double indice) throws EstudianteInvalidoException {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new EstudianteInvalidoException("Error: El nombre no puede estar vacío.");
        }

        if (edad < 18 || edad > 100) {
            throw new EstudianteInvalidoException("Error: La edad debe ser mayor o igual a 18 años.");
        }

        if (indice < 0.0 || indice > 4.0) {
            throw new EstudianteInvalidoException("Error: El índice debe estar entre 0 y 4.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Esto arregla el error de la captura que me mandaste:
        scanner.useLocale(Locale.US);

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Edad: ");
        int edad = scanner.nextInt();

        System.out.print("Índice: ");
        double indice = scanner.nextDouble();

        System.out.println();

        try {
            validarEstudiante(nombre, edad, indice);
            System.out.println("Estudiante registrado correctamente.");
        } catch (EstudianteInvalidoException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Proceso finalizado.");
        }

        scanner.close();
    }
}