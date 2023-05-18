package upm.etsisi;

import java.util.*;

public class VistaUsuario {

    private static final VistaUsuario vistaUsuario = new VistaUsuario();

    public static VistaUsuario getInstance() {
        return vistaUsuario;
    }

    private VistaUsuario() {
    }

    public void mostrarUsuario(Usuario usuario) {
        LinkedHashMap<String, String> datosUsuario = usuario.getInformacion();
        System.out.println("Datos del usuario " + datosUsuario.get("Nombre de usuario: "));
        for (Map.Entry<String, String> dato : datosUsuario.entrySet()) {
            if (!dato.getKey().equals("Nombre de usuario: ")) {
                System.out.println(dato.getKey() + dato.getValue());
            }
        }
    }

    public void renderShowListaUsuarios(List<IUsuario> listaClientesCurso) {
        for (IUsuario usuario : listaClientesCurso) {
            LinkedHashMap<String, String> datosUsuario = usuario.getInformacionBasica();
            System.out.println("Datos del usuario " + datosUsuario.get("Nombre de usuario: "));
            for (Map.Entry<String, String> dato : datosUsuario.entrySet()) {
                if (!dato.getKey().equals("Nombre de usuario: ")) {
                    System.out.println(dato.getKey() + dato.getValue());
                }
            }
            System.out.println();
        }
    }

    public HashMap<String, String> mostrarFormularioRegistro() {
        HashMap<String, String> datosUsuario = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce un nombre de usuario (debe tener entre 3 y 10 caracteres):");
        datosUsuario.put("nombreUsuario", scanner.nextLine().trim());

        System.out.print("Introduce el nombre y apellidos: ");
        datosUsuario.put("nombreCompleto", scanner.nextLine().trim());

        System.out.print("Introduce el correo electrónico: ");
        datosUsuario.put("correoElectronico", scanner.nextLine().trim());

        System.out.print("Introduce una contraseña válida (debe tener al menos una letra mayúscula," +
                " una letra minúscula, un número, un símbolo y tener una longitud entre 8 y 12 caracteres):");
        datosUsuario.put("contrasena", scanner.nextLine().trim());

        System.out.print("Introduce el DNI: ");
        datosUsuario.put("DNI", scanner.nextLine().trim());

        System.out.print("Introduce la edad: ");
        datosUsuario.put("edad", scanner.nextLine().trim());

        System.out.print("Introduce el peso: ");
        datosUsuario.put("peso", scanner.nextLine().trim());

        System.out.print("Introduce el sexo: ");
        datosUsuario.put("sexo", scanner.nextLine().trim());

        System.out.print("Introduce la tarjeta de crédito: ");
        datosUsuario.put("tarjetaCredito", scanner.nextLine().trim());

        return datosUsuario;
    }

    public String mostrarFormularioPersonal() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce tu antiguedad en la UPM: ");
        return scanner.nextLine().trim();
    }

    public String mostrarFormularioAlumno() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce la matrícula: ");
        return scanner.nextLine().trim();
    }
}