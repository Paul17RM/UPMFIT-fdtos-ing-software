package upm.etsisi;

import upm.menu.MainUPMFitMenu;

public class UPMFit {

    private ControladorUsuario controladorUsuarios;
    private VistaSistema vistaSistema;
    private ControladorCursoDeportivo controladorCursos;
    private ControladorInscripciones controladorInscripciones;

    public UPMFit() {
    }

    public static void main(String[] args) {
        new UPMFit().initialize();
    }

    public void initialize() {
        VistaSistema.getInstance().bienvenida();
        new MainUPMFitMenu("Que quieres hacer?").interact();
    }
}