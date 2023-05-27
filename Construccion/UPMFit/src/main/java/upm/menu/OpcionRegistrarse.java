package upm.menu;

import upm.etsisi.ControladorUsuario;

public class OpcionRegistrarse extends Option {
    public OpcionRegistrarse(String title) {
        super(title);
    }

    @Override
    public void interact() {
        ControladorUsuario.getInstance().crearUsuario();
    }
}
