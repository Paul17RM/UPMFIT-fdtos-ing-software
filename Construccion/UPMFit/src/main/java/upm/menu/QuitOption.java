package upm.menu;

import upm.etsisi.VistaSistema;

public class QuitOption extends Option {

    private boolean executed;

    public QuitOption() {
        super("Salir");
        this.executed = false;
    }

    public void interact() {
        this.executed = true;
        VistaSistema.getInstance().despedida();
    }

    protected boolean isExecuted() {
        return this.executed;
    }

}
