package upm.etsisi;

import java.util.ArrayList;
import java.util.List;

public class CursoDeportivo implements ICursoDeportivo {

    private String nombre;
    private List<SesionDeportivaDeCurso> sesionesCurso;
    private List<InscripcionCurso> inscripcionesCurso;

    public CursoDeportivo(String nombre, List<SesionDeportivaDeCurso> sesionesCurso) {
        this.nombre = nombre;
        this.sesionesCurso = sesionesCurso;
        this.inscripcionesCurso = new ArrayList<>();
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
}