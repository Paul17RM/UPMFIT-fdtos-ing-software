package upm.etsisi;

import java.util.ArrayList;
import java.util.List;

public class ControladorCursoDeportivo {

    private final List<CursoDeportivo> listaDeCursos = new ArrayList<>();
    private static final VistaCursoDeportivo vistaCurso = VistaCursoDeportivo.getInstance();
    private static final ControladorUsuario controladorUsuario = ControladorUsuario.getInstance();
    private static final ControladorCursoDeportivo controladorCursoDeportivo = new ControladorCursoDeportivo();
    private static final ControladorInscripciones controladorInscripciones = ControladorInscripciones.getInstance();
    private static final ControladorSalas controladorSalas = ControladorSalas.getInstance();


    public CursoDeportivo getCursoDeportivo(String nombre) {
        return this.findCurso(nombre);
    }

    private ControladorCursoDeportivo() {
    }

    private void darDeAltaCurso(String datosCurso) {
        List<SesionDeportivaDeCurso> listaSesiones = new ArrayList<>();
        listaSesiones.add(new SesionDeportivaDeCurso(TActividad.Natacion,
                52,
                "02/06/2023 19:00",
                "02/06/2023 10:00",
                new SalaDeporte(45, 60, 369),
                new Monitor("Sportacus", "Jose Manuel", "josito@gmail.com", "2Gb&poicv", "3657854F", "ES12 1234 1234 12 1234567890")));

        listaSesiones.add(new SesionDeportivaDeCurso(TActividad.Baile,
                70, "07/06/2023 14:00",
                "07/06/2023 08:00",
                new SalaDeporte(60, 100, 420),
                new Monitor("Mike", "Micheal J Fernandez", "elJordan69@gmail.com", "5Tb&jiji", "86418418F", "ES12 1234 1234 12 12378677890")));
        this.listaDeCursos.add(new CursoDeportivo(datosCurso, listaSesiones));
    }

    public void darDeAltaCurso() {
        darDeAltaCurso(vistaCurso.mostrarFormularioRegistroCurso());
    }

    public static ControladorCursoDeportivo getInstance() {
        return controladorCursoDeportivo;
    }

    private CursoDeportivo findCurso(String nombre) {
        for (CursoDeportivo curso : listaDeCursos) {
            if (curso.getNombre().equals(nombre)) {
                return curso;
            }
        }
        return null;
    }

    public void mostrarCursos() {
        vistaCurso.renderShowListaCursos(listaDeCursos);
    }

    public void mostrarDetallesCurso() {
        if (listaDeCursos.isEmpty()) {
            vistaCurso.noHayCursos();
            return;
        }
        CursoDeportivo cursoDeportivo = vistaCurso.seleccionarCurso(listaDeCursos);
        vistaCurso.renderShowCurso(cursoDeportivo);
        //controladorUsuario.showListaUsuarios(controladorInscripciones.getListaClientesCurso(cursoDeportivo.getNombre()));
    }

    public List<CursoDeportivo> getListaDeCursos() {
        return this.listaDeCursos;
    }


    public CursoDeportivo getCursoAInscribir() {
        return vistaCurso.seleccionarCurso(listaDeCursos);
    }

    public void asociarSesionesYSalas(List<SesionDeportiva> sesionesDeportivas, List<SalaDeporte> salasDeporte) {
        for (int i = 0; i < sesionesDeportivas.size(); i++)
            sesionesDeportivas.get(i).setSala(salasDeporte.get(i));
    }

    private void asociarSesionYSala(SesionDeportiva sesionDeportiva, SalaDeporte salaDeporte) {
        sesionDeportiva.setSala(salaDeporte);
    }
}