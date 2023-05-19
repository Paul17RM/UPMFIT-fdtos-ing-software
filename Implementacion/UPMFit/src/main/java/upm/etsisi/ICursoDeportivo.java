package upm.etsisi;

import java.util.List;

public interface ICursoDeportivo {

    String getNombre();

    List<InscripcionCurso> getInscripcionCursos();

    List<SesionDeportivaDeCurso> getSesionesCurso();

    void addInscripcionCurso(InscripcionCurso inscripcionCurso);

    Monitor getMonitor();
}