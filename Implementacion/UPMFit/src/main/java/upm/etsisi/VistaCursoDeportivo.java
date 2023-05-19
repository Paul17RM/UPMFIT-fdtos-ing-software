package upm.etsisi;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
        System.out.println("Las sesiones del curso " + curso.getNombre()+" impartidas por: ");
        LinkedHashMap<String, String> datosUsuario = curso.getMonitor().getInformacionBasica();
        System.out.println(datosUsuario.get("Nombre de usuario: "));
        for (Map.Entry<String, String> dato : datosUsuario.entrySet()) {
            if (!dato.getKey().equals("Nombre de usuario: ")) {
                System.out.println(dato.getKey() + dato.getValue());
            }
        }
        System.out.println();
        for (SesionDeportivaDeCurso sesionDeportivaDeCurso : listaSesiones) {
            System.out.println();
            System.out.println("Sesion de " + sesionDeportivaDeCurso.getActividad().name());
            System.out.println("Comienza el " + sesionDeportivaDeCurso.getFechaInicio());
            System.out.println("Acaba el " + sesionDeportivaDeCurso.getFechaFin());
            System.out.println("El numero de plazas es de " + (sesionDeportivaDeCurso.getAforo() - curso.getInscripcionCursos().size()));
            System.out.println();
        }
        System.out.println("Usuarios inscritos al curso: \n");

    }

    public void renderShowListaCursos(List<CursoDeportivo> listaDeCursos) {
        System.out.println("Los cursos disponible actualmente son: ");
        for (CursoDeportivo curso : listaDeCursos) {
            System.out.println(1 + ". " + curso.getNombre());
        }
    }

    public String mostrarFormularioRegistroCurso() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un nombre para el curso: ");
        return sc.nextLine().trim();
    }

    public CursoDeportivo seleccionarCurso(List<CursoDeportivo> listaDeCursos) {
        renderShowListaCursos(listaDeCursos);
        System.out.println("¿Que curso quieres seleccionar?: ");
        return listaDeCursos.get(pedirNumero(listaDeCursos.size()));
    }

    public void noHayCursos() {
        System.out.println("Actualmente no hay cursos disponibles");
    }

    public int pedirNumero(int max) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        boolean ok = false;
        do {
            System.out.print("Elige una opcion: ");
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt() - 1;
                ok = 0 <= opcion && opcion < max;
            } else {
                scanner.nextLine();
            }
            if (!ok) {
                System.out.println(max==1?"Error: Ingresa un número válido (1)":"Error: Ingresa un número válido entre 1 y " + max);
            }
        } while (!ok);
        return opcion;
    }
}