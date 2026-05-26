package sistema;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        GestionVehiculos gestion = new GestionVehiculos();
        int opcion = 0;

        do {
            System.out.println("\n====================================");
            System.out.println("        REGISTRO DE VEHÍCULOS          ");
            System.out.println("=====================================");
            System.out.println("1. Registrar vehículo");
            System.out.println("2. Mostrar vehículos");
            System.out.println("3. Buscar vehículo por placa");
            System.out.println("4. Mostrar vehículos por marca");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción (1-5): ");

            if (teclado.hasNextInt()) {
                opcion = teclado.nextInt();
                teclado.nextLine();
            } else {
                System.out.println("\n[Error] Por favor, digite un número válido.");
                teclado.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("\n--- INGRESAR LOS DATOS DEL VEHÍCULO ---");
                    System.out.print("Placa: ");
                    String placa = teclado.nextLine().trim();
                    System.out.print("Marca: ");
                    String marca = teclado.nextLine().trim();
                    System.out.print("Modelo: ");
                    String modelo = teclado.nextLine().trim();

                    int anio = 0;
                    System.out.print("Año: ");
                    if (teclado.hasNextInt()) {
                        anio = teclado.nextInt();
                        teclado.nextLine();
                    } else {
                        System.out.println("[Error] Año inválido. Registro fué cancelado.");
                        teclado.nextLine();
                        break;
                    }

                    System.out.print("Color: ");
                    String color = teclado.nextLine().trim();

                    double precio = 0.0;
                    System.out.print("Precio: ");
                    if (teclado.hasNextDouble()) {
                        precio = teclado.nextDouble();
                        teclado.nextLine();
                    } else {
                        System.out.println("[Error] Precio inválido. Registro fué cancelado.");
                        teclado.nextLine();
                        break;
                    }

                    Vehiculo nuevo = new Vehiculo(placa, marca, modelo, anio, color, precio);
                    gestion.registrarVehiculo(nuevo);
                    break;

                case 2:
                    gestion.mostrarTodosLosVehiculos();
                    break;

                case 3:
                    System.out.print("\nIngrese el número de placa que va a  buscar: ");
                    String placaBusqueda = teclado.nextLine().trim();
                    gestion.buscarPorPlaca(placaBusqueda);
                    break;

                case 4:
                    System.out.print("\nIngrese la marca que desea filtrar: ");
                    String marcaBusqueda = teclado.nextLine().trim();
                    gestion.mostrarPorMarca(marcaBusqueda);
                    break;

                case 5:
                    System.out.println("\nSaliendo del sistema... ¡Que tenga un buen día!");
                    break;

                default:
                    System.out.println("\nOpción fuera de rango. Intente nuevamente.");
            }

        } while (opcion != 5);

        teclado.close();
    }
}
