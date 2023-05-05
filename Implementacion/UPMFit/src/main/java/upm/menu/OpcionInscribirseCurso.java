package upm.menu;

import upm.etsisi.ControladorCursoDeportivo;
import upm.etsisi.ControladorInscripciones;

public class OpcionInscribirseCurso extends Option {
    public OpcionInscribirseCurso(String title) {
        super(title);
    }

    @Override
    public void interact() {
        ControladorInscripciones.getInstance().inscribirEnCurso(ControladorCursoDeportivo.getInstance().getCursoAInscribir());
    }
}
