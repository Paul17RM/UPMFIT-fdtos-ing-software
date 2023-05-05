package upm.etsisi;

import java.sql.Date;

public class InscripcionCurso implements IInscripcionCurso {

    private Date fecha;
    private Cliente cliente;
    private CursoDeportivo cursoDeportivo;

    public InscripcionCurso(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public Date getFecha() {
        return this.fecha;
    }

    @Override
    public void setFecha(Date fecha) {
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