package upm.etsisi;

import java.util.ArrayList;
import java.util.List;

public class CursoDeportivo implements ICursoDeportivo {

    private String nombre;
    private List<SesionDeportivaDeCurso> sesiones;
    private List<InscripcionCurso> inscripcionesCurso;
    private Monitor monitor;

    public CursoDeportivo(String nombre, List<SesionDeportivaDeCurso> sesiones, Monitor monitor) {
        this.nombre = nombre;
        this.sesiones = sesiones;
        this.inscripcionesCurso = new ArrayList<>();
        this.monitor = monitor;
        monitor.setCursoDeportivo(this);
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public List<SesionDeportivaDeCurso> getSesiones() {
        return this.sesiones;
    }

    @Override
    public List<InscripcionCurso> getInscripcionCursos() {
        return this.inscripcionesCurso;
    }

    @Override
    public void addInscripcionCurso(InscripcionCurso inscripcionCurso) {
        this.inscripcionesCurso.add(inscripcionCurso);
    }

    @Override
    public Monitor getMonitor() {
        return this.monitor;
    }
}