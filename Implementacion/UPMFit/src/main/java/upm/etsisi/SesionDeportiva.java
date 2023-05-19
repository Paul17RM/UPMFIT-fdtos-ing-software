package upm.etsisi;

public abstract class SesionDeportiva {

    private TActividad actividad;
    private int aforo;
    private String fechaFin;
    private String fechaInicio;
    private Monitor monitor;

    public SesionDeportiva(TActividad actividad, int aforo, String fechaFin, String fechaInicio) {
        this.actividad = actividad;
        this.aforo = aforo;
        this.fechaFin = fechaFin;
        this.fechaInicio = fechaInicio;
    }

    public SesionDeportiva(TActividad actividad, int aforo, String fechaFin, String fechaInicio, Monitor monitor) {
        this.actividad = actividad;
        this.aforo = aforo;
        this.fechaFin = fechaFin;
        this.fechaInicio = fechaInicio;
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

    public Monitor getMonitor() {
        return monitor;
    }
}