package upm.etsisi;

import java.sql.Date;

public class InscripcionCurso {


    private Cliente cliente;
    private CursoDeportivo cursoDeportivo;

    public InscripcionCurso() {

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