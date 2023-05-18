package upm.etsisi;

import java.util.LinkedHashMap;

public abstract class Usuario implements IUsuario {

    private String contrasenia;
    private String correoElectronico;
    private String nombreCompleto;
    private String nombreUsuario;
    private String DNI;

    public Usuario(String contrasenia, String correoElectronico,
                   String nombreCompleto, String nombreUsuario, String DNI) {
        this.contrasenia = contrasenia;
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
        //datosUsuario.put("Contraseñas: ",nombreUsuario);
        return datosUsuario;
    }

    public abstract LinkedHashMap<String, String> getInformacion();

    @Override
    public String getNombreCompleto() {
        return this.nombreCompleto;
    }

    @Override
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }

    @Override
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getDNI() {
        return this.DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
}