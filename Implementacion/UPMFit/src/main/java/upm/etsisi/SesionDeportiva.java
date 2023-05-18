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

    public int getAforo() {
        return this.aforo;
    }

    public String getFechaFin() {
        return this.fechaFin;
    }

    public String getFechaInicio() {
        return this.fechaInicio;
    }

    public SalaDeporte getSala() {
        return this.sala;
    }

    public Monitor getMonitor() {
        return monitor;
    }
}