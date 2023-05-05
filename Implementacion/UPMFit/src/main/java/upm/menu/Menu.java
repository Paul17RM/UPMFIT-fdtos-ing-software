package upm.menu;

import upm.etsisi.VistaSistema;

public abstract class Menu {

    private final String title;
    private final Option[] options;
    private static final int MAX = 100;
    private int size;

    public Menu(String title) {
        this.title = title;
        this.options = new Option[Menu.MAX];
        this.size = 0;
    }

    public void interact() {
        this.addOptions();
        this.interact_();
    }

    protected abstract void addOptions();

    protected void interact_() {
        this.showTitles();
        this.execChoosedOption();
    }

    protected void showTitles() {
        this.showTitle();
        for (int i = 0; i < this.size; i++) {
            this.options[i].showTitle(i + 1);
        }
    }

    private void showTitle() {
        String string = "\n" + this.title + "\n";
        for (int i = 0; i < this.title.length(); i++) {
            string += "-";
        }
        VistaSistema.getInstance().mostrarTitulo(string);
    }

    protected void execChoosedOption() {
        this.options[VistaSistema.getInstance().opcionAEjecutar(this.size)].interact();
    }

    protected void add(Option option) {
        assert this.size < Menu.MAX;

        this.options[this.size] = option;
        this.size++;
    }

    protected boolean hasOption(Option option) {
        for (int i = 0; i < this.size; i++) {
            if (this.options[i] == option) {
                return true;
            }
        }
        return false;
    }

    protected void removeOptions() {
        this.size = 0;
    }

}