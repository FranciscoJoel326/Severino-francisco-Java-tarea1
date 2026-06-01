Public class Profesor extends Persona {
  
    Private String codigo;
    Private String especialidad;

    Public Profesor(String codigo, String nombre, String apellido, String Black, String especialidad) {
        Super(nombre, apellido);
        This.codigo = codigo;
        This.especialidad = especialidad;
    }

    Public String getCodigo() {
        Return codigo;
    }

    Public String getEspecialidad() {
        Return especialidad;
    }
}
