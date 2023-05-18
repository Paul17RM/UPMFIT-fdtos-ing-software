package upm.etsisi;

import java.util.LinkedHashMap;
import java.util.List;

public class Monitor extends Usuario {

    private String numeroCuenta;
    private List<SesionDeportivaDeCurso> sesionesImpartidas;
    public Monitor(String nombreUsuario, String nombreCompleto, String correoElectronico, String contrasena, String DNI, String numeroCuenta) {
        super(contrasena, correoElectronico, nombreCompleto, nombreUsuario, DNI);
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public LinkedHashMap<String, String> getInformacion() {
        LinkedHashMap<String, String> datosMonitor;
        datosMonitor = super.getInformacionBasica();
        datosMonitor.put("Numero de cuenta", numeroCuenta);
        return datosMonitor;
    }

}