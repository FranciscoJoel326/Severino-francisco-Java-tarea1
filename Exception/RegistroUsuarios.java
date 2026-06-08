import java.util.InputMismatchException;
import java.util.Scanner;

public class RegistroUsuarios {

    public static void validarUsuario(String nombre, int edad, String correo, double salario) throws Exception {

        // Valido Nombre
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new NombreInvalidoException("El nombre no puede estar vacío.");
        }
        if (nombre.trim().length() < 3) {
            throw new NombreInvalidoException("El nombre debe contener al menos 3 caracteres.");
        }

        // Valido Edad
        if (edad < 18 || edad > 100) {
            throw new EdadInvalidaException("La edad debe ser mayor o igual a 18 años.");
        }

        if (!correo.contains("@") || !correo.contains(".")) {
            throw new CorreoInvalidoException("El correo electrónico no es válido.");
        }

        // valido Salario
        if (salario <= 0) {
            throw new SalarioInvalidoException("El salario debe ser mayor que cero.");
        }
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("========================");
            System.out.println("REGISTRO DE USUARIOS");
            System.out.println("========================");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = teclado.nextInt();
                teclado.nextLine();

                if (opcion == 1) {
                    try {
                        System.out.print("Nombre: ");
                        String nombre = teclado.nextLine();

                        System.out.print("Edad: ");
                        int edad = teclado.nextInt();
                        teclado.nextLine();

                        System.out.print("Correo: ");
                        String correo = teclado.nextLine();

                        System.out.print("Salario: ");
                        double salario = teclado.nextDouble();
                        teclado.nextLine();
                        validarUsuario(nombre, edad, correo, salario);

                        System.out.println("Usuario registrado correctamente.");

                    } catch (NombreInvalidoException e) {
                        System.out.println("Error: " + e.getMessage());
                    } catch (EdadInvalidaException e) {
                        System.out.println("Error: " + e.getMessage());
                    } catch (CorreoInvalidoException e) {
                        System.out.println("Error: " + e.getMessage());
                    } catch (SalarioInvalidoException e) {
                        System.out.println("Error: " + e.getMessage());
                    } catch (InputMismatchException e) {

                        System.out.println("Error: Debe ingresar un número válido.");
                        teclado.nextLine();
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    } finally {
                        System.out.println("Proceso finalizado.");
                    }
                } else if (opcion == 2) {
                    System.out.println("Saliendo del sistema...");
                } else {
                    System.out.println("Opción no válida. Intente de nuevo.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Opción de menú inválida. Ingrese un número.");
                teclado.nextLine();
            }
            System.out.println();

        } while (opcion != 2);

        teclado.close();
    }
}