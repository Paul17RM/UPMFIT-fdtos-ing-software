package upm.etsisi;

import java.util.List;

public class CursoDeportivo implements ICursoDeportivo {

    private String nombre;
    private List<SesionDeportivaDeCurso> sesionesCurso;
    private List<InscripcionCurso> inscripcionesCurso;

    public CursoDeportivo(String nombre, List<SesionDeportivaDeCurso> sesionesCurso) {
        this.nombre = nombre;
        this.sesionesCurso = sesionesCurso;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<SesionDeportivaDeCurso> getSesionesCurso() {
        return this.sesionesCurso;
    }

    public void setSesionesCurso(List<SesionDeportivaDeCurso> sesionesCurso) {
        this.sesionesCurso = sesionesCurso;
    }

    public List<InscripcionCurso> getInscripcionCursos() {
        return this.inscripcionesCurso;
    }

    public void setInscripcionCursos(List<InscripcionCurso> inscripcionCursos) {
        this.inscripcionesCurso = inscripcionCursos;
    }

    public void addInscripcionCurso(InscripcionCurso inscripcionCurso) {
        inscripcionesCurso.add(inscripcionCurso);
    }
}