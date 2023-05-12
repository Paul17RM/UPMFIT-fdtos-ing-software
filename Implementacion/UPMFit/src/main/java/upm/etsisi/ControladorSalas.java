package upm.etsisi;

import java.util.ArrayList;
import java.util.List;

public class ControladorSalas {
    private final List<SalaDeporte> listaSalas = new ArrayList<>();
    private static final ControladorSalas controladorSalas = new ControladorSalas();
    private static final VistaSalas vistaSalas = VistaSalas.getInstance();

    private ControladorSalas() {
        this.listaSalas.add(new SalaDeporte(30, 10, 1));
        this.listaSalas.add(new SalaDeporte(40, 15, 2));
        this.listaSalas.add(new SalaDeporte(30, 10, 3));
    }

    public static ControladorSalas getInstance() {
        return controladorSalas;
    }

    private SalaDeporte getSalaDeporte(int id) {
        for (SalaDeporte sala : listaSalas) {
            if (sala.getId() == id) {
                return sala;
            }
        }
        return new SalaDeporte(0, 0, 0);
    }

    public void mostrarListaSalas() {
        vistaSalas.renderShowListaSalas(listaSalas);
    }

    public void mostrarSala(int id) {
        vistaSalas.renderShowSala(getSalaDeporte(id));
    }

    public List<SalaDeporte> getSalasDisponibles() {// hay que hacer lo de comprobar que este disponible de verda
        return listaSalas;
    }
}
