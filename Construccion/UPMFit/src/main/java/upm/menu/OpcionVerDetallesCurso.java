package upm.menu;

import upm.etsisi.ControladorCursoDeportivo;

public class OpcionVerDetallesCurso extends Option{
    public OpcionVerDetallesCurso(String title) {
        super(title);
    }

    @Override
    public void interact() {
        ControladorCursoDeportivo.getInstance().mostrarDetallesCurso();
    }
}
