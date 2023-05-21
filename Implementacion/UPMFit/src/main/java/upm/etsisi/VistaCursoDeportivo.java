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
        List<SesionDeportivaDeCurso> listaSesiones = curso.getSesiones();
        System.out.println("\nLas sesiones del curso " + curso.getNombre() + " impartidas por: ");
        LinkedHashMap<String, String> datosUsuario = curso.getMonitor().getInformacionBasica();
        System.out.println(datosUsuario.get("Nombre de usuario: "));
        for (Map.Entry<String, String> dato : datosUsuario.entrySet()) {
            if (!dato.getKey().equals("Nombre de usuario: ")) {
                System.out.println(dato.getKey() + dato.getValue());
            }
        }
        System.out.println("\nSon: ");
        for (SesionDeportivaDeCurso sesionDeportivaDeCurso : listaSesiones) {
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
        for (ICursoDeportivo curso : listaDeCursos) {
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
        return listaDeCursos.get(VistaSistema.getInstance().opcionAElegir(listaDeCursos.size()));
    }

    public void noHayCursos() {
        System.out.println("Actualmente no hay cursos disponibles");
    }

    public void cursoYaExiste() {
        System.out.println("ERROR El curso introducido ya existe");
    }
}