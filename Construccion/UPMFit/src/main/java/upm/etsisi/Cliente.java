package upm.etsisi;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Cliente extends Usuario {

    private int descuento = 0;
    private int edad;
    private float peso;
    private String sexo;
    private String tarjetaCredito;

    private final List<InscripcionCurso> inscripcionesCurso = new ArrayList<>();

    public Cliente(String nombreUsuario, String nombreCompleto, String correoElectronico, String contrasena,
                   String DNI, int edad, float peso, String sexo, String tarjetaCredito) {
        super(contrasena, correoElectronico, nombreCompleto, nombreUsuario, DNI);
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
        datosCliente.put("Decuento aplicado: ", String.valueOf(this.descuento));
        return datosCliente;
    }

    public List<InscripcionCurso> getInscripcionesCurso() {
        return this.inscripcionesCurso;
    }

    public void addInscripcionCurso(InscripcionCurso inscripcionCurso) {
        if (inscripcionCurso != null) {
            this.inscripcionesCurso.add(inscripcionCurso);
        }
    }

    public void setDescuento(int descuento) {
        if (validarDescuento(descuento)) {
            this.descuento = descuento;
        }
    }

    public int getDescuento() {
        return this.descuento;
    }

    public static boolean validarDescuento(int descuento) {
        return descuento >= 0 && descuento <= 100;
    }

}