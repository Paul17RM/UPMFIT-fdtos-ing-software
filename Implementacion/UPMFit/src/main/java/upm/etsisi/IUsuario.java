package upm.etsisi;

import java.util.LinkedHashMap;

public interface IUsuario {

    LinkedHashMap<String, String> getInformacionBasica();

    LinkedHashMap<String, String> getInformacion();

    String getCorreoElectronico();

}