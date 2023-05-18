package upm.etsisi;

import java.util.LinkedHashMap;

public abstract class Usuario implements IUsuario {

    private String contrasenia;
    private String correoElectronico;
    private String nombreCompleto;
    private String nick;
    private String DNI;

    public Usuario(String contrasenia, String correoElectronico,
                   String nombreCompleto, String nick, String DNI) {
        this.contrasenia = contrasenia;
        this.correoElectronico = correoElectronico;
        this.nombreCompleto = nombreCompleto;
        this.nick = nick;
        this.DNI = DNI;
    }

    @Override
    public LinkedHashMap<String, String> getInformacionBasica() {
        LinkedHashMap<String, String> datosUsuario = new LinkedHashMap<>();
        datosUsuario.put("Nombre de usuario: ", this.nick);
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
        return this.nick;
    }

}