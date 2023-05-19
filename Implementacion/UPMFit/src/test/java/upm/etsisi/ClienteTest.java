package upm.etsisi;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class ClienteTest {
    Cliente cliente;
    InscripcionCurso inscripcionCurso=new InscripcionCurso();

    @Before
    public void setUp() throws Exception {
        cliente = new Cliente("Enrique", "Enrique De la Fuente", "enriq@alumnos.upm.es", "Ff1#345678",
                "14266495D", 20, 20, "Femenino", "fgcuyhkdvc");
    }

    @After
    public void tearDown(){
        this.cliente.getInscripcionesCurso().remove(this.inscripcionCurso);
    }

    @Test
    public void addInscripcionCurso() {
        this.cliente.addInscripcionCurso(inscripcionCurso);
        assertEquals(this.cliente.getInscripcionesCurso().contains(inscripcionCurso),true);
    }

    //CP1= V1 (44)
    //CP2= N1 (-1)
    //CP3= N2 (101)
    @Test
    public void setDescuentoCP1() {
        assertEquals(Cliente.validarDescuento(44),true);
    }

    @Test
    public void setDescuentoCP2() {
        assertEquals(Cliente.validarDescuento(-1),false);
    }

    @Test
    public void setDescuentoCP3() {
        assertEquals(Cliente.validarDescuento(101),false);
    }

    @Test
    public void setDescuentoFuncional() {
        cliente.setDescuento(50);
        assertEquals(cliente.getDescuento(),50);
    }
}