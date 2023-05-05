package upm.etsisi;

public class Material {

    private int anioCompra;
    private String descripcion;
    private int referencia;


    public Material(int anioCompra, String descripcion, int referencia) {
        this.anioCompra = anioCompra;
        this.descripcion = descripcion;
        this.referencia = referencia;
    }

    public int getAnioCompra() {
        return this.anioCompra;
    }

    public void setAnioCompra(int anioCompra) {
        this.anioCompra = anioCompra;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getReferencia() {
        return this.referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }
}