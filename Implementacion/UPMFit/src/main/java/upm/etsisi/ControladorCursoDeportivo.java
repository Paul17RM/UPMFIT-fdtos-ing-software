package upm.etsisi;

import java.util.ArrayList;
import java.util.List;

public class ControladorCursoDeportivo {

    private final List<CursoDeportivo> listaCursos = new ArrayList<>();
    private static final ControladorCursoDeportivo controladorCursoDeportivo = new ControladorCursoDeportivo();

    private ControladorCursoDeportivo() {
    }

    private void darDeAltaCurso(String datosCurso) {
        List<SesionDeportivaDeCurso> listaSesiones = new ArrayList<>();
        listaSesiones.add(new SesionDeportivaDeCurso(TActividad.Natacion,
                52,
                "02/06/2023 19:00",
                "02/06/2023 10:00"));

        listaSesiones.add(new SesionDeportivaDeCurso(TActividad.Baile,
                70, "07/06/2023 14:00",
                "07/06/2023 08:00"));

        CursoDeportivo cursoDeportivo = new CursoDeportivo(datosCurso, listaSesiones,new Monitor("Mike", "Micheal J Fernandez",
                "elJordan69@gmail.com", "5Tb&jiji",
                "86418418F", "ES12 1234 1234 12 12378677890"));

        ControladorInscripciones.getInstance().inscribirEnCurso(cursoDeportivo, new Cliente("Pablo NPC", "Pablo García Solana",
                "pablosol@gmail.com", "12efwefasñ3456789KL", "46438429A", 52, 80.5f, "Masculino",
                "7777777"));
        ControladorInscripciones.getInstance().inscribirEnCurso(cursoDeportivo, new PersonalUPM("MartaSolas",
                "Marta Solas Martinez", "martaso.martinez@upm.es", "Admin/12",
                "01530071L", 64, 55.2f, "Femenino", "4238727745695225", 30, TPersonal.PDI));
        ControladorInscripciones.getInstance().inscribirEnCurso(cursoDeportivo, new Estudiante("FedericoGomez",
                "Federico Gomez Gonzalez", "federico.gomez@alumnos.upm.es",
                "Password_1", "60951938Y", 20, 80.6f, "Masculino", "4506116367141129", "bs001"));
        this.listaCursos.add(cursoDeportivo);
    }

    public void darDeAltaCurso() {
        this.darDeAltaCurso(VistaCursoDeportivo.getInstance().mostrarFormularioRegistroCurso());
    }

    public static ControladorCursoDeportivo getInstance() {
        return controladorCursoDeportivo;
    }

    public void mostrarDetallesCurso() {
        if(this.hayCursos()) {
            CursoDeportivo cursoDeportivo = VistaCursoDeportivo.getInstance().seleccionarCurso(this.listaCursos);
            VistaCursoDeportivo.getInstance().renderShowCurso(cursoDeportivo);
            ControladorUsuario.getInstance().showListaUsuarios(ControladorInscripciones.getInstance().getListaClientesCurso(cursoDeportivo.getNombre()));
        }
    }

    public boolean hayCursos() {
        if (this.listaCursos.isEmpty()) {
            VistaCursoDeportivo.getInstance().noHayCursos();
            return false;
        } else {
            return true;
        }
    }

    public CursoDeportivo getCursoAInscribir() {
        return VistaCursoDeportivo.getInstance().seleccionarCurso(this.listaCursos);
    }
}