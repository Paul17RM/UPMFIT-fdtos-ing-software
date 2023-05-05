package upm.etsisi;

import java.util.LinkedHashMap;

public interface IUsuario {

    String getContrasenia();

    String getCorreoElectronico();

    String getNombreCompleto();

    String getNombreUsuario();

    void setContrasenia(String contrasenia);

    void setCorreoElectronico(String correo);

    void setNombreCompleto(String nomre);

    void setNombreUsuario(String nombre);

    boolean validarEmail();

    LinkedHashMap<String, String> getInformacionBasica();

    LinkedHashMap<String, String> getInformacion();

    String getDNI();

    void setDNI(String DNI);

}