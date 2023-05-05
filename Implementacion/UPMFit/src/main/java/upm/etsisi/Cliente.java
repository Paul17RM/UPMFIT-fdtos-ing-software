package upm.etsisi;

import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.List;

public class Cliente extends Usuario {

    private int descuentoFijo = 0;
    private int edad;
    private Date fechaBaja;
    private float peso;//recuerda pasarlo al enterprise que esto antes era int
    private String sexo;
    private String tarjetaCredito;
    private List<Cuota> cuotas;

    private List<InscripcionCurso> inscripcionesCurso;

    public Cliente(String nombreUsuario, String nombreCompleto, String correoElectronico, String contrasena, String DNI, int edad,
                   Date fechaBaja, float peso, String sexo, String tarjetaCredito) {
        super(nombreUsuario, nombreCompleto, correoElectronico, contrasena, DNI);
        this.edad = edad;
        this.fechaBaja = fechaBaja;
        this.peso = peso;
        this.sexo = sexo;
        this.tarjetaCredito = tarjetaCredito;
    }

    public Cliente(String nombreUsuario, String nombreCompleto, String correoElectronico, String contrasena,
                   String DNI, int edad, float peso, String sexo, String tarjetaCredito) {
        super(nombreUsuario, nombreCompleto, correoElectronico, contrasena, DNI);
        this.edad = edad;
        this.peso = peso;
        this.sexo = sexo;
        this.tarjetaCredito = tarjetaCredito;
    }

    public void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public LinkedHashMap<String, String> getInformacion() {
        LinkedHashMap<String, String> datosCliente;
        datosCliente = super.getInformacionBasica();
        datosCliente.put("Edad: ", String.valueOf(this.edad));
        datosCliente.put("Sexo: ", this.sexo);
        datosCliente.put("Peso: ", String.valueOf(this.peso));
        datosCliente.put("Numero Tarjeta de credito: ", this.tarjetaCredito);
        datosCliente.put("Decuento aplicado: ", String.valueOf(this.descuentoFijo));
        datosCliente.put("Fecha de baja: ", this.fechaBaja.toString());
        return datosCliente;
    }

    public void destroy() {

    }

    public int getDescuentoFijo() {
        return this.descuentoFijo;
    }

    public void setDescuentoFijo(int descuentoFijo) {
        this.descuentoFijo = descuentoFijo;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Date getFechaBaja() {
        return this.fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public float getPeso() {
        return this.peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTarjetaCredito() {
        return this.tarjetaCredito;
    }

    public void setTarjetaCredito(String tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public List<Cuota> getCuotas() {
        return this.cuotas;
    }

    public void setCuotas(List<Cuota> cuotas) {
        this.cuotas = cuotas;
    }

    public List<InscripcionCurso> getInscripcionesCurso() {
        return inscripcionesCurso;
    }

    public void setInscripcionesCurso(List<InscripcionCurso> inscripcionesCurso) {
        this.inscripcionesCurso = inscripcionesCurso;
    }

    public void addInscripcionCurso(InscripcionCurso inscripcionCurso) {
        inscripcionesCurso.add(inscripcionCurso);
    }
}