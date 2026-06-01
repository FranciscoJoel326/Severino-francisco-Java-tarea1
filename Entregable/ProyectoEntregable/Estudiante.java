import java.util.ArrayList;

public class Estudiante extends Persona {
    private String matricula;
    private int edad;
    private String carrera;
    private String fechaInscripcion;
    
    private ArrayList<Materia> materiasAsignadas;
    private ArrayList<Double> calificaciones;

    public Estudiante(String matricula, String nombre, String apellido, int edad, String carrera, String fechaInscripcion) {
        super(nombre, apellido); // Llama al constructor de Persona
        this.matricula = matricula;
        this.edad = edad;
        this.carrera = carrera;
        this.fechaInscripcion = fechaInscripcion;
        this.materiasAsignadas = new ArrayList<>();
        this.calificaciones = new ArrayList<>();
    }

    public void asignarMateria(Materia materia) {
        materiasAsignadas.add(materia);
        calificaciones.add(-1.0); // -1 indica que aún no tiene nota registrada
    }

    public ArrayList<Materia> getMateriasAsignadas() {
        return materiasAsignadas;
    }

    public void registrarNota(int indiceMateria, double nota) {
        if (indiceMateria >= 0 && indiceMateria < calificaciones.size()) {
            calificaciones.set(indiceMateria, nota);
        }
    }

    public double calcularPromedio() {
        double suma = 0;
        int cont = 0;
        for (double nota : calificaciones) {
            if (nota != -1.0) { // Solo cuenta si ya tiene nota
                suma += nota;
                cont++;
            }
        }
        if (cont == 0) return 0.0;
        return suma / cont;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getEdad() {
        return edad;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getFechaInscripcion() {
        return fechaInscripcion;
    }

    public ArrayList<Double> getCalificaciones() {
        return calificaciones;
    }
}