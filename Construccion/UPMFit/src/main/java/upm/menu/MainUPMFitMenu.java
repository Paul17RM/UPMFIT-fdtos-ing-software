package upm.menu;

public class MainUPMFitMenu extends IterativeMenu {
    public MainUPMFitMenu(String title) {
        super(title);
    }

    @Override
    protected void addOptions() {
        this.add(new OpcionRegistrarse("Registrarse"));
        this.add(new OpcionCrearCurso("Crear un curso"));
        this.add(new OpcionVerDetallesCurso("Ver detalles de un Curso"));
        this.add(new OpcionInscribirseCurso("Inscribirse en un Curso"));
    }
}
