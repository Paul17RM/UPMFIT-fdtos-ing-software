package upm.etsisi;

import java.util.HashMap;
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
            System.out.println("Comienza el" + sesionDeportivaDeCurso.getFechaInicio());
            System.out.println("Acaba el " + sesionDeportivaDeCurso.getFechaFin());
            System.out.println("El numero de plazas es de  " + (sesionDeportivaDeCurso.getAforo() - curso.getInscripcionCursos().size()));
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

    public HashMap<String, String> mostrarFormularioRegistroCurso() {
        HashMap<String, String> datosCurso = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        boolean ok = false;
        while (!ok) {

            System.out.println("Introduce un nombre para el curso");
            datosCurso.put("nombre", sc.nextLine());

            int i = 0;
            boolean out = false;
            while (i < 2 && !out) {
                System.out.print("Introduce la fecha de inicio (DD/MM/YYYY): ");
                datosCurso.put("fechaDeInicio" + i, sc.nextLine());

                System.out.print("Introduce la fecha de fin (DD/MM/YYYY): ");
                datosCurso.put("fechaDeFin" + i, sc.nextLine());

                System.out.print("Introduce el aforo: ");
                datosCurso.put("aforo" + i, sc.nextLine());

                System.out.print("Elija la actividad la actividad: ");
                for (int j = 0; j < TActividad.values().length; j++) {
                    System.out.println((j + 1) + TActividad.values()[j].name());
                }
                datosCurso.put("actividad" + i, String.valueOf(pedirNumero(TActividad.values().length)));


                i++;
                System.out.println("Ha terminado de introducir las sesiones de este curso?(recuerde que debe introducir como minimo 2) ");
                out = sc.nextLine().equalsIgnoreCase("y");
            }


            System.out.println("Datos del introducidos:");
            for (String key : datosCurso.keySet()) {
                System.out.println(key + ": " + datosCurso.get(key));
            }
            System.out.println("Son correctos los datos introducidos?");
            ok = sc.nextLine().equalsIgnoreCase("y");

        }
        sc.close();

        return datosCurso;
    }

    public CursoDeportivo seleccionarCurso(List<CursoDeportivo> listaDeCursos) {
        renderShowListaCursos(listaDeCursos);
        System.out.println("¿Que curso quieres seleccionar?: ");
        return listaDeCursos.get(pedirNumero(listaDeCursos.size()));
    }

    public static int pedirNumero(int max) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        boolean ok;
        do {
            System.out.print("Elige una opcion: ");
            opcion = Integer.parseInt(scanner.nextLine());
            ok = 1 < opcion && opcion < max;
            if (!ok) {
                System.out.println("Error: Ingresa un número válido entre 1 y " + max);
            }
        } while (!ok);
        scanner.close();
        return opcion;
    }
}