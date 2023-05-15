package upm.menu;

import upm.etsisi.ControladorCursoDeportivo;

public class OpcionCrearCurso extends Option {
    public OpcionCrearCurso(String title) {
        super(title);
    }

    @Override
    public void interact() {
        ControladorCursoDeportivo.getInstance().darDeAltaCurso();
    }
}
