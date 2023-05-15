package upm.etsisi;

import upm.menu.MainUPMFitMenu;

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
    }

    public void initialize() {
        this.controladorUsuarios = ControladorUsuario.getInstance();
        this.vistaSistema = VistaSistema.getInstance();
        this.controladorCursos = ControladorCursoDeportivo.getInstance();
        this.controladorInscripciones = ControladorInscripciones.getInstance();
        this.controladorDeSalas = ControladorSalas.getInstance();
        this.vistaSistema.bienvenida();
        new MainUPMFitMenu("Que quieres hacer?").interact();
    }
}