package upm.etsisi;

import servidor.Autenticacion;
import servidor.ObtencionDeRol;
import servidor.UPMUsers;
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
    private static final ControladorUsuario controladorUsuario = new ControladorUsuario();

    private ControladorUsuario() {
    }

    private void crearUsuario(HashMap<String, String> datosUsuario) {
        if (datosUsuario.containsKey("antiguedad")) {
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
                    Integer.parseInt(datosUsuario.get("antiguedad")),
                    ObtencionDeRol.get_UPM_AccountRol(datosUsuario.get("correoElectronico")).equals(UPMUsers.PDI) ? TPersonal.PDI : TPersonal.PAS));
        } else if (datosUsuario.containsKey("matricula")) {
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

    public static ControladorUsuario getInstance() {
        return controladorUsuario;
    }


    public void showListaUsuarios(List<IUsuario> listaClientesCurso) {
        VistaUsuario.getInstance().renderShowListaUsuarios(listaClientesCurso);
    }

    public void crearUsuario() {
        HashMap<String, String> datosUsuario;
        boolean hayError;

        do {
            datosUsuario = VistaUsuario.getInstance().mostrarFormularioRegistro();
            hayError = false;

            if (!nombreValido(datosUsuario.get("nombreUsuario"))) {
                VistaUsuario.getInstance().mostrarErrorDatos("ERROR El numero de caracteres es incorrecto o el nombre no esta disponible");
                hayError = true;
            }
            if (!validarCorreo(datosUsuario.get("correoElectronico"))) {
                VistaUsuario.getInstance().mostrarErrorDatos("ERROR Introduce un correo electronico con un formato valido");
                hayError = true;
            }
            if (!constrasenaValida(datosUsuario.get("contrasena")) || !datosUsuario.get("contrasena").equals(datosUsuario.get("contrasena1"))) {
                VistaUsuario.getInstance().mostrarErrorDatos("ERROR El formato de la contraseña es incorrecto");
                hayError = true;
            }
            if (!validarDNI(datosUsuario.get("DNI"))) {
                VistaUsuario.getInstance().mostrarErrorDatos("ERROR Introduce in DNI valido");
                hayError = true;
            }
            if (datosUsuario.get("edad").isEmpty() || !datosUsuario.get("edad").matches("^[0-9]*$") || Integer.parseInt(datosUsuario.get("edad")) < 0) {
                VistaUsuario.getInstance().mostrarErrorDatos("ERROR Introduce un numero valido");
                hayError = true;
            }
            if (datosUsuario.get("peso").isEmpty() || !datosUsuario.get("peso").matches("^[0-9]*$") || Float.parseFloat(datosUsuario.get("peso")) < 0) {
                VistaUsuario.getInstance().mostrarErrorDatos("ERROR Introduce un numero valido");
                hayError = true;
            }

        } while (hayError);

        UPMUsers rolUsuario = ObtencionDeRol.get_UPM_AccountRol(datosUsuario.get("correoElectronico"));
        if (rolUsuario == null) {
            crearUsuario(datosUsuario);
        } else if (rolUsuario.equals(UPMUsers.PDI) || rolUsuario.equals(UPMUsers.PAS)) {
            datosUsuario.put("antiguedad", VistaUsuario.getInstance().mostrarFormularioPersonal());
        } else if (rolUsuario.equals(UPMUsers.ALUMNO)) {
            datosUsuario.put("matricula", VistaUsuario.getInstance().mostrarFormularioAlumno());
        }
        VistaSistema.getInstance().resgistroCorrectamente("Usuario");
    }

    private boolean validarCorreo(String correo) {
        return correo.endsWith("@gmail.com") || new Autenticacion().existeCuentaUPM(correo) || correo.endsWith("@yahoo.com");
    }

    private boolean validarDNI(String dni) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        String dniRegex = "\\d{8}[A-HJ-NP-TV-Za-hj-np-tv-z]";

        if (dni.matches(dniRegex)) {
            char letraCalculada = letras.charAt(Integer.parseInt(dni.substring(0, 8)) % 23);
            char letraDNI = Character.toUpperCase(dni.charAt(8));
            return letraCalculada == letraDNI;
        }

        return false;
    }

    private boolean nombreValido(String nombre) {
        File nameList = new File("Nombres_prohibidos.txt");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(nameList));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(nombre)) {
                    return false;
                }
            }
        } catch (IOException e) {

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

}