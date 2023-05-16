package upm.etsisi;

import java.util.LinkedHashMap;

public class PersonalUPM extends Cliente {

    private int antiguedad;
    private TPersonal rol;

    public PersonalUPM(String nombreUsuario, String nombreCompleto, String correoElectronico, String contrasena, String DNI, int edad, float peso, String sexo, String tarjetaCredito, int antiguedad, TPersonal rol) {
        super(nombreUsuario, nombreCompleto, correoElectronico, contrasena, DNI, edad, peso, sexo, tarjetaCredito);
        this.antiguedad = antiguedad;
        this.rol = rol;
    }

    public PersonalUPM(String nombreUsuario, String nombreCompleto, String correoElectronico, String contrasena, String DNI, int edad, float peso, String sexo, String tarjetaCredito, int antiguedad) {
        super(nombreUsuario, nombreCompleto, correoElectronico, contrasena, DNI, edad, peso, sexo, tarjetaCredito);
        this.antiguedad = antiguedad;
    }


    public LinkedHashMap<String, String> getInformacion() {
        LinkedHashMap<String, String> datosPersonal;
        datosPersonal = super.getInformacionBasica();
        datosPersonal.put("Antigueadad: ", String.valueOf(antiguedad));
        return datosPersonal;
    }

    public int calcularDescuentoVariable() {
        return 0;
    }

}