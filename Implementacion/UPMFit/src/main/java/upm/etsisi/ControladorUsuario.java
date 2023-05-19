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
        int i = 0;
        do {
            if (i > 0) {
                VistaUsuario.getInstance().mostrarErrorDatos();
            }
            i++;
            datosUsuario = VistaUsuario.getInstance().mostrarFormularioRegistro();

        } while (!this.constrasenaValida(datosUsuario.get("contrasena"))
                || !this.nombreValido(datosUsuario.get("nombreUsuario"))
                || Integer.parseInt(datosUsuario.get("edad")) < 0
                || Float.parseFloat(datosUsuario.get("peso")) < 0
                || !this.validarDNI(datosUsuario.get("DNI"))
                || !this.validarCorreo(datosUsuario.get("correoElectronico")));

        UPMUsers rolUsuario = new ObtencionDeRol().get_UPM_AccountRol(datosUsuario.get("correoElectronico"));
        if (rolUsuario == null) {
            crearUsuario(datosUsuario);
        } else if (rolUsuario.equals(UPMUsers.PDI) || rolUsuario.equals(UPMUsers.PAS)) {
            datosUsuario.put("antiguedad", VistaUsuario.getInstance().mostrarFormularioPersonal());
        } else if (rolUsuario.equals(UPMUsers.ALUMNO)) {
            datosUsuario.put("matricula", VistaUsuario.getInstance().mostrarFormularioAlumno());
        }
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
            System.out.println("El nombre de usuario esta pendiente de verificacion");
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