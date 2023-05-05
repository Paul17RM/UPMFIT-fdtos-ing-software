package upm.etsisi;

import java.util.List;

public class SalaDeporte {

    private int aforo;
    private int tamanio;
    private int id;

    private List<Material> materiales;

    private List<SesionDeportiva> sesiones;

    public SalaDeporte(int tamanio, int aforo, int id) {
        this.tamanio = tamanio;
        this.aforo = aforo;
        this.id = id;
    }

    public int getAforo() {
        return this.aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public int getTamanio() {
        return this.tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Material> getMateriales() {
        return this.materiales;
    }

    public void setMateriales(List<Material> materiales) {
        this.materiales = materiales;
    }

    public List<SesionDeportiva> getSesiones() {
        return sesiones;
    }

    public void setSesiones(List<SesionDeportiva> sesiones) {
        this.sesiones = sesiones;
    }
}