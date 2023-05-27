package upm.menu;

import upm.etsisi.*;

public class OpcionInscribirseCurso extends Option {
    public OpcionInscribirseCurso(String title) {
        super(title);
    }

    @Override
    public void interact() {
        if (!ControladorCursoDeportivo.getInstance().hayCursos()) {
            VistaCursoDeportivo.getInstance().noHayCursos();
        } else {
            ControladorInscripciones.getInstance().inscribirEnCurso(ControladorCursoDeportivo.getInstance().getCursoAInscribir(),
                    new Cliente("illojuan", "Juan Illo"
                            , "illojuan@gmail.com", "01234H@la",
                            "05340307Y", 19, 78.6f, "Masculino", "4854481086593861"));
            VistaSistema.getInstance().inscripcionCorrecta();
        }
    }
}
