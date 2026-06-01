public class Materia {
    private String codigo;
    private String nombreMateria;
    private int creditos;

    public Materia(String codigo, String nombreMateria, int creditos) {
        this.codigo = codigo;
        this.nombreMateria = nombreMateria;
        this.creditos = creditos;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public int getCreditos() {
        return creditos;
    }
}
