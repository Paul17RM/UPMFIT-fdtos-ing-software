package upm.etsisi;

import upm.menu.Console;

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
        System.out.println("#                       esperamos verle de pronto de nuevo                         #");
        System.out.println("#																				   #");
        System.out.println("####################################################################################");
    }

    public void mostrarTitulo(String titulo) {
        System.out.println(titulo);
    }

    public int opcionAEjecutar(int tamanio) {
        Scanner sc = new Scanner(System.in);
        int respuesta;
        boolean ok;
        do {
            System.out.print("Opción? [1-" + tamanio + "]: ");
            respuesta = (sc.nextInt()) - 1;
            ok = 0 <= respuesta && respuesta < tamanio;
            if (!ok) {
                System.out.println("opcion no valida");
            }
        } while (!ok);
        sc.close();
        return respuesta;
    }

}