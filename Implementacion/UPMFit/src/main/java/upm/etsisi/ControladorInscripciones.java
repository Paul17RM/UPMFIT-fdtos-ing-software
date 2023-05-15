package upm.etsisi;

import java.sql.Date;
import java.util.*;

public class ControladorInscripciones {

    private final List<InscripcionCurso> listaInscripciones = new ArrayList<>();
    private static final ControladorInscripciones controladorInscripciones = new ControladorInscripciones();

    private ControladorInscripciones() {

    }

    public static ControladorInscripciones getInstance() {
        return controladorInscripciones;
    }

    public List<Usuario> getListaClientesCurso(String nombreCurso) {
        List<Usuario> listaClientes = new ArrayList<>();
        InscripcionCurso inscripcionCurso;
        for (InscripcionCurso listaInscripcione : this.listaInscripciones) {
            inscripcionCurso = listaInscripcione;
            if (inscripcionCurso.getCursoDeportivo().getNombre().equals(nombreCurso)) {
                listaClientes.add(inscripcionCurso.getCliente());
            }
        }
        return listaClientes;
    }

    public List<CursoDeportivo> getListaCursosCliente(String email) {
        List<CursoDeportivo> listaCursos = new ArrayList<>();
        InscripcionCurso inscripcionCurso;
        for (InscripcionCurso listaInscripcione : this.listaInscripciones) {
            inscripcionCurso = listaInscripcione;
            if (inscripcionCurso.getCliente().getCorreoElectronico().equals(email)) {
                listaCursos.add(inscripcionCurso.getCursoDeportivo());
            }
        }
        return listaCursos;
    }

    public void inscribirEnCurso(CursoDeportivo cursoDeportivo) {//tambien le tendria que llegar que cliente se ha inscrito
        InscripcionCurso inscripcionCurso = new InscripcionCurso(new Date(System.currentTimeMillis()));
        inscripcionCurso.setCursoDeportivo(cursoDeportivo);
        //inscripcionCurso.setCliente(cliente);
        cursoDeportivo.addInscripcionCurso(inscripcionCurso);
        //cliente.addInscripcionCurso(inscripcionCurso);
        this.listaInscripciones.add(inscripcionCurso);
    }
}