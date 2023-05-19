package upm.etsisi;

public class InscripcionCurso {

    private String fecha;
    private Cliente cliente;
    private CursoDeportivo cursoDeportivo;

    public InscripcionCurso(String fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public CursoDeportivo getCursoDeportivo() {
        return this.cursoDeportivo;
    }

    public void setCursoDeportivo(CursoDeportivo cursoDeportivo) {
        this.cursoDeportivo = cursoDeportivo;
    }
}