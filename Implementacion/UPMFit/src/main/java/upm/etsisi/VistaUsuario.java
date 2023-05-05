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

    public void renderShowListaUsuarios(List<Usuario> listaClientesCurso) {

        for (Usuario usuario : listaClientesCurso) {
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
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un nombre de usuario (debe tener entre 3 y 10 caracteres):");
        datosUsuario.put("nombreUsuario", sc.nextLine());

        System.out.print("Introduce el nombre y apellidos: ");
        datosUsuario.put("nombreCompleto", sc.nextLine());

        System.out.print("Introduce el correo electrónico: ");
        datosUsuario.put("correoElectronico", sc.nextLine());

        System.out.println("Introduce una contraseña válida (debe tener al menos una letra mayúscula," +
                " una letra minúscula, un número, un símbolo y tener una longitud entre 8 y 12 caracteres):");
        datosUsuario.put("contrasena", sc.nextLine());

        System.out.print("Introduce el DNI: ");
        datosUsuario.put("DNI", sc.nextLine());

        System.out.print("Introduce la edad: ");
        datosUsuario.put("edad", sc.nextLine());

        System.out.print("Introduce el peso: ");
        datosUsuario.put("peso", sc.nextLine());

        System.out.print("Introduce el sexo: ");
        datosUsuario.put("sexo", sc.nextLine());

        System.out.print("Introduce la tarjeta de crédito: ");
        datosUsuario.put("tarjetaCredito", sc.nextLine());

        System.out.print("Introduce la matrícula: ");
        datosUsuario.put("matricula", sc.nextLine());

        System.out.print("Introduce tu antiguedad en la UPM si procede: ");
        datosUsuario.put("antiguedad", sc.nextLine());

        return datosUsuario;
    }
}