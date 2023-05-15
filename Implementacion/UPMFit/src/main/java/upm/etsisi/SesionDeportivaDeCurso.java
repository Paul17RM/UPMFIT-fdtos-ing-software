package upm.etsisi;

public class SesionDeportivaDeCurso extends SesionDeportiva {

    public SesionDeportivaDeCurso(TActividad actividad, int aforo, String fechaFin, String fechaInicio, SalaDeporte salaDeporte) {
        super(actividad, aforo, fechaFin, fechaInicio, salaDeporte);
    }

    public SesionDeportivaDeCurso(TActividad actividad, int aforo, String fechaFin, String fechaInicio, SalaDeporte salaDeporte, Monitor monitor) {
        super(actividad, aforo, fechaFin, fechaInicio, salaDeporte, monitor);
    }

}