package upm.etsisi;

import java.util.List;
import java.util.Scanner;

public class VistaCursoDeportivo {

    private static final VistaCursoDeportivo vistaCursoDeportivo = new VistaCursoDeportivo();

    private VistaCursoDeportivo() {

    }

    public static VistaCursoDeportivo getInstance() {
        return vistaCursoDeportivo;
    }

    public void renderShowCurso(CursoDeportivo curso) {
        List<SesionDeportivaDeCurso> listaSesiones = curso.getSesionesCurso();
        System.out.println("Las sesiones del curso" + curso.getNombre() + "son: ");
        for (SesionDeportivaDeCurso sesionDeportivaDeCurso : listaSesiones) {
            System.out.println("Sesion de " + sesionDeportivaDeCurso.getActividad().name());
            System.out.println("Comienza el " + sesionDeportivaDeCurso.getFechaInicio());
            System.out.println("Acaba el " + sesionDeportivaDeCurso.getFechaFin());
            //System.out.println("El numero de plazas es de  " + (sesionDeportivaDeCurso.getAforo() - curso.getInscripcionCursos().size()));
            System.out.println("Se imparte en las salas: ");
            System.out.println(sesionDeportivaDeCurso.getSala().getId());
            System.out.println("Con tamaño: " + sesionDeportivaDeCurso.getSala().getTamanio() + " m²");
            System.out.println("Con aforo: " + sesionDeportivaDeCurso.getSala().getAforo());
        }
        System.out.println("Usuarios inscritos al curso: ");

    }

    public void renderShowListaCursos(List<CursoDeportivo> listaDeCursos) {
        System.out.println("Los cursos disponible actualmente son: ");
        for (CursoDeportivo curso : listaDeCursos) {
            System.out.println(1 + ". " + curso.getNombre());
        }
    }

    public String mostrarFormularioRegistroCurso() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un nombre para el curso");
        return sc.nextLine();
    }

    public CursoDeportivo seleccionarCurso(List<CursoDeportivo> listaDeCursos) {
        renderShowListaCursos(listaDeCursos);
        System.out.println("¿Que curso quieres seleccionar?: ");
        return listaDeCursos.get(pedirNumero(listaDeCursos.size()));
    }

    public void noHayCursos() {
        System.out.println("actualmente no hay cursos disponibles");
    }

    public int pedirNumero(int max) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        boolean ok;
        do {
            System.out.print("Elige una opcion: ");
            opcion = Integer.parseInt(scanner.next())-1;
            ok = 0 <= opcion && opcion < max;
            if (!ok) {
                System.out.println("Error: Ingresa un número válido entre 1 y " + max);
            }
        } while (!ok);
        scanner.close();
        return opcion;
    }
}