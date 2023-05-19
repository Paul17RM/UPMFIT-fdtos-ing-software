package upm.etsisi;

import upm.menu.MainUPMFitMenu;

public class UPMFit {



    public static void main(String[] args) {
        new UPMFit().initialize();
    }

    public void initialize() {
        VistaSistema.getInstance().bienvenida();
        new MainUPMFitMenu("Que quieres hacer?").interact();
    }
}