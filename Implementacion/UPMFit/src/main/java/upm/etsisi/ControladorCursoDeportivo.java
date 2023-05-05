package upm.etsisi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ControladorCursoDeportivo {

    private final List<CursoDeportivo> listaDeCursos = new ArrayList<>();
    private static final VistaCursoDeportivo vistaCurso = VistaCursoDeportivo.getInstance();
    private static final ControladorUsuario controladorUsuario = ControladorUsuario.getInstance();
    private static final ControladorCursoDeportivo controladorCursoDeportivo = new ControladorCursoDeportivo();
    private static final ControladorInscripciones controladorInscripciones = ControladorInscripciones.getInstance();


    public CursoDeportivo getCursoDeportivo(String nombre) {
        return this.findCurso(nombre);
    }

    private ControladorCursoDeportivo() {

    }

    public void darDeAltaCurso(HashMap<String, String> datosCurso) {
        List<SesionDeportivaDeCurso> list = new ArrayList<>();
        for (int i = 1; i < datosCurso.size(); i++) {
            list.add(new SesionDeportivaDeCurso(
                    TActividad.values()[Integer.parseInt(datosCurso.get("actividad " + i)) - 1]
                    , Integer.parseInt(datosCurso.get("aforo " + i))
                    , datosCurso.get("fechaDeInicio " + i), datosCurso.get("fechaDeFin " + i)));
        }
        this.listaDeCursos.add(new CursoDeportivo(datosCurso.get("nombre"), list));
    }

    public void darDeAltaCurso() {
        HashMap<String, String> datosCurso;
        datosCurso = vistaCurso.mostrarFormularioRegistroCurso();
        //se comprueban los datos
        darDeAltaCurso(datosCurso);
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

    public void mostrarDetallesCurso(String nombre) {
        vistaCurso.renderShowCurso(findCurso(nombre));
        controladorUsuario.showListaUsuarios(controladorInscripciones.getListaClientesCurso(nombre));
    }

    public List<CursoDeportivo> getListaDeCursos() {
        return this.listaDeCursos;
    }


    public CursoDeportivo getCursoAInscribir() {
        return vistaCurso.seleccionarCurso(listaDeCursos);
    }
}