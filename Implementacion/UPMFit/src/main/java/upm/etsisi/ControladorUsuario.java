package upm.etsisi;

import utilidades.Cifrado;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ControladorUsuario {

    private final List<Usuario> listaUsuarios = new ArrayList<>();
    private final VistaUsuario vistaUsuario = VistaUsuario.getInstance();
    private static final ControladorUsuario controladorUsuario = new ControladorUsuario();

    private ControladorUsuario() {

    }

    private void crearUsuario(HashMap<String, String> datosUsuario) {//se puede hacer el factory
        if (!datosUsuario.get("antiguedad").equals("")) {
            this.listaUsuarios.add(new PersonalUPM(
                    datosUsuario.get("nombreUsuario"),
                    datosUsuario.get("nombreCompleto"),
                    datosUsuario.get("correoElectronico"),
                    Cifrado.cifrar(datosUsuario.get("contrasena"), Cifrado.Tipo.SECURITY_UPM),
                    datosUsuario.get("DNI"),
                    Integer.parseInt(datosUsuario.get("edad")),
                    Float.parseFloat(datosUsuario.get("peso")),
                    datosUsuario.get("sexo"),
                    datosUsuario.get("tarjetaCredito"),
                    Integer.parseInt(datosUsuario.get("antiguedad"))));
        } else if (!datosUsuario.get("matricula").equals("")) {
            this.listaUsuarios.add(new Estudiante(
                    datosUsuario.get("nombreUsuario"),
                    datosUsuario.get("nombreCompleto"),
                    datosUsuario.get("correoElectronico"),
                    Cifrado.cifrar(datosUsuario.get("contrasena"), Cifrado.Tipo.SECURITY_UPM),
                    datosUsuario.get("DNI"),
                    Integer.parseInt(datosUsuario.get("edad")),
                    Float.parseFloat(datosUsuario.get("peso")),
                    datosUsuario.get("sexo"),
                    datosUsuario.get("tarjetaCredito"),
                    datosUsuario.get("matricula")));
        } else {
            this.listaUsuarios.add(new Cliente(
                    datosUsuario.get("nombreUsuario"),
                    datosUsuario.get("nombreCompleto"),
                    datosUsuario.get("correoElectronico"),
                    Cifrado.cifrar(datosUsuario.get("contrasena"), Cifrado.Tipo.SECURITY_UPM),
                    datosUsuario.get("DNI"),
                    Integer.parseInt(datosUsuario.get("edad")),
                    Float.parseFloat(datosUsuario.get("peso")),
                    datosUsuario.get("sexo"),
                    datosUsuario.get("tarjetaCredito")));

        }
    }

    private Usuario findUser(String email) {
        for (Usuario usuario : this.listaUsuarios) {
            if (usuario.getCorreoElectronico().equals(email)) {
                return usuario;
            }
        }
        return null;
    }

    public static ControladorUsuario getInstance() {
        return controladorUsuario;
    }

    public Usuario getUsuario(String email) {
        return findUser(email);
    }

    public void showUsuario(String email) {
        vistaUsuario.mostrarUsuario(findUser(email));
    }

    public void showListaUsuarios(List<Usuario> listaClientesCurso) {
        vistaUsuario.renderShowListaUsuarios(listaClientesCurso);
    }

    private boolean nombreValido(String nombre) {
        File nameList = new File("filename.txt");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(nameList));
            String line = "";
            while ((line = reader.readLine()) != null) {
                if (line.contains(nombre)) {
                    return false;
                }
            }
        } catch (IOException e) {
            //de momento no hacemos nada, no le vamos a sacar al usuario un problema nuestro
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {

                }
            }
        }
        return nombre.length() >= 3 && nombre.length() <= 10 && nombre.matches("[a-zA-Z0-9]+");
    }

    private boolean constrasenaValida(String password) {
        boolean hasUpperCase = false;
        boolean hasLowercase = false;
        boolean hasNumbers = false;
        boolean hasSymbols = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasNumbers = true;
            } else {
                hasSymbols = true;
            }
        }

        return hasUpperCase && hasLowercase && hasNumbers && hasSymbols && 8 <= password.length() && password.length() <= 12;
    }

    public void crearUsuario() {
        HashMap<String, String> datosUsuario = new HashMap<>();
        datosUsuario.put("contrasena", "1234");
        while (!constrasenaValida(datosUsuario.get("contrasena"))
                || !nombreValido(datosUsuario.get("nombreUsuario"))
                || (Integer.parseInt(datosUsuario.get("edad")) < 0
                || Float.parseFloat(datosUsuario.get("peso")) < 0)) {
            datosUsuario = this.vistaUsuario.mostrarFormularioRegistro();
        }
        crearUsuario(datosUsuario);
    }
}