package upm.etsisi;

import java.util.LinkedHashMap;
import java.util.List;

public class Monitor extends Usuario {

    private String numeroCuenta;
    private List<SesionDeportivaDeCurso> sesionDeportivaMonitores;
    private List<Nomina> nominas;

    public Monitor(String nombreUsuario, String nombreCompleto, String correoElectronico, String contrasena, String DNI, String numeroCuenta) {
        super(nombreUsuario, nombreCompleto, correoElectronico, contrasena, DNI);
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public LinkedHashMap<String, String> getInformacion() {
        LinkedHashMap<String, String> datosMonitor;
        datosMonitor = super.getInformacionBasica();
        datosMonitor.put("Numero de cuenta", numeroCuenta);
        return datosMonitor;
    }

    public void cobrar() {

    }

    public String getNumeroCuenta() {
        return this.numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public List<SesionDeportivaDeCurso> getSesionDeportivaMonitores() {
        return this.sesionDeportivaMonitores;
    }

    public void setSesionDeportivaMonitores(List<SesionDeportivaDeCurso> sesionDeportivaMonitores) {
        this.sesionDeportivaMonitores = sesionDeportivaMonitores;
    }

    public List<Nomina> getNominas() {
        return this.nominas;
    }

    public void setNominas(List<Nomina> nominas) {
        this.nominas = nominas;
    }
}