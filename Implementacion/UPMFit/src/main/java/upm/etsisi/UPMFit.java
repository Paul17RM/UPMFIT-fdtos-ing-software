package upm.etsisi;

import upm.menu.MainUPMFitIMenu;
import upm.menu.MainUPMFitMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UPMFit {

    private ControladorUsuario controladorUsuarios;
    private VistaSistema vistaSistema;
    private ControladorCursoDeportivo controladorCursos;// aqui han cambiado los nombres con respecto al enter
    private ControladorInscripciones controladorInscripciones;
    private ControladorSalas controladorDeSalas;

    public UPMFit() {

    }

    public static void main(String[] args) {
        UPMFit upmFit = new UPMFit();
        upmFit.initialize();
        //MainUPMFitMenu menu =new MainUPMFitMenu("Que quieres hacer?");
    }

    public static int pedirNumero() {
        int numero = 0;
        boolean entradaValida = false;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (!entradaValida) {
            try {
                System.out.print("Ingrese un número: ");
                String entrada = reader.readLine();
                numero = Integer.parseInt(entrada);
                entradaValida = true;
            } catch (NumberFormatException | IOException e) {
                System.out.println("Entrada no válida. Intente nuevamente.");
            }
        }
        return numero;
    }

    public void initialize() {
        this.controladorUsuarios = ControladorUsuario.getInstance();
        this.vistaSistema = VistaSistema.getInstance();
        this.controladorCursos = ControladorCursoDeportivo.getInstance();
        this.controladorInscripciones = ControladorInscripciones.getInstance();
        this.controladorDeSalas = ControladorSalas.getInstance();
        this.vistaSistema.bienvenida();
        new MainUPMFitIMenu("Que quieres hacer?").interact();
    }

    /*public void ejecutarOpcion(String opcion) {
        String nombreCurso;
        switch (opcion) {
            case "Bienvenida":
                this.vistaSistema.bienvenida();
                break;
            case "Salida":
                this.vistaSistema.despedida();
                break;
            case "Registrarse":
                this.controladorUsuarios.crearUsuario(this.vistaSistema.mostrarFormularioRegistro());
                break;
            case "Crear un curso":
                this.controladorCursos.darDeAltaCurso(this.vistaSistema.mostrarFormularioRegistroCurso());
                break;
            case "Inscribirse en un Curso":
                this.controladorCursos.mostrarCursos();
                nombreCurso = this.vistaSistema.seleccionarCurso(this.controladorCursos.getListaDeCursos());
                this.controladorInscripciones.inscribirEnCurso(this.controladorCursos.getCursoDeportivo(nombreCurso));
                break;
            case "Ver detalles de un Curso":
                this.controladorCursos.mostrarCursos();
                nombreCurso = this.vistaSistema.seleccionarCurso(this.controladorCursos.getListaDeCursos());
                this.controladorCursos.mostrarDetallesCurso(nombreCurso);
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }*/
}