package upm.etsisi;

import java.util.ArrayList;
import java.util.List;

public class CursoDeportivo implements ICursoDeportivo {

    private String nombre;
    private List<SesionDeportivaDeCurso> sesionesCurso;
    private List<InscripcionCurso> inscripcionesCurso;
    private Monitor monitor;

    public CursoDeportivo(String nombre, List<SesionDeportivaDeCurso> sesionesCurso, Monitor monitor) {
        this.nombre = nombre;
        this.sesionesCurso = sesionesCurso;
        this.inscripcionesCurso = new ArrayList<>();
        this.monitor = monitor;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    public List<SesionDeportivaDeCurso> getSesionesCurso() {
        return this.sesionesCurso;
    }

    public List<InscripcionCurso> getInscripcionCursos() {
        return this.inscripcionesCurso;
    }

    public void addInscripcionCurso(InscripcionCurso inscripcionCurso) {
        this.inscripcionesCurso.add(inscripcionCurso);
    }

    public Monitor getMonitor() {
        return monitor;
    }
}