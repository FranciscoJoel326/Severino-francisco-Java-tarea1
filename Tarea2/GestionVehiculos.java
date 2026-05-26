package sistema;

import java.util.ArrayList;

public class GestionVehiculos {
    private ArrayList<Vehiculo> listaVehiculos;

    public GestionVehiculos() {
        this.listaVehiculos = new ArrayList<>();
    }

    public boolean registrarVehiculo(Vehiculo nuevoVehiculo) {
        for (Vehiculo v : listaVehiculos) {
            if (v.getPlaca().equalsIgnoreCase(nuevoVehiculo.getPlaca())) {
                System.out.println("\n[Error] Ya existe un vehículo registrado con esa placa.");
                return false;
            }
        }
        listaVehiculos.add(nuevoVehiculo);
        System.out.println("\n¡Vehículo registrado con éxito!");
        return true;
    }

    public void mostrarTodosLosVehiculos() {
        if (listaVehiculos.isEmpty()) {
            System.out.println("\nNo hay vehículos registrados en el sistema en este momento .");
            return;
        }

        System.out.println("\n--- LISTA TOTAL DE VEHÍCULOS ---");
        for (Vehiculo v : listaVehiculos) {
            v.mostrarDatos();
        }
    }

    public void buscarPorPlaca(String placaBuscar) {
        boolean encontrado = false;

        for (Vehiculo v : listaVehiculos) {
            if (v.getPlaca().equalsIgnoreCase(placaBuscar)) {
                System.out.println("\n--- VEHÍCULO ENCONTRADO ---");
                v.mostrarDatos();
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("\nNo se encontró ningún vehículo con esa placa: " + placaBuscar);
        }
    }

    public void mostrarPorMarca(String marcaBuscar) {
        boolean coincidencia = false;
        System.out.println("\n--- VEHÍCULOS DE LA MARCA: " + marcaBuscar.toUpperCase() + " ---");

        for (Vehiculo v : listaVehiculos) {
            if (v.getMarca().equalsIgnoreCase(marcaBuscar)) {
                v.mostrarDatos();
                coincidencia = true;
            }
        }

        if (!coincidencia) {
            System.out.println("No se encontraron vehículos registrados con esta marca.");
        }
    }
}
