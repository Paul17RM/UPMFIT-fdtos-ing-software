package upm.etsisi;

import upm.menu.MainUPMFitIMenu;

public class UPMFit {

    private ControladorUsuario controladorUsuarios;
    private VistaSistema vistaSistema;
    private ControladorCursoDeportivo controladorCursos;// aqui han cambiado los nombres con respecto al enter
    private ControladorInscripciones controladorInscripciones;
    private ControladorSalas controladorDeSalas;

    public UPMFit() {

    }

    public static void main(String[] args) {
        UPMFit upmFit = new UPMFit();
        upmFit.initialize();
        new MainUPMFitIMenu("Que quieres hacer?").interact();
    }

    public void initialize() {
        this.controladorUsuarios = ControladorUsuario.getInstance();
        this.vistaSistema = VistaSistema.getInstance();
        this.controladorCursos = ControladorCursoDeportivo.getInstance();
        this.controladorInscripciones = ControladorInscripciones.getInstance();
        this.controladorDeSalas = ControladorSalas.getInstance();
        this.vistaSistema.bienvenida();
    }

    /*public void ejecutarOpcion(String opcion) {
        String nombreCurso;
        switch (opcion) {
            case "Bienvenida":
                this.vistaSistema.bienvenida();
                break;
            case "Salida":
                this.vistaSistema.despedida();
                break;
            case "Registrarse":
                this.controladorUsuarios.crearUsuario(this.vistaSistema.mostrarFormularioRegistro());
                break;
            case "Crear un curso":
                this.controladorCursos.darDeAltaCurso(this.vistaSistema.mostrarFormularioRegistroCurso());
                break;
            case "Inscribirse en un Curso":
                this.controladorCursos.mostrarCursos();
                nombreCurso = this.vistaSistema.seleccionarCurso(this.controladorCursos.getListaDeCursos());
                this.controladorInscripciones.inscribirEnCurso(this.controladorCursos.getCursoDeportivo(nombreCurso));
                break;
            case "Ver detalles de un Curso":
                this.controladorCursos.mostrarCursos();
                nombreCurso = this.vistaSistema.seleccionarCurso(this.controladorCursos.getListaDeCursos());
                this.controladorCursos.mostrarDetallesCurso(nombreCurso);
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }*/
}