package upm.etsisi;

import java.util.List;

public class VistaSalas {

    private static final VistaSalas vistaSalas = new VistaSalas();

    public static VistaSalas getInstance(){ return vistaSalas;}

    private VistaSalas(){
    }

    public void renderShowSala(SalaDeporte salaDeporte){
        System.out.println("id de la sala: " + salaDeporte.getId());
        System.out.println("Tamaño de la sala: " + salaDeporte.getTamanio() + " m²");
        System.out.println("Aforo de la sala: " + salaDeporte.getAforo() + " personas");
        if (salaDeporte.getMateriales().size() != 0){
            System.out.println("Lista materiales:");
            for (int i = 0; i < salaDeporte.getMateriales().size(); i++)
                System.out.println("\t- " + salaDeporte.getMateriales().get(i));
        }
        if (salaDeporte.getSesiones().size() != 0){
            System.out.println("Sesiones en la sala: ");
            for (int i = 0; i < salaDeporte.getSesiones().size(); i++){
                System.out.println("\t- Sesion " + salaDeporte.getSesiones().get(i).getId());
                System.out.println("\t\t Actividad " + salaDeporte.getSesiones().get(i).getActividad());
                System.out.println("\t\t Aforo " + salaDeporte.getSesiones().get(i).getAforo());
                System.out.println("\t\t De " + salaDeporte.getSesiones().get(i).getFechaInicio()
                + " a " + salaDeporte.getSesiones().get(i).getFechaFin());

            }
        }
    }

    public void renderShowListaSalas(List<SalaDeporte> listaSalas) {
        for (SalaDeporte listaSala : listaSalas) {
            renderShowSala(listaSala);
            System.out.println();
        }
    }
}
