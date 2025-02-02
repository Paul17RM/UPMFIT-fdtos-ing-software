package upm.etsisi;

import java.util.LinkedHashMap;

public class Estudiante extends Cliente {

    private String matricula;

    public Estudiante(String nombreUsuario, String nombreCompleto, String correoElectronico, String contrasena, String dni, int edad, float peso, String sexo, String tarjetaCredito, String matricula) {
        super(nombreUsuario, nombreCompleto, correoElectronico, contrasena, dni, edad, peso, sexo, tarjetaCredito);
        this.matricula = matricula;
        super.setDescuento(50);
    }

    public LinkedHashMap<String, String> getInformacion() {
        LinkedHashMap<String, String> datosEstudiante;
        datosEstudiante = super.getInformacion();
        datosEstudiante.put("Matricula: ", this.matricula);
        return datosEstudiante;
    }
}