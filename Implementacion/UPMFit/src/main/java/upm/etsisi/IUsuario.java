package upm.etsisi;

import java.util.LinkedHashMap;

public interface IUsuario {

    String getNombreCompleto();

    String getNombreUsuario();

    LinkedHashMap<String, String> getInformacionBasica();

    LinkedHashMap<String, String> getInformacion();

}