package upm.menu;

import upm.etsisi.Cliente;
import upm.etsisi.ControladorCursoDeportivo;
import upm.etsisi.ControladorInscripciones;

public class OpcionInscribirseCurso extends Option {
    public OpcionInscribirseCurso(String title) {
        super(title);
    }

    @Override
    public void interact() {
        if (ControladorCursoDeportivo.getInstance().hayCursos()) {
            ControladorInscripciones.getInstance().inscribirEnCurso(ControladorCursoDeportivo.getInstance().getCursoAInscribir(),
                    new Cliente("Nachingy4", "Iganacio Fernández Rodriguez"
                            , "nachigy4@gmail.com", "01234H@la",
                            "05340307Y", 19, 78.6f, "Masculino", "4854481086593861"));
        }
    }
}
