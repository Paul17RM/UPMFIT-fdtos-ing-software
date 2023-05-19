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

    public List<IUsuario> getListaClientesCurso(String nombreCurso) {
        List<IUsuario> listaClientes = new ArrayList<>();
        InscripcionCurso inscripcionCurso;
        for (InscripcionCurso listaInscripcione : this.listaInscripciones) {
            inscripcionCurso = listaInscripcione;
            if (inscripcionCurso.getCursoDeportivo().getNombre().equals(nombreCurso)) {
                listaClientes.add(inscripcionCurso.getCliente());
            }
        }
        return listaClientes;
    }

    public void inscribirEnCurso(CursoDeportivo cursoDeportivo, Cliente cliente) {
        InscripcionCurso inscripcionCurso = new InscripcionCurso();
        inscripcionCurso.setCursoDeportivo(cursoDeportivo);
        inscripcionCurso.setCliente(cliente);
        cursoDeportivo.addInscripcionCurso(inscripcionCurso);
        cliente.addInscripcionCurso(inscripcionCurso);
        this.listaInscripciones.add(inscripcionCurso);
    }
}