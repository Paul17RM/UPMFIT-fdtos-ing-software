package upm.etsisi;

import java.util.LinkedHashMap;
import java.util.List;

public class Cliente extends Usuario {

    private int descuentoFijo = 0;
    private int edad;
    private float peso;
    private String sexo;
    private String tarjetaCredito;
    private List<Cuota> cuotas;

    private List<InscripcionCurso> inscripcionesCurso;

    public Cliente(String nombreUsuario, String nombreCompleto, String correoElectronico, String contrasena,
                   String DNI, int edad, float peso, String sexo, String tarjetaCredito) {
        super(nombreUsuario, nombreCompleto, correoElectronico, contrasena, DNI);
        this.edad = edad;
        this.peso = peso;
        this.sexo = sexo;
        this.tarjetaCredito = tarjetaCredito;
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
        return datosCliente;
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