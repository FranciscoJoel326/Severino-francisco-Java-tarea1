
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();
    private static ArrayList<Profesor> listaProfesores = new ArrayList<>();
    private static ArrayList<Materia> listaMaterias = new ArrayList<>();
    private static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;

        do {
            System.out.println("\n=====================================");
            System.out.println("       SISTEMA DE GESTION ACADEMICA    ");
            System.out.println("=====================================");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Registrar profesor");
            System.out.println("3. Registrar materia");
            System.out.println("4. Asignar materia a estudiante");
            System.out.println("5. Registrar calificacion");
            System.out.println("6. Buscar estudiante");
            System.out.println("7. Mostrar estudiantes");
            System.out.println("8. Mostrar materias");
            System.out.println("9. Mostrar reporte de promedios");
            System.out.println("10. Salir");
            System.out.print("Seleccione una opcion: ");
            
            try {
                opcion = Integer.parseInt(leer.nextLine());
            } catch (Exception e) {
                opcion = 0; 
            }

            switch (opcion) {
                case 1: registrarEstudiante(); break;
                case 2: registrarProfesor(); break;
                case 3: registrarMateria(); break;
                case 4: asignarMateriaAEstudiante(); break;
                case 5: registrarCalificacion(); break;
                case 6: buscarEstudiante(); break;
                case 7: mostrarEstudiantes(); break;
                case 8: mostrarMaterias(); break;
                case 9: mostrarReportePromedios(); break;
                case 10: System.out.println("Saliendo del sistema..."); break;
                default: System.out.println("Opcion invalida, intente de nuevo.");
            }
        } while (opcion != 10);
    }

    private static void registrarEstudiante() {
        System.out.print("Matricula: "); String mat = leer.nextLine();
        System.out.print("Nombre: "); String nom = leer.nextLine();
        System.out.print("Apellido: "); String ape = leer.nextLine();
        
        int edad = 0;
        System.out.print("Edad: ");
        try { edad = Integer.parseInt(leer.nextLine()); } catch(Exception e){}
        
        System.out.print("Carrera: "); String car = leer.nextLine();
        System.out.print("Fecha de Inscripcion (dd/mm/aaaa): "); String fec = leer.nextLine();

        Estudiante nuevo = new Estudiante(mat, nom, ape, edad, car, fec);
        listaEstudiantes.add(nuevo);
        System.out.println("Estudiante registrado con exito.");
    }

    private static void registrarProfesor() {
        System.out.print("Codigo de Profesor: "); String cod = leer.nextLine();
        System.out.print("Nombre: "); String nom = leer.nextLine();
        System.out.print("Apellido: "); String ape = leer.nextLine();
        System.out.print("Especialidad: "); String esp = leer.nextLine();

        Profesor nuevo = new Profesor(cod, nom, ape, esp);
        listaProfesores.add(nuevo);
        System.out.println("Profesor registrado con exito.");
    }

    private static void registrarMateria() {
        System.out.print("Codigo de Materia: "); String cod = leer.nextLine();
        System.out.print("Nombre de Materia: "); String nom = leer.nextLine();
        
        int cred = 0;
        System.out.print("Cantidad de Creditos: ");
        try { cred = Integer.parseInt(leer.nextLine()); } catch(Exception e){}

        Materia nueva = new Materia(cod, nom, cred);
        listaMaterias.add(nueva);
        System.out.println("Materia registrada con exito.");
    }

    private static void asignarMateriaAEstudiante() {
        System.out.print("Ingrese la matricula del estudiante: ");
        String mat = leer.nextLine();
        Estudiante est = encontrarEstudiante(mat);

        if (est == null) {
            System.out.println("Estudiante no encontrado.");
            return;
        }

        System.out.print("Ingrese el codigo de la materia: ");
        String cod = leer.nextLine();
        Materia matSeleccionada = encontrarMateria(cod);

        if (matSeleccionada == null) {
            System.out.println("Materia no encontrada.");
            return;
        }

        est.asignarMateria(matSeleccionada);
        System.out.println("Materia asignada correctamente al estudiante.");
    }

    private static void registrarCalificacion() {
        System.out.print("Ingrese la matricula del estudiante: ");
        String mat = leer.nextLine();
        Estudiante est = encontrarEstudiante(mat);

        if (est == null) {
            System.out.println("Estudiante no encontrado.");
            return;
        }

        if (est.getMateriasAsignadas().isEmpty()) {
            System.out.println("El estudiante no tiene materias asignadas.");
            return;
        }

        System.out.println("Materias del estudiante:");
        for (int i = 0; i < est.getMateriasAsignadas().size(); i++) {
            System.out.println(i + ". " + est.getMateriasAsignadas().get(i).getNombreMateria());
        }
        System.out.print("Seleccione el numero de la materia a calificar: ");
        int indice = -1;
        try { indice = Integer.parseInt(leer.nextLine()); } catch(Exception e){}

        if (indice >= 0 && indice < est.getMateriasAsignadas().size()) {
            System.out.print("Ingrese la nota: ");
            double nota = -1;
            try { nota = Double.parseDouble(leer.nextLine()); } catch(Exception e){}
            
            if (nota >= 0 && nota <= 100) {
                est.registrarNota(indice, nota);
                System.out.println("Calificacion guardada.");
            } else {
                System.out.println("Nota invalida (debe ser entre 0 y 100).");
            }
        } else {
            System.out.println("Seleccion incorrecta.");
        }
    }

    private static void buscarEstudiante() {
        System.out.println("Buscar por: 1. Matricula | 2. Nombre");
        String op = leer.nextLine();
        boolean encontrado = false;

        if (op.equals("1")) {
            System.out.print("Matricula a buscar: ");
            String mat = leer.nextLine();
            for (Estudiante e : listaEstudiantes) {
                if (e.getMatricula().equalsIgnoreCase(mat)) {
                    imprimirDatosEstudiante(e);
                    encontrado = true;
                }
            }
        } else if (op.equals("2")) {
            System.out.print("Nombre a buscar: ");
            String nom = leer.nextLine();
            for (Estudiante e : listaEstudiantes) {
                if (e.getNombre().equalsIgnoreCase(nom)) {
                    imprimirDatosEstudiante(e);
                    encontrado = true;
                }
            }
        }
        if (!encontrado) System.out.println("No se encontraron resultados.");
    }

    private static void mostrarEstudiantes() {
        if (listaEstudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        for (Estudiante e : listaEstudiantes) {
            imprimirDatosEstudiante(e);
            System.out.println("-------------------------------");
        }
    }

    private static void mostrarMaterias() {
        if (listaMaterias.isEmpty()) {
            System.out.println("No hay materias registradas.");
            return;
        }
        for (Materia m : listaMaterias) {
            System.out.println("Codigo: " + m.getCodigo() + " | Nombre: " + m.getNombreMateria() + " | Creditos: " + m.getCreditos());
        }
    }

    private static void mostrarReportePromedios() {
        if (listaEstudiantes.isEmpty()) {
            System.out.println("No hay estudiantes para generar reporte.");
            return;
        }
        System.out.println("\n=== REPORTE DE PROMEDIOS ===");
        for (Estudiante e : listaEstudiantes) {
            double prom = e.calcularPromedio();
            String estado = (prom >= 70) ? "Aprobado" : "Reprobado"; 
            System.out.println("Estudiante: " + e.getNombre() + " " + e.getApellido() + 
                               " | Mat: " + e.getMatricula() + 
                               " | Promedio: " + prom + " | Estado: " + estado);
        }
    }

    private static Estudiante encontrarEstudiante(String matricula) {
        for (Estudiante e : listaEstudiantes) {
            if (e.getMatricula().equalsIgnoreCase(matricula)) return e;
        }
        return null;
    }

    private static Materia encontrarMateria(String codigo) {
        for (Materia m : listaMaterias) {
            if (m.getCodigo().equalsIgnoreCase(codigo)) return m;
        }
        return null;
    }

    private static void imprimirDatosEstudiante(Estudiante e) {
        System.out.println("Matricula: " + e.getMatricula() + " - " + e.getNombre() + " " + e.getApellido() +
                           " - Edad: " + e.getEdad() + " - Carrera: " + e.getCarrera() + " - Inscrito: " + e.getFechaInscripcion());
    }
}