package upm.etsisi;

import java.util.Scanner;


public class VistaSistema {

    private static final VistaSistema vistaSistema = new VistaSistema();

    public static VistaSistema getInstance() {
        return vistaSistema;
    }

    private VistaSistema() {

    }

    public void bienvenida() {
        System.out.println("####################################################################################");
        System.out.println("#																				   #");
        System.out.println("#                          Bienvenido al Gimnasio UPMFit                           #");
        System.out.println("#																				   #");
        System.out.println("####################################################################################");
    }

    public void despedida() {
        System.out.println("####################################################################################");
        System.out.println("#																				   #");
        System.out.println("#                          Muchas gracias por su visita                            #");
        System.out.println("#                         esperamos verle pronto de nuevo                          #");
        System.out.println("#																				   #");
        System.out.println("####################################################################################");
    }

    public void mostrarTitulo(String titulo) {
        System.out.println(titulo);
    }

    public void resgistroCorrectamente(String entidad) {
        System.out.println("\nEl " + entidad + " se ha registrado correctamente en UPMFit");
    }

    public void inscripcionCorrecta() {
        System.out.println("\nSe ha inscrito correctamente en el curso ");
    }

    public int opcionAElegir(int tamanio) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        boolean ok = false;
        do {
            System.out.print("Opción? [1-" + tamanio + "]: ");
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt() - 1;
                ok = 0 <= opcion && opcion < tamanio;
            } else {
                scanner.nextLine();
            }

            if (!ok) {
                System.out.println("Opcion no valida");
            }

        } while (!ok);
        return opcion;
    }

}