package upm.etsisi;

import java.util.List;

public class SalaDeporte {

    private int aforo;
    private int tamanio;
    private int id;

    private List<SesionDeportiva> sesiones;

    public SalaDeporte(int tamanio, int aforo, int id) {
        this.tamanio = tamanio;
        this.aforo = aforo;
        this.id = id;
    }

    public int getAforo() {
        return this.aforo;
    }

    public int getTamanio() {
        return this.tamanio;
    }

    public int getId() {
        return this.id;
    }
}