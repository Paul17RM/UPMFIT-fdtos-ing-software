package upm.menu;

import upm.etsisi.VistaSistema;

public abstract class Option {

    private final String title;

    public Option(String title) {
        this.title = title;
    }

    public abstract void interact();

    protected void showTitle(int index) {
        VistaSistema.getInstance().mostrarTitulo(index + ". " + this.getTitle());
    }

    protected String getTitle() {
        return this.title;
    }

}
