package upm.etsisi;

import java.util.LinkedHashMap;

public class PersonalUPM extends Cliente {

    private int antiguedad;
    private TPersonal rol;

    public PersonalUPM(String nombreUsuario, String nombreCompleto, String correoElectronico, String contrasena, String DNI, int edad, float peso, String sexo, String tarjetaCredito, int antiguedad, TPersonal rol) {
        super(nombreUsuario, nombreCompleto, correoElectronico, contrasena, DNI, edad, peso, sexo, tarjetaCredito);
        this.antiguedad = antiguedad;
        this.rol = rol;
        super.setDescuento(Math.min(25 + 3 * antiguedad, 70));
    }

    public LinkedHashMap<String, String> getInformacion() {
        LinkedHashMap<String, String> datosPersonal;
        datosPersonal = super.getInformacion();
        datosPersonal.put("Antigueadad: ", String.valueOf(this.antiguedad));
        datosPersonal.put("Tipo de personal: ", this.rol.name());
        return datosPersonal;
    }

}