package upm.etsisi;

public abstract class SesionDeportiva {

    private TActividad actividad;
    private int aforo;
    private String fechaFin;
    private String fechaInicio;
    private SalaDeporte sala; // esto antes era una lista, hay que cambiar en el enterprise que esta como una agregacion
    private Monitor monitor;

    public SesionDeportiva(TActividad actividad, int aforo, String fechaFin, String fechaInicio, SalaDeporte sala) {
        this.actividad = actividad;
        this.aforo = aforo;
        this.fechaFin = fechaFin;
        this.fechaInicio = fechaInicio;
        this.sala = sala;
    }

    public SesionDeportiva(TActividad actividad, int aforo, String fechaFin, String fechaInicio, SalaDeporte sala, Monitor monitor) {
        this.actividad = actividad;
        this.aforo = aforo;
        this.fechaFin = fechaFin;
        this.fechaInicio = fechaInicio;
        this.sala = sala;
        this.monitor = monitor;
    }

    public TActividad getActividad() {
        return this.actividad;
    }

    public void setActividad(TActividad actividad) {
        this.actividad = actividad;
    }

    public int getAforo() {
        return this.aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public String getFechaFin() {
        return this.fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public SalaDeporte getSala() {
        return this.sala;
    }

    public void setSala(SalaDeporte cursosDeportivosSalas) {
        this.sala = cursosDeportivosSalas;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }
}