package upm.etsisi;

import java.util.LinkedHashMap;

public abstract class Usuario implements IUsuario {

    private String contrasena;
    private String correoElectronico;
    private String nombreCompleto;
    private String nombreUsuario;
    private String DNI;

    public Usuario(String contrasena, String correoElectronico,
                   String nombreCompleto, String nombreUsuario, String DNI) {
        this.contrasena = contrasena;
        this.correoElectronico = correoElectronico;
        this.nombreCompleto = nombreCompleto;
        this.nombreUsuario = nombreUsuario;
        this.DNI = DNI;
    }

    @Override
    public LinkedHashMap<String, String> getInformacionBasica() {
        LinkedHashMap<String, String> datosUsuario = new LinkedHashMap<>();
        datosUsuario.put("Nombre de usuario: ", this.nombreUsuario);
        datosUsuario.put("Nombre completo: ", this.nombreCompleto);
        datosUsuario.put("Correo Electronico: ", this.correoElectronico);
        datosUsuario.put("DNI: ", this.DNI);
        return datosUsuario;
    }

    public abstract LinkedHashMap<String, String> getInformacion();

    public String getCorreoElectronico() {
        return this.correoElectronico;
    }
}